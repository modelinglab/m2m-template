/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.utils.m2m;

import org.modelinglab.utils.m2m.ClassTranslatorFactory;
import org.modelinglab.utils.m2m.ModelTransformation;
import org.modelinglab.utils.m2m.Translator;
import org.modelinglab.utils.m2m.TransformationContext;
import org.modelinglab.utils.m2m.exceptions.NotTranslatableException;
import org.modelinglab.utils.m2m.exceptions.TranslationException;
import junit.framework.TestCase;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
public class ClassTranslatorFactoryTest extends TestCase {
    
    Translator t1,t2,t3;
    
    public ClassTranslatorFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        t1 = new Translator() {

            public boolean isTranslatable(Object input) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void translate(ModelTransformation modelTransformation, Object input, Object output, TransformationContext context) throws TranslationException, NotTranslatableException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        t2 = new Translator() {

            public boolean isTranslatable(Object input) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void translate(ModelTransformation modelTransformation, Object input, Object output, TransformationContext context) throws TranslationException, NotTranslatableException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        t3 = new Translator() {

            public boolean isTranslatable(Object input) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void translate(ModelTransformation modelTransformation, Object input, Object output, TransformationContext context) throws TranslationException, NotTranslatableException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of addTranslator method, of class ClassTranslatorFactory.
     */
    public void testAddTranslator() {
        System.out.println("addTranslator");
        
        ClassTranslatorFactory instance = new ClassTranslatorFactory();
        
        Translator expResult = null;
        Translator result = instance.addTranslator(Integer.class, t1);
        assertEquals(expResult, result);
        
        expResult = t1;
        result = instance.addTranslator(Integer.class, t2);
        assertEquals("Expected previous translator assigned to Integer", expResult, result);
        
        expResult = null;
        result = instance.addTranslator(Double.class, t3);
        assertEquals(expResult, result);
        
        expResult = t2;
        result = instance.addTranslator(Integer.class, t1);
        assertEquals("Expected previous translator assigned to Integer", expResult, result);
    }

    /**
     * Test of getTranslator method, of class ClassTranslatorFactory.
     */
    public void testGetTranslator() throws Exception {
        System.out.println("getTranslator");
        
        Object input = null;
        ClassTranslatorFactory instance = new ClassTranslatorFactory();
        
        instance.addTranslator(Integer.class, t1);
        instance.addTranslator(Double.class, t2);
        
        try {
            instance.getTranslator(input);
            fail("This function should throw a NullPointerException with a null input");
        }
        catch (NullPointerException ex) {
        }
        
        try {
            instance.getTranslator('a');
            fail("This function should throw a NotTranslatableException in this case");
        }
        catch (NotTranslatableException ex) {
        }
        
        assertEquals(t1, instance.getTranslator(2));
        assertEquals(t2, instance.getTranslator(2d));
    }
}
