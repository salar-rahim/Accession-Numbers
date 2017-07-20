package com.ebi.accessionNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Salar
 */
public class RangeBuilder {
    static List<String> accNumbersList = new ArrayList<>();
    
    private static boolean compareLength(String str1, String str2){
        return (str1.length()==str2.length())? true:false;
    }
    
    private static boolean isGreaterByOne(int x, int y){
        return (x+1 == y)? true : false;
    }
    static List<String> getOrderedNumberRanges(){
        Collections.sort(accNumbersList);
        return accNumbersList;
    }
    
    static void buildNumberRanges(){
        AccessionNumbers.alphanumeric.entrySet().parallelStream()
                                                .forEach(RangeBuilder::buildNumberRanges);
    }
    
    private static void buildNumberRanges(Entry entry){
        String key = (String) entry.getKey();
        List<String> values = (ArrayList<String>) entry.getValue();
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
    
     private static String createRangeString(String letter, String rangeStart, String rangeEnd){
        return letter.concat(rangeStart).concat("-").concat(letter).concat(rangeEnd);
    }

}
