/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.modelinglab.utils.m2m.exceptions.NotTranslatableException;

/**
 * This class is a {@link TranslatorFactory} that associates a class with a translator
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public class ClassTranslatorFactory<I, O, C extends TransformationContext> implements TranslatorFactory<I, O, C> {

    private final Map<Class, Translator> translatorMap;
    
    protected ClassTranslatorFactory() {
        translatorMap = new HashMap<Class, Translator>();
    }
    
    protected Translator addTranslator(Class clazz, Translator t) {
        return translatorMap.put(clazz, t);
    }
    
    @Nonnull
    public Translator getTranslator(Object input) throws NotTranslatableException {
        Class clazz = input.getClass();
        if(translatorMap.containsKey(clazz))
            return translatorMap.get(clazz);
        for(Class interfaze : clazz.getInterfaces()) {
            if(translatorMap.containsKey(interfaze))
                return translatorMap.get(interfaze);
        }
        clazz = clazz.getSuperclass();
        while(clazz != null) {
            if(translatorMap.containsKey(clazz))
                return translatorMap.get(clazz);
            clazz = clazz.getSuperclass();
        }
        throw new NotTranslatableException(input);
    }
    
}
