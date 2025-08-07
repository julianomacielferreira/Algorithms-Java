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
package algorithms.data_abstraction;

import algorithms.fundamentals.BinarySearch;

import java.util.Arrays;

/**
 * Represents a static set of integers that supports fast membership testing.
 * <p>
 * This class creates a sorted array of integers and uses binary search to check
 * for membership in the set. The set is immutable, meaning that once it is created,
 * its contents cannot be modified.
 */
public class StaticSetOfInts {

    /**
     * The binary search object used to perform fast membership testing.
     *
     * @implNote This field is used internally to implement the contains method.
     */
    private final BinarySearch binarySearch;

    /**
     * Creates a new static set of integers from the given array of keys.
     * <p>
     * The keys are sorted in ascending order and stored in a defensive copy of
     * the input array.
     *
     * @param keys the array of integers to include in the set
     */
    public StaticSetOfInts(int[] keys) {

        int[] numbers = new int[keys.length];

        // defensive copy
        System.arraycopy(keys, 0, numbers, 0, keys.length);

        Arrays.sort(numbers);

        this.binarySearch = new BinarySearch(numbers);
    }

    /**
     * Checks whether the given value is a member of this set.
     *
     * @param value the integer to check for membership
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return this.binarySearch.findIndexOf(value) != -1;
    }
}


