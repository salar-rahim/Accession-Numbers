/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebi.accessionNumber;

import junit.framework.TestCase;

/**
 *
 * @author Salar
 */
public class AccessionNumbersTest extends TestCase {
    
    public AccessionNumbersTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of add method, of class AccessionNumbers.
     */
    public void testAdd() {
        System.out.println("test add method");
        String accNumber = "AAA00098";
        AccessionNumbers.add(accNumber);
        
    }
    
}
