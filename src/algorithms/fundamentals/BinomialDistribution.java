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

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a binomial distribution, which models the probability of obtaining
 * exactly k successes in n independent trials, each with a constant probability
 * of success.
 */
public class BinomialDistribution {

    private static int called;
    private static final Map<String, Double> COEFFICIENTS_CACHE = new HashMap<>();

    /**
     * Calculates the probability of obtaining exactly k successes in n independent
     * trials, each with a probability p of success.
     *
     * @param trials                          the number of trials (n)
     * @param probabilityOfSuccessInEachTrial the probability of success in each trial (p)
     * @param numberOfSuccesses               the number of successes (k)
     * @return the probability of obtaining exactly k successes
     * @throws IllegalArgumentException if the number of trials is negative,
     *         the probability of success is not between 0 and 1,
     *         or the number of successes is not between 0 and the number of trials
     */
    public static double calculate(int trials, double probabilityOfSuccessInEachTrial, int numberOfSuccesses) {

        if (trials < 0) {
            throw new IllegalArgumentException("Number of trials must be non-negative");
        }
        if (probabilityOfSuccessInEachTrial < 0 || probabilityOfSuccessInEachTrial > 1) {
            throw new IllegalArgumentException("Probability of success must be between 0 and 1");
        }
        if (numberOfSuccesses < 0 || numberOfSuccesses > trials) {
            throw new IllegalArgumentException("Number of successes must be between 0 and the number of trials");
        }

        double probabilityOfFailure = 1 - probabilityOfSuccessInEachTrial;

        double coefficient = calculateBinomialCoefficient(trials, numberOfSuccesses);

        return coefficient * Math.pow(probabilityOfSuccessInEachTrial, numberOfSuccesses) * Math.pow(probabilityOfFailure, trials - numberOfSuccesses);
    }

    /**
     * Calculates the binomial coefficient (n choose k) using memoization to cache
     * previously computed values.
     *
     * @param trials            the number of trials (n)
     * @param numberOfSuccesses the number of successes (k)
     * @return the binomial coefficient (n choose k)
     */
    private static double calculateBinomialCoefficient(int trials, int numberOfSuccesses) {

        StdOut.println(
                String.format(
                        "%s - calculateBinomialCoefficient(n: %s, k: %s)",
                        ++called,
                        trials,
                        numberOfSuccesses
                )
        );

        final String CACHE_KEY = String.format("%s-%s", trials, numberOfSuccesses);

        // If we cached the value, then return it
        if (COEFFICIENTS_CACHE.containsKey(CACHE_KEY)) {
            return COEFFICIENTS_CACHE.get(CACHE_KEY);
        }

        double binomialCoefficient;

        // Base case
        if (numberOfSuccesses == 0 || numberOfSuccesses == trials) {
            binomialCoefficient = 1.0;
        } else {
            binomialCoefficient = calculateBinomialCoefficient(trials - 1, numberOfSuccesses - 1) + calculateBinomialCoefficient(trials - 1, numberOfSuccesses);
        }

        // Cache the value and return it
        COEFFICIENTS_CACHE.put(CACHE_KEY, binomialCoefficient);

        return binomialCoefficient;
    }
}
