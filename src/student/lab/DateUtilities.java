package student.lab;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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

    public DateUtilities() {
    }

    /**
     * Returns the current date and time.
     * @return current date and time.
     */
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Format a <code>LocalDateTime</code> object as day of week, month, day
     * of month, year.  Example output:  Monday March 28, 2016.  Full day of
     * week and month names, US locale.
     *
     * @param date A <code>LocalDateTime</code> object.
     * @return a String formatted as textual day of week, textual month,
     * numeric day of month, numeric year.
     * @throws IllegalArgumentException if date is null.
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new DateException();
        }
        String dow = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
        
        return dow + " " + month + " " + date.getDayOfMonth() + ", " + date.getYear();
        
    }
    
    /**
     * Format a <code>String</code> according to user supplied DateTimeFormatter format.
     * Note that this 
     * 
     * @param date A <code>String</code> object, must be 8 characters in length.
     * Example: 20160320.  Numeric year, numeric month with leading zero,
     * numeric day with leading zero.
     * @param df A <code>DateTimeFormatter</code> object.  Example:
     * DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
     * df is passed, to get the supplied string back as a LocalDate object
     * in BASIC ISO DATE format:  2016-03-20
     * @return a LocalDate object according to the supplied date time formatter.
     * @throws IllegalArgumentException if string date passed in is null, or is
     * not the expected 8 characters.
     */
    public LocalDate toFormattedDate(String date, DateTimeFormatter df) throws IllegalArgumentException {
        if (date == null || date.isEmpty() || date.length() != 8) {
            throw new DateException();
        }
        LocalDate formattedDate = LocalDate.parse(date, df);
        
        return formattedDate;
    }
    
    /**
     * Format a <code>String</code> according to the BASIC_ISO_DATE format.
     *
     * @param date A <code>String</code> object, must be 8 characters in length.
     * Example: 20160320.  Numeric year, numeric month with leading zero,
     * numeric day with leading zero.
     * @return a LocalDate object formatted according to the built in BASIC_ISO_DATE format
     * @throws IllegalArgumentException if date is null, or is not the expected
     * 8 characters in length.
     */
    public LocalDate toIsoDate(String date) throws IllegalArgumentException {
        if (date == null || date.isEmpty() || date.length() != 8) {
            throw new DateException();
        }
        LocalDate formattedDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        
        return formattedDate;
    }
    
    /**
     * Format a <code>String</code> according to a custom date pattern, this
     * one being the first three letters of the month, the numeric day, and the
     * numeric year.
     *
     * @param date - a <code>String</code> object, must be formatted as year, month,
     * date, with leading zeroes.  Example:  20160320
     * @return A LocalDate formatted according to a custom date format: MM dd yyyy.
     * @throws IllegalArgumentException if date is null or is not the expected 8 
     * characters in length.
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
     * Check if a supplied date is before or after today's date.
     * @param date A <code>LocalDate</code> object to be analyzed.
     * @return A string stating if the date parameter is before, equal to, or
     * after today's date.
     * @throws DateException if date is null.
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
     * @param date1 LocalDate object, the first date to be analyzed.
     * @param date2 LocalDate object, the second date to be analyzed.
     * @return A String with the months and days between the two given dates.
     * @throws IllegalArgumentException if either date parameters are null.
     */
    public String timeBetween(LocalDate date1, LocalDate date2) throws IllegalArgumentException {
        if (date1 == null || date2 == null) {
            throw new DateException();
        }
        Period timeBetween = Period.between(date1, date2);
        
        return "There are: " + timeBetween.getMonths() + " months and " +
                timeBetween.getDays() + " days between those two dates.";
        
    }
    
    /**
     * Adds a number of weeks to the supplied date. 
     * @param date A <code>LocalDate</code> object that you want to increment.
     * @param weeks A <code>integer</code> representing the number of weeks you want to
     * increment the supplied date by.
     * @return A <code>LocalDate</code> object incremented by the number of weeks given.
     */
    public LocalDate addWeek(LocalDate date, int weeks) {
        LocalDate nextWeek = date.plus(weeks, ChronoUnit.WEEKS);
        return nextWeek;
    }
    
    
    
}
