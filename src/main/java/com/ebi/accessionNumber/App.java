package com.ebi.accessionNumber;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String [] numbers = {"A00000","A0001","ERR000111","ERR000112","ERR000113"};
        Arrays.stream(numbers).sorted().forEach(AccessionNumbers::add);
    
        
    }
    
}
