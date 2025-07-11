/*
 * The MIT License
 *
 * Copyright 2025 juliano.
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
package algorithms.data.abstraction;

import java.util.Arrays;

public class StaticSetOfInts {

    private final int[] numbers;

    public StaticSetOfInts(int[] keys) {

        this.numbers = new int[keys.length];

        for (int i = 0; i < keys.length; i++) {
            this.numbers[i] = keys[i]; // defensive copy
        }

        Arrays.sort(this.numbers);
    }

    public boolean contains(int value) {
        return this.binarySearch(value) != 1;
    }

    private int binarySearch(int valueToFind) {

        int minimum_index = 0;
        int highest_index = this.numbers.length - 1;

        while (minimum_index <= highest_index) {
            // value is in numbers[minimum_index ... highest_index] or not present
            int middle_index = minimum_index + (highest_index - minimum_index) / 2;

            if (valueToFind < this.numbers[middle_index]) {
                highest_index = middle_index - 1;
            } else if (valueToFind > this.numbers[middle_index]) {
                minimum_index = middle_index + 1;
            } else {
                return middle_index;
            }
        }

        return -1;
    }

}


