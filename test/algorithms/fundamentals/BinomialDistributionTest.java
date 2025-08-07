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
package algorithms.fundamentals;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinomialDistributionTest {

    @Test
    public void testCalculateProbability() {

        int trials = 10;
        double probabilityOfSuccess = 0.5;
        int numberOfSuccesses = 5;
        double probability = BinomialDistribution.calculate(trials, probabilityOfSuccess, numberOfSuccesses);

        assertTrue(probability > 0);
    }

    @Test
    public void testCalculateProbabilityZeroSuccesses() {

        int trials = 10;
        double probabilityOfSuccess = 0.5;
        int numberOfSuccesses = 0;
        double probability = BinomialDistribution.calculate(trials, probabilityOfSuccess, numberOfSuccesses);

        assertTrue(probability > 0);
    }

    @Test
    public void testCalculateProbabilityAllSuccesses() {

        int trials = 10;
        double probabilityOfSuccess = 0.5;
        int numberOfSuccesses = 10;
        double probability = BinomialDistribution.calculate(trials, probabilityOfSuccess, numberOfSuccesses);

        assertTrue(probability > 0);
    }

    @Test
    public void testCalculateSpecificProbability() {

        int trials = 10;
        double probabilityOfSuccess = 0.25;
        int numberOfSuccesses = 5;
        double probability = BinomialDistribution.calculate(trials, probabilityOfSuccess, numberOfSuccesses);

        assertEquals("0,06", String.format("%.2f", probability));
    }

    @Test
    public void testCalculateProbabilityInvalidInput() {

        assertThrows(
                IllegalArgumentException.class,
                () -> BinomialDistribution.calculate(-1, 0.5, 5)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> BinomialDistribution.calculate(10, -1, 5)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> BinomialDistribution.calculate(10, 1.1, 5)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> BinomialDistribution.calculate(10, 0.5, -1)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> BinomialDistribution.calculate(10, 0.5, 11)
        );
    }

    @Test
    public void testCalculateBinomialCoefficient() {

        int trials = 5;
        int numberOfSuccesses = 2;
        double coefficient = BinomialDistribution.calculateBinomialCoefficient(trials, numberOfSuccesses);

        assertEquals(10, coefficient, 0.01);
    }

    @Test
    public void testCalculateBinomialCoefficientEdgeCases() {
        assertEquals(1,  BinomialDistribution.calculateBinomialCoefficient(5, 0), 0.01);
        assertEquals(1,  BinomialDistribution.calculateBinomialCoefficient(5, 5), 0.01);
    }
}
