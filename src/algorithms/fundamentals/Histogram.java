/*
 * The MIT License
 *
 * Copyright 2020 juliano.
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

/**
 *
 * @author juliano
 */
public class Histogram {

    /**
     * Takes an array a[] of int values and an integer M as argument and returns
     * an array of length M whose ith entry is the number of times the integer i
     * appeared in the argument array.
     *
     * @param argArray argument array
     * @param M length M of the returned array
     * @return
     */
    public static int[] numberOfTimesIAppearedIn(int argArray[], int M) {

        int returnedArray[] = new int[M];

        // If the values in a[] are all between 0 and M - 1 the sum of the 
        // values in the returned array should be equal to a.length.
        for (int i = 0; i < returnedArray.length; i++) {
            int totalIth = 0;

            for (int j = 0; j < argArray.length; j++) {
                if (argArray[j] == i) {
                    totalIth++;
                }
            }

            returnedArray[i] = totalIth;
        }

        return returnedArray;
    }
}
