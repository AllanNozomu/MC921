#!/bin/bash

for i in $(seq 1 4); do
  echo "EDITANDO ARQUIVO ${i}"
  bash lower_case_keywords.sh code${i}.c 
  diff corrected.c results/code${i}_corrected.c

  ./exec.sh corrected.c > token${i}.txt
  diff token${i}.txt results/code${i}_tokens.txt
  rm token${i}.txt
  echo "==================================================="
done
rm corrected.c
