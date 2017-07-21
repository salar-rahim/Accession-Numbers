package com.ebi.accessionNumber;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author Salar
 */
public class AccessionNumbersTest {
    
   
    /**
     * Test of add method, of class AccessionNumbers.
     */
    @Test
    public void testAddKey() {
        String accNumber = "AAA00098";
        AccessionNumbers.add(accNumber);
        boolean result = AccessionNumbers.alphanumeric.containsKey("AAA");
        assertTrue(result);
    }
    @Test
    public void testAddValue() {
        String accNumber = "AAA00098";
        AccessionNumbers.add(accNumber);
        boolean result = AccessionNumbers.alphanumeric.get("AAA").contains("00098");
        assertTrue(result);
    }
    @Test
    public void testExtractDigits(){
        String accessionNumber = "ABC12345";
        String actual = "12345";
        String expected = AccessionNumbers.extractDigits(accessionNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void testInvalidExtractedDigits(){
        String accessionNumber = "ABC12345";
        String actual = "123";
        String expected = AccessionNumbers.extractDigits(accessionNumber);
        assertNotEquals(expected, actual);
    }
    
    
    @Test
    public void testExtractLetters(){
        String accessionNumber = "ABC12345";
        String actual = "ABC";
        String expected = AccessionNumbers.extractLetters(accessionNumber);
        assertEquals(expected, actual);
    }
    @Test
    public void testInvalidExtractedLetters(){
        String accessionNumber = "ABC12345";
        String actual = "AB";
        String expected = AccessionNumbers.extractLetters(accessionNumber);
        assertNotEquals(expected, actual);
    }
    
}
