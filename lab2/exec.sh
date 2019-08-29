#!/bin/bash
flex -i -o scanner.c scanner.l
gcc -g -o scanner scanner_test.c scanner.c
./scanner < $1
