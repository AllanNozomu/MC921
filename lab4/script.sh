#!/bin/bash
# set -x
#compiling the Sum.g4 in java files
java -jar "antlr-4.7.2-complete.jar" -no-listener -visitor Gramatica.g4

export CLASSPATH=".:antlr-4.7.2-complete.jar:$CLASSPATH"
javac *.java

tstcase=$1
java MyParser < ${tstcase} > result.ll
llc result.ll
gcc Printer.c result.s
./a.out

rm ./*.class
rm ./*.tokens
rm ./*.interp
rm ./*.ll
rm ./*.s
rm ./*.out