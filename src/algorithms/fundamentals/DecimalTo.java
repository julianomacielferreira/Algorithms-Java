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

/**
 *
 * @author juliano
 */
public class DecimalTo {

    public static String binary(int n) {

        // Assuming only positive integers (not dealing with sign)
        n = Math.abs(n);

        // If n is {0,1} just return it
        if (n < 2) {
            return String.valueOf(n);
        }

        // Using StringBuilder to improve performance
        StringBuilder buffer = new StringBuilder();

        // Flag to stop the iteration        
        boolean quotientNotZeroOrOne = true;

        // Start the sucessive divisions keeping the remainder    
        while (quotientNotZeroOrOne) {

            // Use module operator to get the remainder            
            int remainder = n % 2;

            // Append the remainder because it always go to the result            
            buffer.append(String.valueOf(remainder));

            // Divide by the base and keep the quotient            
            n /= 2;

            // Check if it's in the base case      
            if (n < 2) {
                buffer.append(String.valueOf(n));
                quotientNotZeroOrOne = false;
            }
        }

        // Return the result in reverse order (right from left)
        return buffer.reverse().toString();
    }

}
