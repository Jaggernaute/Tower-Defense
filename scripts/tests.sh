#!/bin/bash

mkdir -p build/classes/java/main
mkdir -p build/classes/java/test
javac -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar -d build/classes/java/main src/main/java/Main.java
javac -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar -d build/classes/java/test src/test/java/TestImplementation.java
java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:build/classes/java/main:build/classes/java/test org.junit.runner.JUnitCore TestImplementation