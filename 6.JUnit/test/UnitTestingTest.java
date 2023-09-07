/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import  static org.junit.Assert.*;


/**
 *
 * 
 */
public class JUnitTest {

    static double EPSILON = .1e-10;

    /**
     * Test of bus method, of class JUnit.
     */
    @Test
    public void testBus() {
        System.out.println("bus");
        JUnit instance = new JUnit();
        int expResult = 0;
        int result = instance.numBuses(0);
        assertEquals(expResult, result);

        expResult = 1;
        result = instance.numBuses(50);
        assertEquals(expResult, result);

        expResult = 2;
        result = instance.numBuses(51);
        assertEquals(expResult, result);

        expResult = 1;
        result = instance.numBuses(1);
        assertEquals(expResult, result);

        expResult = 1;
        result = instance.numBuses(49);
        assertEquals(expResult, result);

        expResult = 5;
        result = instance.numBuses(250);
        assertEquals(expResult, result);
    }

    /**
     * Test of stock_price_summary method, of class JUnit.
     */
    @Test
    public void testStock_price_summary() {
        System.out.println("stock_price_summary");
        Double[] ary = {0.01, 0.03, -0.02, -0.14, 0.0, 0.0, 0.10, -0.01};
        ArrayList<Double> price_changes = new ArrayList<Double>(Arrays.asList(ary));
        JUnit instance = new JUnit();
        ArrayList<Double> expResult = new ArrayList<Double>();
        expResult.add(.14);
        expResult.add(-.17);
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        //assertEquals(expResult, result);
        boolean a = Math.abs(result.get(0) - .14) < EPSILON;
        boolean b = Math.abs(result.get(1) - -.17) < EPSILON;
        assertTrue(a && b);

        ary = new Double[0];
        price_changes = new ArrayList<Double>(Arrays.asList(ary));
        expResult.set(0, 0.0);
        expResult.set(1, 0.0);
        result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);

        Double[] ary1 = {1.0};
        price_changes = new ArrayList<Double>(Arrays.asList(ary1));
        expResult.set(0, 1.0);
        expResult.set(1, 0.0);
        result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);

        Double[] ary2 = {-1.0};
        price_changes = new ArrayList<Double>(Arrays.asList(ary2));
        expResult.set(0, 0.0);
        expResult.set(1, -1.0);
        result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);

        Double[] ary3 = {0.0};
        price_changes = new ArrayList<Double>(Arrays.asList(ary3));
        expResult.set(0, 0.0);
        expResult.set(1, 0.0);
        result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);

    }

    /**
     * Test of swap method, of class JUnit.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        ArrayList L = new ArrayList();
        int k = 5;
        for (int i = 0; i < 10; i++) {
            L.add(i);
        }
        ArrayList J = new ArrayList();
        for (int i = 5; i < 10; i++) {
            J.add(i);
        }
        for (int i = 0; i < 5; i++) {
            J.add(i);
        }
        JUnit instance = new JUnit();
        instance.swap_k(L, k);
        assertArrayEquals(J.toArray(), L.toArray());

        L = new ArrayList();
        k = 2;
        for (int i = 0; i < 10; i++) {
            L.add(i);
        }
        J = new ArrayList();
        for (int i = 0; i < 10; i++) {
            J.add(i);
        }
        J.set(0, 8);
        J.set(1, 9);
        J.set(9, 1);
        J.set(8, 0);
        instance.swap_k(L, k);
        assertArrayEquals(J.toArray(), L.toArray());

        L = new ArrayList();
        k = 0;
        for (int i = 0; i < 10; i++) {
            L.add(i);
        }
        J = new ArrayList();
        for (int i = 0; i < 10; i++) {
            J.add(i);
        }
        instance.swap_k(L, k);
        assertArrayEquals(J.toArray(), L.toArray());

        L = new ArrayList();
        k = 1;
        for (int i = 0; i < 10; i++) {
            L.add(i);
        }
        J = new ArrayList();
        for (int i = 0; i < 10; i++) {
            J.add(i);
        }
        J.set(0, 9);
        J.set(9, 0);
        instance.swap_k(L, k);
        assertArrayEquals(J.toArray(), L.toArray());

    }

    // additional test cases with some redundancy form Carson
    /**
     * Test of numBuses method, of class JUnit.
     */
    @Test
    public void testNumZero() {
        System.out.println("numZero");
        int n = 0;
        JUnit instance = new JUnit();
        int expResult = 0;
        int result = instance.numBuses(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumOneUnder() {
        System.out.println("numOneUnder");
        int n = 49;
        JUnit instance = new JUnit();
        int expResult = 1;
        int result = instance.numBuses(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumMultiple() {
        System.out.println("numMultiple");
        int n = 100;
        JUnit instance = new JUnit();
        int expResult = 2;
        int result = instance.numBuses(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumOneOver() {
        System.out.println("numOneOver");
        int n = 51;
        JUnit instance = new JUnit();
        int expResult = 2;
        int result = instance.numBuses(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of stock_price_summary method, of class JUnit.
     */
    @Test
    public void testEmpty() {
        System.out.println("testEmpty");
        Double[] ary = {};
        ArrayList<Double> price_changes = new ArrayList<>(Arrays.asList(ary));
        JUnit instance = new JUnit();
        Double[] exp = {0.0, 0.0};
        ArrayList<Double> expResult = new ArrayList<>(Arrays.asList(exp));
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);
    }

    @Test
    public void testSingle1() {
        System.out.println("testSingle1");
        Double[] ary = {0.03};
        ArrayList<Double> price_changes = new ArrayList<>(Arrays.asList(ary));
        JUnit instance = new JUnit();
        Double[] exp = {0.03, 0.0};
        ArrayList<Double> expResult = new ArrayList<>(Arrays.asList(exp));
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);
    }

    @Test
    public void testSingle2() {
        System.out.println("testSingle2");
        Double[] ary = {0.0};
        ArrayList<Double> price_changes = new ArrayList<>(Arrays.asList(ary));
        JUnit instance = new JUnit();
        Double[] exp = {0.0, 0.0};
        ArrayList<Double> expResult = new ArrayList<>(Arrays.asList(exp));
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);
    }

    @Test
    public void testSingle3() {
        System.out.println("testSingle3");
        Double[] ary = {-0.05};
        ArrayList<Double> price_changes = new ArrayList<>(Arrays.asList(ary));
        JUnit instance = new JUnit();
        Double[] exp = {0.0, -0.05};
        ArrayList<Double> expResult = new ArrayList<>(Arrays.asList(exp));
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        assertEquals(expResult, result);
    }

    /**
     * Test of swap_k method, of class JUnit.
     */
    @Test
    public void testSwap_kZero() {
        System.out.println("swap_kZero");
        int[] ary = {1, 2, 3, 4, 5};
        ArrayList L = new ArrayList<>(Arrays.asList(ary));
        int k = 0;
        JUnit instance = new JUnit();
        instance.swap_k(L, k);
        int[] exp = {1, 2, 3, 4, 5};
        ArrayList expect = new ArrayList<>(Arrays.asList(ary));
        assertEquals(expect, L);
    }

    @Test
    public void testSwap_kOne() {
        System.out.println("swap_kOne");
        String[] ary = {"1", "2", "3", "4", "5"};
        ArrayList L = new ArrayList<>(Arrays.asList(ary));
        int k = 1;
        JUnit instance = new JUnit();
        instance.swap_k(L, k);
        String[] exp = {"5", "2", "3", "4", "1"};
        ArrayList expect = new ArrayList<>(Arrays.asList(exp));
        assertEquals(expect, L);
    }

    @Test
    public void testSwap_kTwo() {
        System.out.println("swap_kTwo");
        String[] ary = {"1", "2", "3", "4", "5"};
        ArrayList L = new ArrayList<>(Arrays.asList(ary));
        int k = 2;
        JUnit instance = new JUnit();
        instance.swap_k(L, k);
        System.out.println("what " + L);
        String[] exp = {"4", "5", "3", "1", "2"};
        ArrayList expect = new ArrayList<>(Arrays.asList(exp));
        assertEquals(expect, L);
    }

    // tests from Josh
    @Test
    public void testNumBuses() {
        System.out.println("numBuses");
        int n = 52;
        JUnit instance = new JUnit();
        int expResult = 2;
        int result = instance.numBuses(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of stock_price_summary method, of class JUnit.
     */
    @Test
    public void testStock_price_summary3() {
        System.out.println("stock_price_summary");
        ArrayList<Double> price_changes = new ArrayList<>();
        price_changes.add(.2);
        price_changes.add(-.1);
        price_changes.add(.4);
        price_changes.add(-.2);
        JUnit instance = new JUnit();
        // exp .6 and -.3
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        boolean a = Math.abs(result.get(0) - .6) < EPSILON;
        boolean b = Math.abs(result.get(1) - -.3) < EPSILON;
        assertTrue(a && b);
    }

    /**
     * Test of swap_k method, of class JUnit.
     */
    @Test
    public void testSwap_k() {
        System.out.println("swap_k");
        ArrayList L = new ArrayList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        L.add(5);
        L.add(6);
        int k = 2;
        JUnit instance = new JUnit();
        instance.swap_k(L, k);
        ArrayList expResult = new ArrayList<>();
        expResult.add(5);
        expResult.add(6);
        expResult.add(3);
        expResult.add(4);
        expResult.add(1);
        expResult.add(2);
        assertEquals(expResult, L);

    }

    // one from Rohan
    /**
     * Test of stock_price_summary method, of class FirstLab.
     */
    @Test
    public void testStock_price_summaryAlt() {
        System.out.println("stock_price_summary");
        ArrayList<Double> price_changes = new ArrayList<>();
        price_changes.add(.5);
        price_changes.add(.7);
        price_changes.add(.4);
        price_changes.add(-.5);
        price_changes.add(-.5);
        price_changes.add(.5);
        price_changes.add(-.9);
        JUnit instance = new JUnit();
        ArrayList<Double> result = instance.stock_price_summary(price_changes);
        boolean a = Math.abs(result.get(0) - 2.1) < EPSILON;
        boolean b = Math.abs(result.get(1) - -1.9) < EPSILON;
        assertTrue(a && b);

    }
}
