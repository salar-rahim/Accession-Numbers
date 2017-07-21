package com.ebi.accessionNumber;

import java.util.Arrays;

/**
 * @author Salar (salar.rahim@gmail.com)
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
