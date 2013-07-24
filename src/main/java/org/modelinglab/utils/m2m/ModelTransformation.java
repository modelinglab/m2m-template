/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m;

import org.modelinglab.utils.m2m.exceptions.NotTranslatableException;
import org.modelinglab.utils.m2m.exceptions.TranslationException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public class ModelTransformation<I, C extends TransformationContext> {
    
    final Map<I, Object> translatedObjects;
    final TranslatorFactory<I, Object, C> translatorFactory;
    final ObjectFactory<I, Object> objectFactory;

    public ModelTransformation(TranslatorFactory<I, Object, C> translatorFactory, ObjectFactory<I, Object> objectFactory) {
        this.translatorFactory = translatorFactory;
        this.objectFactory = objectFactory;
        translatedObjects = new HashMap<I, Object>();
    }
    
    /**
     * Translate an input object. If the object had already been translated, the previous 
     * translated object are returned
     * @param input the input object you want to translate
     * @return the translated output object/objects
     * @throws NotTranslatableException if the factory does not known how to translate the input object
     * @throws TranslationException if there was an error translating the input object
     */
    public Object getTranslation(I input, C context) throws NotTranslatableException, TranslationException {
        if(input == null) {
            throw new NullPointerException("The input object is null");
        }
        if(translatedObjects.containsKey(input)) {
            return translatedObjects.get(input);
        }
        Object output = objectFactory.createObject(input);
        translatedObjects.put(input, output);
        if (output == null) {
            return null;
        }
        Translator<I, Object, C> t = translatorFactory.getTranslator(input);
        t.translate(this, input, output, context);
        return output;
    }

    public Map<I, Object> getTranslatedObjects() {
        return translatedObjects;
    }
    
    public Object getTranslatedObjectFor(I input) {
        return translatedObjects.get(input);
    }
}
