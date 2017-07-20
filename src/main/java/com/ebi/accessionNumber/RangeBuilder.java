package com.ebi.accessionNumber;

import java.util.ArrayList;
import java.util.List;

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
    
    

}
