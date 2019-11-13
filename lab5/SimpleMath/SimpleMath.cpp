#include "llvm/Pass.h"
#include "llvm/IR/Instructions.h"
#include "llvm/IR/Function.h"
#include "llvm/IR/Constants.h"
#include "llvm/IR/InstrTypes.h"
#include "llvm/IR/Module.h"
#include "llvm/Support/raw_ostream.h"
#include <unordered_map>
#include <map>
#include <vector>
#include <string>

using namespace llvm;

std::unordered_map<std::string, int> instruction_to_index;
std::map<int, int> id_used_where;

std::unordered_map<std::string, int> replaced_constants;

namespace {
struct SimpleMath : public FunctionPass {
  static char ID;
  SimpleMath() : FunctionPass(ID) {}

  bool doInitialization(Module &M) {
    return false;
  }

  bool isConstant(Value* op1, Value* op2){
    errs() << op1->getName() << " " << op2->getName() << "\n";
    if (!isa<ConstantInt>(*op1) && replaced_constants.find(op1->getName()) == replaced_constants.end()) {
      return false;
    }
    if (!isa<ConstantInt>(*op2) && replaced_constants.find(op2->getName()) == replaced_constants.end()) {
      return false;
    }
    return true;
  }

  int getValue(Value* op1, Value* op2, Instruction &I) {
    int val1;
    int val2;
    if (isa<ConstantInt>(*op1)) {
      val1 = cast<ConstantInt>(op1)->getSExtValue();
    } else {
      val1 = replaced_constants[op1->getName()];
    }

    if (isa<ConstantInt>(*op2)) {
      val2 = cast<ConstantInt>(op2)->getSExtValue();
    } else {
      val2 = replaced_constants[op2->getName()];
    }

    switch (I.getOpcode()) {
      case Instruction::Add: return val1 + val2;
      case Instruction::Sub: return val1 - val2;
      case Instruction::Mul: return val1 * val2;
      case Instruction::SDiv: return val1 / val2;
    }
    return 0;
  }

  bool canReplace(Value* op){
    return isa<Instruction>(*op) && replaced_constants.find(op->getName()) != replaced_constants.end();
  }

  void printOperand(Value *op, std::string& from) {
    if (isa<Instruction>(*op)) {
      Instruction *_I = cast<Instruction>(op);

        std::string str;
        llvm::raw_string_ostream ss(str);
        ss << *_I;
        id_used_where[instruction_to_index[str]] = instruction_to_index[from];
    }
  }

  bool runOnFunction(Function &F) {
    for (BasicBlock &BB : F) {
      instruction_to_index = std::unordered_map<std::string, int>();
      id_used_where = std::map<int, int>();
      replaced_constants = std::unordered_map<std::string, int>();

      std::unordered_map<int, std::string> index_to_instruction;

      for (Instruction &I : BB) {
        std::string str;
        llvm::raw_string_ostream ss(str);
        ss << I;
        instruction_to_index[str] = instruction_to_index.size();
        index_to_instruction[instruction_to_index[str]] = str;
        

        Value *left;
        Value *right;
        Function *f;
        Module* m = I.getModule();
        switch (I.getOpcode()) {
          case Instruction::Add:
          case Instruction::Sub:
          case Instruction::Mul:
          case Instruction::SDiv:
            left = I.getOperand(0);
            right = I.getOperand(1);

            if (isConstant(left, right)) {
              replaced_constants[I.getName()] = getValue(left, right, I);
              errs() << I.getName() << " Eh constante e vale " << replaced_constants[I.getName()] << "\n";
            }
            printOperand(left, str);
            printOperand(right, str);

            if (canReplace(left)){
              Type *i32_type = IntegerType::getInt32Ty(m->getContext());
              Constant *i32_val = ConstantInt::get(i32_type, replaced_constants[left->getName()]);
              cast<Instruction>(left)->eraseFromParent();

              I.setOperand(0, i32_val);
            }
            if (canReplace(right)){
              Type *i32_type = IntegerType::getInt32Ty(m->getContext());
              Constant *i32_val = ConstantInt::get(i32_type, replaced_constants[right->getName()]);
              cast<Instruction>(right)->eraseFromParent();

              I.setOperand(1, i32_val);
            }

            break;

          case Instruction::Store:
            left = I.getOperand(0);
            right = I.getOperand(1);

            printOperand(left, str);
            printOperand(right, str);

            if (canReplace(left)){    
              Type *i32_type = IntegerType::getInt32Ty(m->getContext());
              Constant *i32_val = ConstantInt::get(i32_type, replaced_constants[left->getName()]);
              cast<Instruction>(left)->eraseFromParent();

              I.setOperand(0, i32_val);
            }
            if (canReplace(right)){
              Type *i32_type = IntegerType::getInt32Ty(m->getContext());
              Constant *i32_val = ConstantInt::get(i32_type, replaced_constants[right->getName()]);
              cast<Instruction>(right)->eraseFromParent();

              I.setOperand(1, i32_val);
            }

            id_used_where[instruction_to_index[str]] = instruction_to_index[str];
            
            break;

          case Instruction::Ret:
            left = I.getOperand(0);
            printOperand(left, str);

            if (canReplace(left)){    
              Type *i32_type = IntegerType::getInt32Ty(m->getContext());
              Constant *i32_val = ConstantInt::get(i32_type, replaced_constants[left->getName()]);
              cast<Instruction>(left)->eraseFromParent();

              I.setOperand(0, i32_val);
            }

            id_used_where[instruction_to_index[str]] = instruction_to_index[str];
            break;

          case Instruction::Call:
            CallInst *callInst = cast<CallInst>(&I);
            f = callInst->getCalledFunction();

            for (int i = 0; i < std::distance(callInst->value_op_begin(), callInst->value_op_end()) - 1; ++i) {
              left = I.getOperand(i);
              printOperand(left, str);

              if (canReplace(left)){    
                Type *i32_type = IntegerType::getInt32Ty(m->getContext());
                Constant *i32_val = ConstantInt::get(i32_type, replaced_constants[left->getName()]);
                cast<Instruction>(left)->eraseFromParent();

                I.setOperand(0, i32_val);
              }
            }

            if (f->getReturnType()->isVoidTy()){
              id_used_where[instruction_to_index[str]] = instruction_to_index[str];
            }
            break;
        }
      }
      for (auto &key_val : id_used_where) {
        int left = key_val.first;
        int right = key_val.second;
        errs() << "I" << left << ": " << index_to_instruction[left] << " | " << "I" << right << ": " << index_to_instruction[right] << "\n";
      }
    }
    return false;
  }

  bool doFinalization(Module &M) {
    return false;
  }
};
}

char SimpleMath::ID = 0;
static RegisterPass<SimpleMath> X("sm", "Simple math pass", false, false);
