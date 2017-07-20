package com.ebi.accessionNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Salar
 */
public class AccessionNumbers {
    private static Map<String,List<String>> alphanumeric = new HashMap<>();
    
    /**
     * This method adds a key,value pair to the map, if the key is already added
     * in the map the value will be added to list of values of that key
     * @param key is a series of letters extracted from the accession number
     * @param value is a series of digits in String type extracted from the accession number
     */
    public static void add(String key, String value){
        List<String> numbers = alphanumeric.get(key);
        if (numbers == null) {
            numbers = new ArrayList<>();
        }
        numbers.add(value);
        alphanumeric.put(key, numbers);
    }
    
    /**
     * 
     * @param accNumber the original accession number
     * @return a series of digits found in the accNumber
     */
    public String extractDigits(String accNumber){
        return accNumber.replaceAll("\\D+","");
    }
    
    /**
     * 
     * @param accNumber the original accession number
     * @return a series of letters found in the accNumber
     */
    public String extractLetters(String accNumber){
        return accNumber.replaceAll("[^A-Za-z]+","");
    }

}
