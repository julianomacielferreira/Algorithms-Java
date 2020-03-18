/*
 * The MIT License
 *
 * Copyright 2019 juliano.
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
package algorithms;

import algorithms.fundamentals.Factorial;
import algorithms.fundamentals.Fibonacci;
import edu.princeton.cs.algs4.StdOut;

/**
 * Entry point class (contains the main() method). It could be called Main.java,
 * Bootstrap.java, etc.
 *
 * @author juliano
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Drawing.points(100);
//        Drawing.random(50);
//        Drawing.random(50, true);
//        StdOut.println(DecimalTo.binary(365));
//
//        boolean[][] arr = {{false, true}, {true, false}, {true, true}};
//
//        StdOut.println(BooleanArray.format(arr));
        for (int N = 0; N <= 100; N++) {
            StdOut.println(N + " " + Fibonacci.F(N));
        }

        for (int N = 0; N <= 65; N++) {
            StdOut.println(N + " " + Factorial.compute(N));
        }
    }

}
