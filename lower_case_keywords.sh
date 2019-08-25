#!/bin/bash
declare -a keywords=(
"WHILE" "IF" "ELSE" "SWITCH" "CASE" "BREAK" "FOR"
"INT" "CHAR" "BYTE" "LONG" "UNSIGNED" "VOID" "FLOAT"
"TYPEDEF" "STRUCT" "RETURN" "UNION" "ENUM"
)

cat $1 > $2

for keyword in "${keywords[@]}"
do
  sed -i -E -e "/TEST/d" $2
  sed -i -E -e "s/(^|[^A-Za-z0-9])("${keyword}")([^A-Za-z0-9]|$)/\1\L\2\E\3/g" $2
done 
