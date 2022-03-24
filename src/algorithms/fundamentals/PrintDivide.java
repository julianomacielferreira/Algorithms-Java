/*
 * The MIT License
 *
 * Copyright 2022 juliano.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package algorithms.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author juliano
 */
public class PrintDivide {

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
            String parts[] = line.split(" ");

            try {
                String name = parts[0];
                Integer firstInt = Integer.parseInt(parts[1]);
                Integer secondNumber = Integer.parseInt(parts[2]);
                Float result = (float) firstInt / secondNumber;
                StdOut.printf("%s\t%d\t%d\t%.3f", name, firstInt, secondNumber, result);
                StdOut.println();
            } catch (IndexOutOfBoundsException ex) {
                StdOut.print(ex.getMessage());
            }

        }


    }

}
