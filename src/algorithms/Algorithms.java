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
package algorithms;

import algorithms.data_abstraction.StaticSetOfInts;
import algorithms.fundamentals.*;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Entry point class (contains the main() method). It could be called Main.java,
 * Bootstrap.java, etc.
 *
 * @author juliano
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {

//        decimalToBinary();
//        booleanArray();
//        fibonacci();
//        factorial();
//        compareNumbers();
//        division();
//        drawing();
//        staticSetOfInts();

        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12")
        );

        final BigDecimal totalDiscountedPrices = prices.stream().
                filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0).
                map(price -> price.multiply(BigDecimal.valueOf(0.9))).
                reduce(BigDecimal.ZERO, BigDecimal::add);

        StdOut.println("Total discounted price: " + totalDiscountedPrices);

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        friends.forEach((final String name) -> StdOut.println(name));

        friends.forEach(StdOut::println);

        friends.stream().map(String::toUpperCase).forEach(name -> StdOut.println(name));

        final List<String> startsWithNFriends = friends.stream().
                filter(checkStartsWith("N")).
                collect(Collectors.toList());

        StdOut.println(String.format("Found %d names starting with N:", startsWithNFriends.size()));
        StdOut.println(startsWithNFriends);

        final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");

        final List<String> startsWithB = editors.stream().
                filter(checkStartsWith("B")).
                collect(Collectors.toList());

        StdOut.println(String.format("Found %d names starting with B:", startsWithB.size()));
        StdOut.println(startsWithB);

        int[] numbers = getNumbersFromFile("4Kints.txt");
        int[] numbersToFind = getNumbersFromFile("1Kints.txt");

        Arrays.sort(numbers);
        Arrays.sort(numbersToFind);

        printNumbersThatAreInWhitelist(numbers, numbersToFind);
        printNumbersThatAreNotInWhiteList(numbers, numbersToFind);

        int gcd = EuclidsGCD.compute(105, 24);
        StdOut.println(String.format("greatest common divisor of 105 and 24 is %s", gcd));

        gcd = EuclidsGCD.compute(1111111, 1234567);
        StdOut.println(String.format("greatest common divisor of 1111111 and 1234567 is %s", gcd));

        double binomialDistribution = BinomialDistribution.calculate(100, 0.25, 50);

        StdOut.println(String.format("The Binomial Distribution of (%s, %s) with number of successes %s is %s", 100, 50, 0.25, String.format("%.10f", binomialDistribution)));
    }

    public static Predicate<String> checkStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    private static void drawing() {
        Drawing.points(100);
        Drawing.random(50);
        Drawing.random(50, true);
    }

    private static void decimalToBinary() {
        StdOut.println(DecimalTo.binary(365));
    }

    private static void booleanArray() {
        boolean[][] arr = {{false, true}, {true, false}, {true, true}};
        StdOut.println(BooleanArray.format(arr));
    }

    private static void fibonacci() {
        for (int N = 0; N <= 100; N++) {
            StdOut.println(N + " " + Fibonacci.F(N));
        }
    }

    private static void factorial() {
        for (int N = 0; N <= 65; N++) {
            StdOut.println(N + " " + Factorial.compute(N));
        }
    }

    private static void compareNumbers() {

        StdOut.print("Type n1: ");
        int n1 = StdIn.readInt();
        StdOut.print("Type n2: ");
        int n2 = StdIn.readInt();
        StdOut.print("Type n3: ");
        int n3 = StdIn.readInt();

        boolean isEqual = CompareNumbers.printIfThreeNumbersAreEqual(n1, n2, n3);

        StdOut.print("The numbers are equal? ");
        StdOut.println(isEqual);

        StdOut.print("Type x: ");
        double x = StdIn.readDouble();
        StdOut.print("Type y: ");
        double y = StdIn.readDouble();

        boolean isBetween = CompareNumbers.checkIfTheNumbersAreBetweenZeroAndOne(x, y);

        StdOut.print("The numbers are between 0 and 1? ");
        StdOut.println(isBetween);
    }

    private static void division() {
        Division.print();
    }

    private static void staticSetOfInts() {

        int[] numbers = getNumbersFromFile("8Kints.txt");
        int[] numbersToFind = getNumbersFromFile("4Kints.txt");

        StaticSetOfInts setOfIntegers = new StaticSetOfInts(numbers);

        for (int i = 0; i < numbersToFind.length; i++) {

            int value = numbersToFind[i];

            if (setOfIntegers.contains(value)) {
                StdOut.println(String.format("Found: %s", value));
            } else StdOut.println(String.format("Not found: %s", value));

        }

    }

    private static void printNumbersThatAreInWhitelist(final int[] numbers, int[] numbersToFind) {

        BinarySearch binarySearch = new BinarySearch(numbers);

        for (Integer number : numbersToFind) {

            int index = binarySearch.findIndexOf(number);

            if (index > -1) {
                StdOut.println(String.format("The number %s is at the list", number));
            }
        }

    }

    private static void printNumbersThatAreNotInWhiteList(final int[] numbers, int[] numbersToFind) {

        BinarySearch binarySearch = new BinarySearch(numbers);

        for (Integer number : numbersToFind) {

            int index = binarySearch.findIndexOf(number);

            if (index == -1) {
                StdOut.println(String.format("The number %s is not in the list", number));
            }
        }
    }

    private static int[] getNumbersFromFile(final String file) {
        return In.readInts("./data/" + file);
    }
}
