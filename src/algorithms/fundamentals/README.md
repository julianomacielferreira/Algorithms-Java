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

**I choose problems that, in my opinion, they are not hard. But should be nice to explain the process followed to solve.**

In summary, the approach is:

    1 - Decompose the problem and check if all parts were understood (the explicit and implicit).
    2 - Define inputs and outputs.
    3 - Determine (if it's not already in the statement) the procedure.
    4 - Gather some references if the problem involves related knowledge of other areas.  
    5 - Implement the solution in Java with comments to explain each part. 

## Problems

**1.1.9: Write a code fragment that puts the binary representation of a positive _integer N_ into a _String s_.**

**_Solution:_** 
    
Decomposing this problem is very easy, it's giving us the input and output:

    - Inputs: an integer (int) variable N.
    - Output: a String s representing the binary form of the decimal number.
        
To define the _Procedure_  it's necessary to understand some fundamentals about [Positional notation](https://en.wikipedia.org/wiki/Positional_notation) and [Numeral Systems](https://en.wikipedia.org/wiki/Numeral_system). 

The definition is taken from [Quora](https://www.quora.com) question ["What is a positional number system?"](https://www.quora.com/What-is-a-positional-number-system)

> A positional (numeral) system is a system for representation of numbers by an ordered set of numerals symbols (called digits) in which the value of a numeral symbol depends on its position

Exemplifying:

In a straightforward manner it's saying that a decimal number, for example 36, is equal to the sum of two numbers (digits) multiplied by powers of 10. 

From right to left direction increases the power of the base (starting from 10 raised to 0):
 
> 36 = (6 * 10<sup>0</sup>) + (3 * 10<sup>1</sup>) = (6 * 1) + (3 * 10) = 6 + 30 = 36

The quantity of numerals (symbols) is the same as the base. The base ten has 10 digits => {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}.

The rule for the symbols is: start from 0 until _base - 1_.
 
So the base two, starting from 0 until (2 - 1) has only the symbols {0, 1}.

From right to left, the representation of the binary number 1010<sub>2</sub> in base ten is:

> 1010 = (0 * 2<sup>0</sup>) + (1 * 2<sup>1</sup>) + (0 * 2<sup>2</sup>) + (1 * 2<sup>3</sup>) = (0 * 1) + (1 * 2) + (0 * 4) + (1 * 8) = 0 + 2 + 0 + 8 = 10

With all said, the problem is asking us to implement the algorithm to make the inverse path, i.e, given a number in base ten (in the example above, 36), convert it to binary.


    2 - Procedure

**1.1.11: Write a code fragment that prints the contents of a two-dimensional boolean array, using * to represent true and a space to represent false.
Include row and column numbers.**

**Solution:** @TODO - Solve it

**1.1.13: Write a code fragment to print the transposition (rows and columns changed) of a two-dimensional array with M rows and N columns.**

**Solution:** @TODO - Solve it

**1.1.14: Write a static method **lg()** that takes an **int** value as argument and returns the largest int not larger than the base-2 logarithm of N. Do not use _Math_.**

**Solution:** @TODO - Solve it

**1.1.15: Write a static method _histogram()_ that takes an array a[] of _int_ values and an integer M as argument and returns an array of length M whose ith entry is the number of times
the integer i appeared in the argument array. If the values in a[] are all between 0 and M-1, the sum of the values int the returned array should be equal to a.length.** 

**Solution:** @TODO - Solve it

# References

- ["Algorithms, 4th Edition" by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/)
- [The Java Tutorials](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)
- [Mathematics Fundamentals I (Brazilian Portuguese)](http://mtm.grad.ufsc.br/files/2014/04/Fundamentos-de-Matem%C3%A1tica-I.pdf)