package student.lab;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Utility class to simplify managing and using dates and times, 
 * using the new Java 8 Date/Time API. Fields are
 * provided for choice of units to be returned from date/time difference
 * calculations.
 * <P>
 * Change History:
 * <UL>
 * <LI>2016-03-26 - initial version.</LI>
 * </UL>
 *
 * (C) 2016 - Joel Hedding
 *
 * This code is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <P>
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * @author etherdesign
 * (<a href="mailto:jahedding@gmail.com">jahedding@gmail.com</a>)
 * @version 1.0
 */
public class DateUtilities {

    private DateUtilities() {
    }

    /**
     * Returns the current date and time.
     * @return current date and time.
     */
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Format a <code>LocalDateTime</code> according to the default date pattern for the
     * current locale
     *
     * @param date - a <code>LocalDateTime</code> object
     * @return a date formatted according to the default date pattern for the
     * current locale
     * @throws IllegalArgumentException if date is null
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new DateException();
        }
        DateFormat df = DateFormat.getDateInstance();
        return df.format(date);
    }

    /**
     * Format a <code>String</code> according to the BASIC_ISO_DATE format.
     *
     * @param date - a <code>String</code> object
     * @return a date formatted according to the built in BASIC_ISO_DATE format
     * @throws IllegalArgumentException if date is null
     */
    public LocalDate toIsoDate(String date) throws IllegalArgumentException {
        if (date == null || date.isEmpty() || date.length() != 8) {
            throw new DateException();
        }
        LocalDate formattedDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        
        return formattedDate;
    }
    
    /**
     * Format a <code>String</code> according to the a custom date pattern, this
     * one being the first three letters of the month, the numeric day, and the
     * numeric year.
     *
     * @param date - a <code>String</code> object
     * @return a date formatted according to a custom date format.
     * @throws IllegalArgumentException if date is null
     */
    public LocalDate toTextDate(String date) throws IllegalArgumentException {
        if (date == null || date.isEmpty() || date.length() != 8) {
            throw new DateException();
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy");
        LocalDate formattedDate = LocalDate.parse(date, format);
        
        return formattedDate;
    }
    
    
    /**
     * Check if a date is before or after a given date.
     * @param date - LocalDate object to be analyzed
     * @return a string stating if the date parameter is before, equal to, or
     * after today's date.
     * @throws DateException if date is null
     */
    public String isBeforeAfter(LocalDate date) throws IllegalArgumentException {
            
        if (date == null) {
            throw new DateException();
        }
        
        LocalDate today = LocalDate.now();
        
        if (date.isBefore(today)) {
            return "The given date is before today.";
        } else if (date.isEqual(today)) {
            return "The given date is today.";
        } else {
            return "The given date is after today.";
        }
    }
    
    /**
     * Calculates the time difference between two given dates in months and days.
     * @param date1 the first date to be analyzed
     * @param date2 the second date to be analyzed
     * @return a String with the months and days between the two given dates.
     * @throws IllegalArgumentException
     */
    public String timeBetween(LocalDate date1, LocalDate date2) throws IllegalArgumentException {
        if (date1 == null || date2 == null) {
            throw new DateException();
        }
        Period timeBetween = Period.between(date1, date2);
        
        return "There are: " + timeBetween.getMonths() + " months and " +
                timeBetween.getDays() + " days between those two dates.";
        
    }
    
    
    
    
}