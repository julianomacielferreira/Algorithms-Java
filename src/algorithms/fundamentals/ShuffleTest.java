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
package algorithms.fundamentals;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShuffleTest {

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

                if (deviation > 0.2) { // arbitrary threshold
                    StdOut.printf("Cell (%d, %d): count=%d, deviation=%.2f%%\n", i, j, counts[i][j], deviation * 100);
                }
            }
        }
    }

    /**
     * Shuffles the elements of the given array in place using the Fisher-Yates shuffle algorithm.
     * <p>
     * This method randomly rearranges the elements of the array such that each permutation is
     * equally likely, ensuring an unbiased shuffle.
     *
     * @param a the array to be shuffled
     */
    public static void shuffle(int[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
