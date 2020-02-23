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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juliano
 */
public class Fibonacci {

    // Use a Map to dynamically add and retrieve by key the values already computed    
    private static final Map<Integer, Long> RESULT_CACHE = new HashMap<>();

    /**
     * Computes the Fibonacci number of N
     *
     * @param N
     * @return
     */
    public static long F(int N) {

        // If we cached the value, then return it
        if (RESULT_CACHE.containsKey(N)) {
            return RESULT_CACHE.get(N);
        }

        // Compute the Nth term 
        long fibonnaci_value;

        switch (N) {
            case 0:
                fibonnaci_value = 0;
                break;
            case 1:
                fibonnaci_value = 1;
                break;
            default:
                fibonnaci_value = F(N - 1) + F(N - 2);
                break;
        }

        // Cache the value and return it        
        RESULT_CACHE.put(N, fibonnaci_value);

        return fibonnaci_value;
    }
}
