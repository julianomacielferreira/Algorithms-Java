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

import edu.princeton.cs.algs4.StdOut;

public class BinomialDistribution {

    private static int called;

    /**
     * @param trials                          The number of trials
     * @param probabilityOfSuccessInEachTrial The probability of success in each trial
     * @param numberOfSuccesses               The number of successes
     * @return the number of successes in a fixed number of independent trials
     */
    public static double calculate(int trials, int probabilityOfSuccessInEachTrial, double numberOfSuccesses) {

        double probabilityOfFailure = 1 - numberOfSuccesses;

        double coefficient = calculateBinomialCoefficient(trials, probabilityOfSuccessInEachTrial);

        return coefficient * (Math.pow(numberOfSuccesses, probabilityOfSuccessInEachTrial)) * (Math.pow(probabilityOfFailure, (trials - probabilityOfSuccessInEachTrial)));
    }

    /**
     * @param trials                          The number of trials
     * @param probabilityOfSuccessInEachTrial The probability of success in each trial
     * @return the binomial coefficient from trials with probability of success
     */
    private static double calculateBinomialCoefficient(int trials, int probabilityOfSuccessInEachTrial) {

        StdOut.println(
                String.format(
                        "%s - calculateBinomialCoefficient(n: %s, k: %s)",
                        ++called,
                        trials,
                        probabilityOfSuccessInEachTrial
                )
        );
        // Base case
        if ((probabilityOfSuccessInEachTrial == 0) || (probabilityOfSuccessInEachTrial == trials))
            return 1;
        else // Recursive case
            return calculateBinomialCoefficient(trials - 1, probabilityOfSuccessInEachTrial - 1) + calculateBinomialCoefficient(trials - 1, probabilityOfSuccessInEachTrial);
    }
}
