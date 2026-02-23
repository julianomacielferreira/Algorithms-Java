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

public class RelativelyPrimeArray {

    /**
     * Creates an N-by-N boolean array where a[i][j] is true if i and j are relatively prime (coprime),
     * and false otherwise.
     * <p>
     * Note: For this exercise, consider indices starting from 1 for the concept of "relatively prime".
     * If N is less than 1, an empty array is returned.
     *
     * @param N The dimension of the square array (N-by-N).
     * @return An N-by-N boolean array.
     * @throws IllegalArgumentException if N is negative.
     */
    public static boolean[][] createRelativelyPrimeArray(int N) {

        if (N < 0) {
            throw new IllegalArgumentException("Array dimension N cannot be negative");
        }

        boolean[][] a = new boolean[N][N];

        // If N is 0, array a will be 0x0 and the loops won't run, which is correct.
        // If N is 1, array a will be 1x1. a[0][0] corresponds to (1,1) if we map.
        // We'll treat i and j as (i+1) and (j+1) for GCD calculation.
        // For array indices 0...N-1, we consider numbers 1...N.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // To check relative primality for numbers (i+1) and (j+1)
                // (e.g., if N=3, we check 1,2,3 against 1,2,3)
                int p = i + 1;
                int q = j + 1;
                a[i][j] = (gcd(p, q) == 1);
            }
        }

        return a;
    }

    /**
     * Computes the greatest common divisor (GCD) of two non-negative integers using the Euclidean algorithm.
     *
     * @param p The first non-negative integer.
     * @param q The second non-negative integer.
     * @return The GCD of p and q.
     * @throws IllegalArgumentException if p or q is negative.
     */
    public static int gcd(int p, int q) {
        if (p < 0 || q < 0) {
            throw new IllegalArgumentException("GCD inputs must be non-negative");
        }

        if (q == 0) {
            return p;
        }

        int r = p % q;

        return gcd(q, r);
    }
}
