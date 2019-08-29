#!/bin/bash
for i in $(seq 1 4); do
  echo "TESTANDO entregavel.sh code${i}.c"
  bash entregavel.sh code${i}.c

  echo "Verificando selected.txt"
  diff results/code${i}_selected.txt selected.txt

  echo "Verificando corrected.c"
  diff results/code${i}_corrected.c corrected.c

  echo "Verificando tokens.txt"
  diff results/code${i}_tokens.txt tokens.txt
  echo "==================================================="
done

rm selected.txt
rm corrected.c
rm tokens.txt
