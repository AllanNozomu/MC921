#!/bin/bash
# set -x
#compiling the Sum.g4 in java files
java -jar "antlr-4.7.2-complete.jar" -no-listener -visitor Summer.g4
#exporting the class path
export CLASSPATH=".:antlr-4.7.2-complete.jar:$CLASSPATH"
#compiling the .java generated from Sum.g4 with MyParser.java and AddVisitor.java
javac *.java

for i in $(seq 1 8); do
    # Run the tests and write the results into results files
    java MyParser < ./test${i}.sm > ./result${i}.txt
done

# Opens visual tree for test 7
java org.antlr.v4.gui.TestRig Summer root -gui < ./test7.sm > /dev/null &
