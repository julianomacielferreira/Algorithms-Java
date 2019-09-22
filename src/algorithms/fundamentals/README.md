# Fundamentals Problem Set

The [book site](https://algs4.cs.princeton.edu/home/) has the pre-requirements (I'm not going to copy here) to going deep and 
solve the problems of the first chapter _1.1 Basic Programming Fundamentals_.

The basic knowledge necessary is:
- Primitive data types and expressions
- Statements
- Arrays
- Static methods
- APIs
- Strings
- Input and output

It's really complete with detailed (and others summarized) information about the Java programming fundamentals that is familiar in a whole bunch of other languages.

**Required knowledge:**

- [1. Fundamentals](https://algs4.cs.princeton.edu/10fundamentals/)
    - [1.1 Programming Model](https://algs4.cs.princeton.edu/11model/)

- [The Java Tutorials: _Learning the Java Language_](https://docs.oracle.com/javase/tutorial/java/index.html)
    - [Language Basics](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)
        - [Variables](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
        - [Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
        - [Expressions, Statements, and Blocks](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/expressions.html)
        - [Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)

## Problems

I choose some problems that, in my opinion, are not hard to solve but would be nice to explain the solution and the process followed. 

In summary, the approach is:

    1 - Decompose the problem in its related inputs and outputs.
    2 - Determine (if it's not already in the statement) the procedure.
    3 - Gather some references if the problem involves related knowledge of other areas.  
    4 - Implement the solution in Java with comments to explain each part. 


**1.1.9: Write a code fragment that puts the binary representation of a positive _integer N_ into a _String s_.**

**_Solution:_** 
First, decompose the problem and see if all parts were understood (the explicit and implicit, ones).

__Note about Positional Number Systems_: @TODO - Define

It's necessary to create a method with the input and output:
- _Input:_ a variable N with type int (integer);
- _Output:_ a String representing the binary form of the decimal number;
- _Procedure:_ 

**1.1.11: Write a code fragment that prints the contents of a two-dimensional boolean array, using * to represent true and a space to represent false.
Include row and column numbers.**

**Solution:** @TODO - Solve it

**1.1.13: Write a code fragment to print the tranposition (rows and columns changed) of a two-dimensional array with M rows and N columns.**

**Solution:** @TODO - Solve it

**1.1.14: Write a static method **lg()** that takes an **int** value as argument and returns the largest int not larger than the base-2 logarithm of N. Do not use _Math_.**

**Solution:** @TODO - Solve it

**1.1.15: Write a static method _histogram()_ that takes an array a[] of _int_ values and an integer M as argument and returns an array of length M whose ith entry is the number of times
the integer i appeared in the argument array. If the values in a[] are all between 0 and M-1, the sum of the values int the returned array should be equal to a.length.** 

**Solution:** @TODO - Solve it

# References

- ["Algorithms, 4th Edition" by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/)
- [The Java Tutorials](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)