/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.util.concurrent.TimeUnit.MINUTES;

/**
 *
 * @author jhedding
 */
public class DateTimeLab {
    
    public static void main(String[] args) {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Last business day of the Month, Thursday, for June 2016
        
        LocalDate demoDate = LocalDate.now();
        LocalDate lastBusDay = demoDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        System.out.println(lastBusDay.getDayOfMonth());
        
        LocalDateTime demoDate2 = LocalDateTime.now();
        LocalDateTime demoDate3 = demoDate2.with(TemporalAdjusters.firstDayOfNextMonth());
        
        // time of germany
        LocalDateTime currTime = LocalDateTime.now();
        ZoneId germany = ZoneId.of("Europe/Berlin");
        ZonedDateTime germanyTime = ZonedDateTime.of(currTime, germany);
        System.out.println(germanyTime);
        
        LocalDateTime dueDate = LocalDateTime.now().plusDays(15);
        System.out.println("Due date: " + dueDate.format(fmt));
        
        // next leap year
        int year = LocalDateTime.now().getYear();
        
        
        
        // http://javarevisited.blogspot.com/2015/03/20-examples-of-date-and-time-api-from-Java8.html
        
        
        
        
        
        
    }
    
}
