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
public class BooleanArray {

    /**
     * This method prints the contents of a two-dimensional boolean
     * array, using '*' to represent true and a 'space' to represent
     * false (includes row and column numbers).
     *
     * @param booleanArray boolean array
     * @return two-dimensional boolean array string representation
     */
    public static String format(boolean[][] booleanArray) {

        try {

            // Using StringBuilder to improve performance
            StringBuilder output = new StringBuilder();

            // Get the length of first column to format the header (column numbers)
            int columns = booleanArray[0].length;

            // Add four spaces to start exactly above the first column
            addSpaceToOutput(4, output);

            // Add the column header to output            
            for (int j = 1; j <= columns; j++) {
                output.append(j);
                addSpaceToOutput(1, output);
            }

            // Append new line before start the rows and columns
            output.append("\n");

            // Iterate over the rows
            for (int i = 0; i < booleanArray.length; i++) {

                // Add the row number to output 
                output.append(i + 1);

                addSpaceToOutput(1, output);

                // Add the first separator of each row
                output.append("|");

                addSpaceToOutput(1, output);

                // Iterate over each column of the i'th row
                for (int j = 0; j < booleanArray[i].length; j++) {

                    // If it's true add '*'
                    if (booleanArray[i][j]) {

                        output.append("*");
                        addSpaceToOutput(1, output);

                    } else {
                        // False add two ' ' (spaces)
                        addSpaceToOutput(2, output);
                    }
                }

                // Append the separator and add new line
                output.append("|\n");

            }

            return output.toString();

        } catch (Exception e) {
            return "Array is empty!";
        }

    }

    /**
     * Append an empty space to string builder.
     *
     * @param quantity
     * @param output
     */
    private static void addSpaceToOutput(int quantity, StringBuilder output) {

        final String space = " ";

        for (int i = 0; i < quantity; i++) {
            output.append(space);
        }
    }
}
