/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udea.texto;

import com.udea.listaligada.simple.ListaCircularSLRCGeneric;
import com.udea.listaligada.simple.SLNode;
import com.udea.listaligada.simple.SimpleLinkedListCircularRCIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * Representa un texto en el cual esta almacenado en un lista simplemente ligada
 * circular con registro cabeza
 * @author Andres Felipe Montoya
 */
public class TextoNodo {
    
    /**
     * Lista de preposiciones
     */
    private static final String[] PREPOS = {"a","ante","bajo","con","contra","como","de","desde","durante","en","entre","exepto","hasta","hacia","incluso","mediante","menos","para","por","salvo","segun","sin","sobre","tras"};
   
    /**
     * Lista ligada que contiene el texto
     */
    private ListaCircularSLRCGeneric listaLigada = null;

    /**
     * Contructor de la clase
     */
    public TextoNodo() {
        listaLigada = new ListaCircularSLRCGeneric();
    }

    /**
     * Constructor de la clase
     * @param texto String que contiene el texto a representar
     */
    public TextoNodo(String texto) {
        listaLigada = texto2Lista(texto);
    }
    
    /**
     * Constructor de la clase
     * @param texto Set que contiene el texto a representar
     */
    public TextoNodo(Set<String> texto) {
        listaLigada = new ListaCircularSLRCGeneric();
        
        for (String string : texto) {
            listaLigada.insertarFinal(string);
        }
        
    }
    
    /**
     * Utilidad que crea una LSLCRC a partir de un string
     * @param texto
     * @return 
     */
    private static ListaCircularSLRCGeneric texto2Lista(String texto){
    
        ListaCircularSLRCGeneric lista = null;
        
        lista = new ListaCircularSLRCGeneric<String>();
        
        String[] palabras = texto.split(" ");
        for (String string : palabras) {
            lista.insertarFinal(string);
        }
        
        
        return lista;
        
    }
    
    /**
     * Retorna un lista con par valor (interface Map) con cada una de la 
     * palabras que sean preposiciones
     * y la cantidad de veces que aparece en el texto de la instancia
     * @return objeto el cual implementa la inteface java.util.Map
     * @see java.util.List
     */
    public Map<String, Integer> getConteoPreposisiones(){
        Map<String, Integer> conteo = new HashMap<String, Integer>();
        
        List<String> prepos = Arrays.asList(PREPOS);
        
        for (Iterator it = this.listaLigada.iterator(); it.hasNext();) {
            String palabra = it.next().toString();
            
            if(prepos.contains(palabra)){
                
                if (conteo.containsKey( palabra )) {
                    int count = conteo.get( palabra );
                    conteo.put( palabra, count + 1);
                } else {
                    conteo.put( palabra,1 );
                }
                
            }
            
        }
        
        
        return conteo;
    }
    
    /**
     * Retorna un texto a partir de las llaves de un mapa con claves como string
     * @param mapa mapa que contenga llaves tipo string
     * @return objeto de la clse TextNodo
     */
    public static TextoNodo getTexto4Map(Map<String, Integer> mapa){
        
        TextoNodo res = null;
        if (mapa != null) {
            
            Set<String> keys = mapa.keySet();
            
            res = new TextoNodo(keys);
            
        }
        
        
        return res;
    }
    
    /**
     * Retorna un lista con par valor (interface Map) con cada una de la 
     * palabras que tengan tildes
     * y la cantidad de veces que aparece en el texto de la instancia
     * @return objeto el cual implementa la inteface java.util.Map
     * @see java.util.List 
     */
    public Map<String, Integer> getConteoTildadas(){
        Map<String, Integer> conteo = new HashMap<String, Integer>();
        
        for (Iterator it = this.listaLigada.iterator(); it.hasNext();) {
            String palabra = it.next().toString();
            
            if(tieneTildes(palabra)){
                
                if (conteo.containsKey( palabra )) {
                    int count = conteo.get( palabra );
                    conteo.put( palabra, count + 1);
                } else {
                    conteo.put( palabra,1 );
                }
                
            }
            
        }
        
        
        return conteo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        for (Iterator it = this.listaLigada.iterator(); it.hasNext();) {
            Object object = it.next().toString();
            builder.append(object+" ");
        }
        
        return builder.toString();
    }
    
    //TODO mover a paquete util
    /**
     * Funcion que verifica si una palabra contiene tildes
     * @param palabra
     * @return 
     */
    public static boolean tieneTildes(String palabra){
    
        boolean res = false;
        
        if (palabra != null) {
            String[] tildadas = {"á", "é", "í", "ó",};
            
            for (String string : tildadas) {
                
                res = palabra.contains(string) || palabra.contains(string.toUpperCase());
                
                if (res) {
                    break;
                }
            }
        }
        return res;
        
    }
    
    /**
     * elimina la palabra anterior a la palabra ingresada como parametro, si la 
     * palabra no se encuentra lanza un null pointer exception
     * @param palabra 
     * @throws NullPointerException
     */
    public void eliminaPalabra(String palabra){
        
        SLNode<String> nodoPalabra = this.listaLigada.contienDato(palabra);
        
        if (nodoPalabra != null) {
            SLNode<String> aEliminar = this.listaLigada.anterior(nodoPalabra);
            this.listaLigada.remover(aEliminar);
            
        }else{
            throw new NullPointerException();
        }
        
    
    }
    
    /**
     * Retorna el texto representado en el orden inverso
     * @return 
     */
    public String textoInverso(){
        
        List<String> lista = copyIterator(this.listaLigada.iterator());
        
        Collections.reverse(lista);
    
        StringBuilder builer = new StringBuilder();
        
        for (String string : lista) {
            builer.append(string+" ");
        }
    
        return builer.toString();
    }
    
    /**
     * Reemplaza una palabra en la lista
     * @param palabra
     * @param reemplaza 
     */
    public void reemplaza(String palabra,String reemplaza){
        
        boolean encontro = false;
        
        for (ListIterator it = this.listaLigada.iterator(); it.hasNext();) {
            String object = it.next().toString();
            if(palabra.equals(object)){
                encontro = encontro || true;
                it.set(reemplaza);
            }
            
            
        }
        
        if(!encontro){
            throw new NullPointerException();
        }
        
    }
    
    
    public static void main(String[] args){
    
        String a = "á";
        
        System.out.println(""+a + " "+ a.toUpperCase());
        
    }
    
    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }

    

    @Override
    public boolean equals(Object obj) {
        
        String mitexto = this.toString();
        
        String suTexto = obj.toString();
        
        return mitexto.equals(suTexto);
    }
    
    
}
