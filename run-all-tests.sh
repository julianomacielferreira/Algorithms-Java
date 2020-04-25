#!/bin/bash
javac -cp "lib/algs4.jar:lib/junit-4.13.jar:dist/algorithms/fundamentals/*" -sourcepath "test/algorithms" -d "dist" -g test/algorithms/*/*.java
#cd dist/
#java -cp "../lib/algs4.jar:../lib/junit-4.13.jar" org.junit.runner.JUnitCore algorithms/* test/algorithms/MatrixTest