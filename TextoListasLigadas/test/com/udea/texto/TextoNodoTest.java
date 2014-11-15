/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udea.texto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sony vaio
 */
public class TextoNodoTest {
    
    public TextoNodoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConteoPreposisiones method, of class TextoNodo.
     */
    @Test
    public void testGetConteoPreposisiones() {
        System.out.println("getConteoPreposisiones");
        TextoNodo instance = new TextoNodo("ante pepe ante pepe");
        Map<String, Integer> expResult = new HashMap<String, Integer>();
        expResult.put("ante",2);
        Map<String, Integer> result = instance.getConteoPreposisiones();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTexto4Map method, of class TextoNodo.
     */
    @Test
    public void testGetTexto4Map() {
        System.out.println("getTexto4Map");
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        mapa.put("pepe",1);
        mapa.put("pepo",1);
        TextoNodo expResult = new TextoNodo("pepe pepo");
        TextoNodo result = TextoNodo.getTexto4Map(mapa);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getConteoTildadas method, of class TextoNodo.
     */
    @Test
    public void testGetConteoTildadas() {
        System.out.println("getConteoTildadas");
        TextoNodo instance = new TextoNodo("Andrés");
        Map<String, Integer> expResult = new HashMap<String, Integer>();
        expResult.put("Andrés", 1);
        Map<String, Integer> result = instance.getConteoTildadas();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of tieneTildes method, of class TextoNodo.
     */
    @Test
    public void testTieneTildes() {
        System.out.println("tieneTildes");
        String palabra = "";
        boolean expResult = false;
        boolean result = TextoNodo.tieneTildes(palabra);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testTieneTildes2() {
        System.out.println("tieneTildes");
        String palabra = "ándres";
        boolean expResult = true;
        boolean result = TextoNodo.tieneTildes(palabra);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testTieneTildes3() {
        System.out.println("tieneTildes");
        String palabra = "Ándres";
        boolean expResult = true;
        boolean result = TextoNodo.tieneTildes(palabra);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of eliminaPalabra method, of class TextoNodo.
     */
    @Test
    public void testEliminaPalabra() {
        System.out.println("eliminaPalabra");
        String palabra = "palabra";
        TextoNodo instance = new TextoNodo("esto chao palabra varias veces");
        instance.eliminaPalabra(palabra);
        String expResult = "esto palabra varias veces ";
        System.out.println("expResult:-"+expResult+"- resulto:-"+instance.toString()+"-");
        assertEquals(instance.toString(), expResult);
        
    }

    /**
     * Test of textoInverso method, of class TextoNodo.
     */
    @Test
    public void testTextoInverso() {
        System.out.println("textoInverso");
        TextoNodo instance = new TextoNodo("uno dos tres");
        String expResult = "tres dos uno ";
        String result = instance.stextoInverso();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of reemplaza method, of class TextoNodo.
     */
    @Test
    public void testReemplaza() {
        System.out.println("reemplaza");
        String palabra = "padabra";
        String reemplaza = "palabra";
        TextoNodo instance = new TextoNodo("esta padabra que padabra fue reemplzada");
        instance.reemplaza(palabra, reemplaza);
       
    }

    
    /**
     * Test of getConteoPalabras method, of class TextoNodo.
     */
    @Test
    public void testGetConteoPalabras() {
        System.out.println("getConteoPalabras");
        TextoNodo instance = new TextoNodo();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getConteoPalabras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConteoPreposisiones method, of class TextoNodo.
     */
    @Test
    public void testGetConteoPreposisiones0() {
        System.out.println("getConteoPreposisiones");
        TextoNodo instance = new TextoNodo();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getConteoPreposisiones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of textoPreposiciones method, of class TextoNodo.
     */
    @Test
    public void testTextoPreposiciones() {
        System.out.println("textoPreposiciones");
        TextoNodo instance = new TextoNodo();
        TextoNodo expResult = null;
        TextoNodo result = instance.textoPreposiciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTexto4Map method, of class TextoNodo.
     */
    @Test
    public void testGetTexto4Map0() {
        System.out.println("getTexto4Map");
        Map<String, Integer> mapa = null;
        TextoNodo expResult = null;
        TextoNodo result = TextoNodo.getTexto4Map(mapa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConteoTildadas method, of class TextoNodo.
     */
    @Test
    public void testGetConteoTildadas0() {
        System.out.println("getConteoTildadas");
        TextoNodo instance = new TextoNodo();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getConteoTildadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of textoTildado method, of class TextoNodo.
     */
    @Test
    public void testTextoTildado0() {
        System.out.println("textoTildado");
        TextoNodo instance = new TextoNodo();
        TextoNodo expResult = null;
        TextoNodo result = instance.textoTildado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaPalabra method, of class TextoNodo.
     */
    @Test
    public void testEliminaPalabra0() {
        System.out.println("eliminaPalabra");
        String palabra = "";
        TextoNodo instance = new TextoNodo();
        instance.eliminaPalabra(palabra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sinPalabra method, of class TextoNodo.
     */
    @Test
    public void testSinPalabra0() {
        System.out.println("sinPalabra");
        String palabra = "";
        TextoNodo instance = new TextoNodo();
        TextoNodo expResult = null;
        TextoNodo result = instance.sinPalabra(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stextoInverso method, of class TextoNodo.
     */
    @Test
    public void testStextoInverso0() {
        System.out.println("stextoInverso");
        TextoNodo instance = new TextoNodo();
        String expResult = "";
        String result = instance.stextoInverso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ltextoInverso method, of class TextoNodo.
     */
    @Test
    public void testLtextoInverso0() {
        System.out.println("ltextoInverso");
        TextoNodo instance = new TextoNodo();
        List<String> expResult = null;
        List<String> result = instance.ltextoInverso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of textoInverso method, of class TextoNodo.
     */
    @Test
    public void testTextoInverso0() {
        System.out.println("textoInverso");
        TextoNodo instance = new TextoNodo();
        TextoNodo expResult = null;
        TextoNodo result = instance.textoInverso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stextoAlfabetico method, of class TextoNodo.
     */
    @Test
    public void testStextoAlfabetico0() {
        System.out.println("stextoAlfabetico");
        TextoNodo instance = new TextoNodo();
        String expResult = "";
        String result = instance.stextoAlfabetico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ltextoAlfabetico method, of class TextoNodo.
     */
    @Test
    public void testLtextoAlfabetico0() {
        System.out.println("ltextoAlfabetico");
        TextoNodo instance = new TextoNodo();
        List<String> expResult = null;
        List<String> result = instance.ltextoAlfabetico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of textoAlfabetico method, of class TextoNodo.
     */
    @Test
    public void testTextoAlfabetico0() {
        System.out.println("textoAlfabetico");
        TextoNodo instance = new TextoNodo();
        TextoNodo expResult = null;
        TextoNodo result = instance.textoAlfabetico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reemplaza method, of class TextoNodo.
     */
    @Test
    public void testReemplaza0() {
        System.out.println("reemplaza");
        String palabra = "";
        String reemplaza = "";
        TextoNodo instance = new TextoNodo();
        instance.reemplaza(palabra, reemplaza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conReemplazo method, of class TextoNodo.
     */
    @Test
    public void testConReemplazo0() {
        System.out.println("conReemplazo");
        String palabra = "";
        String reemplaza = "";
        TextoNodo instance = new TextoNodo();
        TextoNodo expResult = null;
        TextoNodo result = instance.conReemplazo(palabra, reemplaza);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyIterator method, of class TextoNodo.
     */
    @Test
    public void testCopyIterator0() {
        System.out.println("copyIterator");
        List expResult = null;
        List result = TextoNodo.copyIterator(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tieneTildes method, of class TextoNodo.
     */
    @Test
    public void testTieneTildes0() {
        System.out.println("tieneTildes");
        String palabra = "";
        boolean expResult = false;
        boolean result = TextoNodo.tieneTildes(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TextoNodo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        TextoNodo instance = new TextoNodo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TextoNodo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TextoNodo instance = new TextoNodo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
