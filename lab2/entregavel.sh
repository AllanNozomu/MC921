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

flex -i -o scanner.c scanner.l
gcc -g -o scanner scanner_test.c scanner.c
./scanner < corrected.c > tokens.txt

sed -E -n "/(T_ID |T_STR |T_NUM )/p" tokens.txt > selected.txt
