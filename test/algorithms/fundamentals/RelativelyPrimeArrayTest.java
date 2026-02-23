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

import org.junit.Test;

import static org.junit.Assert.*;

public class RelativelyPrimeArrayTest {

    @Test
    public void gcd_standardPositiveNumbers() {

        assertEquals(1, RelativelyPrimeArray.gcd(7, 5));
        assertEquals(6, RelativelyPrimeArray.gcd(48, 18));
        assertEquals(1, RelativelyPrimeArray.gcd(17, 13));
        assertEquals(12, RelativelyPrimeArray.gcd(60, 36));
    }

    @Test
    public void gcd_oneNumberIsZero() {

        assertEquals(5, RelativelyPrimeArray.gcd(5, 0));
        assertEquals(10, RelativelyPrimeArray.gcd(0, 10));
        assertEquals(0, RelativelyPrimeArray.gcd(0, 0)); // By convention, GCD(0,0) is 0
    }

    @Test
    public void gcd_equalNumbers() {
        assertEquals(7, RelativelyPrimeArray.gcd(7, 7));
    }

    @Test
    public void gcd_primeNumbers() {
        assertEquals(1, RelativelyPrimeArray.gcd(29, 13));
    }

    @Test
    public void gcd_negativeNumbersThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> RelativelyPrimeArray.gcd(-5, 10));
        assertThrows(IllegalArgumentException.class, () -> RelativelyPrimeArray.gcd(5, -10));
        assertThrows(IllegalArgumentException.class, () -> RelativelyPrimeArray.gcd(-5, -10));
    }

    @Test
    public void createRelativelyPrimeArray_Nis0() {

        boolean[][] result = RelativelyPrimeArray.createRelativelyPrimeArray(0);

        assertNotNull(result);

        assertEquals(0, result.length);
    }

    @Test
    public void createRelativelyPrimeArray_Nis1() {

        boolean[][] result = RelativelyPrimeArray.createRelativelyPrimeArray(1);
        assertNotNull(result);

        assertEquals(1, result.length);
        assertEquals(1, result[0].length);

        // (1,1) are relatively prime
        assertTrue(result[0][0]);
    }

    @Test
    public void createRelativelyPrimeArray_Nis2() {

        boolean[][] expected = {
                // (1,1) (1,2)
                {true, true},
                // (2,1) (2,2)
                {true, false}
        };

        boolean[][] actual = RelativelyPrimeArray.createRelativelyPrimeArray(2);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void createRelativelyPrimeArray_Nis3() {

        boolean[][] expected = {
                // 1 2 3
                // (1,1) (1,2) (1,3)
                {true, true, true},
                // (2,1) (2,2) (2,3)
                {true, false, true},
                // (3,1) (3,2) (3,3)
                {true, true, false}
        };

        boolean[][] actual = RelativelyPrimeArray.createRelativelyPrimeArray(3);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void createRelativelyPrimeArray_Nis5_specificCells() {

        boolean[][] result = RelativelyPrimeArray.createRelativelyPrimeArray(5);
        // Indices map to (i+1, j+1) numbers
        // (1,1) -> true
        assertTrue(result[0][0]);
        // (2,4) -> false (GCD(2,4)=2)
        assertFalse(result[1][3]);
        // (3,5) -> true (GCD(3,5)=1)
        assertTrue(result[2][4]);
        // (4,2) -> false (GCD(4,2)=2)
        assertFalse(result[3][1]);
        // (5,5) -> false (GCD(5,5)=5)
        assertFalse(result[4][4]);
        // (2,3) -> true (GCD(2,3)=1)
        assertTrue(result[1][2]);
        // (4,5) -> true (GCD(4,5)=1)
        assertTrue(result[3][4]);
    }

    @Test
    public void createRelativelyPrimeArray_largeN_dimensionsCorrect() {

        int largeN = 100;
        boolean[][] result = RelativelyPrimeArray.createRelativelyPrimeArray(largeN);
        assertNotNull(result);
        assertEquals(largeN, result.length);
        for (int i = 0; i < largeN; i++) {
            assertEquals(largeN, result[i].length);
        }
    }

    @Test
    public void createRelativelyPrimeArray_NisNegativeThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> RelativelyPrimeArray.createRelativelyPrimeArray(-1));
        assertThrows(IllegalArgumentException.class, () -> RelativelyPrimeArray.createRelativelyPrimeArray(-10));
    }
}
