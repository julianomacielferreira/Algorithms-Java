/*
 * The MIT License
 *
 * Copyright 2026 juliano.
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

        int first = firstIndex(key, a);

        if (first < 0)
            return 0;

        int last = lastIndex(key, a);

        return last - first + 1;
    }

    public static int firstIndex(int key, int[] a) {

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
                hi = mid - 1; // keep searching left
            }
        }

        return result;
    }

    public static int lastIndex(int key, int[] a) {

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
                lo = mid + 1; // keep searching right
            }
        }

        return result;
    }
}
