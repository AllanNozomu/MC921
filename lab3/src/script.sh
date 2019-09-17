#!/bin/bash
set -x
#compiling the Sum.g4 in java files
java -jar "antlr-4.7.2-complete.jar" -no-listener -visitor Summer.g4
#exporting the class path
export CLASSPATH=".:antlr-4.7.2-complete.jar:$CLASSPATH"
#compiling the .java generated from Sum.g4 with MyParser.java and AddVisitor.java
javac *.java

# for i in $(seq 1 7); do
  echo "Tokens"
  java org.antlr.v4.gui.TestRig Summer root -tokens < ../tests/test${1}.sm

  echo "Tree"
  java org.antlr.v4.gui.TestRig Summer root -tree < ../tests/test${1}.sm 

  echo "GUI"
  java org.antlr.v4.gui.TestRig Summer root -gui < ../tests/test${1}.sm 

  echo "Verificando saida"
  java MyParser < test${i}.sm > temp_res.txt
  diff ../tests/result${i}.txt temp_res.txt
  echo "==================================================="
# done
rm temp_res.txt