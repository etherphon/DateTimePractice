/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jhedding
 */
public class SimpleDateTime {
    
    public static void main(String[] args) {
        // Old way (pre-JDK8)
        
        // Not international
        Date date1 = new Date();
        System.out.println(date1);
        
        // Get date / time long integer value
        long dateTimeValue = date1.getTime();
        System.out.println("Date Time Value: " + dateTimeValue);
        
        // International
        Calendar date3 = Calendar.getInstance();
        System.out.println(date3);
        
        // Bad practice, don't do this
        date3.set(2020, 2, 22);
        System.out.println("Bad practice: " + date3);
        
        // Good practice, do this
        date3.set(2020, Calendar.MARCH, 22);
        System.out.println("Bad practice: " + date3);
        
        // New way (JDK8+)
        // International
        LocalDateTime date2 = LocalDateTime.now();
        System.out.println(date2);
        
        // Date only (No time)
        LocalDate date4 = LocalDate.now();
        System.out.println(date4);
        
    }
    
}
