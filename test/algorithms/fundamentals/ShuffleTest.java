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

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class ShuffleTest {

    @Test
    public void testShuffle_ArrayIsShuffled() {

        int[] array = {1, 2, 3, 4, 5};
        int[] original = array.clone();

        boolean changed = false;

        for (int i = 0; i < 10; i++) {
            ShuffleTestClient.shuffle(array);
            if (!Arrays.equals(array, original)) {
                changed = true;
                break;
            }

            array = original.clone();
        }

        if (!changed) {
            Assert.fail("Array was not shuffled after multiple attempts");
        }
    }

    @Test
    public void shuffle_ArrayElementsAreReordered() {

        int[] array = {1, 2, 3, 4, 5};
        int[] original = array.clone();

        ShuffleTestClient.shuffle(array);

        assertNotEquals(Arrays.toString(original), Arrays.toString(array));
    }

    @Test
    public void shuffle_EmptyArrayRemainsUnchanged() {

        int[] array = {};
        int[] original = array.clone();

        ShuffleTestClient.shuffle(array);

        assertArrayEquals(original, array);
    }

    @Test
    public void shuffle_SingleElementArrayRemainsUnchanged() {

        int[] array = {42};
        int[] original = array.clone();

        ShuffleTestClient.shuffle(array);

        assertArrayEquals(original, array);
    }

    @Test
    public void shuffle_ArrayContainsSameElementsAfterShuffle() {

        int[] array = {1, 2, 3, 4, 5};
        int[] original = array.clone();

        ShuffleTestClient.shuffle(array);

        Arrays.sort(array);
        Arrays.sort(original);
        
        assertArrayEquals(original, array);
    }
}
