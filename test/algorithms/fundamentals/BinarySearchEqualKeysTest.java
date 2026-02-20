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

import static org.junit.Assert.assertEquals;

public class BinarySearchEqualKeysTest {

    @Test
    public void test_rank_KeyPresentNoDuplicates() {

        int[] a = {10, 20, 30, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.rank(10, a));
        assertEquals(2, BinarySearchEqualKeys.rank(30, a));
        assertEquals(4, BinarySearchEqualKeys.rank(50, a));
    }

    @Test
    public void test_rank_KeyPresentWithDuplicates() {

        int[] a = {10, 20, 20, 30, 30, 30, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.rank(10, a));

        // rank returns the index of the first element >= key
        assertEquals(1, BinarySearchEqualKeys.rank(20, a));
        assertEquals(3, BinarySearchEqualKeys.rank(30, a));
    }

    @Test
    public void test_rank_KeyAbsentSmallerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(0, BinarySearchEqualKeys.rank(5, a));
    }

    @Test
    public void test_rank_KeyAbsentLargerThanAll() {

        int[] a = {10, 20, 30};

        // Should return a.length, which is 3
        assertEquals(3, BinarySearchEqualKeys.rank(35, a));
    }

    @Test
    public void test_rank_KeyAbsentInMiddle() {

        int[] a = {10, 20, 40, 50};

        assertEquals(2, BinarySearchEqualKeys.rank(30, a)); // Should point to 40
    }

    @Test
    public void test_rank_EmptyArray() {

        int[] a = {};

        assertEquals(0, BinarySearchEqualKeys.rank(10, a)); // Empty array, key is 'larger than all' effectively
    }

    @Test
    public void test_rank_SingleElementArrayKeyPresent() {

        int[] a = {10};

        assertEquals(0, BinarySearchEqualKeys.rank(10, a));
    }

    @Test
    public void test_rank_SingleElementArrayKeyAbsentSmaller() {

        int[] a = {10};

        assertEquals(0, BinarySearchEqualKeys.rank(5, a));
    }

    @Test
    public void test_rank_SingleElementArrayKeyAbsentLarger() {

        int[] a = {10};

        assertEquals(1, BinarySearchEqualKeys.rank(15, a));
    }

    @Test
    public void test_firstIndex_KeyPresentNoDuplicates() {

        int[] a = {10, 20, 30, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.firstIndex(10, a));
        assertEquals(2, BinarySearchEqualKeys.firstIndex(30, a));
        assertEquals(4, BinarySearchEqualKeys.firstIndex(50, a));
    }

    @Test
    public void test_firstIndex_KeyPresentWithDuplicates() {

        int[] a = {10, 20, 20, 30, 30, 30, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.firstIndex(10, a));
        assertEquals(1, BinarySearchEqualKeys.firstIndex(20, a));
        assertEquals(3, BinarySearchEqualKeys.firstIndex(30, a));
    }

    @Test
    public void test_firstIndex_KeyAbsentSmallerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(-1, BinarySearchEqualKeys.firstIndex(5, a));
    }

    @Test
    public void test_firstIndex_KeyAbsentLargerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(-1, BinarySearchEqualKeys.firstIndex(35, a));
    }

    @Test
    public void test_firstIndex_KeyAbsentInMiddle() {

        int[] a = {10, 20, 40, 50};

        assertEquals(-1, BinarySearchEqualKeys.firstIndex(30, a));
    }

    @Test
    public void test_firstIndex_EmptyArray() {

        int[] a = {};

        assertEquals(-1, BinarySearchEqualKeys.firstIndex(10, a));
    }

    @Test
    public void test_firstIndex_SingleElementArrayKeyPresent() {

        int[] a = {10};

        assertEquals(0, BinarySearchEqualKeys.firstIndex(10, a));
    }

    @Test
    public void test_firstIndex_SingleElementArrayKeyAbsent() {

        int[] a = {10};

        assertEquals(-1, BinarySearchEqualKeys.firstIndex(5, a));
        assertEquals(-1, BinarySearchEqualKeys.firstIndex(15, a));
    }

    @Test
    public void test_lastIndex_KeyPresentNoDuplicates() {

        int[] a = {10, 20, 30, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.lastIndex(10, a));
        assertEquals(2, BinarySearchEqualKeys.lastIndex(30, a));
        assertEquals(4, BinarySearchEqualKeys.lastIndex(50, a));
    }

    @Test
    public void test_lastIndex_KeyPresentWithDuplicates() {

        int[] a = {10, 20, 20, 30, 30, 30, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.lastIndex(10, a));
        assertEquals(2, BinarySearchEqualKeys.lastIndex(20, a)); // Last index of 20
        assertEquals(5, BinarySearchEqualKeys.lastIndex(30, a)); // Last index of 30
    }

    @Test
    public void test_lastIndex_KeyAbsentSmallerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(-1, BinarySearchEqualKeys.lastIndex(5, a));
    }

    @Test
    public void test_lastIndex_KeyAbsentLargerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(-1, BinarySearchEqualKeys.lastIndex(35, a));
    }

    @Test
    public void test_lastIndex_KeyAbsentInMiddle() {

        int[] a = {10, 20, 40, 50};

        assertEquals(-1, BinarySearchEqualKeys.lastIndex(30, a));
    }

    @Test
    public void test_lastIndex_EmptyArray() {

        int[] a = {};

        assertEquals(-1, BinarySearchEqualKeys.lastIndex(10, a));
    }

    @Test
    public void test_lastIndex_SingleElementArrayKeyPresent() {

        int[] a = {10};

        assertEquals(0, BinarySearchEqualKeys.lastIndex(10, a));
    }

    @Test
    public void test_lastIndex_SingleElementArrayKeyAbsent() {

        int[] a = {10};

        assertEquals(-1, BinarySearchEqualKeys.lastIndex(5, a));
        assertEquals(-1, BinarySearchEqualKeys.lastIndex(15, a));
    }

    @Test
    public void test_count_KeyPresentNoDuplicates() {

        int[] a = {10, 20, 30, 40, 50};

        assertEquals(1, BinarySearchEqualKeys.count(10, a));
        assertEquals(1, BinarySearchEqualKeys.count(30, a));
        assertEquals(1, BinarySearchEqualKeys.count(50, a));
    }

    @Test
    public void test_count_KeyPresentWithDuplicates() {

        int[] a = {10, 20, 20, 30, 30, 30, 40, 50};

        assertEquals(1, BinarySearchEqualKeys.count(10, a));
        assertEquals(2, BinarySearchEqualKeys.count(20, a));
        assertEquals(3, BinarySearchEqualKeys.count(30, a));
    }

    @Test
    public void test_count_KeyAbsentSmallerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(0, BinarySearchEqualKeys.count(5, a));
    }

    @Test
    public void test_count_KeyAbsentLargerThanAll() {

        int[] a = {10, 20, 30};

        assertEquals(0, BinarySearchEqualKeys.count(35, a));
    }

    @Test
    public void test_count_KeyAbsentInMiddle() {

        int[] a = {10, 20, 40, 50};

        assertEquals(0, BinarySearchEqualKeys.count(30, a));
    }

    @Test
    public void test_count_EmptyArray() {

        int[] a = {};

        assertEquals(0, BinarySearchEqualKeys.count(10, a));
    }

    @Test
    public void test_count_SingleElementArrayKeyPresent() {

        int[] a = {10};

        assertEquals(1, BinarySearchEqualKeys.count(10, a));
    }

    @Test
    public void test_count_SingleElementArrayKeyAbsent() {

        int[] a = {10};

        assertEquals(0, BinarySearchEqualKeys.count(5, a));
        assertEquals(0, BinarySearchEqualKeys.count(15, a));
    }

    @Test
    public void test_count_AllElementsSame() {

        int[] a = {5, 5, 5, 5, 5};

        assertEquals(5, BinarySearchEqualKeys.count(5, a));
        assertEquals(0, BinarySearchEqualKeys.count(4, a));
        assertEquals(0, BinarySearchEqualKeys.count(6, a));
    }
}