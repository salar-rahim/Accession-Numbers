package com.ebi.accessionNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Salar (salar.rahim@gmail.com)
 */
public class RangeBuilder {
    private static List<String> accNumbersList = new ArrayList<>();
    
    /**
     * Checks whether two strings have same length
     * @param str1 extracted digits from accession number
     * @param str2 extracted digits from accession number
     * @return true if both strings have the same length otherwise false.
     */
    private static boolean compareLength(String str1, String str2){
        return (str1.length()==str2.length())? true:false;
    }
    
    /**
     * Checks whether the second int value is equal to the first value incrementing by 1
     * @param x the extracted digits from an accession number in integer format
     * @param y the extracted digits from an accession number in integer format
     * @return true if second param is incrementing of the first param by 1
     */
    private static boolean isGreaterByOne(int x, int y){
        return (x+1 == y)? true : false;
    }
    
    /**
     * This method returns the final version of the number ranges
     * @return a list of the accession numbers with possible ranges
     */
    static List<String> getOrderedNumberRanges(){
//        Collections.sort(accNumbersList);
        return accNumbersList;
    }
    
    /**
     * This method works on a single entryset from a hasmap.
     * the entryset has key,value pairs
     * key is the alphabetical letters found in the accession numbers
     * keys are a list of values which belong to a single key
     * if a key has only one value its directly stored in the final list of numbers
     * if a key has multiple values it will go through two phases to find a possible range
     * phase-1: checks two adjacent values if they have different length which means they're not in a possible range
     * first value will be stored in the final list of numbers and the second value will goes through the same process
     * phase-2: in this phase two adjacent values have the same length.
     *          checks if the second value is incrementing of the first value by only one
     *          repeats the same process until last value from the possible range is found
     *          the start and end of the range is concatenated two form one number range and stored in the final list of numbers
     * @param entry is the entryset of the hashmap used to store accession numbers (letters as key and digits as values)
     */ 
    static void buildNumberRanges(Entry entry){
        String key = (String) entry.getKey();
        List<String> values = (ArrayList<String>) entry.getValue();
        Collections.sort(values);
        if (values.size() > 1) {
            String rangeStart,rangeEnd;
            for (int i = 0; i < values.size()-1; i++) {
               rangeStart = values.get(i);
               rangeEnd = values.get(i+1);
                if (compareLength(rangeStart, rangeEnd) && isGreaterByOne(Integer.parseInt(rangeStart),Integer.parseInt(rangeEnd))) {
                    rangeEnd = findRangeEnd(values, i);
                    accNumbersList.add(createRangeString(key, rangeStart, rangeEnd));
                    i = values.indexOf(rangeEnd);
                    continue;
                } else if(i == values.size()-2) {
                    accNumbersList.add(key.concat(rangeEnd));
                }
                accNumbersList.add(key.concat(rangeStart));
            }
        } else {
            accNumbersList.add(key.concat(values.get(0)));
        }
    }
    
    /**
     * This is a helper method for buildNumberRanges() method to find the last value of a possible number range
     * @param numbersList list of number values of a single key(letters from accession number)
     * @param index the starting point to which the search must be made from.
     * @return the last value of the possible number range
     */
    private static String findRangeEnd(List<String> numbersList, int index){
        String rangeStart="",rangeEnd;
        for (int i = index+1; i < numbersList.size()-1; i++) {
            rangeStart = numbersList.get(i);
            rangeEnd = numbersList.get(i+1);
            if (!(compareLength(rangeStart, rangeEnd) && isGreaterByOne(Integer.parseInt(rangeStart),Integer.parseInt(rangeEnd)))) {
                break;
            }
        }
        return rangeStart;
    }
    
    /**
     * This method creates a string representation of a number range
     * @param letter the series of letters found at the begining of an accession number
     * @param rangeStart the start value of a possible number range
     * @param rangeEnd the end value of a possible number range
     * @return a  string representation of the number ranges
     */
     private static String createRangeString(String letter, String rangeStart, String rangeEnd){
        return letter.concat(rangeStart).concat("-").concat(letter).concat(rangeEnd);
    }

}
