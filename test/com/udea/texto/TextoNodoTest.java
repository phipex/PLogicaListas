/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udea.texto;

import java.util.AbstractMap;
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

    

    
    
}
