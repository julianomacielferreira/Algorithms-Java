# Fundamentals Problem Set

The [book site](https://algs4.cs.princeton.edu/home/) has the pre-requirements (**I'm not going to copy here**) to going
deep and
solve the problems of the first chapter _1.1 Basic Programming Fundamentals_.

The basic knowledge necessary is:

- Primitive data types and expressions
- Statements
- Arrays
- Static methods
- APIs
- Strings
- Input and output

It's really complete with detailed (and others summarized) information about the Java programming fundamentals that is
familiar in a lot of other languages.

**Required knowledge:**

- [1. Fundamentals](https://algs4.cs.princeton.edu/10fundamentals/)
    - [1.1 Programming Model](https://algs4.cs.princeton.edu/11model/)

- [The Java Tutorials: _Learning the Java Language_](https://docs.oracle.com/javase/tutorial/java/index.html)
    - [Language Basics](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)
        - [Variables](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
        - [Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
        - [Expressions, Statements, and Blocks](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/expressions.html)
        - [Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)

**I choose problems that, in my opinion, are not hard to solve, but it should be nice to explain the process I followed
to solve them.**

In summary, the approach is:

    1 - Decompose the problem and check if all parts were understood (explicit and implicit).
    2 - Define inputs and outputs.
    3 - Determine the procedure (if it's not already in the statement).
    4 - Gather some references if the problem involves related knowledge of other areas.  
    5 - Implement the solution in Java with comments to explain each part. 

## Problems

**1.1.9: Write a code fragment that puts the binary representation of a positive _integer N_ into a _String s_.**

**_Observation:_**
The book already provides a much simpler solution:

```java
String s="";

for(int n=N; n > 0 ; n /= 2) {
  s = (n % 2) + s;
}
```

compared to
the [implemented](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms/fundamentals/DecimalTo.java)
below, and there's one in
the [Java API](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#toBinaryString-int-), too.

But, to understand why these solutions works, it's important to try to create / recreate your own implementation.

**_Solution:_**

Decomposing this problem is very easy, it's giving us the input and output:

    - Inputs: an integer (int) variable 'N'.
    - Output: a String 's' representing the binary form of the decimal number.

To define a **_Procedure_** to solve it's necessary an overview
of [Positional notation](https://en.wikipedia.org/wiki/Positional_notation)
and [Numeral Systems](https://en.wikipedia.org/wiki/Numeral_system).

The definition is taken from a [Quora](https://www.quora.com)
question ["What is a positional number system?"](https://www.quora.com/What-is-a-positional-number-system)

> A positional (numeral) system is a system for representation of numbers by an ordered set of numerals symbols (called
> digits) in which the value of a numeral symbol depends on its position

Exemplifying:

In a straightforward manner, it's saying that a decimal number, for example 36, is equal to the sum of two numbers (
digits) multiplied by powers of 10.

Reading the number 36, from right to left (units, dozens, etc.), increases the power of the base starting from 10 raised
to 0 (i.e, 10<sup>0</sup>):

> 36 = (6 $\times$ 10<sup>0</sup>) + (3 $\times$ 10<sup>1</sup>)<br>
> 36 = (6 $\times$ 1) + (3 $\times$ 10)<br>
> 36 = 6 + 30<br>
> 36 = 36

The quantity of numerals (or symbols Indo-Arabic) are the same as the base.

For example, base 10 has { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } digits.

The rule for the symbols is: start from 0 until _base - 1_.

So the base two, starting from 0 until (2 - 1) has { 0, 1 }.

From right to left, the representation of the binary number 1010<sub>2</sub> in base ten is:

> 1010<sub>2</sub> = (0 $\times$ 2<sup>0</sup>) + (1 $\times$ 2<sup>1</sup>) + (0 $\times$ 2<sup>2</sup>) + (1 $\times$ 2<sup>3</sup>)<br>
> 1010<sub>2</sub> = (0 $\times$ 1) + (1 $\times$ 2) + (0 $\times$ 4) + (1 $\times$ 8)<br>
> 1010<sub>2</sub> = 0 + 2 + 0 + 8<br>
> 1010<sub>2</sub> = 10<br>

With all said, the problem is asking us to implement an algorithm to make the inverse of the example above, i.e, given a
number in base decimal convert it to binary:

> 10 = 1010<sub>2</sub>.

Now, it's necessary to understand very little about [Number theory](https://en.wikipedia.org/wiki/Number_theory)
basics: **Euclid's Division Algorithm**.

In summary, It's about multiples and divisors of integer numbers and states the follow:

> Suppose _n_ is a natural number, $n \in \mathbb{N}$ (i.e, 1, 2, 3, ..., etc.) not null (n $\gt$ 0).<br>
>
> If _m_ is a natural number, so _m_ is a multiple of _n_ OR it is between two consecutive multiples of _m_.<br>
> 
> In algebraic notation: ( _m_ $\times$ q ) $\leq$ _n_ $\lt$ _m_ $\times$ (q + 1)<br>
>
> If (_m_ $\times$ q) $\leq$ _n_ (a multiple of _m_ is less than _n_), implies that there's a natural number r (remainder) such
> that: 
> 
> _n_ = ( _m_ $\times$ q ) + r , (r $\lt$ _m_).<br>
> 
> If r = 0, so _n_ = ( _m_ $\times$ q ), i.e, _m_ is multiple of _n_.

The above explanation is the follow theorem:

> For any natural numbers _n_ and _m_, with _m_ $\ne$ 0 (not null), there exists only one pair of numbers _q_ and _r_ such
> that:
> 
> _n_ = ( _m_ $\times$ q ) + r.

Let's use numbers to see that:

> Let: ( _m_ $\times$ q ) $\leq$ _n_ $\lt$ _m_ $\times$ (q + 1)<br>
> 
> With: _n_ = 73 and _m_ = 5<br>
> 
> We have: (5 $\times$ q) $\leq$ 73 $\lt$ 5 $\times$ (q + 1)<br>
> 
> Then: q = 14 and (5 $\times$ 14) $\leq$ 73 $\lt$ 5 $\times$ (14 + 1)<br>
> 
> Is equal to: 70 $\leq$ 73 $\lt$ 75<br>
> 
> The only natural numbers to represent the inequality are:
> 
> q = 14, 
> 
> r = 73 - (5 $\times$ 14) = 3 [ remember, r = _n_ - ( _m_ $\times$ q ) ].
> 
> So: 73 = (5 $\times$ 14) + 3.

These concepts show that any number **n** (n $\gt$ 1) in a base **b**, with **m** being the numerals {0, 1, 2, ..., (b - 1)
}, can be represented uniquely as:

> **n** = m<sub>0</sub> + m<sub>1</sub> $\times$ **b**<sup>1</sup> + m<sub>2</sub> $\times$ **b**<sup>2</sup> + ... + m<sub>i</sub> $\times$ **b**<sup>i</sup> ( i $\geq$ 0 and m<sub>i</sub> $\neq$ 0)

or

> __n__ = ( __b__ $\times$ q ) + m<sub>0</sub>

representing ( __b__ * q ) as:

> ( __b__ $\times$ q ) = m<sub>1</sub> $\times$ __b__<sup>1</sup> + m<sub>2</sub> $\times$ __b__<sup>2</sup> + ... + m<sub>i</sub> $\times$ __b__<sup>i</sup>

using the **distributive property**:

> m<sub>1</sub> $\times$ __b__<sup>1</sup> + m<sub>2</sub> $\times$ __b__<sup>2</sup> + ... + m<sub>i</sub> $\times$ __b__<sup>i</sup> = __b__ $\times$ (m<sub>1</sub> + m<sub>2</sub> $\times$ __b__<sup>1</sup> + m<sub>3</sub> $\times$ __b__<sup>2</sup> + ... + m<sub>i</sub> $\times$ __b__<sup>i - 1</sup>)

we reach the form:

> __n__ = __b__ $\times$ (m<sub>1</sub> + m<sub>2</sub> $\times$ __b__<sup>1</sup> + m<sub>3</sub> $\times$ __b__<sup>2</sup> + ... + m<sub>i</sub> $\times$ __b__<sup>i - 1</sup>) + m<sub>0</sub>

with all __m<sub>i</sub>__'s = {0, 1,..., (b - 1)}.

Plugging the example numbers:

> 36 = 10 $\times$ (3) + 6 {m<sub>0</sub>=6 and m<sub>1</sub>=3}

> 365 = 10 $\times$ (6 + 3 $\times$ 10<sup>1</sup>) + 5 {m<sub>0</sub>=5, m<sub>1</sub>=6 and m<sub>2</sub>=3}

> 1010<sub>2</sub> = 2 $\times$ (1 + 0 $\times$ 2<sup>1</sup> + 1 $\times$ 2<sup>2</sup>) + 0 {m<sub>0</sub>=0, m<sub>1</sub>=1, m<sub>2</sub>=0 and m<sub>3</sub>=1}

So, to convert any number __n__ (written in base ten) to binary, it's necessary that its representation be of the form:

__n__ = 2 $\times$ (m<sub>1</sub> + m<sub>2</sub> $\times$ __b__<sup>1</sup> + m<sub>3</sub> $\times$ __b__<sup>2</sup> + ... + m<sub>i</sub> $\times$ __b__<sup>i - 1</sup>) + m<sub>0</sub>

with all __m<sub>i</sub>__'s = {0, 1}.

Doing that is just a matter of using successive divisions by the base we wish to convert __keeping each remainder and
the last quotient until it's {0, 1}__:

> 36 = ????<sub>2</sub>

Start dividing by the base:

> 36 $\div$ 2 = 18 (remainder=0, that's the m<sub>0</sub> digit)

The quotient is 18 not {0, 1}, keep dividing by the base:

> 18 $\div$ 2 = 9 (remainder=0, that's the m<sub>1</sub> digit)

The quotient is 9 not {0, 1}, keep dividing by the base:

> 9 $\div$ 2 = 4 (remainder=1, that's the m<sub>2</sub> digit)

The quotient is 4 not {0, 1}, keep dividing by the base:

> 4 $\div$ 2 = 2 (remainder=0, that's the m<sub>3</sub> digit)

The quotient is 2 not {0, 1}, keep dividing by the base:

> 2 $\div$ 2 = 1 (remainder=0, that's the m<sub>4</sub> digit)

Finally, the quotient is 1 (the m<sub>5</sub> digit).

All the __m<sub>i</sub>__'s are m<sub>0</sub>=0, m<sub>1</sub>=0, m<sub>2</sub>=1, m<sub>3</sub>=0, m<sub>4</sub>=0,
m<sub>5</sub>=1.

> 36 = 2 $\times$ (m<sub>1</sub> + m<sub>2</sub> $\times$ 2<sup>1</sup> + m<sub>3</sub> $\times$ 2<sup>2</sup> + m<sub>4</sub> $\times$ 2<sup>
> 3</sup> + m<sub>5</sub> $\times$ 2<sup>4</sup>) + m<sub>0</sub><br>
> 36 = 2 $\times$ (0 + 1 $\times$ 2<sup>1</sup> + 0 $\times$ 2<sup>2</sup> + 0 $\times$ 2<sup>3</sup> + 1 $\times$ 2<sup>4</sup>) + 0<br>
> 36 = 2 $\times$ (0 + 2 + 0 + 0 + 16) + 0<br>
> 36 = 2 $\times$ (18) + 0<br>
> 36 = 36

Representing as {0, 1} it's just a matter of concatenating all __m<sub>i</sub>__'s (from right to left):

> 36 = m<sub>5</sub>m<sub>4</sub>m<sub>3</sub>m<sub>2</sub>m<sub>1</sub>m<sub>0</sub> = 100100<sub>2</sub>

Implement this procedure as
a [static method](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms/fundamentals/DecimalTo.java)
in Java:

```java
public class DecimalTo {

    public static String binary(int n) {

        // Assuming only positive integers (not dealing with sign)
        n = Math.abs(n);

        // If n is {0,1} just return it
        if (n < 2) {
            return String.valueOf(n);
        }

        // Using StringBuilder to improve performance
        StringBuilder buffer = new StringBuilder();

        // Flag to stop the iteration        
        boolean quotientNotZeroOrOne = true;

        // Start the sucessive divisions keeping the remainder    
        while (quotientNotZeroOrOne) {

            // Use module operator to get the remainder            
            int remainder = n % 2;

            // Append the remainder because it always go to the result            
            buffer.append(String.valueOf(remainder));

            // Divide by the base      
            n /= 2;

            // Check if the quotient is {0, 1} to stop the iteration      
            if (n < 2) {
                // The last quotient is the highest order term
                buffer.append(String.valueOf(n));

                // Set the flag to false to stop the iteration
                quotientNotZeroOrOne = false;
            }
        }

        // Return the result in reverse order (right from left)
        return buffer.reverse().toString();
    }

}
```

__Obs.:__ The problem statement does not specify, but this solution can be implemented with recursion and a Stack,
LIFO (last-in-first-out).
Soon I'm going to do that and show the difference.

The [test case](https://github.com/julianomacielferreira/Algorithms/blob/master/test/algorithms/fundamentals/DecimalToTest.java)
is very simple:

```java
public class DecimalToTest {

    /**
     * Test of binary method, of class DecimalTo.
     */
    @Test
    public void testBinary() {
        assertEquals("0", DecimalTo.binary(0));
        assertEquals("1", DecimalTo.binary(1));
        assertEquals("10", DecimalTo.binary(2));
        assertEquals("1010", DecimalTo.binary(10));
        assertEquals("100100", DecimalTo.binary(36));
        assertEquals("111010110111100110100010101", DecimalTo.binary(123456789));
    }

    /**
     * Test of binary method, of class DecimalTo, compared to the Java API.
     */
    @Test
    public void testBinaryWithJavaAPI() {
        assertEquals(Integer.toBinaryString(0), DecimalTo.binary(0));
        assertEquals(Integer.toBinaryString(1), DecimalTo.binary(1));
        assertEquals(Integer.toBinaryString(2), DecimalTo.binary(2));
        assertEquals(Integer.toBinaryString(10), DecimalTo.binary(10));
        assertEquals(Integer.toBinaryString(36), DecimalTo.binary(36));
        assertEquals(Integer.toBinaryString(123456789), DecimalTo.binary(123456789));
    }

}
```

**1.1.11: Write a code fragment that prints the contents of a two-dimensional boolean array, using * to represent true
and a space to represent false.
Include row and column numbers.**

**Solution:**

The input and output to this problem are:

    - Input: a two-dimensional boolean array like boolean[][] booleanArray = {{false, true}, {true, false}}
    - Output: a representation of the array using '*' for true and ' ' (space) for false

_Example:_

```java
boolean[][]booleanArray={{false,true},{true,false}};
```

|   | 1 | 2 |
|---|---|---|
| 1 |   | * |
| 2 | * |   |

Assuming that the two-dimensional array is not [ragged](https://en.wikipedia.org/wiki/Jagged_array),
the [solution](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms/fundamentals/BooleanArray.java):

```java
public class BooleanArray {

    /**
     * This method prints the contents of a two-dimensional boolean
     * array, using '*' to represent true and a 'space' to represent
     * false (includes row and column numbers).
     *
     * @param booleanArray boolean array
     * @return two-dimensional boolean array string representation
     */
    public static String format(boolean[][] booleanArray) {

        try {

            // Using StringBuilder to improve performance
            StringBuilder output = new StringBuilder();

            // Get the length of first column to format the header (column numbers)
            int columns = booleanArray[0].length;

            // Add four spaces to start exactly above the first column
            addSpaceToOutput(4, output);

            // Add the column header to output            
            for (int j = 1; j <= columns; j++) {
                output.append(j);
                addSpaceToOutput(1, output);
            }

            // Append new line before start the rows and columns
            output.append("\n");

            // Iterate over the rows
            for (int i = 0; i < booleanArray.length; i++) {

                // Add the row number to output 
                output.append(i + 1);

                addSpaceToOutput(1, output);

                // Add the first separator of each row
                output.append("|");

                addSpaceToOutput(1, output);

                // Iterate over each column of the i'th row
                for (int j = 0; j < booleanArray[i].length; j++) {

                    // If it's true add '*'
                    if (booleanArray[i][j]) {

                        output.append("*");
                        addSpaceToOutput(1, output);

                    } else {
                        // False add two ' ' (spaces)
                        addSpaceToOutput(2, output);
                    }
                }

                // Append the separator and add new line
                output.append("|\n");
            }

            return output.toString();

        } catch (Exception e) {
            return "Array is empty!";
        }

    }

    /**
     * Append an empty space to string builder.
     *
     * @param quantity
     * @param output
     */
    private static void addSpaceToOutput(int quantity, StringBuilder output) {

        final String space = " ";

        for (int i = 0; i < quantity; i++) {
            output.append(space);
        }
    }
}
```

The [test case](https://github.com/julianomacielferreira/Algorithms/blob/master/test/algorithms/fundamentals/BooleanArrayTest.java)
is very simple:

```java
public class BooleanArrayTest {

    /**
     * Test of format method, of class BooleanArray.
     */
    @Test
    public void testFormat() {

        String expResult = "    1 2 \n1 |   * |\n2 | *   |\n3 | * * |\n";

        boolean[][] booleanArray1 = {{false, true}, {true, false}, {true, true}};
        String result1 = BooleanArray.format(booleanArray1);

        assertEquals(expResult, result1);

        boolean[][] booleanArray2 = {{true, true}, {true, true}, {true, true}};
        String result2 = BooleanArray.format(booleanArray2);

        assertNotEquals(expResult, result2);
    }

}
```

**1.1.13: Write a code fragment to print the transposition (rows and columns changed) of a two-dimensional array with M
rows and N columns.**

**_Solution:_**

Decomposing this problem is very easy, it's giving us the input and output:

    - Input: a two-dimensional array.
    - Output: a transposed two-dimensional array.

_Example:_

Suppose _a_ is 3x3 matrix:

```java
Integer[][]a={{1,2,3},{4,5,6},{7,8,9}};
```

| 1 | 2 | 3 |
|---|---|---|
| 4 | 5 | 6 |
| 7 | 8 | 9 |

the transposed is:

```java
Integer[][]b={{1,4,7},{2,5,8},{3,6,9}};
```

| 1 | 4 | 7 |
|---|---|---|
| 2 | 5 | 8 |
| 3 | 6 | 9 |

Assuming that the two-dimensional array is not ragged,
the [solution](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms/fundamentals/Matrix.java)
is very straightforward:

```java
public class Matrix<T> {

    /**
     * Make the transposition (rows and columns changed) of a two-dimensional
     * array, NOT ragged, with M rows and N columns.
     *
     * @param <T> type of the array elements
     * @param a two-dimensional array NOT ragged.
     * @return the transpose of the array.
     */
    public static <T> T[][] transpositionOf(T a[][]) {

        // The columns of transposed is the number of rows of a (a.length).
        int columns = a.length;

        // Because a is not ragged, all rows have the same number os columns 
        // and it's enough get the length of one column.
        int rows = a[0].length;

        // Instantiate an array of base type Object, and cast it to T type.        
        T[][] transposed = (T[][]) new Object[rows][columns];

        for (int i = 0; i < a.length; i++) { // Iterate over the rows of a.  
            for (int j = 0; j < a[i].length; j++) { // Iterate over the columns of each i-row.        
                transposed[j][i] = a[i][j]; // Here is where the swap happens.
            }
        }

        return transposed;
    }
}
```

The [test case](https://github.com/julianomacielferreira/Algorithms/blob/master/test/algorithms/fundamentals/MatrixTest.java)
is very simple:

```java
public class MatrixTest {

    /**
     * Test of transposition method, of class Matrix.
     */
    @Test
    public void testTranspositionOf() {

        Integer[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] b = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        assertArrayEquals(b, Matrix.transpositionOf(a));
        assertArrayEquals(a, Matrix.transpositionOf(b));

        Double[][] c = {{1.9, 2.8, 3.7}, {4.6, 5.5, 6.4}, {7.3, 8.2, 9.1}};
        Double[][] d = {{1.9, 4.6, 7.3}, {2.8, 5.5, 8.2}, {3.7, 6.4, 9.1}};

        assertArrayEquals(d, Matrix.transpositionOf(c));
        assertArrayEquals(c, Matrix.transpositionOf(d));
    }

}

```

__Obs.:__ I did not implemented the print method logic because the test case is already checking it.

**1.1.14: Write a static method **lg()** that takes an **int** value as argument and returns the largest int not larger
than the base-2 logarithm of N. Do not use _Math_.**

**Solution:**

Decomposing this problem is very easy, it's giving us the input and output:

    - Input: an integer N.
    - Output: the largest integer not greater than base-2 log of n.

So, just divide the integer N by 2 and keep tracking of how many times the remainder continues above 1, incrementing a
variable that is going to be the 2 exponent.

```java
public class LargestInteger {

    /**
     * This method takes an integer value as argument and returns the largest
     * integer not larger than the base-2 logarithm of N (not using Math).
     *
     * @param n an arbitrary integer
     * @return the largest integer not greater than base-2 log of n
     */
    public static int lg(int n) {

        int largestIntegerNotGreater = 0;

        for (int i = n; i > 1; i = i / 2) {
            largestIntegerNotGreater++;
        }

        return largestIntegerNotGreater;
    }
}
```

The [test case](https://github.com/julianomacielferreira/Algorithms/blob/master/test/algorithms/fundamentals/LargestIntegerTest.java)
is very simple:

```java
public class LargestIntegerTest {

    /**
     * Test of lg method, of class LargestInteger.
     */
    @Test
    public void testLg() {

        assertEquals(1, LargestInteger.lg(3));
        assertEquals(2, LargestInteger.lg(4));
        assertEquals(2, LargestInteger.lg(6));
        assertEquals(2, LargestInteger.lg(7));
        assertEquals(3, LargestInteger.lg(8));
    }

}
```

**1.1.15: Write a static method _histogram()_ that takes an array a[] of _int_ values and an integer M as argument and
returns an array of length M whose ith entry is the number of times
the integer i appeared in the argument array. If the values in a[] are all between 0 and M-1, the sum of the values in
the returned array should be equal to a.length.**

**Solution:**

Decomposing the input and output:

    - Input: an array a[] of int values and an integer M.
    - Output: an array of length M whose ith entry is the number of times the integer i appeared in the argument array.

The solution is straightforward, just iterating the returned array and using a temporary variable to keep counting how
many
times the 'ith' integer appears as value of the argument array.

```java
public class Histogram {

    /**
     * Takes an array a[] of int values and an integer M as argument and returns
     * an array of length M whose ith entry is the number of times the integer i
     * appeared in the argument array.
     *
     * @param argArray argument array
     * @param M length M of the returned array
     * @return
     */
    public static int[] numberOfTimesIAppearedIn(int argArray[], int M) {

        int returnedArray[] = new int[M];

        // If the values in a[] are all between 0 and M - 1 the sum of the 
        // values in the returned array should be equal to a.length.
        for (int i = 0; i < returnedArray.length; i++) {
            int totalIth = 0;

            for (int j = 0; j < argArray.length; j++) {
                if (argArray[j] == i) {
                    totalIth++;
                }
            }

            returnedArray[i] = totalIth;
        }

        return returnedArray;
    }
}
```

The [test case](https://github.com/julianomacielferreira/Algorithms/blob/master/test/algorithms/fundamentals/HistogramTest.java)
is very simple:

```java
public class HistogramTest {

    /**
     * Test of numberOfTimesIAppearedIn method, of class Histogram.
     */
    @Test
    public void testNumberOfTimesIAppearedIn() {

        int[] a = {1, 1, 2, 2, 3, 4, 5, 6};

        int M = 7;

        int[] expResult = {0, 2, 2, 1, 1, 1, 1};

        int[] result = Histogram.numberOfTimesIAppearedIn(a, M);

        assertArrayEquals(expResult, result);
    }

}
```

**1.1.19: Run the following program on your computer:**

```java
public class Fibonacci {

    public static long F(int N) {

        if (N == 0) return 0;
        if (N == 1) return 1;

        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {

        for (int N = 0; N < 100; N++) {
            StdOut.println(N + " " + F(N));
        }
    }
}
```

**What is the largest value of N for which this program takes less than 1 hour to compute the value of F(N)?**

    - When reach 34 it completely slows down.

**Develop a better implementation of F(N) that saves computed values in ~~an array~~ HashMap.**

**Solution:**

Decomposing the input and output:

    - Input: an integer N.
    - Output: the Fibonacci of N.

First, the definition of [Fibonacci number](https://en.wikipedia.org/wiki/Fibonacci_number) by Wikipedia is:

> In mathematics, the Fibonacci numbers, commonly denoted Fn,
> form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting
> from 0 and 1.

To optimize the solution we have to use [Memoization](https://en.wikipedia.org/wiki/Memoization) technique alongside
with recursion.

```java
public class Fibonacci {

    // Use a Map to dynamically add and retrieve by key the values already computed    
    private static final Map<Integer, Long> RESULT_CACHE = new HashMap<>();

    /**
     * Computes the Fibonacci number of N
     *
     * @param N
     * @return
     */
    public static long F(int N) {

        // If we cached the value, then return it
        if (RESULT_CACHE.containsKey(N)) {
            return RESULT_CACHE.get(N);
        }

        // Compute the Nth term 
        long fibonnaci_value;

        switch (N) {
            case 0:
                fibonnaci_value = 0;
                break;
            case 1:
                fibonnaci_value = 1;
                break;
            default:
                fibonnaci_value = F(N - 1) + F(N - 2);
                break;
        }

        // Cache the value and return it        
        RESULT_CACHE.put(N, fibonnaci_value);

        return fibonnaci_value;
    }
}
```

The [test case](https://github.com/julianomacielferreira/Algorithms/blob/master/test/algorithms/fundamentals/FibonacciTest.java)
is very trivial:

```java
public class FibonacciTest {

    /**
     * Test of F method, of class Fibonacci.
     */
    @Test
    public void testF() {

        int N = 6; // F(6) = [0 + 1 = 1], [1 + 2 = 3], [3 + 5 = 8]

        assertEquals(8L, Fibonacci.F(N));

        N = 80; // F(80) = 3 x 5 x 7 x 11 x 41 x 47 x 1601 x 2161 x 3041

        assertEquals(23416728348467685L, Fibonacci.F(N));
    }

}
```

**1.1.20: Write a recursive static method that computes the value of ln(N!)**

**Solution:**

Decomposing the input and output:

    - Input: an integer N.
    - Output: the value of the natural logarithm (ln) of N factorial (N!).

First, the definition of [Factorial](https://en.wikipedia.org/wiki/Factorial) by Wikipedia is:

> In mathematics, the factorial of a positive integer n, denoted by n!, is the product of all positive integers less
> than or equal to n:
>
> n! = n * (n - 1) * (n - 2) * ... * 2 * 1

Again, to optimize the solution we have to use [Memoization](https://en.wikipedia.org/wiki/Memoization) technique
alongside with recursion (as in 1.1.19 exercise).

```java
public class Factorial {

    // Use a Map to dynamically add and retrieve by key the values already computed    
    private static final Map<Integer, Long> RESULT_CACHE = new HashMap<>();

    /**
     * Computes the Factorial number of N
     *
     * @param N
     * @return
     */
    public static long compute(int N) {

        // If we cached the value, then return it
        if (RESULT_CACHE.containsKey(N)) {
            return RESULT_CACHE.get(N);
        }

        // Compute the Nth term 
        long factorial_value;

        if (N == 0) {

            factorial_value = 1;

        } else {

            factorial_value = N * compute(N - 1);
        }

        // Cache the value and return it        
        RESULT_CACHE.put(N, factorial_value);

        return factorial_value;
    }
}
```

**1.1.21: Write a program that reads in lines from standard input with each line containing a name and two integers and
then uses printf() to print a table with a column of names, the integers, and the result of dividing the first by the
second, accurate to three decimal places. You could use a program like this to tabulate batting averages for baseball
players or grades for students.**

**Solution:**

Decomposing the input and output:

    - Input: Read lines from console using (StdIn)
    - Output: Output in the console a table with a column of names, more two columns for the integers and the last column with the result of dividing the first by the second with three decimal places.

The solution implementation:

```java
public class Division {

    /**
     * Reads in lines from standard input with each line containing a name and two integers and then uses printf()
     * to print a table with a column of names, the integers, and the result of dividing the first by the second,
     * accurate to three decimal places
     */
    public static void print() {

        // Ask the user to type in console
        StdOut.println("Type a name and two integers in each line:");

        // While user does not type ctrl D, its tries to read a line
        while (!StdIn.isEmpty()) {
            // Remove spaces from beginning and end of the string
            String line = StdIn.readLine().trim();

            // Split or separate the string in 3 parts using blank space as divider
            String[] inputs = line.split(" ");

            try {
                // Get the name in the first position of the array
                String name = inputs[0];

                // Get the first number in the second position of the array
                int firstNumber = Integer.parseInt(inputs[1]);

                // Get the second number in the third position of the array
                int secondNumber = Integer.parseInt(inputs[2]);

                // Calculate the result dividing and casting to float
                float result = (float) firstNumber / secondNumber;

                // Print the line with a tab space between each value
                StdOut.printf("%s\t%d\t%d\t%.3f\n", name, firstNumber, secondNumber, result);

            } catch (IndexOutOfBoundsException ex) {
                StdOut.print(ex.getMessage());
            }

        }
    }
}
```

**1.1.22: Write a version of BinarySearch that uses the recursive rank() given on page 25 and _traces_ the method calls.
Each time the recursive method is called , print the argument values lo and hi, indented by depth of the recursion. _
Hint_: Add an argument to the recursive method that's keeps track of the depth.**

**Solution:**

Decomposing the input and output:

    - Input: An integer value to be found and the array of values
    - Output: The value position in the array or negative minus 1 if its not present.

One implementation of solution is very straightforward:

```java
public class BinarySearchRecursive {

    private static int depth;
    private static final StringBuilder tabs = new StringBuilder();

    /**
     * This method is an implementation of binary search algorithm
     * to find integers in an ordered array
     *
     * @param key int
     * @param arr int[]
     * @return the key (arr index) if found, -1 otherwise
     */
    public static int rank(int key, int[] arr) {
        return rank(key, arr, 0, arr.length - 1);
    }

    public static int rank(int key, int[] arr, int lo, int hi) {

        traceRecursiveCalls(lo, hi);

        // index of key in arr[], if present,
        // is not smaller than lo and not larger than hi
        if (lo > hi)
            return -1;

        int middle = lo + (hi - lo) / 2;

        if (key < arr[middle])
            return rank(key, arr, lo, middle - 1);
        else if (key > arr[middle])
            return rank(key, arr, middle + 1, hi);
        else
            return middle;
    }

    private static void traceRecursiveCalls(int lo, int hi) {

        depth++;

        tabs.append('\t');

        StdOut.printf("%slo=%d, hi=%d\n", tabs, lo, hi);
    }
}
``` 

**1.1.23: Add to the BinarySearch test client the ability to respond to a second argument: + to print numbers from
standard input that _are not_ in the whitelist, - to print numbers that _are_ in the whitelist.**

**Solution:**

Decomposing the input and output:

    - Input: String parameter '+' or '-' from command line.
    - Output: The numbers from "4Kints.txt" that are in the whitelist ("1Kints.txt") and the numbers that are not in the list

First implementing the BinarySearch class:

```java
public class BinarySearch {

    private final int[] numbers;

    public BinarySearch(int[] numbers) {
        this.numbers = numbers;
    }

    public int findIndexOf(int value) {

        int lo_index = 0;
        int hi_index = this.numbers.length - 1;

        while (lo_index <= hi_index) {

            int mid_index = lo_index + (hi_index - lo_index) / 2;

            if (value < this.numbers[mid_index]) {
                hi_index = mid_index - 1;
            } else if (value > this.numbers[mid_index]) {
                lo_index = mid_index + 1;
            } else {
                return mid_index;
            }
        }

        return -1;
    }
}
```

And then implementing the BinarySearchTestClient class to read the command line parameter:

```java
import java.util.Arrays;

public class BinarySearchTestClient {

    public static void main(final String[] args) {

        String param = args[0];
        
        if(param == null) throw new RuntimeException("No parameter found");
        
        int[] numbers = In.readInts("./data/4Kints.txt");
        int[] numbersToFind = In.readInts("./data/1Kints.txt");

        Arrays.sort(numbers);
        Arrays.sort(numbersToFind);
        
        if(param.equals("+")) {
            printNumbersThatAreNotInWhiteList(numbers, numbersToFind);
        } else if(param.equals("-")) {
            printNumbersThatAreInWhitelist(numbers, numbersToFind);
        }
    }
    
    private static void printNumbersThatAreInWhitelist(final int[] numbers, int[] numbersToFind) {

        BinarySearch binarySearch = new BinarySearch(numbers);

        for (Integer number : numbersToFind) {

            int index = binarySearch.findIndexOf(number);

            if (index > -1) {
                StdOut.println(String.format("The number %s is at the list", number));
            }
        }

    }

    private static void printNumbersThatAreNotInWhiteList(final int[] numbers, int[] numbersToFind) {

        BinarySearch binarySearch = new BinarySearch(numbers);

        for (Integer number : numbersToFind) {

            int index = binarySearch.findIndexOf(number);

            if (index == -1) {
                StdOut.println(String.format("The number %s is not in the list", number));
            }
        }
    }
}
```

**1.1.24: Give the sequence of values of _p_ and _q_ that are computed when Euclid's algorithm is used to compute the
greatest common divisor of 105 and 24. Extend the code given on page 4 to develop a program Euclid that takes two
integers from the command line and computes their greatest common divisor, printing out two arguments for each call on
the recursive method. Use your program to compute the greatest common divisor of 1111111 and 1234567.**

Decomposing the input and output:

    - Input: two integers from the command line.
    - Output: greatest common divisor, printing out two arguments for each call on the recursive method.

In the code solution, first implement a class with the gcd algorithm:

```java
import edu.princeton.cs.algs4.StdOut;

public class EuclidsGCD {

    public static int compute(int p, int q) {

        StdOut.println(String.format("gcd(p: %s, q: %s)", p, q));

        if (q == 0) return p;

        int remainder = p % q;

        return compute(q, remainder);
    }
}
```

Create the test client reading the two parameters from command line:

```java
public class EuclidsGCDTestClient {

    public static void main(final String[] args) {

        String p = args[0];
        String q = args[1];

        if (p == null || q == null) throw new RuntimeException("No parameters found");

        int gcd = EuclidsGCD.compute(Integer.valueOf(p), Integer.valueOf(q));
        StdOut.println(String.format("greatest common divisor of %s and %s is %s", p, q, gcd));
    }
}
```

**1.1.25 Use mathematical induction to prove that Euclid's algorithm computes the greatest common divisor of any pair 
of non-negative integers p and q.**

First, we need to know what is <ins>**mathematical induction**</ins>:

> It's a method used to prove that a mathematical statement is true for all positive integers (or sometimes for all 
> integers greater than a certain number). It involves two main steps:
> 1. <ins>**Base Case**</ins>: Prove that the statement is true for the smallest possible value (usually 1 or 0).
> 2. <ins>**Inductive Step**</ins>: Assume that the statement is true for some arbitrary value (k), and then prove that is true for the next value (k+1). 
>
> If both steps are successfully proven, then the statement is true for all positive integers (or all integers greater than the base case). 

The solution is just textual with mathematics symbology and logic:

> **Step 1**: <ins>**Base Case**</ins>
>
> To prove that Euclid's algorithm computes the greatest common divisor (GCD) of any pair of non-negative integers **_p_** and **_q_**,
> we start with the base case, i.e, when **_q = 0_**.
>
> When **_q = 0_**, the algorithm returns **_p_**, which is indeed the GCD of **_p_** and **_0_** since the GCD of **_any number_** and **_0_** is the number itself.
>
> **Step 2**: <ins>**Inductive Hypothesis**</ins>
> 
> Assume that Euclid's algorithm correctly computes the GCD for all pairs (**_p_**, **_q_**) where **_q_** < **_k_**, for some positive integer **_k_**.
> Specifically, we assume that GCD(**_p_**, **_q_**) = GCD(**_q_**, **_r_**), where **_r_** is the remainder of "**_p_** 
> divided by **_q_**" (i.e, **_p_** = **_a_** * **_q_** + **_r_** for some integer **_a_**).
>
> **Step 3**: <ins>**Inductive Step**</ins> 
> 
> Now, consider the case when **_q_** = **_k_**. According to Euclid's algorithm, we compute the remainder **_r_** of "**_p_** divided by **_q_**" and 
> then find GCD(**_q_**, **_r_**). 
>
> By the division algorithm, **_p_** = **_a_** * **_q_** + **_r_** for some integer **_a_** and **_r_** where 0 &le; **_r_** < **_q_**.
> Any common divisor of **_p_** and **_q_** must also divide **_r_** (since **_r_** = **_p_** - **_a_** * **_q_**, remember from algebra!),
> and any common divisor of **_q_** and **_r_** must also divide **_p_**. 
> 
> Therefore, the set of common divisors of **_p_** and **_q_** is the same as the set 
> of common divisors of **_q_** and **_r_**, which implies that GCD(**_p_**, **_q_**) = GCD(**_q_**, **_r_**). 
>
> **Step 4**: <ins>**Conclusion of induction**</ins> 
> 
> Given that GCD(**_p_**, **_q_**) = GCD(**_q_**, **_r_**) and **_r_** < **_q_** (**_q_** = **_k_**), by the inductive hypotheses (Step 3),
> Euclid's algorithm correctly computes GCD(**_q_**, **_r_**), and thus it correctly computes GCD(**_p_**, **_q_**) for **_q_** = **_k_**.
> 
> This concludes the inductive step.
>
> <ins>**Conclusion**</ins>
> 
> By mathematical induction, Euclid's algorithm computes the greatest common divisor of any pair of non-negative integers **_p_** and **_q_**.
> 
> Example:
> 
> Compute the GCD of 542 and 234: 
> 
> - 542 = 2 * 234 + 74 (**_p_** = 542, **_q_** = 234, **_a_** = 2 and **_r_** = 74)
> - 234 = 3 * 74 + 12 (**_p_** = 234, **_q_** = 74, **_a_** = 3 and **_r_** = 12)
> - 74 = 6 * 12 + 2 (**_p_** = 74, **_q_** = 12, **_a_** = 6 and **_r_** = 2)
> - 12 = 6 * 2 + 0 (**_p_** = 12, **_q_** = 2, **_a_** = 6 and **_r_** = 0)
> 
> So, the GCD(2, 0) = 2, what implies that the GCD(542, 234) = 2.


**1.1.27 _Binomial Distribution_. Estimate the number of recursive calls that would be used by the code**

```java
public static double binomial(int N, int k, double p) {
    
    if((N == 0) && (k == 0)) 
        return 1.0;
    
    if((N < 0) || (k < 0))
        return 0.0;
    
    return (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
}
```
**to compute binomial(100, 50, 0.25). Develop a better implementation that is based on saving
computed values after the sort.**

Again, like in exercise 1.1.25, we need some background to understand the code solution. Let's see a definition of what is a "Binomial Distribution":

> The binomial distribution is a discrete probability distribution that models the number of successes
> in a fixed number of independent trials, where each trial has a constant probability of success.
> 
> It's commonly used to analyse and predict the outcomes of experiments or events that have two possible outcomes, such as:
> 
> - Success or failure
> - Yes or no
> - Heads or tails
> 
> The binomial distribution is characterized by three parameters:
> 
> - 1. **n**: The number os trials
> - 2. **p**: The probability of success in each trial
> - 3. **x**: The number of successes
> 
> The probability of getting exactly x successes in n trials is given by binomial probability formula:
> 
> P(X = x) = (n choose x) $\times$ p<sup>x</sup> $\times$ (1-p)<sup>(n-x)</sup>
> 
> The binomial distribution has many real-world applications, such as:
> 
> - Predicting the number of defective products in a batch
> - Analyzing the results of medical trials
> - Modeling the behavior of stock prices
> 
> Some key properties of the binomial distribution include:
> 
> - Mean (or expected value): np
> - Variance (a measure of how spread out the possible outcomes are around the expected value): np(1-p)
> - Standard deviation (measure the spread or variability of the distribution): $\sqrt{(np(1-p))}$
> 
> The binomial distribution is a fundamental concept in statistics and probability theory, and it's
> widely used in many fields, including business, medicine, social sciences, and engineering.
> 
> A recursive algorithm to calculate the binomial distribution using the following formula:
> 
> P(X = k) = ($\frac{n}{k}$) $\times$ p $\times$ P(X = k-1) $\div$ q + (1 - ($\frac{n}{k}$) $\times$ $\frac{p}{q}$) $\times$ P(X = k)
> 
> where:
> - P(X = k) is the probability of k successes
> - n is the number of trials
> - k is the number of successes
> - nCk is the number of combinations of n items taken k at a time (binomial coefficient)
> - p is the probability of successes
> - q is the probability of failure (q = 1 - p)
> 
> However, this approach is not efficient. A better approach is to calculate the binomial coefficients 
> recursively and then use them to calculate the binomial distribution.
> 
> Calculating the binomial coefficients recursively using the following formula:
> 
> nCk = n - 1Ck - 1 + n - 1Ck
> 

In java code:

```java
/**
* @param trials                          The number of trials
* @param probabilityOfSuccessInEachTrial The probability of success in each trial
* @return the binomial coefficient from trials with probability of success
*/
private static double calculateBinomialCoefficient(int trials, int probabilityOfSuccessInEachTrial) {

   // Base case
   if ((probabilityOfSuccessInEachTrial == 0) || (probabilityOfSuccessInEachTrial == trials))
      return 1;
   else // Recursive case
      return calculateBinomialCoefficient(trials - 1, probabilityOfSuccessInEachTrial - 1) + calculateBinomialCoefficient(trials - 1, probabilityOfSuccessInEachTrial);
}  
```
 And then using this function to calculate the binomial distribution:

```java
/**
* @param trials                          The number of trials
* @param probabilityOfSuccessInEachTrial The probability of success in each trial
* @param numberOfSuccesses               The number of successes
* @return the number of successes in a fixed number of independent trials
*/
public static double calculate(int trials, int probabilityOfSuccessInEachTrial, double numberOfSuccesses) {

     double probabilityOfFailure = 1 - numberOfSuccesses;

     double coefficient = calculateBinomialCoefficient(trials, probabilityOfSuccessInEachTrial);

     return coefficient * (Math.pow(numberOfSuccesses, probabilityOfSuccessInEachTrial)) * (Math.pow(probabilityOfFailure, (trials - probabilityOfSuccessInEachTrial)));
}
```
But the above recursive algorithm has a really high time complexity due to the repeated calculations of binomial coefficients.
 
It's possible to optimize it using the dynamic programming techniques called memoization, to store and reuse previously calculated binomial coefficients.
 
In java code we just start to use a Map for cache the already computed values:

```java
private static final Map<String, Double> COEFFICIENTS_CACHE = new HashMap();

/**
* @param trials                          The number of trials
* @param probabilityOfSuccessInEachTrial The probability of success in each trial
* @return the binomial coefficient from trials with probability of success
*/
private static double calculateBinomialCoefficient(int trials, int probabilityOfSuccessInEachTrial) {

       final String CACHE_KEY = String.format("%s-%s", trials, probabilityOfSuccessInEachTrial);

        // If we cached the value, then return it
        if (COEFFICIENTS_CACHE.containsKey(CACHE_KEY)) {
            return COEFFICIENTS_CACHE.get(CACHE_KEY);
        }

        // Base case
        if ((probabilityOfSuccessInEachTrial == 0) || (probabilityOfSuccessInEachTrial == trials)) {

            COEFFICIENTS_CACHE.put(CACHE_KEY, 1.0);

            return 1.0;
        }

        // Recursive case
        double binomialCoefficient = calculateBinomialCoefficient(trials - 1, probabilityOfSuccessInEachTrial - 1) + calculateBinomialCoefficient(trials - 1, probabilityOfSuccessInEachTrial);

        // Cache the value and return it
        COEFFICIENTS_CACHE.put(CACHE_KEY, binomialCoefficient);

        return binomialCoefficient;
}
```

**1.1.28 _Remove duplicates_. Modify the test client in BinarySearch to remove any duplicate keys in the whitelist after the sort.**

Decomposing the input and output:

    - Input: The files `largeAllowlist.txt` and `largeText.txt`
    - Output: Each number of the `largeAllowlist.txt` (without duplicated keys) that's in the `largeText.txt`

The implementation of the solution:

```java
import java.util.Arrays;

public class BinarySearchWithoutDuplicateKey {

    private final int[] numbers;

    public BinarySearchWithoutDuplicateKey(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] removeDuplicateKeys(int[] keys) {
        return Arrays.stream(keys).distinct().toArray();
    }

    /**
     * Searches for a specified value in a sorted array using the Binary Search algorithm.
     * <p>
     * This method repeatedly divides the search interval in half. It compares the target
     * value with the element at the middle index of the current interval:
     * <ul>
     *     <li>If the value is smaller than the middle element, the search continues
     *     in the left half of the array.</li>
     *     <li>If the value is greater than the middle element, the search continues
     *     in the right half of the array.</li>
     *     <li>If the value matches the middle element, its index is returned.</li>
     * </ul>
     * The process continues until the value is found or the search interval becomes empty.
     *
     * <p><strong>Precondition:</strong> The array {@code numbers} must be sorted in ascending order.
     *
     * <p><strong>Time Complexity:</strong> O(log n), where n is the length of the array.
     * <br>
     * <strong>Space Complexity:</strong> O(1), since the search is performed iteratively
     * using constant extra space.
     *
     * @param value the integer value to search for in the sorted array
     * @return the index of the value if it exists in the array;
     * -1 if the value is not present
     */
    public int findIndexOf(int value) {

        int lo_index = 0;
        int hi_index = this.numbers.length - 1;

        while (lo_index <= hi_index) {

            int mid_index = lo_index + (hi_index - lo_index) / 2;

            if (value < this.numbers[mid_index]) {
                hi_index = mid_index - 1;
            } else if (value > this.numbers[mid_index]) {
                lo_index = mid_index + 1;
            } else {
                return mid_index;
            }
        }

        return -1;
    }
}
```

Running the following code:

```java
public class Algorithms {
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {

        int[] largeAllowlist = In.readInts("./data/largeAllowlist.txt");
        int[] largeText = In.readInts("./data/largeText.txt");

        Arrays.sort(largeAllowlist);
        Arrays.sort(largeText);

        StdOut.println("BinarySearch removing any duplicate keys in the whitelist after the sort\n\n");
        printNumbersThatAreInWhitelistRemovingDuplicateKeys(largeAllowlist, largeText);
    }

    private static void printNumbersThatAreInWhitelistRemovingDuplicateKeys(final int[] numbers, int[] numbersToFind) {

        BinarySearchWithoutDuplicateKey binarySearchWithoutDuplicateKey = new BinarySearchWithoutDuplicateKey(numbers);
        
        for (Integer number : binarySearchWithoutDuplicateKey.removeDuplicateKeys(numbersToFind)) {

            int index = binarySearchWithoutDuplicateKey.findIndexOf(number);

            if (index > -1) {
                StdOut.println(String.format("The number %s is at the list", number));
            }
        }
    }
}
```

The output:

```bash
The number 949992 is at the list
The number 949996 is at the list
The number 949997 is at the list
...
The number 950022 is at the list
The number 950024 is at the list
```

**1.1.29 _Equal keys_. Add to BinarySearch a static method rank() that takes a key and a sorted array of int values 
(some of which may be equal) as arguments and returns the number of elements that are smaller than the key and a 
similar method count() that returns the number of elements equal to the key. Note: If i and j are the values returned
by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in the array that are equal to _key_.**

Decomposing the input and output:

    - Input: an integer key and a sorted array of int values (some of which may be equal)
    - Output: the number of elements that are smaller than the key and a the number of elements equal to the key

Below is an implementation of Binary search variants that find boundaries:

```java
public class BinarySearchEqualKeys {

    public static int rank(int key, int[] a) {

        // Array must be sorted
        int lo = 0;
        int hi = a.length - 1;
        int result = a.length; // default if key greater than all

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (a[mid] >= key) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return result;
    }

    public static int count(int key, int[] a) {

        int first = indexAt(key, a, true);

        if (first < 0)
            return 0;

        int last = indexAt(key, a, false);

        return last - first + 1;
    }

    public static int indexAt(int key, int[] a, boolean first) {

        int lo = 0;
        int hi = a.length - 1;
        int result = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                result = mid;
                if (first) {
                    hi = mid - 1; // keep searching left
                } else {
                    lo = mid + 1; // keep searching right
                }
            }
        }

        return result;
    }
}
```

If you run, for example with the array:

```
[1, 2, 2, 2, 3, 4]
```

And search for the `key = 2`:

```
firstIndex → 1
lastIndex → 3
rank → 1
count → 3
```

The Time Complexity of each function is `O(log n)`, so:

```
rank → O(log n)
count → O(log n)
```

The main reasonings in this exercise is to realize that the `rank(key)` is not searching for a value.
It's searching for a boundary between two regions:

``` 
< key   >= key
```

For `key=2`:

```
[1 | 2 | 2 | 2 | 3 | 4]
   ^
boundary  
```

While, binary search finds:

```
First index where a[i] ≥ key.
```

That boundary index equals:

```
Number of elements strictly less than key.
```

Now, with `count(key)`, think of two boundaries:

```
< key | == key | > key
```

That's defining:

```
Left boundary → first occurrence
Right boundary → last occurrence
```

So, the distance between them gives count.

**1.1.30 _Array exercise_. Write a code fragment that creates an `N-by-N` boolean array a[][] such that `a[i][j]` is true
if `i` and `j` are relatively prime (have no common factors), and false otherwise.**

Decomposing the input and output:

    - Input: N (Integer), the size of the square boolean array. It will determine the dimensions of the output array (N rows by N columns).
    - Output: a[][] (N-by-N Boolean Array), a two-dimensional array where each element a will be either true or false.

Some constraints / assumptions are:

- `N` is expected to be a positive integer (e.g., `N` >= 1).
- The problem implies indices `i` and `j` will range from `0` to `N-1` (standard array indexing).

Key definition `Relative prime`: Two integers `i` and `j` are relative prime (or coprime) if their only positive common
divisor is 1. This means their Greatest Common Divisor (GCD) is 1 `GCD(i, j) = 1`.

The edge cases for GCD (Greatest Common Divisor):

- `GCD(x, 0)` is typically `x` (or `abs(x)`) .
- `GCD(0, 0)` is often undefined or 0, but for "relative prime" it's usually considered `GCD(0, x)=x`, so `0` isn't 
relatively prime to anything but `1` (which itself is only relatively prime to `1` by strict definition).

**1.1.31 _Random connections_. Write a program that takes as command-line arguments an integer N and a double
value p (between 0 and 1), plots N equally spaced dots of size .05 on the circumference of circle, and then,
with probability p for each pair of points draws a gray line connecting them.**

Decomposing the input and output:

    - Input:
    - Output:

**1.1.32 _Histogram_. Suppose that the standard input stream is a sequence of double values. Write a program that takes
an Integer ``N`` and two double values ``l`` and ``r`` from the command line and uses ``StdDraw`` to plot a histogram of 
the count of the numbers in the standard input stream that fail in each of the N intervals defined by dividing (l, r) 
into N equal-sized intervals.**

Decomposing the input and output:

    - Input:
    - Output:

**1.1.33 _Matrix Library_. Write a library ``Matrix`` that implements the following API:**

```java
public class Matrix {
    
    // vector dot product
    static double dot(double[] x, double[] y) {
        ...
    }
    
    // matrix-matrix product
    static double[][] mult(double[][] a, double[][] b) {
        ...
    }
    
    // transpose
    static double[][] transpose(double[][] a) {
        ...
    }
    
    // matrix-vector product
    static double[] mult(double[][] a, double[] x) {
        ...
    }
    
    // vector-matrix product
    static double[] multi(double[] y, double[][] a) {
        ...
    }
    
}
```

**1.1.34 _Filtering_. Which of the following require saving all the values from standard input (in an array, say), and which
could be implemented as a filter using only a fixed number of variables and arrays of fixed size (not dependent on N)?
For each, the input comes from standard input and consists of _N_ real numbers between 0 and 1.**

- Print the maximum and minimum numbers.
- Print the median of the numbers.
- Print the _k_ th smallest value, for _k_ less than 100.
- Print the sum of the squares of the numbers.
- Print the average of the _N_ numbers.
- Print the percentage of numbers greater than the average.
- Print the _N_ numbers in increasing order.
- Print the _N_ numbers in random order.

**1.1.35 _Dice simulations_. The following code computes the exact probability distribution for the sum of two dice:**

```java
int SIDES = 6;
double[] dist = new  double[2 * SIDES + 1];

for(int i = 1; i <= SIDES; i++)
    for(int j = 1; j <= SIDES; j++)
        dist[i+j] += 1.0;

for(int k = 2; k <= 2 * SIDES; k++)
    dist[k] /= 36.0;
```

**The value ``dist[i]`` is the probability that the dice sum to ``k``. Run experiments to validate this calculation simulating ``N`` 
dice throws, keeping track of the frequencies of occurrence of each value when you compute the sum of two random integers
between 1 and 6. How large does ``N`` have to be before your empirical results match the exact results to three decimal places?**

**1.1.36 _Empirical shuffle check_. Run computational experiments to check that our shuffling code on page 32 works as 
advertised. Write a program ``ShuffleTestClient`` that takes command-line arguments ``M`` and ``N``,
does ``N`` shuffles of an array of size ``M`` that is initialized with ``a[i] = i`` before each shuffle,
and prints an ``M-by-N`` table such that row ``i`` gives the number of times ``i``
wound up in position ``j`` for all ``j``. All entries in the array should be close to ``N/M``.**

Decomposing the input and output:

    - Input: M The size of the array to be shuffled and N The number of times the array is shuffled.
    - Output: an M-by-M table where each row i represents the element i in the original array, each column j represents the position j in the shuffled array. The value at row i and column j is the number of times element i ended up in position j after N shuffles.

The shuffling code on page 32 (the Fisher-Yates shuffle is an unbiased shuffling algorithm):

```java
import edu.princeton.cs.algs4.StdRandom;

/**
 * Shuffles the elements of the given array in place using the Fisher-Yates shuffle algorithm.
 *
 * This method randomly rearranges the elements of the array such that each permutation is 
 * equally likely, ensuring an unbiased shuffle.
 *
 * @param a the array to be shuffled
 */
public static void shuffle(int[] a) {
    int N = a.length;

    for (int i = 0; i < N; i++) {
        // Exchange a[i] with random element in a[i..N-1]
        int r = i + StdRandom.uniform(N-i);
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;        
    }
}
```

Below is ``ShuffleTestClient`` program to perform computational experiments on the shuffling algorithm, likely referring to the
Fisher-Yates shuffle.

```java
import edu.princeton.cs.algs4.StdOut;

public class ShuffleTestClient {
    public static void main(String args[]) {
        int M = Integer.parseInt(args[0]); // array size
        int N = Integer.parseInt(args[1]); // number of shuffles

        int counts[][] = new int[M][N]; // counts[i][j] = #times i ended in position j

        for (int n = 0; n < N; n++) {

            int a[] = new int[M];

            for (int i = 0; i < M; i++) a[i] = i; // initialize a[i] = i

            shuffle(a);

            for (int i = 0; i < M; i++) {
                counts[i][a[i]]++; // counts where i ended up
            }
        }

        // Print M-by-M table
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                StdOut.printf("%7d ", counts[i][j]);
            }

            StdOut.println();
        }
        
        // Check if counts are close to M/N
        double expected = (double) N / M;
        
        StdOut.println("\nExpected count per cell ≈ " + expected);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                double deviation = Math.abs(counts[i][j] - expected) / expected;
                
                if(deviation > 0.2) { // arbitrary threshold
                    StdOut.printf("Cell (%d, %d): count=%d, deviation=%.2f%%\n", i, j, counts[i][j], deviation * 100);
                }
            }            
        }        
    }
}
```

If you run:

```bash
java ShuffleTest 5 1000
```

```bash
   2019    1973    2073    2014    1921 
   1950    2025    2036    2001    1988 
   2090    1954    1998    1996    1962 
   1994    2030    1916    2011    2049 
   1947    2018    1977    1978    2080 

Expected count per cell ≈ 2000.0
```

#### Notes
 
- ```StdRandom.uniform(int n)```: Assumed to be available; provides a random int in ```[0, n-1]```.
- The shuffle initializes the array ```a[i] = i``` before each shuffle.
- Counts where each element ```i``` ends up in position ```j```.
- Checks if counts are roughly ```N/M```, indicating a uniform distribution.

#### Interpretation

- **Uniform Shuffle**: Each element should appear in each position ≈ N/M times if shuffle is unbiased.
- Deviations indicate potential non-uniformity; statistical tests could further analyze uniformity.


**1.1.37 _Bad Shuffling_. Suppose that you choose a random integer between ``0`` and ``N-1`` in our shuffling code instead of 
one between ``i`` and ``N-1``. Show that the resulting order is not equally likely to be one of the ``N!`` possibilities. 
Run the test of the previous exercise for this version.**

Decomposing the input and output:

    - Input: M The size of the array to be shuffled and N The number of times the array is shuffled.
    - Output: an M-by-M table where each row i represents the element i in the original array, each column j represents the position j in the shuffled array. The value at row i and column j is the number of times element i ended up in position j after N shuffles.

A bad shuffling code based on page 32:

```java
import edu.princeton.cs.algs4.StdRandom;

/**
 * Shuffles the elements of the given array in place using a flawed algorithm that does not produce a uniform
 * distribution of permutations.
 * <p>
 * This method randomly rearranges the elements of the array, but it does not ensure that each permutation is
 * equally likely, resulting in a biased shuffle.
 *
 * @param a the array to be shuffled
 */
public static void badShuffle(int[] a) {
    int N = a.length;

    for (int i = 0; i < N; i++) {
        // Exchange a[i] with random element in a[0..N-1]
        int r = StdRandom.uniform(N);
        swap(a, i, r);
    }
}

private static void swap(int[] a, int i, int r) {
    int temp = a[i];
    a[i] = a[r];
    a[r] = temp;
}
```

If you run:

```bash
java ShuffleTest 5 1000
```

```bash
Bad Shuffle with parameters 5 1000
    195     246     201     174     184 
    189     208     225     219     159 
    203     182     199     217     199 
    197     179     185     185     254 
    216     185     190     205     204 

Expected count per cell ≈ 200.0
Cell (0, 1): count=246, deviation=23.00%
Cell (1, 4): count=159, deviation=20.50%
Cell (3, 4): count=254, deviation=27.00%
```

Why does badShuffle produce bias ?

The code:

```java
for (int i = 0; i < N; i++) {
    int r = StdRandom.uniform(N);
    swap(a[i], a[r]);
}
```

> At every iteration, it selects a random index `r` from the entire array (0 to N-1) instead of from the remaining unshuffled portion (i to N-1). This means that elements that have already been shuffled can be swapped again, leading to a non-uniform distribution of permutations. Some permutations will be more likely than others, resulting in bias in the shuffle.
> In summary, the bias arises because:
> - You choose a random index from `0 to N-1`
> - You swap the current element with the randomly chosen index
>
> The core problem is that each position is allowed to be swapped multiple times, including positions
> that were already decided. That's create overlapping randomness. Some permutations becomes reachable 
> through more execution paths than others.

**1.1.38 _Binary Search versus brute-force search_. Write a program ``BruteForceSearch`` that uses the brute-force search
method given on page 48 and compare its running time on your computer with that of ``BinarySearch`` for ``largeW.txt``
and ``largeT.txt``.**  

Decomposing the input and output:

    - Input: The files `tinyText.txt` and `largeText.txt`
    - Output: Each number of the `tinyText.txt` that's in the `largeText.txt` and the elapsed time of running it

The implementation of the brute force search (linear search, check every entry in the array) on page 48:

```java
public class BruteForceSearch {

    private final int[] numbers;

    public BruteForceSearch(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Searches for a key in an array using brute force (linear search).
     * This method sequentially examines each element of the array from left to right
     * until it finds the key or exhausts all elements.
     * <p>
     * Time complexity: O(n) where n is the length of the array.
     * Space complexity: O(1)
     *
     * @param key the integer value to search for in the array
     * @return the index of the first occurrence of key in the array,
     * or -1 if the key is not found
     */
    public int findIndexOf(int key) {

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == key)
                return i;
        }

        return -1;
    }
} 
```

When running the following code:

```java
public class Algorithms {
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {

        int[] largeAllowlist = In.readInts("./data/largeAllowlist.txt");
        int[] largeText = In.readInts("./data/largeText.txt");

        StdOut.println("Brute-force search versus Binary Search\n\n");

        Stopwatch timer1 = new Stopwatch();
        printNumbersThatAreInArrayByBruteForce(largeAllowlist, largeText);
        StdOut.printf("\nThe elapsed time with brute force search was: %.2f seconds", timer1.elapsedTime());

        StdOut.println();

        Arrays.sort(largeAllowlist);
        Arrays.sort(largeText);

        Stopwatch timer2 = new Stopwatch();
        printNumbersThatAreInArrayByBinarySearch(largeAllowlist, largeText);
        StdOut.printf("\nThe elapsed time with binary search was: %.2f seconds", timer2.elapsedTime());
    }

    private static void printNumbersThatAreInArrayByBruteForce(final int[] numbers, int[] numbersToFind) {

        BruteForceSearch bruteForceSearch = new BruteForceSearch(numbers);

        for (Integer number : numbersToFind) {

            int index = bruteForceSearch.findIndexOf(number);

            if (index > -1) {
                StdOut.println(String.format("The number %s is at the list", number));
            }
        }
    }

    private static void printNumbersThatAreInArrayByBinarySearch(final int[] numbers, int[] numbersToFind) {

        BinarySearch binarySearch = new BinarySearch(numbers);

        for (Integer number : numbersToFind) {

            int index = binarySearch.findIndexOf(number);

            if (index > -1) {
                StdOut.println(String.format("The number %s is at the list", number));
            }
        }
    }
}
```

The output:

```bash
Brute-force search versus Binary Search

The number 48 is at the list
The number 18 is at the list
The number 18 is at the list
...
The number 99 is at the list
The number 99 is at the list
The number 23 is at the list

The elapsed time with brute force search was: Do not finish in my computer

The number 48 is at the list
The number 18 is at the list
The number 18 is at the list
...
The number 99 is at the list
The number 99 is at the list
The number 23 is at the list

The elapsed time with binary search was: 21.67 seconds
```

**1.1.39 _Random matches_. Write a ``BinarySearch`` client that takes an ``int`` value ``T`` as command-line argument
and runs ``T`` trials of the following experiment for N = 10<sup>3</sup>, 10<sup>4</sup>, 10<sup>5</sup>, and 10<sup>6</sup>:
generate two arrays of ``N`` randomly generated positive six-digit ``int`` values, and find the number of values that appear in both
arrays. Print a table giving the average value of this quantity over the ``T`` trials for each value of ``N``.**

Decomposing the input and output:

    - Input:
    - Output:

# References

- ["Algorithms, 4th Edition" by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/)
- [The Java Tutorials](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)
- [Mathematics Fundamentals I (Brazilian Portuguese)](http://mtm.grad.ufsc.br/files/2014/04/Fundamentos-de-Matem%C3%A1tica-I.pdf)
- [Fundamentals of Arithmetic (Brazilian Portuguese)](https://livraria.ufsc.br/produto/818/fundamentos-de-aritmetica)
- [Wikipedia Memoization definition](https://en.wikipedia.org/wiki/Memoization)
- [Fibonacci number](https://en.wikipedia.org/wiki/Fibonacci_number)
- [Factorial](https://en.wikipedia.org/wiki/Factorial)
- [Binomial Distribution](https://en.wikipedia.org/wiki/Binomial_distribution)

# License

Please see the [license agreement](https://github.com/julianomacielferreira/Algorithms/blob/master/LICENSE).