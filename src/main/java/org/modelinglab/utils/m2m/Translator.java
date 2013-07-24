/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m;

import org.modelinglab.utils.m2m.exceptions.NotTranslatableException;
import org.modelinglab.utils.m2m.exceptions.TranslationException;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public interface Translator<I, O, Context extends TransformationContext> {
    
    /**
     * Translate an input object in a list of output objects
     * @param input the object we want to translate
     * @param m2m the {@link ModelTransformation} that calls this method
     * @param output output object
     * @param context An object that could be use to pass information between transformations
     * @throws TranslationException if it is impossible to translate the input object for a reason other than their class
     * @throws NotTranslatableException if {@link Translator#isTranslatable(input)} returns false
     */
    public void translate(
            ModelTransformation m2m, 
            I input, 
            O output, 
            Context context) throws TranslationException, NotTranslatableException;
    
}
