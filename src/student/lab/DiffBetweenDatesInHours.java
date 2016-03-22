/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.Duration;
import java.util.Calendar;

/**
 *
 * @author jhedding
 */
public class DiffBetweenDatesInHours {
    
    public static void main(String[] args) {
        
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, 20);
        
        
        Duration duration = Duration.between(cal.toInstant(), cal2.toInstant());
        System.out.println(duration);
        
        
    }
    
}
