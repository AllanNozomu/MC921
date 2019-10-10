#!/bin/bash
# set -x
#compiling the Sum.g4 in java files
java -jar "antlr-4.7.2-complete.jar" -no-listener -visitor Gramatica.g4

export CLASSPATH=".:antlr-4.7.2-complete.jar:$CLASSPATH"
javac *.java

echo "#################################################"
echo "#              GERANDO AS SAIDAS                #"
echo "#################################################"

i=$1
# java org.antlr.v4.gui.TestRig Gramatica root -tokens < ./tests/test${i}.sm
# java org.antlr.v4.gui.TestRig Gramatica root -tree < ./tests/test${i}.sm
# java org.antlr.v4.gui.TestRig Gramatica root -gui < ./tests/test${i}.sm > /dev/null &

for i in $(seq 0 9); do
    echo "TESTANDO ${i}========================================="
    java MyParser < tests/test${i}.sm > test${i}.ll
    llc test${i}.ll
    gcc Printer.c test${i}.s
    ./a.out > test${i}.out
    diff test${i}.out tests/test${i}.res
    # rm test${i}.out test${i}.ll test${i}.s
    echo "==================================================="
done
# cat test${i}.ll