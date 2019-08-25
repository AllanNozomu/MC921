#!bin/bash

for i in $(seq 1 4); do
  echo "EDITANDO ARQUIVO ${i}"
  bash lower_case_keywords.sh c_lang/code${i}.c res${i}.c
  diff res${i}.c c_lang/results/code${i}_corrected.c
  echo "==================================================="
  rm res${i}.c
done
