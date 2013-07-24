/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m.exceptions;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public class TranslationException extends RuntimeException {
    
    final boolean userError;
    final Object input;

    public TranslationException(Throwable cause, boolean userError, Object input) {
        super(cause);
        this.userError = userError;
        this.input = input;
    }

    public TranslationException(String message, Throwable cause, boolean userError, Object input) {
        super(message, cause);
        this.userError = userError;
        this.input = input;
    }

    public TranslationException(String message, boolean userError, Object input) {
        super(message);
        this.userError = userError;
        this.input = input;
    }

    public TranslationException(boolean userError, Object input) {
        this.userError = userError;
        this.input = input;
    }

    public Object getInput() {
        return input;
    }

    public boolean isUserError() {
        return userError;
    }
    
    
}
