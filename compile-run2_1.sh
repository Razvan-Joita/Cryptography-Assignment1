#!/bin/bash

javac Assignment2FirstExercise.java

if [ $? -eq 0 ]; then
    echo "Compilation successfull!!!"

    java Assignment2FirstExercise
else
    echo "Compilation failed:((("
fi
