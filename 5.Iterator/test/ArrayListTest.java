/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayListTest {

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * Test of size method, of class ArrayList.
     */
    @Test
    public void testS() {
        ArrayList instance = new ArrayList();
        instance.add("why??");
        instance.clear();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class ArrayList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayList instance = new ArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

        instance.add("Des");
        instance.add("Pa", 0);
        instance.add("Cit");
        instance.add("O", 2);
        expResult = false;
        result = instance.isEmpty();
        assertEquals(expResult, result);

        instance.remove();
        instance.remove(1);
        instance.remove();
        instance.remove(0);
        expResult = true;
        result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class ArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayList instance = new ArrayList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        instance.add("Alexa");
        instance.add("This", 0);
        instance.add("is");
        instance.add("Sad", 2);
        expResult = 4;
        result = instance.size();
        assertEquals(expResult, result);

        instance.remove(0);
        instance.remove();
        instance.remove(1);
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        ArrayList instance = new ArrayList();
        instance.add("despacito");
        instance.add(420);
        String res = (String) instance.ary[0];
        res += (int) instance.ary[1];
        assertEquals(res, "despacito420");
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd_GenericType_int() {
        System.out.println("add");
        ArrayList instance = new ArrayList();
        instance.add("Pa", 0);
        instance.add("To", 1);
        instance.add("Des", 0);
        instance.add("Ci", 2);
        String res = "";
        for (int i = 0; i < instance.size(); i++) {
            res += (String) instance.ary[i];
        }
        assertEquals(res, "DesPaCiTo");
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove_0args() {
        System.out.println("remove");
        ArrayList instance = new ArrayList();
        for (int i = 0; i < 10; i++) {
            instance.add("despacito2".charAt(i));
        }
        assertEquals('2', (char) instance.remove());
        assertEquals('o', (char) instance.remove());
        assertEquals('t', (char) instance.remove());
        assertEquals('i', (char) instance.remove());
        assertEquals('c', (char) instance.remove());

        String res = "";
        for (int i = 0; i < instance.size(); i++) {
            res += (char) instance.ary[i];
        }
        assertEquals("despa", res);
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        ArrayList instance = new ArrayList();
        for (int i = 0; i < 10; i++) {
            instance.add("luis fonsi".charAt(i));
        }

        assertEquals('l', (char) instance.remove(0));
        assertEquals('s', (char) instance.remove(2));
        assertEquals('i', (char) instance.remove(7));
        assertEquals('o', (char) instance.remove(4));
        assertEquals('u', (char) instance.remove(0));
        // TODO review the generated test code and remove the default call to fail.
        String res = "";
        for (int i = 0; i < instance.size(); i++) {
            res += (char) instance.ary[i];
        }
        assertEquals("i fns", res);
    }

    /**
     * Test of get method, of class ArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        ArrayList instance = new ArrayList();
        instance.add("Daddy");
        instance.add("Yankee");
        instance.add(1738.1337);
        assertEquals("Daddy", (String) instance.get(0));
        assertEquals("Yankee", (String) instance.get(1));
        assertEquals((double) 1738.1337, (double) instance.get(2), 0.01);
    }

    /**
     * Test of clear method, of class ArrayList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ArrayList instance = new ArrayList();
        for (int i = 0; i < 1e6; i++) {
            instance.add(i+"");
        }
        instance.add(true);

        assertEquals(false, instance.size() == 0);
        assertEquals(false, instance.ary[0] == null);

        instance.clear();

        assertEquals(true, instance.size() == 0);
        assertEquals(true, instance.ary[0] == null);
        assertTrue(instance.ary.length == 10);
    }

    /**
     * Test of iterator method, of class ArrayList.
     */
    /*
    @org.junit.Test
    public void testIterator() {
        System.out.println("iterator");
        ArrayList instance = new ArrayList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class ArrayList.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ArrayList.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
