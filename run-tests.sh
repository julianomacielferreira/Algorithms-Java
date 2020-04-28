#!/bin/bash
javac -cp "lib/algs4.jar:lib/junit-4.13.jar:dist/algorithms/fundamentals/*" -sourcepath "src/algorithms:test/algorithms" -d "dist" -g src/algorithms/*/*.java -g test/algorithms/*/*.java
cd dist/
java -cp "./:../lib/algs4.jar:../lib/junit-4.13.jar:../lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore algorithms.fundamentals.BooleanArrayTest