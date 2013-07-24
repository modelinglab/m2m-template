/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m;

import org.modelinglab.utils.m2m.exceptions.NotTranslatableException;
import javax.annotation.Nonnull;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public interface TranslatorFactory<I, O, C extends TransformationContext> {
    
    /**
     * @param input the object we want to translate
     * @return an {@link Translator} object ensuring that calling {@link Translator#isTranslatable(input)}
     * returns true. Result could be also null if the input object is not translated
     * @throws NotTranslatableException if this factory does not know how to translate the input object
     */
    @Nonnull
    public Translator<I, O, C> getTranslator(@Nonnull I input) throws NotTranslatableException;
    
}
