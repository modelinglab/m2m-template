/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m;

import javax.annotation.Nullable;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public interface ObjectFactory<I, O> {
    
    /**
     * 
     * @param input
     * @return the output object to that input. It can return null if the input object is not
     * mapeable
     */
    @Nullable
    public O createObject(I input);    
    
}
