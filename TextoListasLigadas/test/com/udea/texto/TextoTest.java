/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udea.texto;

import com.udea.listaligada.simple.ListaCircularSLRCGeneric;
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
public class TextoTest {
    
    public TextoTest() {
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
     * Test of mostrarTexto method, of class Texto.
     */
    @Test
    public void testMostrarTexto() {
        System.out.println("mostrarTexto");
        int largoLinea = 0;
        Texto instance = null;
        List<String> expResult = null;
        List<String> result = instance.mostrarTexto(largoLinea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conteoPalabras method, of class Texto.
     */
    @Test
    public void testConteoPalabras() {
        System.out.println("conteoPalabras");
        Texto instance = null;
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.conteoPalabras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conteoPalabrasVocal method, of class Texto.
     */
    @Test
    public void testConteoPalabrasVocal() {
        System.out.println("conteoPalabrasVocal");
        Texto instance = null;
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.conteoPalabrasVocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conteoLetras method, of class Texto.
     */
    @Test
    public void testConteoLetras() {
        System.out.println("conteoLetras");
        Texto instance = null;
        Map<Character, Integer> expResult = null;
        Map<Character, Integer> result = instance.conteoLetras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contiene method, of class Texto.
     */
    @Test
    public void testContiene() {
        System.out.println("contiene");
        Texto texto = null;
        Texto instance = null;
        boolean expResult = false;
        boolean result = instance.contiene(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class Texto.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Texto texto = null;
        Texto instance = null;
        int expResult = 0;
        int result = instance.buscar(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cuantasVecesContiene method, of class Texto.
     */
    @Test
    public void testCuantasVecesContiene() {
        System.out.println("cuantasVecesContiene");
        Texto texto = null;
        Texto instance = null;
        int expResult = 0;
        int result = instance.cuantasVecesContiene(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of empiezaCon method, of class Texto.
     */
    @Test
    public void testEmpiezaCon() {
        System.out.println("empiezaCon");
        Texto texto = null;
        Texto instance = null;
        boolean expResult = false;
        boolean result = instance.empiezaCon(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elimina method, of class Texto.
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        Texto texto = null;
        Texto instance = null;
        boolean expResult = false;
        boolean result = instance.elimina(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reemplaza method, of class Texto.
     */
    @Test
    public void testReemplaza() {
        System.out.println("reemplaza");
        Texto texto = null;
        Texto instance = null;
        boolean expResult = false;
        boolean result = instance.reemplaza(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarSubHilera method, of class Texto.
     */
    @Test
    public void testIngresarSubHilera() {
        System.out.println("ingresarSubHilera");
        Texto subhilera = null;
        int posicion = 0;
        Texto instance = null;
        boolean expResult = false;
        boolean result = instance.ingresarSubHilera(subhilera, posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTexto method, of class Texto.
     */
    @Test
    public void testGetTexto() {
        System.out.println("getTexto");
        Texto instance = null;
        ListaCircularSLRCGeneric<Character> expResult = null;
        ListaCircularSLRCGeneric<Character> result = instance.getTexto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Texto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Texto instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminaCon method, of class Texto.
     */
    @Test
    public void testTerminaCon() {
        System.out.println("terminaCon");
        Texto texto = null;
        Texto instance = null;
        boolean expResult = false;
        boolean result = instance.terminaCon(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of palabrasTerminaCon method, of class Texto.
     */
    @Test
    public void testPalabrasTerminaCon() {
        System.out.println("palabrasTerminaCon");
        Texto texto = null;
        Texto instance = null;
        int expResult = 0;
        int result = instance.palabrasTerminaCon(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of palabrasComienzaCon method, of class Texto.
     */
    @Test
    public void testPalabrasComienzaCon() {
        System.out.println("palabrasComienzaCon");
        Texto texto = null;
        Texto instance = null;
        int expResult = 0;
        int result = instance.palabrasComienzaCon(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of palabrasContieneCon method, of class Texto.
     */
    @Test
    public void testPalabrasContieneCon() {
        System.out.println("palabrasContieneCon");
        Texto texto = null;
        Texto instance = null;
        int expResult = 0;
        int result = instance.palabrasContieneCon(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaracteres method, of class Texto.
     */
    @Test
    public void testGetCaracteres() {
        System.out.println("getCaracteres");
        Texto instance = null;
        int expResult = 0;
        int result = instance.getCaracteres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Texto.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Texto.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
