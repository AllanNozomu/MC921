#!/bin/bash
declare -a keywords=(
"WHILE" "IF" "ELSE" "SWITCH" "CASE" "BREAK" "FOR"
"INT" "CHAR" "BYTE" "LONG" "UNSIGNED" "VOID" "FLOAT"
"TYPEDEF" "STRUCT" "RETURN" "UNION" "ENUM"
)

cat $1 > corrected.c 

for keyword in "${keywords[@]}"
do
  sed -i -E -e "/TEST/d" corrected.c
  sed -i -E -e "s/(^|[^A-Za-z0-9_])("${keyword}")([^A-Za-z0-9_]|$)/\1\L\2\E\3/g" corrected.c
done 
