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

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {

    /**
     * Shuffles the elements of the given array in place using the Fisher-Yates shuffle algorithm.
     * <p>
     * This method randomly rearranges the elements of the array such that each permutation is
     * equally likely, ensuring an unbiased shuffle.
     *
     * @param a the array to be shuffled
     */
    public static void doShuffle(int[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N - i);
            swap(a, i, r);
        }
    }

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
}
