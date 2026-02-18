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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinarySearchWithoutDuplicateKeyTest {

    @Test
    public void test_RemoveDuplicates() {

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(new int[]{});

        int[] keys = {1, 2, 2, 3, 3, 3, 4};
        int[] result = search.removeDuplicateKeys(keys);

        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    public void test_ReturnSameArrayWhenNoDuplicates() {

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(new int[]{});

        int[] keys = {1, 2, 3, 4};
        int[] result = search.removeDuplicateKeys(keys);

        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    public void test_HandleAllDuplicateValues() {

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(new int[]{});

        int[] keys = {5, 5, 5, 5};
        int[] result = search.removeDuplicateKeys(keys);

        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    public void test_HandleEmptyKeysArray() {

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(new int[]{});

        int[] keys = {};
        int[] result = search.removeDuplicateKeys(keys);

        assertArrayEquals(new int[]{}, result);
    }

    @Test
    public void test_HandleNegativeValuesInDuplicates() {

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(new int[]{});

        int[] keys = {-1, -1, 0, 1, 1};
        int[] result = search.removeDuplicateKeys(keys);

        assertArrayEquals(new int[]{-1, 0, 1}, result);
    }

    @Test
    public void test_FindElementInMiddle() {

        int[] numbers = {1, 3, 5, 7, 9};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(5);

        assertEquals(2, index);
    }

    @Test
    public void test_FindElementAtBeginning() {

        int[] numbers = {2, 4, 6, 8};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(2);

        assertEquals(0, index);
    }

    @Test
    public void test_FindElementAtEnd() {

        int[] numbers = {10, 20, 30, 40};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(40);

        assertEquals(3, index);
    }

    @Test
    public void test_ReturnMinusOneWhenElementNotFound() {

        int[] numbers = {1, 2, 3, 4, 5};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(6);

        assertEquals(-1, index);
    }

    @Test
    public void test_HandleSingleElementFound() {

        int[] numbers = {42};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(42);

        assertEquals(0, index);
    }

    @Test
    public void test_HandleSingleElementNotFound() {

        int[] numbers = {42};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(7);

        assertEquals(-1, index);
    }

    @Test
    public void test_HandleEmptyArray() {

        int[] numbers = {};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(10);

        assertEquals(-1, index);
    }

    @Test
    public void test_WorkWithNegativeNumbers() {

        int[] numbers = {-10, -5, 0, 5, 10};

        BinarySearchWithoutDuplicateKey search = new BinarySearchWithoutDuplicateKey(numbers);

        int index = search.findIndexOf(-5);

        assertEquals(1, index);
    }
}
