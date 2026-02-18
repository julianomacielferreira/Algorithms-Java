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

public class ButeForceSearchTest {

    @Test
    public void test_FindElementInMiddle() {

        int[] numbers = {10, 20, 30, 40, 50};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(30);

        assertEquals(2, index);
    }

    @Test
    public void test_FindElementAtBeginning() {

        int[] numbers = {5, 10, 15};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(5);

        assertEquals(0, index);
    }

    @Test
    public void test_FindElementAtEnd() {

        int[] numbers = {1, 2, 3, 4};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(4);

        assertEquals(3, index);
    }

    @Test
    public void test_ReturnMinusOneWhenElementNotFound() {

        int[] numbers = {2, 4, 6, 8};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(5);

        assertEquals(-1, index);
    }

    @Test
    public void test_ReturnFirstOccurrenceWhenDuplicatesExist() {

        int[] numbers = {7, 3, 7, 9};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(7);

        assertEquals(0, index);
    }

    @Test
    public void test_WorkWithNegativeNumbers() {

        int[] numbers = {-10, -5, 0, 5};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(-5);

        assertEquals(1, index);
    }

    @Test
    public void test_HandleSingleElementArrayFound() {

        int[] numbers = {42};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(42);

        assertEquals(0, index);
    }

    @Test
    public void test_HandleSingleElementArrayNotFound() {

        int[] numbers = {42};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(10);

        assertEquals(-1, index);
    }

    @Test
    public void test_HandleEmptyArray() {

        int[] numbers = {};

        BruteForceSearch search = new BruteForceSearch(numbers);

        int index = search.findIndexOf(1);

        assertEquals(-1, index);
    }
}
