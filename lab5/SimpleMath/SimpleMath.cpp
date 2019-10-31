#include "llvm/Pass.h"
#include "llvm/IR/Function.h"
#include "llvm/IR/Constants.h"
#include "llvm/Support/raw_ostream.h"
#include "llvm/Support/raw_ostream.h"
#include <unordered_map>
#include <string>

using namespace llvm;

std::unordered_map<std::string, int> temp_to_index;

namespace {
struct SimpleMath : public FunctionPass {
  static char ID;
  SimpleMath() : FunctionPass(ID) {}

  bool doInitialization(Module &M) {
    return false;
  }

  void printOperand(Value *op, std::string from) {
    if (isa<Instruction>(*op)) {
      Instruction *_I = cast<Instruction>(op);

        std::string str;
        llvm::raw_string_ostream ss(str);
        ss << *_I;

      errs() << "I" << temp_to_index[str] << ":" << str << " | " << "I" << temp_to_index[from] << ":" << from << "\n";
    // }
    } else if (isa<ConstantInt>(*op)) {
      ConstantInt *_V = cast<ConstantInt>(op);
      errs() << std::to_string(_V->getSExtValue()) << "\n";
    }else errs() << op << "\n";
  }

  bool runOnFunction(Function &F) {
    for (BasicBlock &BB : F) {
      temp_to_index = std::unordered_map<std::string, int>();

      for (Instruction &I : BB) {
        std::string str;
        llvm::raw_string_ostream ss(str);
        ss << I;
        errs() << str << "\n";
        temp_to_index[str] = temp_to_index.size();

        Value *left;
        Value *right;
        switch (I.getOpcode()) {
          case Instruction::Add:
          case Instruction::Sub:
          case Instruction::Mul:
          case Instruction::SDiv:
            left = I.getOperand(0);
            right = I.getOperand(1);
            // errs() << "Instruction: " << I << "\n";
            // errs() << "    Left operand: ";
            // printOperand(left);getOperand
            // errs() << "    Right operand: ";
            printOperand(left, str);
            printOperand(right, str);
            break;
          default:
            errs() << "Instruction isn't arithmetic\n";
            break;
        }
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
