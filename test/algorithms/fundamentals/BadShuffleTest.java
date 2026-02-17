/*
 * The MIT License
 *
 * Copyright 2019 juliano.
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BadShuffleTest {

    @Test
    public void test_EmptyArray() {

        int[] arr = {};

        Shuffle.badShuffle(arr);

        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void test_SingleElement() {

        int[] arr = {42};

        Shuffle.badShuffle(arr);

        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void test_ElementsPreserved() {

        int[] arr = {1, 2, 3, 4, 5};

        int[] original = Arrays.copyOf(arr, arr.length);

        Shuffle.badShuffle(arr);

        assertTrue("Shuffled array must contain exactly the same elements",
                sameElements(original, arr));
    }

    @Test
    public void test_ShuffleActuallyChangesOrderSometimes() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] original = Arrays.copyOf(arr, arr.length);

        boolean changed = false;

        for (int i = 0; i < 20; i++) {
            int[] testArr = Arrays.copyOf(original, original.length);
            Shuffle.badShuffle(testArr);
            if (!Arrays.equals(original, testArr)) {
                changed = true;
                break;
            }
        }

        assertTrue("Shuffle should change order at least sometimes", changed);
    }

    @Test
    public void test_BiasDetectionSimpleFrequencyCheck() {

        int[] arr = {1, 2, 3};

        Map<String, Integer> permutationCounts = new HashMap<>();

        int trials = 100;

        for (int i = 0; i < trials; i++) {

            int[] testArr = {1, 2, 3};

            Shuffle.badShuffle(testArr);

            permutationCounts.merge(Arrays.toString(testArr), 1, Integer::sum);
        }

        // For a uniform shuffle, each of the 6 permutations
        // should appear roughly trials/6 times (~16.66).
        // This flawed shuffle often produces imbalance.
        int expected = trials / 6;

        boolean significantBias = false;

        for (int count : permutationCounts.values()) {

            if (Math.abs(count - expected) > expected * 0.25) {

                significantBias = true;

                break;
            }
        }

        assertTrue("badShuffle should show noticeable bias in permutation frequencies",
                significantBias);
    }

    private boolean sameElements(int[] original, int[] shuffled) {

        if (original.length != shuffled.length)
            return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int value : original) {
            count.put(value, count.getOrDefault(value, 0) + 1);
        }

        for (int value : shuffled) {

            if (!count.containsKey(value))
                return false;

            count.put(value, count.get(value) - 1);

            if (count.get(value) == 0) {
                count.remove(value);
            }
        }

        return count.isEmpty();
    }
}
