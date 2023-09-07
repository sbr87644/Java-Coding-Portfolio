/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.System.out;
import java.util.Iterator;
import java.util.ListIterator;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 *
 * @author 19792
 */
public class GenericIterableStackTest extends TestCase {
    
    public GenericIterableStackTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getArray method, of class GenericIterableStack.
     */
    public void testGetArray() {
        System.out.println("getArray");
        GenericIterableStack instance = new GenericIterableStack();
        Object[] expResult = null;
        Object[] result = instance.getArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class GenericIterableStack.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        GenericIterableStack instance = new GenericIterableStack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class GenericIterableStack.
     */
    public void testPush() {
        System.out.println("push");
        Object item = null;
        GenericIterableStack instance = new GenericIterableStack();
        Object expResult = null;
        Object result = instance.push(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class GenericIterableStack.
     */
    public void testPop() {
        System.out.println("pop");
        GenericIterableStack instance = new GenericIterableStack();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class GenericIterableStack.
     */
    public void testPeek() {
        System.out.println("peek");
        GenericIterableStack instance = new GenericIterableStack();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GenericIterableStack.
     */
    public void testToString() {
        System.out.println("toString");
        GenericIterableStack instance = new GenericIterableStack();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class GenericIterableStack.
     */
    public void testIterator() {
        System.out.println("iterator");
        GenericIterableStack instance = new GenericIterableStack();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class GenericIterableStack.
     */
    public void testListIterator() {
        System.out.println("listIterator");
        GenericIterableStack instance = new GenericIterableStack();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
