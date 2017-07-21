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
        Arrays.stream(args).sorted().forEach(AccessionNumbers::add);
        AccessionNumbers.buildNumberRanges();
        
        
        RangeBuilder.getOrderedNumberRanges().stream()
                                            .sorted()
                                            .forEach(System.out::println);
        
    }
    
}
