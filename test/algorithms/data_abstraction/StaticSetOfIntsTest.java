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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author juliano
 */
public class StaticSetOfIntsTest {

    @Test
    public void testEmptySet() {
        int[] keys = {};
        StaticSetOfInts set = new StaticSetOfInts(keys);
        assertFalse(set.contains(1));
        assertFalse(set.contains(0));
        assertFalse(set.contains(-1));
    }

    @Test
    public void singleElementSet() {
        int[] keys = {5};
        StaticSetOfInts set = new StaticSetOfInts(keys);
        assertTrue(set.contains(5));
        assertFalse(set.contains(1));
        assertFalse(set.contains(0));
        assertFalse(set.contains(-1));
    }

    @Test
    public void multipleElementSet() {
        int[] keys = {1, 2, 3, 4, 5};
        StaticSetOfInts set = new StaticSetOfInts(keys);

        for (int key : keys) {
            assertTrue(set.contains(key));
        }

        assertFalse(set.contains(0));
        assertFalse(set.contains(7));
    }

    @Test
    public void testDuplicateElements() {
        int[] keys = {1, 2, 2, 3, 3, 3};
        StaticSetOfInts set = new StaticSetOfInts(keys);

        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertFalse(set.contains(0));
        assertFalse(set.contains(4));
    }

    @Test
    public void testNegativeNumbers() {
        int[] keys = {-5, -2, 0, 2, 5};
        StaticSetOfInts set = new StaticSetOfInts(keys);

        for (int key : keys) {
            assertTrue(set.contains(key));
        }

        assertFalse(set.contains(-7));
        assertFalse(set.contains(-4));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> new StaticSetOfInts(null));
    }
}
