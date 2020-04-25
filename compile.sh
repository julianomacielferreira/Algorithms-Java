#!/bin/bash
javac -cp "lib/algs4.jar" -sourcepath "src/algorithms" -d "dist" -g src/algorithms/*.java src/algorithms/*/*.java
cd dist/
java -cp "../lib/algs4.jar": algorithms/Algorithms