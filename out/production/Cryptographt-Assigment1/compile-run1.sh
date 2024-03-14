#!/bin/bash

echo "Compiling Assignment1.java"
javac Assignment1.java

if [ $? -eq 0 ]; then
    echo "Compilation successfull!!!"
    java Assignment1
else
    echo "Compilation failed:(("
fi
