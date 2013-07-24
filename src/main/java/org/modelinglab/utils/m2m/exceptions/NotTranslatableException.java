/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m.exceptions;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public class NotTranslatableException extends RuntimeException {
    
    Object input;

    public NotTranslatableException(Throwable cause, Object input) {
        super(cause);
        this.input = input;
    }

    public NotTranslatableException(String message, Throwable cause, Object input) {
        super(message, cause);
        this.input = input;
    }

    public NotTranslatableException(String message, Object input) {
        super(message);
        this.input = input;
    }

    public NotTranslatableException(Object input) {
        this.input = input;
    }

    @Override
    public String getMessage() {
        String superMessage = super.getMessage();
        if(superMessage == null) {
            if(input == null) 
                return "null object";
            return input.toString();
        }
        return superMessage;
    }
    
    
    
}
