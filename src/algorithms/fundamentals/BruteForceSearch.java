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
