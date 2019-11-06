#include "llvm/Pass.h"
#include "llvm/IR/Instructions.h"
#include "llvm/IR/Function.h"
#include "llvm/IR/Constants.h"
#include "llvm/IR/InstrTypes.h"
#include "llvm/Support/raw_ostream.h"
#include "llvm/Support/raw_ostream.h"
#include <unordered_map>
#include <map>
#include <string>

using namespace llvm;

std::unordered_map<std::string, int> instruction_to_index;

std::map<int, int> id_used_where;

namespace {
struct SimpleMath : public FunctionPass {
  static char ID;
  SimpleMath() : FunctionPass(ID) {}

  bool doInitialization(Module &M) {
    return false;
  }

  void printOperand(Value *op, std::string& from) {
    if (isa<Instruction>(*op)) {
      Instruction *_I = cast<Instruction>(op);

        std::string str;
        llvm::raw_string_ostream ss(str);
        ss << *_I;
        id_used_where[instruction_to_index[str]] = instruction_to_index[from];
    }
    // } else if (isa<ConstantInt>(*op)) {
    //   ConstantInt *_V = cast<ConstantInt>(op);
    //   errs() << std::to_string(_V->getSExtValue()) << "\n";
    // }else errs() << op << "\n";
  }

  bool runOnFunction(Function &F) {
    for (BasicBlock &BB : F) {
      instruction_to_index = std::unordered_map<std::string, int>();
      id_used_where = std::map<int, int>();

      std::unordered_map<int, std::string> index_to_instruction;

      for (Instruction &I : BB) {
        std::string str;
        llvm::raw_string_ostream ss(str);
        ss << I;
        // errs() << I << "\n";
        instruction_to_index[str] = instruction_to_index.size();
        index_to_instruction[instruction_to_index[str]] = str;

        Value *left;
        Value *right;
        Function *f;
        switch (I.getOpcode()) {
          case Instruction::Add:
          case Instruction::Sub:
          case Instruction::Mul:
          case Instruction::SDiv:
            left = I.getOperand(0);
            right = I.getOperand(1);
            printOperand(left, str);
            printOperand(right, str);
            break;

          case Instruction::Store:
          // case Instruction::Load:
            left = I.getOperand(0);
            right = I.getOperand(1);
            printOperand(left, str);
            printOperand(right, str);
            id_used_where[instruction_to_index[str]] = instruction_to_index[str];
            
            break;

          case Instruction::Ret:
            left = I.getOperand(0);
            printOperand(left, str);
            id_used_where[instruction_to_index[str]] = instruction_to_index[str];
            break;

          case Instruction::Call:
            CallInst *callInst = cast<CallInst>(&I);
            f = callInst->getCalledFunction();
            left = I.getOperand(0);

            for (int i = 0; i < std::distance(callInst->value_op_begin(), callInst->value_op_end()) - 1; ++i) {
              left = I.getOperand(i);
              printOperand(left, str);
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
