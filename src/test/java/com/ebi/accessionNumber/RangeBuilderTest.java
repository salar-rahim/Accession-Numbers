/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebi.accessionNumber;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author Salar
 */
public class RangeBuilderTest {
    
    public RangeBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOrderedNumberRanges method, of class RangeBuilder.
     */
    @Ignore
    public void testGetOrderedNumberRanges() {
        System.out.println("getOrderedNumberRanges");
        List<String> expResult = null;
        List<String> result = RangeBuilder.getOrderedNumberRanges();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of buildNumberRanges method, of class RangeBuilder.
     */
    @Ignore
    public void testBuildNumberRanges() {
        System.out.println("buildNumberRanges");
        Map.Entry entry = null;
        RangeBuilder.buildNumberRanges(entry);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
