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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author juliano
 */
public class DecimalToTest {

    /**
     * Test of binary method, of class DecimalTo.
     */
    @Test
    public void testBinary() {
        assertEquals("0", DecimalTo.binary(0));
        assertEquals("1", DecimalTo.binary(1));
        assertEquals("10", DecimalTo.binary(2));
        assertEquals("1010", DecimalTo.binary(10));
        assertEquals("100100", DecimalTo.binary(36));
        assertEquals("111010110111100110100010101", DecimalTo.binary(123456789));
    }

    /**
     * Test of binary method, of class DecimalTo, compared to the Java API.
     */
    @Test
    public void testBinaryWithJavaAPI() {
        assertEquals(Integer.toBinaryString(0), DecimalTo.binary(0));
        assertEquals(Integer.toBinaryString(1), DecimalTo.binary(1));
        assertEquals(Integer.toBinaryString(2), DecimalTo.binary(2));
        assertEquals(Integer.toBinaryString(10), DecimalTo.binary(10));
        assertEquals(Integer.toBinaryString(36), DecimalTo.binary(36));
        assertEquals(Integer.toBinaryString(123456789), DecimalTo.binary(123456789));
    }

}
