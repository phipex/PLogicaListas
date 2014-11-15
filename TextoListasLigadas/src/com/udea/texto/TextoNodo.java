package com.udea.texto;

import com.udea.listaligada.simple.ListaCircularSLRCGeneric;
import com.udea.listaligada.simple.SLNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
     * Retorna un lista con par valor (interface Map) con cada una de la
     * palabras en el texto
     * y la cantidad de veces que aparece en el texto de la instancia
     * @return objeto el cual implementa la inteface java.util.Map
     * @see java.util.List
     */
    public Map<String, Integer> getConteoPalabras(){
        Map<String, Integer> conteo = new HashMap<String, Integer>();
        
        
        
        for (Iterator it = this.listaLigada.iterator(); it.hasNext();) {
            String palabra = it.next().toString();
            palabra = limpiaPalabra(palabra);
            
            if (validaPalabra(palabra)) {
                
                if (conteo.containsKey(palabra)) {
                    int count = conteo.get(palabra);
                    conteo.put(palabra, count + 1);
                } else {
                    conteo.put(palabra, 1);
                }
            }
                
            
        }
        
        
        return conteo;
    }

    
    
    //<editor-fold defaultstate="collapsed" desc="Conteo Preposiciones">
    
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
            palabra = limpiaPalabra(palabra);
            if (validaPalabra(palabra)) {
                
                if (prepos.contains(palabra)) {
                    
                    if (conteo.containsKey(palabra)) {
                        int count = conteo.get(palabra);
                        conteo.put(palabra, count + 1);
                    } else {
                        conteo.put(palabra, 1);
                    }
                    
                }
            }
            
        }
        
        
        return conteo;
    }
    
    /**
     * Retorna el texto con la preposiciones encontradas en el texto
     * @return 
     */
    public TextoNodo textoPreposiciones(){
        
        Map<String, Integer> conteoPreposiciones = getConteoPreposisiones();
        
        Set<String> setConteoTildes = conteoPreposiciones.keySet();
        
        TextoNodo textoNodo = new TextoNodo(setConteoTildes);
        
        return textoNodo;
        
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Funciones Estaticas">
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
     * Le quita a la palabra los espacios finales e iniciales y quita las comas
     * @param palabra
     * @return 
     */
    public static String limpiaPalabra(String palabra) {
        palabra = palabra.trim();
        palabra = palabra.replaceAll(",", "");
        return palabra;
    }
    
    /**
     * Valida que la palabra no sea nula, un string vacio o un espacio
     * @param palabra
     * @return 
     */
    public static boolean validaPalabra(String palabra){
        boolean isValida = false;
        
        isValida = isValida || (palabra != null);
        
        isValida = isValida || (!"".equals(palabra));
        
        isValida = isValida || (!" ".equals(palabra));
        return isValida;
    
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Texto con tildes">
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
            palabra = limpiaPalabra(palabra);
            if (validaPalabra(palabra)) {
                if (tieneTildes(palabra)) {
                    
                    if (conteo.containsKey(palabra)) {
                        int count = conteo.get(palabra);
                        conteo.put(palabra, count + 1);
                    } else {
                        conteo.put(palabra, 1);
                    }
                    
                }
            }
            
        }
        
        
        return conteo;
    }
    
    /**
     * Retorna las palabras con el texto tildado
     * @return 
     */
    public TextoNodo textoTildado(){
        
        Map<String, Integer> conteoTildes = getConteoTildadas();
        
        Set<String> setConteoTildes = conteoTildes.keySet();
        
        TextoNodo textoNodo = new TextoNodo(setConteoTildes);
        
        return textoNodo;
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Elimina">
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
     * elimina la palabra anterior a la palabra ingresada como parametro, si la
     * palabra no se encuentra lanza un null pointer exception
     * @param palabra
     * @throws NullPointerException
     */
    public TextoNodo sinPalabra(String palabra){
        
        String textoActual = toString();
        
        TextoNodo clone = new TextoNodo(textoActual);
        
        clone.eliminaPalabra(palabra);
        
        return clone;
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Inverso">
    /**
     * Retorna el texto representado en el orden inverso
     * @return
     */
    public String stextoInverso(){
        
        List<String> lista = ltextoInverso();
        
        StringBuilder builer = new StringBuilder();
        
        for (String string : lista) {
            builer.append(string+" ");
        }
        
        return builer.toString();
    }
    /**
     * Retorna una lista representado las palabras en el orden inverso
     * @return
     */
    public List<String> ltextoInverso() {
        List<String> lista = copyIterator(this.listaLigada.iterator());
        Collections.reverse(lista);
        return lista;
    }
    
    /**
     * Retorna el texto representado en el orden inverso
     * @return
     */
    public TextoNodo textoInverso(){
        
        String texto = stextoInverso();
        
        TextoNodo textoNodo = new TextoNodo(texto);
        
        return textoNodo;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Alfabetico">
    /**
     * Retorna las palabras en orden alfabetico
     * @return 
     */
    public String stextoAlfabetico(){
        
        List<String> lista = ltextoAlfabetico();
        
        StringBuilder builer = new StringBuilder();
        
        for (String string : lista) {
            builer.append(string+" ");
        }
        
        return builer.toString();
    }
    
    /**
     * Retorna las palabras en orden alfabetico
     * @return 
     */
    public List<String> ltextoAlfabetico() {
        List<String> lista = copyIterator(this.listaLigada.iterator());
        Collections.sort(lista,ALPHABETICAL_ORDER);
        return lista;
    }
    
    
    /**
     * Retorna las palabras en orden alfabetico
     * @return 
     */
    public TextoNodo textoAlfabetico(){
        
        
        String texto = stextoAlfabetico();
        
        TextoNodo textoNodo = new TextoNodo(texto);
        
        return textoNodo;
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Reemplazar">
    
    /**
     * Reemplaza una palabra en la lista
     * @param palabra palabra a buscar
     * @param reemplaza palabra por la que reemplaza
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
    
    /**
     /**
     * Reemplaza una palabra en la lista
     * @param palabra palabra a buscar
     * @param reemplaza palabra por la que reemplaza
     *
     * @return 
     */
    public TextoNodo conReemplazo(String palabra,String reemplaza){
    
        String textoActual = toString();
        
        TextoNodo clone = new TextoNodo(textoActual);
        
        clone.reemplaza(palabra,reemplaza);
        
        return clone;
        
    }
    
    
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Util">
    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
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
    
    private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
        public int compare(String str1, String str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
            if (res == 0) {
                res = str1.compareTo(str2);
            }
            return res;
        }
    };
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Object Override">
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        
//        final TextoNodo other = (TextoNodo) obj;
        
        String mitexto = this.toString();
        
//        String suTexto = other.toString();
        
        String suTexto = obj.toString();
        
        return mitexto.equals(suTexto);
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
    
//</editor-fold>
    
    
}
