#!/bin/bash
# set -x
#compiling the Sum.g4 in java files

for i in $(seq 1 9); do
    echo "Testando ${i}--------------"
    opt -load /usr/src/app/build/lib/LLVMSimpleMath.so -sm ./test${i}.ll -f 2> auxaux > /dev/null 
    diff auxaux ./result/test${i}.txt
done

rm auxaux