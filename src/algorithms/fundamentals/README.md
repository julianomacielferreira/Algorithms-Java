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

I choose some problems that, in my opinion, are not hard to solve but would be nice to explain the solution and the process followed. 

In summary, the approach is:

    1 - Decompose the problem and check if all parts were understood (the explicit and implicit, ones), define inputs and outputs.
    2 - Determine (if it's not already in the statement) the procedure.
    3 - Gather some references if the problem involves related knowledge of other areas.  
    4 - Implement the solution in Java with comments to explain each part. 

## Problems

**1.1.9: Write a code fragment that puts the binary representation of a positive _integer N_ into a _String s_.**

**_Solution:_** 
    
    1 - Decomposing the problem is very easy, it's giving us the input and output:
        - Inputs: an integer (int type) variable N.
        - Output: a String s representing the binary form of the decimal number.
        
To define the _Procedure_  it's necessary to understand some fundamental about Positional Number Systems.

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