/*
 * The MIT License
 *
 * Copyright 2012 juliano.
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

/**
 * @author juliano
 */
public class BinarySearchRecursive {

    private static int depth;

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

        depth++;

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

        StringBuilder tabs = new StringBuilder();

        for (int i = 0; i < depth; i++)
            tabs.append('\t');

        StdOut.printf("%slo=%d, hi=%d\n", tabs, lo, hi, depth);
    }
}
