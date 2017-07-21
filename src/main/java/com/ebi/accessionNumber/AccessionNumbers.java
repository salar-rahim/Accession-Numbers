package com.ebi.accessionNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Salar (salar.rahim@gmail.com)
 */
public class AccessionNumbers {
     static Map<String,List<String>> alphanumeric = new HashMap<>();
    
    /**
     * This method adds a key,value pair to the map, if the key exists
     * the value will be added to list of values of that key
     * @param accNumber the original accession number
     */
    public static void add(String accNumber){
        String key = extractLetters(accNumber);
        String value = extractDigits(accNumber);
        List<String> numbers = alphanumeric.get(key);
        if (numbers == null) {
            numbers = new ArrayList<>();
        }
        numbers.add(value);
        alphanumeric.put(key, numbers);
    }
    
    /**
     * This method use parallel stream to read the entryset of the hashmap
     * and deligates it to the buildNumberRanges() method of RangeBuilder class
     */
     static void buildNumberRanges(){
        AccessionNumbers.alphanumeric.entrySet().parallelStream()
                                                .forEach(RangeBuilder::buildNumberRanges);
    }
  
    /**
     * 
     * @param accNumber the original accession number
     * @return a series of digits found in the accNumber
     */
     static String extractDigits(String accNumber){
        return accNumber.replaceAll("\\D+","");
    }
    
    /**
     * 
     * @param accNumber the original accession number
     * @return a series of letters found in the accNumber
     */
     static String extractLetters(String accNumber){
        return accNumber.replaceAll("[^A-Za-z]+","");
    }
    
    

}
