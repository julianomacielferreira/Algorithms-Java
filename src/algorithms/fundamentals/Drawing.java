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

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Drawing class has static methods showing the usage examples of StdDraw class.
 *
 * @see
 * https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdDraw.html
 * @author juliano
 */
public class Drawing {

    /**
     * This method is an sample from the book showing how to draw points by
     * varying the position parameter of the method StdDraw.point().
     *
     * @param N number of points to generate
     */
    public static void points(int N) {

        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(StdDraw.BLACK);

        StdDraw.text(50, 9000, "Drawing Points");

        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    /**
     * This method generate N random numbers and draw rectangles varying the x
     * and y position.
     *
     * @param N range of random numbers to generate
     * @param sorted optional parameters to sorting the random numbers
     */
    public static void random(int N, boolean... sorted) {

        // Create an array of size N to keep the random numbers 
        double numbers[] = new double[N];

        // Iterating N times calling the random number generating method
        for (int i = 0; i < N; i++) {
            numbers[i] = StdRandom.uniform();
        }

        // If it's to sort the numbers, calls Java API Arrays class.
        if (sorted.length > 0) {
            Arrays.sort(numbers);
        }

        // Iterating N times again to fill the canvas with each rectangle        
        for (int i = 0; i < N; i++) {

            // This makes the x point moves to the right in each iteration
            double x = 1.0 * i / N;

            // Gets the half of the generated number
            double y = numbers[i] / 2.0;

            double halfWidth = 0.5 / N;
            double halfHeight = y;

            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }

    }
}
