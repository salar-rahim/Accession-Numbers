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
        String [] numbers = {"A00000","A0001","ERR000111","ERR000112","ERR000113","ERR000115","ERR000116",
            "ERR100114","ERR200000001","ERR200000002","ERR200000003","DRR2110012","SRR211001","ABCDEFG1"};
        Arrays.stream(numbers).sorted().forEach(AccessionNumbers::add);
        AccessionNumbers.buildNumberRanges();
        System.out.println(RangeBuilder.getOrderedNumberRanges());
    
        
    }
    
}
