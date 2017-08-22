/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.util;

/**
 *
 * @author aabello
 */
public class MaxDay {
    
    private static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static int getMaxDay(int month){
      return MAX_DAYS[month];
    }
    
    public static int getMaxDay(int month, boolean leapYear){
    
    if((leapYear) && month==1) 
        return 29;
    return getMaxDay(month);
    }
    
}
