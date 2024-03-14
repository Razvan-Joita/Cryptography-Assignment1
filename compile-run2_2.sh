#!/bin/bash

javac Assignment2SecondExercise.java

if [ $? -eq 0 ]; then
    echo "Compilation successfull!!!"

    java Assignment2SecondExercise
else
    echo "Compilation failed:((((("
fi
