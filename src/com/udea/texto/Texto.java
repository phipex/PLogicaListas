/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.texto;

import com.udea.listaligada.doble.SLNode;
import java.util.Iterator;
import com.udea.listaligada.doble.ListaCircularSLRCGeneric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Clase que representa un texto, dicho texto ha sido guardo como una lista
 * doblemente ligada circular,
 * @author Andres Felipe Montoya
 */
public class Texto {
    
    /**
     * Lista Doblemente Ligada Circular que contiene el texto de la instancia 
     */
    private ListaCircularSLRCGeneric<Character> texto;

    /**
     * Campo de la instancia que contiene el nombre del texto
     */
    private String nombre;

    /**
     * Contructor de la clase, recibe como parametros el nombre del texto y 
     * y el texto que va a representar
     * @param nombre nombre que representa a la lista
     * @param texto texto que sera representado
     */
    public Texto(String nombre, String texto) {

        this.nombre = nombre;

        this.texto = new ListaCircularSLRCGeneric<Character>(nombre);

        char[] array = texto.toCharArray();

        for (char c : array) {
            System.out.println(c);
            //this.texto.insertarPrincipio(c);
            this.texto.insertarFinal(c);
        }

        //this.texto.imprimir();
    }

    public Texto(String texto){
        this("Texto",texto);
    }
    
    /**
     * Imprime por consola el texto representado por la instancia
     */
    public synchronized void imprimir() {
        System.out.println("Nombre: " + this.nombre);
        int i = 0;

        for (Iterator it = this.texto.iterator(); it.hasNext();) {
            Character object = (char) it.next();
            System.out.println(i + ":" + object);
            i++;
        }

    }

    
    /**
     * @deprecated por que usaria mucho getelemento
     * @param desde posicion desde que busca
     * @return Palabra encontrada
     */
    public synchronized String getPalabraDesde(int desde) {

        String res = null;

        StringBuilder buider = new StringBuilder();

        boolean encontrado = false;

        for (Iterator it = this.texto.iterator(this.texto.getElemento(desde)); it.hasNext();) {
            Character object = (char) it.next();
            System.out.println("object:" + object + " encontrado" + encontrado);
            if (Character.isSpaceChar(object)) {
                if (encontrado) {
                    break;
                }
            } else {
                buider.append(object);
                if (!encontrado) {
                    encontrado = true;
                }
            }

        }

        if (encontrado) {
            res = buider.toString();
        }

        return res;
    }

    /**
     * Retorna una lista donde cada una de sus entradas corresponden a una linea
     * formada por las palabras en el texto con un maximo de caracteres por linea
     * segun el parametro de entrada, sin partir ninguna palabra
     * @param largoLinea numero maximo de caracteres por linea
     * @return objeto que implementa la interface java.util.List
     * @see java.util.List
     */
    public synchronized List<String> mostrarTexto(int largoLinea) {

        List<String> res = new ArrayList<String>();

        StringBuilder palabra = new StringBuilder();

        StringBuilder linea = new StringBuilder();

        for (Iterator it = this.texto.iterator(this.texto.getElemento(0)); it.hasNext();) {
            Character object = (char) it.next();
            //System.out.println("object:" + object + " encontrado" + encontrado);
            if (Character.isSpaceChar(object)) {
                if ((linea.length() + palabra.length()) > largoLinea) {
                    res.add(linea.toString());
                    linea = new StringBuilder();
                }
                linea.append(palabra + " ");
                palabra = new StringBuilder();
            } else {
                palabra.append(object);
                
            }

        }

        return res;
    }

    /**
     * Retorna un lista con par valor (interface Map) con cada una de la palabras
     * y la cantidad de veces que aparece en el texto de la instancia
     * @return objeto el cual implementa la inteface java.util.Map
     * @see java.util.List
     */
    public synchronized Map<String, Integer> conteoPalabras() {

        Map<String, Integer> conteo = new HashMap<String, Integer>();

        StringBuilder palabraBuilder = new StringBuilder();

        for (Iterator it = this.texto.iterator(); it.hasNext();) {
            Character object = (char) it.next();
            //System.out.println("object:" + object + " encontrado" + encontrado);
            if (!Character.isSpaceChar(object) ) {
                
                 palabraBuilder.append(object);
                
            }
            if (Character.isSpaceChar(object) || !it.hasNext()) {
                String palabra = palabraBuilder.toString().toLowerCase();
                
                if (conteo.containsKey( palabra )) {
                    int count = conteo.get( palabra );
                    conteo.put( palabra, count + 1);
                } else {
                    conteo.put( palabra,1 );
                }
                
                palabraBuilder = new StringBuilder();
            }
        }

        return conteo;
    }

    /**
     * Retorna un lista con par valor (interface Map) con cada una de la palabras
     * que contenga cada una de la vocales y la cantidad de veces que aparece
     * en el texto de la instancia
     * @return objeto el cual implementa la inteface java.util.Map
     * @see java.util.List
     */
     public synchronized Map<String, Integer> conteoPalabrasVocal() {

        Map<String, Integer> conteo = new HashMap<String, Integer>();

        StringBuilder palabraBuilder = new StringBuilder();

        int a=0,e=1,i=2,o=3,u=4;
        
        int[] voc = { 0,0,0,0,0 }; 
        
        for (Iterator it = this.texto.iterator(); it.hasNext();) {
            Character object = (char) it.next();
            //System.out.println("object:" + object + " encontrado" + encontrado);
            if (!Character.isSpaceChar(object) ) {
                
                 palabraBuilder.append(object);
                 switch(Character.toLowerCase(object)){
                     case 'a': {
                            voc[a]++;
                            break;
                        } 
                     case 'e': {
                            voc[e]++;
                            break;
                        }
                     case 'i': {
                            voc[i]++;
                            break;
                        }
                     case 'o': {
                            voc[o]++;
                            break;
                        }
                     case 'u': {
                            voc[u]++;
                            break;
                        }
                                            

                 }
            }
            if (Character.isSpaceChar(object) || !it.hasNext()) {
                if ((voc[a]+voc[e]+voc[i]+voc[o]+voc[u]) >= 5) {
                    String palabra = palabraBuilder.toString().toLowerCase();
                    
                    if (conteo.containsKey(palabra)) {
                        int count = conteo.get(palabra);
                        conteo.put(palabra, count + 1);
                    } else {
                        conteo.put(palabra, 1);
                    }
                }
               
               
                
                voc[a]=voc[e]=voc[i]=voc[o]=voc[u]=0;
                
                palabraBuilder = new StringBuilder();
            }
        }

        return conteo;
    }
    
    /**
     * Retorna un lista con par valor (interface Map) con cada una de la letras
     * y la cantidad de veces que aparece en el texto de la instancia
     * @return objeto el cual implementa la inteface java.util.Map
     * @see java.util.List
     */ 
    public synchronized Map<Character, Integer> conteoLetras() {

        Map<Character, Integer> conteo = new HashMap<Character, Integer>();

        StringBuilder palabraBuilder = new StringBuilder();

        for (Iterator it = this.texto.iterator(); it.hasNext();) {
            Character object = (char) it.next();
            //System.out.println("object:" + object + " encontrado" + encontrado);
            if (conteo.containsKey( object )) {
                    int count = conteo.get( object );
                    conteo.put( object, count + 1);
                } else {
                    conteo.put( object,1 );
                }
        }

        return conteo;
    }
    
   
    /**
     * Retorna verdadero si el texto de la instancia contiene el texto de la
     * instancia o falso en caso contrario
     * @param texto texto a buscar
     * @return verdadero si el texto de la instancia contiene el texto de la
     * instancia o falso en caso contrario
     */
    public synchronized boolean contiene(Texto texto) {
        boolean res = false;

        int posicion = this.texto.encontrasLista(texto.getTexto());

        if (posicion > -1) {
            res = true;
        }

        return res;

    }

    /**
     * Busca una cadena de texto y retorna la posicion donde se encuentra
     * 
     * @param texto texto a buscar
     * @return posicion donde se encuentra
     */
    public synchronized int buscar(Texto texto){
       
       
       int res = this.texto.encontrasLista(texto.getTexto());
       
       return res;
   }
    
    
    /**
     * Retorna el numero de veces que el texto ingresado como parametro se encuentra
     * en el texto de la instancia
     * @param texto texto a buscar
     * @return numero de veces que el texto ingresado como parametro se encuentra
     * en el texto de la instancia
     */
    public synchronized int cuantasVecesContiene(Texto texto) {

        int res = 0;

        int index = 0;

        while (index < getCaracteres()) {

            int posicion = this.texto.encontrasLista(texto.getTexto(), index);

            if (posicion != -1) {
                res++;
                index = posicion + texto.getCaracteres();
            } else {
                break;
            }

        }

        return res;
    }

    // busca empieza
    /**
     * Retorna verdadero si el texto ingresado corresponde al principio del texto
     * de la instancia
     * @param texto texto a buscar
     * @return verdadero si el texto ingresado corresponde al principio del texto
     * de la instancia
     */
    public synchronized boolean empiezaCon(Texto texto) {

        boolean res = false;

        int posicion = this.texto.encontrasLista(texto.getTexto());

        if (posicion == 0) {
            res = true;
        }

        return res;
    }

    /**
     *  Elimina una cadena de texto, tantas veces como aparezca
     * @param texto texto a eliminar
     * @return verdadero si logro borrar algun dato
     */
    public synchronized boolean elimina(Texto texto){
        boolean res = false;
        
        int index = 0;

        while (index < getCaracteres()) {

            int posicion = this.texto.encontrasLista(texto.getTexto(), index);

            if (posicion != -1) {
                
                
                this.texto.remover(posicion, posicion + texto.getCaracteres());
                
                index = posicion;
                
                res = true;
            } else {
                break;
            }

        }
        
        return res;
    }
    
    /**
     *  Elimina una cadena de texto, tantas veces como aparezca
     * @param texto texto a eliminar
     * @return verdadero si logro borrar algun dato
     */
    public synchronized boolean reemplaza(Texto texto){
        boolean res = false;
        
        int index = 0;

        while (index < getCaracteres()) {

            int posicion = this.texto.encontrasLista(texto.getTexto(), index);

            if (posicion != -1) {
                
                
                this.texto.remover(posicion, posicion + texto.getCaracteres());
                
                SLNode<Character> actual = this.texto.getElemento(posicion-1);
                
                for (Iterator it = texto.getTexto().iterator(); it.hasNext();) {
                     Character object = (Character)it.next();
                    
                    actual = texto.getTexto().insertar(actual, object);
                    
                }
                
                index = posicion;
                
                res = true;
            } else {
                break;
            }

        }
        
        return res;
    }
    
//   /**
//    * retorna verdadero si la string contiene todas la vocales
//    * @param palabra
//    * @return 
//    * @deprecated 
//    */ 
//   public static synchronized boolean contieneVocales(String palabra){
//      
//       
//       boolean a = palabra.contains("a") || palabra.contains("A") ;
//       boolean e = palabra.contains("e") || palabra.contains("E") ;
//       boolean i = palabra.contains("i") || palabra.contains("I") ;
//       boolean o = palabra.contains("o") || palabra.contains("O") ;
//       boolean u = palabra.contains("u") || palabra.contains("U") ;
//       
//       
//       
//       return a && e && i && o && u;
//   }
//    
   
    public boolean ingresarSubHilera(Texto subhilera,int posicion){
        boolean res = false;
        
        SLNode<Character> actual = texto.getElemento(posicion);
        if (posicion > -1 && posicion < getCaracteres()) {
            for (Iterator it = subhilera.getTexto().iterator(); it.hasNext();) {
                
                    Character object = (Character)it.next();
                    
                    actual = texto.insertar(actual, object);
            }
        }
        
        return res;
    }
    
    /**
     * retorna la lista doblemente ligada circular que represena al texto
     * @return lista doblemente ligada circular que represena al texto
     */
    public ListaCircularSLRCGeneric<Character> getTexto() {
        return texto;
    }

    /**
     * retorna el texto 
     * @return 
     */
    @Override
    public String toString() {
        return texto.toString(false);
    }

    
    /**
     * Retorna verdadero si el texto ingresado como parametro corresponde 
     * exactamente al final del texto de la instancia
     * @param texto texto a buscar
     * @return verdadero si el texto ingresado como parametro corresponde 
     * exactamente al final del texto de la instancia
     * 
     */
    public synchronized boolean terminaCon(Texto texto) {

        boolean res = false;

        int posicion = this.texto.encontrasLista(texto.getTexto());

        System.out.println("positcion " + posicion);

        if (posicion == (getCaracteres() - texto.getCaracteres())) {
            res = true;
        }

        return res;
    }
    
    /**
     * Retorna el numero de veces que una palabara termina con el texto ingresado
     * @param texto texto a buscar
     * @return numero de veces que una palabara contien el texto ingresado
     */
    public synchronized int palabrasTerminaCon(Texto texto){
        int res = -1;
        
        String stexto = texto.toString();
        
        Map<String, Integer> conteo = conteoPalabras();
        
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            String string = entry.getKey();
            Integer integer = entry.getValue();
            
            if(string.endsWith(stexto)){
                if (res == -1) {
                    res++;
                }
                res = res + integer;
            }
        }
        
        return res;
    }
    
    /**
     * Retorna el numero de veces que una palabara comienza con el texto ingresado
     * @param texto texto a buscar
     * @return numero de veces que una palabara contien el texto ingresado
     */
    public synchronized int palabrasComienzaCon(Texto texto){
        int res = -1;
        
        String stexto = texto.toString();
        
        Map<String, Integer> conteo = conteoPalabras();
        
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            String string = entry.getKey();
            Integer integer = entry.getValue();
            
            if(string.startsWith(stexto)){
                if (res == -1) {
                    res++;
                }
                res = res + integer;
            }
        }
        
        return res;
    }
    
    /**
     * Retorna el numero de veces que una palabara contiene el texto ingresado
     * @param texto texto a buscar
     * @return numero de veces que una palabara contien el texto ingresado
     */
    public synchronized int palabrasContieneCon(Texto texto){
        int res = -1;
        
        String stexto = texto.toString();
        
        Map<String, Integer> conteo = conteoPalabras();
        
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            String string = entry.getKey();
            Integer integer = entry.getValue();
            
            if(string.contains(stexto)){
                if (res == -1) {
                    res++;
                }
                res = res + integer;
            }
        }
        
        return res;
    }
    
    /**
     * Retorna el numero de caracteres del texto de la referencia
     * @return numero de caracteres del texto de la referencia
     */
    public synchronized int getCaracteres() {
        return texto.tamanyo();
    }

//    /**
//     *
//     * @param args
//     */
    public static void main(String args[]) {
//        String testo = "esto es un texto de pruena";
//
//        Texto texto = new Texto("prueba", testo);
//        texto.imprimir();
//
//        String fin = testo.substring(testo.length() - 4, testo.length());
//
//        System.out.println("fin: " + fin);
//
//        Texto termina = new Texto("termina", fin);
//
//        System.out.println(texto + " termina en " + termina + ";" + texto.terminaCon(termina));
//
//        String empieza = testo.substring(0, 4);
//
//        System.out.println("principio: " + empieza);
//
//        Texto comienza = new Texto("empieza", empieza);
//
//        System.out.println(texto + " comienza en " + comienza + ";" + texto.empiezaCon(comienza));
//
//        System.out.println(texto + " contiene " + comienza + ";" + texto.contiene(comienza));
//
//        System.out.println(texto + " contiene " + termina + ";" + texto.contiene(termina));
//
//        Texto notiene = new Texto("notiene", "sueño");
//
//        System.out.println(texto + " contiene " + notiene + ";" + texto.contiene(notiene));
//
//        System.out.println(texto + " cuantas veces contiene " + notiene + ";" + texto.cuantasVecesContiene(notiene));
//
//        Texto notiene2 = new Texto("notiene", "texto");
//
//        System.out.println(texto + " cuantas veces contiene " + notiene2 + ";" + texto.cuantasVecesContiene(notiene2));
//
//        Texto notiene3 = new Texto("notiene", "es");
//
//        System.out.println(texto + " cuantas veces contiene " + notiene3 + ";" + texto.cuantasVecesContiene(notiene3));
//
//        System.out.println("primera palabra: " + texto.getPalabraDesde(0));
//
//        System.out.println("Lista:");
//
//        List<String> lista = texto.mostrarTexto(7);
//
//        for (String string : lista) {
//            System.out.println(string);
//        }
//
//        String testocont = "esto es un texto de pruena es texto";
//
//        Texto paraconteo = new Texto("prueba", testocont);
//        
//        Map<String, Integer> map = paraconteo.conteoPalabras();
//        
//        Set< String > keys = map.keySet();
//        
//        for (String string : keys) {
//            System.out.println(string + ": " + map.get( string ));
//        }
//        
//         Map<Character, Integer> mapletras = paraconteo.conteoLetras();
//        
//        Set< Character > keysl = mapletras.keySet();
//        
//        for (Character character : keysl) {
//            System.out.println(character + ": " + mapletras.get( character ));
//        }
//        
//        System.out.println("conteo vocal");
//        
         String testovoc = "esto es unaeiou texto de aeiou pruenaoiyuae es texto aeiou";

        Texto paraconteovoc = new Texto("prueba", testovoc);
//        
//        Map<String, Integer> mapvoc = paraconteovoc.conteoPalabrasVocal();
//        
//        Set< String > keysvoc = mapvoc.keySet();
//        
//        for (String string : keysvoc) {
//            System.out.println(string + ": " + mapvoc.get( string ));
//        }
//        
//        System.out.println("encontrado "+paraconteovoc.buscar(notiene2));
//        
//        paraconteovoc.elimina(notiene2);
//        
//        System.out.println("eliminado"+paraconteovoc);
        
        paraconteovoc.ingresarSubHilera(new Texto(" no "), 4);
        
        System.out.println("ingresar "+paraconteovoc.toString());
        
        System.out.println("cuantos terminan "+paraconteovoc.palabrasTerminaCon(new Texto("xto")));
        
        System.out.println("cuantos contiene "+paraconteovoc.palabrasContieneCon(new Texto("tex")));
        
        System.out.println("cuantos empieza "+paraconteovoc.palabrasComienzaCon(new Texto("tex")));
    }

}
