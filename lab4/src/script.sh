#!/bin/bash
# set -x
#compiling the Sum.g4 in java files
java -jar "antlr-4.7.2-complete.jar" -no-listener -visitor Summer.g4
#exporting the class path
export CLASSPATH=".:antlr-4.7.2-complete.jar:$CLASSPATH"
#compiling the .java generated from Sum.g4 with MyParser.java and AddVisitor.java
javac *.java

echo "#################################################"
echo "#                GERANDO TOKENS                 #"
echo "#################################################"


for i in $(seq 1 8); do
    echo "TESTANDO ${i}========================================="
    java org.antlr.v4.gui.TestRig Summer root -tokens < ../tests/test${i}.sm
    echo "==================================================="
done

echo "#################################################"
echo "#                GERANDO TREES                  #"
echo "#################################################"

for i in $(seq 1 8); do
    echo "TESTANDO ${i}========================================="
    java org.antlr.v4.gui.TestRig Summer root -tree < ../tests/test${i}.sm 
    echo "==================================================="
done

echo "#################################################"
echo "#              GERANDO IMAGENS                  #"
echo "#################################################"

for i in $(seq 1 8); do
    echo "TESTANDO ${i}========================================="
    java org.antlr.v4.gui.TestRig Summer root -gui < ../tests/test${i}.sm > /dev/null &
    echo "==================================================="
done

echo "#################################################"
echo "#             VERIFICANDO SAIDAS                #"
echo "#################################################"

for i in $(seq 1 8); do
    echo "TESTANDO ${i}========================================="
    java MyParser < ../tests/test${i}.sm > temp_res.txt
    diff ../tests/result${i}.txt temp_res.txt
    echo "==================================================="
done
rm temp_res.txt