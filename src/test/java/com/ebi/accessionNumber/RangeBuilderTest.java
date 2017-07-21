/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebi.accessionNumber;

import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author Salar
 */
public class RangeBuilderTest {
    
    
    @Test
    public void testEqualLengthStrings(){
        String str1 = "ABD8765";
        String str2 = "TRE9812";
        boolean expected = RangeBuilder.compareLength(str1, str2);
        assertTrue("Equal length strings test fail",expected);
    }
    @Test
    public void testNonEqualLengthStrings(){
        String str1 = "ABD87";
        String str2 = "TRE9812";
        boolean expected = RangeBuilder.compareLength(str1, str2);
        assertFalse("Non Equal length strings test pass",expected);
    }
    
    @Test
    public void testGreaterByOne(){
        boolean expected = RangeBuilder.isGreaterByOne(5, 6);
        assertTrue("second number greater than first number by one_Test fail",expected);
    }
    @Test
    public void testNotGreaterByOne(){
        boolean expected = RangeBuilder.isGreaterByOne(3, 6);
        assertFalse("second number greater than first number by more than one_Test pass",expected);
    }
    
    @Test
    public void testFindRangeEnd(){
        List<String> numbers = Arrays.asList("00012","00013","00014","12406");
        String expected = RangeBuilder.findRangeEnd(numbers, 0);
        String actual = "00014";
        assertEquals(expected,actual);
    }
    @Test
    public void testInvalidRangeEnd(){
        List<String> numbers = Arrays.asList("00012","00013","00014","12406");
        String expected = RangeBuilder.findRangeEnd(numbers, 0);
        String actual = "12406";
        assertNotEquals(expected,actual);
    }
    
    @Test
    public void testCreateValidRangeString(){
        String actual = "AB1234-AB1236";
        String expected = RangeBuilder.createRangeString("AB", "1234", "1236");
        assertEquals(expected, actual);
    }
    @Test
    public void testCreateInvalidRangeString(){
        String actual = "AB1234-AB1234";
        String expected = RangeBuilder.createRangeString("AB", "1234", "1236");
        assertNotEquals(expected, actual);
    }
    
}
