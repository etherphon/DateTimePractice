/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jhedding
 */
public class SimpleDateTime2 {
    
    public static void main(String[] args) throws ParseException {
        // create a simple date formatter
        String format = "M/d/yy h:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        
        // create a dae formatter
        // use dateinstance for just date, datetimeinstace for date and time
        // need to specify a format for both date and time for the latter
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        
        
        // Current date and time
        Calendar date1 = Calendar.getInstance();
        // using getTime to convert a calendar object into a date object
        System.out.println("Current: " + df.format(date1.getTime()));
        // Add 30 days
        date1.add(Calendar.DATE, -30);
        
        System.out.println("30 days prior: " + df.format(date1.getTime()));
        
        // turn string into date
        // use this for text input into gui and console
        String format2 = "M/d/yyyy";
        String dateString = "1/1/2016";
        SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
        Date date2 = sdf2.parse(dateString);
        System.out.println(date2);
        
    }
    
}
