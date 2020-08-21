#!/bin/bash
javac -Xlint:unchecked -cp "lib/algs4.jar" -sourcepath "src/algorithms" -d "dist" -Xlint:unchecked -g src/algorithms/*.java src/algorithms/*/*.java
cd dist/
java -cp "../lib/algs4.jar": algorithms/Algorithms
