/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plistas;

import com.udea.listaligada.doble.DLNode;
import com.udea.listaligada.doble.ExcepcionListaVacia;
import com.udea.listaligada.doble.ListaCircularDLGeneric;
import java.util.Iterator;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Felipe
 */
public class ListaCircularDLGeneric1Test {
    
    public ListaCircularDLGeneric1Test() {
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
     * Test of tamanyo method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testTamanyo() {
        System.out.println("tamanyo");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        int expResult = 0;
        int result = instance.tamanyo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of tamanyo method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testTamanyo2() {
        System.out.println("tamanyo2");
        ListaCircularDLGeneric instance = crearListaString("to");
        int expResult = 2;
        int result = instance.tamanyo();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of insertarInicio method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertarInicio() {
        System.out.println("insertarInicio");
        Object elementoAInsertar = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.insertarInicio(elementoAInsertar);
        assertEquals(expResult, result);
        
    }

    //TODO crear prueba insertar inicio
    
    /**
     * Test of insertarFinal method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertarFinal() {
        System.out.println("insertarFinal");
        Object elementoAInsertar = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.insertarFinal(elementoAInsertar);
        assertEquals(expResult, result);
        
    }

    //TODO crear prueba insertar final
    
    /**
     * Test of insertar method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode param = null;
        DLNode result = instance.insertar(param,null);
        assertEquals(expResult, result);
        
    }

    //crear pruebas insertar
    
    /**
     * Test of contieneNodo method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testContieneNodo_DLNode() {
        System.out.println("contieneNodo");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        boolean expResult = false;
        boolean result = instance.contieneNodo(null);
        assertEquals(expResult, result);
       
    }

     
    
    /**
     * Test of contieneNodo method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testContieneNodo_DLNode_DLNode() {
        System.out.println("contieneNodo");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        boolean expResult = false;
        boolean result = instance.contieneNodo(null);
        assertEquals(expResult, result);
        
    }

    
    
    /**
     * Test of contienDato method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testContienDato_GenericType() {
        System.out.println("contienDato");
        Object dato = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.contienDato(dato);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of contienDato method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testContienDato_GenericType_DLNode() {
        System.out.println("contienDato");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.contienDato(null);
        assertEquals(expResult, result);
        
    }

    
    
    
    /**
     * Test of obtienePosicion method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testObtienePosicion() {
        System.out.println("obtienePosicion");
        Object data = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        int expResult = -1;
        int result = instance.obtienePosicion(data);
        assertEquals(expResult, result);
        
    }

      /**
     * Test of obtienePosicion method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testObtienePosicion2() {
        System.out.println("obtienePosicion");
        Object data = null;
         ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        int expResult = -1;
        int result = instance.obtienePosicion(' ');
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     /**
     * Test of obtienePosicion method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testObtienePosicion3() {
        System.out.println("obtienePosicion");
        Object data = null;
         ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        int expResult = 4;
        int result = instance.obtienePosicion('i');
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of insertaPosicion method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertaPosicion() {
        System.out.println("insertaPosicion");
        Object data = null;
        int posicion = 0;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        boolean expResult = false;
        boolean result = instance.insertaPosicion(data, posicion);
        assertEquals(expResult, result);
        
    }

    

    
    /**
     * Test of reemplazaPosicio method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testReemplazaPosicio() {
        System.out.println("reemplazaPosicio");
        Object data = null;
        int posicion = 0;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.reemplazaPosicio(data, posicion);
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of reemplazaPosicio method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testReemplazaPosicio2() {
        System.out.println("reemplazaPosicio");
        String data = "aollito";
        int posicion = 0;
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
       
        DLNode result = instance.reemplazaPosicio('a', posicion);
//        assertNotNull(result);
        System.out.println(">>>>"+instance.toString(false));
        assertEquals(instance.toString(false),data);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of remover method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testRemover_0args() throws ClassNotFoundException {
        System.out.println("remover");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        Object expResult = null;
        Object result = null;
        try {
            result = instance.remover();
            
        } catch (Exception e) {
            
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of remover method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testRemover_0args2() {
        System.out.println("remover2");
        try {
            ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
            Object expResult = null;
            Object result = instance.remover();
            assertEquals(expResult, result);
        } catch (ExcepcionListaVacia excepcionListaVacia) {
            
        }
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of remover method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testRemover_DLNode() {
        System.out.println("remover");
        DLNode nodoARemover = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        try {
            instance.remover(nodoARemover);
        } catch (ExcepcionListaVacia excepcionListaVacia) {
        }
        
    }

    /**
     * Test of remover method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testRemover_DLNode2() {
        try {
            System.out.println("remover");
            DLNode nodoARemover = null;
            ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
            instance.remover(nodoARemover);
            // review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (ExcepcionListaVacia excepcionListaVacia) {
             
        }
    }

    
    /**
     * Test of ingresaLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIngresaLista() {
        System.out.println("ingresaLista");
        ListaCircularDLGeneric lista = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        boolean expResult = false;
        boolean result = instance.ingresaLista(lista);
        assertEquals(expResult, result);
        
    }

   
    
    /**
     * Test of ingresaLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIngresaLista2() {
        System.out.println("ingresaLista");
        ListaCircularDLGeneric lista = null;
         ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        boolean expResult = false;
        boolean result = instance.ingresaLista(lista);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     
     /**
     * Test of ingresaLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIngresaLista3() {
        System.out.println("ingresaLista");
        ListaCircularDLGeneric lista = crearListaString("pollito");
         ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        boolean expResult = true;
        boolean result = instance.ingresaLista(lista);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
    
   
     
    
    /**
     * Test of reemplazaLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testReemplazaLista() {
        System.out.println("reemplazaLista");
        ListaCircularDLGeneric lista = null;
        int posicion = 0;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        boolean expResult = false;
        boolean result = instance.reemplazaLista(lista, posicion);
        assertEquals(expResult, result);
       
    }

   
     /**
     * Test of reemplazaLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testReemplazaLista1() {
        System.out.println("reemplazaLista1");
        ListaCircularDLGeneric<Character> lista = crearListaString("otota");
        int posicion = 1;
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        String expResult = "pototao";
        instance.reemplazaLista(lista, posicion);
        String result = instance.toString(false);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
    /**
     * Test of encontrasLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEncontrasLista_ListaCircularDLGeneric1() {
        System.out.println("encontrasLista");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        int expResult = -1;
        int result = instance.encontrasLista(null);
        assertEquals(expResult, result);
        
    }

     /**
     * Test of encontrasLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEncontrasLista2_ListaCircularDLGeneric1() {
        System.out.println("encontrasLista2");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        ListaCircularDLGeneric<Character> parametro = crearListaString("ito");
        int expResult = 4;
        int result = instance.encontrasLista(parametro);
        assertEquals(expResult, result);
        
    }
    
     /**
     * Test of encontrasLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEncontrasLista3_ListaCircularDLGeneric1() {
        System.out.println("encontrasLista2");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        ListaCircularDLGeneric<Character> parametro = crearListaString("pol");
        int expResult = 0;
        int result = instance.encontrasLista(parametro);
        assertEquals(expResult, result);
        
    }
    
     /**
     * Test of encontrasLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEncontrasLista4_ListaCircularDLGeneric1() {
        System.out.println("encontrasLista2");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        ListaCircularDLGeneric<Character> parametro = crearListaString("lli");
        int expResult = 2;
        int result = instance.encontrasLista(parametro);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of encontrasLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEncontrasLista_ListaCircularDLGeneric1_int() {
        System.out.println("encontrasLista");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        int expResult = -1;
        int result = instance.encontrasLista(null,0);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of encontrasLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEncontrasLista_ListaCircularDLGeneric1_int2() {
        System.out.println("encontrasLista2");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        ListaCircularDLGeneric<Character> parametro = crearListaString("lli");
        int expResult = -1;
        int result = instance.encontrasLista(parametro,4);
        assertEquals(expResult, result);
        
    }
    
    

    /**
     * Test of getElemento method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testGetElemento() {
        System.out.println("getElemento");
        int posicion = 0;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.getElemento(posicion);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getElemento method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testGetElemento1() {
        System.out.println("getElemento");
        int posicion = -1;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.getElemento(posicion);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of getElemento method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testGetElemento2() {
        System.out.println("getElemento2");
        int posicion = 4;
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        Character expResult = 'i';
        Character result = instance.getElemento(posicion).getDato();
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    /**
     * Test of estaVacio method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testEstaVacio() {
        System.out.println("estaVacio");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        boolean expResult = true;
        boolean result = instance.estaVacio();
        assertEquals(expResult, result);
       
    }

    
    
    /**
     * Test of imprimir method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testImprimir() {
        System.out.println("imprimir");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        instance.imprimir();
        
    }

   
    /**
     * Test of toString method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testToString_boolean() {
        System.out.println("toString");
        boolean completo = false;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        String expResult = "";
        String result = instance.toString(completo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of iterator method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIterator_0args() {
        System.out.println("iterator");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        ListIterator expResult = null;
        ListIterator result = instance.iterator();
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of iterator method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIterator_DLNode() {
        System.out.println("iterator");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        ListIterator expResult = null;
        ListIterator result = instance.iterator(null);
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of iterator method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIterator_DLNode2() {
        System.out.println("iterator2");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        String expResult = "pollito";
        ListIterator result = instance.iterator(instance.getElemento(0));
        String resultString = iterator2String(result);
        System.out.println(resultString);
        assertEquals(expResult, resultString);
        // review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIterator_DLNode3() {
        System.out.println("iterator3");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        String expResult = "llitopo";
        ListIterator result = instance.iterator(instance.getElemento(2));
        String resultString = iterator2String(result);
        System.out.println(resultString);
        assertEquals(expResult, resultString);
        // review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
    /**
     * Test of main method, of class ListaCircularDLGeneric.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        ListaCircularDLGeneric.main(args);
//        
//    }
//
//    /**
//     * Test of crearListaString method, of class ListaCircularDLGeneric.
//     */
//    @Test
//    public void testCrearListaString() {
//        System.out.println("crearListaString");
//        String texto = "";
//        ListaCircularDLGeneric<Character> expResult = null;
//        ListaCircularDLGeneric<Character> result = ListaCircularDLGeneric.crearListaString(texto);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of main3 method, of class ListaCircularDLGeneric.
//     */
//    @Test
//    public void testMain3() {
//        System.out.println("main3");
//        String[] args = null;
//        ListaCircularDLGeneric.main3(args);
//        
//    }
//
//    /**
//     * Test of main2 method, of class ListaCircularDLGeneric.
//     */
//    @Test
//    public void testMain2() {
//        System.out.println("main2");
//        String[] args = null;
//        ListaCircularDLGeneric.main2(args);
//        
//    }
//    
    
    /**
     * Test of insertar method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertar_GenericType() {
        System.out.println("insertar");
        Object elementoAInsertar = null;
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.insertarInicio(elementoAInsertar);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertarFinal_DLNode_GenericType() {
        System.out.println("insertar");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.insertarFinal(null);
        assertEquals(expResult, result);
        //review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
     /**
     * Test of insertar method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testInsertarInicio_DLNode_GenericType() {
        System.out.println("insertar");
        ListaCircularDLGeneric instance = new ListaCircularDLGeneric();
        DLNode expResult = null;
        DLNode result = instance.insertarInicio(null);
        assertEquals(expResult, result);
        //review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
   

    

    /**
     * Test of contienDato method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testContienDato() {
        System.out.println("contienDato");
        ListaCircularDLGeneric<Integer> instance = new ListaCircularDLGeneric<>();
        DLNode<Integer> expResult = null;
        DLNode<Integer> result = instance.contienDato(null,null);
        assertEquals(expResult, result);
        //review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     /**
     * Test of contienDato method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testContienDato2() {
        System.out.println("contienDato");
        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
       
        DLNode<Character> result = instance.contienDato('i');
        assertNotNull(result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        
     /**
     * Test of ingresaLista method, of class ListaCircularDLGeneric.
     */
    @Test
    public void testIngresaLista4() {
        System.out.println("ingresaLista4");
        ListaCircularDLGeneric lista = crearListaString("pollito");
         ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
        String expResult = "pollitopollito";
        instance.ingresaLista(lista);
        String result = instance.toString(false);
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
   

   
    
   public static ListaCircularDLGeneric<Character> crearListaString(String texto){
       ListaCircularDLGeneric<Character> lista = new ListaCircularDLGeneric<Character>("texto");
        
        
        
        char[] array = texto.toCharArray();
        
        for (char c : array) {
            lista.insertarFinal(c);
        }
        
        return lista;
        
   }
    
   public static String iterator2String(ListIterator iterator){
       
       StringBuilder sb = new StringBuilder();
       
       for (Iterator it = iterator; it.hasNext();) {
           Object object = it.next();
           sb.append(object);
       }
       
       
       return sb.toString();
   }
      
    
}
