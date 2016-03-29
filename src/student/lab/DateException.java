/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

/**
 *
 * @author etherdesign
 */
public class DateException extends IllegalArgumentException {
    
    public static final String ERR_MSG = "That is not a valid date.";

    public DateException() {
        super(ERR_MSG);
    }

    public DateException(String s) {
        super(ERR_MSG);
    }

    public DateException(String message, Throwable cause) {
        super(ERR_MSG, cause);
    }

    public DateException(Throwable cause) {
        super(cause);
    }
}
