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
