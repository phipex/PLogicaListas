/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.listaligada.doble;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Clase que representa una lista circular doblemente ligada sin registro cabeza
 * en la que sus datos son campos genericos
 * @author Andres Felipe Montoya
 */
public class ListaCircularDLGeneric<T> {

    /**
     * Primer nodo de la lista
     */
    private DLNode<T> primerNodo;
    
    /**
     * Nombre de la lista
     */
    private String nombre;

    /**
     * Tamaño de la lista
     */
    private int tamanyo;        // number of elements on list

    
    /**
     * Constructor de la clase
     * @param cadena nombre de la lista
     */
    public ListaCircularDLGeneric(String cadena) {
        nombre = cadena;
        primerNodo = null;
    }

    /**
     * Constructor de la clase con nombre generico
     */
    public ListaCircularDLGeneric() {
        this("Circular DE");
    }

    /**
     * retorna el tamanyo de la lista
     *
     * @return tamanyo de la lista
     */
    public int tamanyo() {
        return tamanyo;
    }

    
    /**
     * Inserta un dato al inicio de la lista
     * @param elementoAInsertar elemento generico a insertar
     * @return el nodo que acaba de ingresar
     */
    public synchronized DLNode<T> insertarInicio(T elementoAInsertar) {
        DLNode<T> res = null;

        res = insertarFinal(elementoAInsertar);

        if (res != null) {
            primerNodo = res;
        }

        return res;
    }

    /**
     * Inserta un dato al final de lista
     * @param elementoAInsertar elemento generico a insertar
     * @return el nodo que acaba de ingresar
     */
    public synchronized DLNode<T> insertarFinal(T elementoAInsertar) {
        DLNode<T> res = null;

        DLNode<T> anterior = null;
        if (primerNodo != null) {//es vacio

            anterior = primerNodo.getNodoAnterior();

        }

        res = insertar(anterior, elementoAInsertar);

        //System.out.println(res);
        return res;
    }

    /**
     * inserta un elemento despues del nodo ingresado (no verifica que el
     * elemento pertenezca a la lista)
     *
     * @param anterior nodo anterior al que se debe insertar
     * @param elementoAInsertar elemento generico a insertar
     * @return Nuevo nodo
     *
     */
    public synchronized DLNode<T> insertar(DLNode<T> anterior, T elementoAInsertar) {
        DLNode<T> res = null;

        if (elementoAInsertar != null) {
            if (estaVacio()) {
                primerNodo = new DLNode<T>(elementoAInsertar);
                primerNodo.setNodoProximo(primerNodo);
                primerNodo.setNodoAnterior(primerNodo);

                res = primerNodo;

            } else if (anterior != null) {

                DLNode<T> proximo = anterior.getNodoProximo();
                DLNode<T> nuevoNodo = new DLNode<>(elementoAInsertar, proximo, anterior);
                anterior.setNodoProximo(nuevoNodo);

                proximo.setNodoAnterior(nuevoNodo);

                res = nuevoNodo;
            }
            if (res != null) {

                tamanyo++;

            }
        }

        return res;
    }

    /**
     * Determina si un nodo pertenece a la lista
     *
     * @param nodo nodo a evluar
     * @return true en caso de que exista o falso en el caso contrario
     * @deprecated solo busca desde el inicio
     */
    public synchronized boolean contieneNodo(DLNode<T> nodo) {
        boolean res = false;
        if (!estaVacio()) {
            DLNode<T> actual = primerNodo;
            while (actual.getNodoProximo() != primerNodo) {
                if (actual.equals(nodo)) {
                    res = true;
                    break;
                }
                actual = actual.getNodoProximo();
            }
        }

        return res;
    }

    /**
     * busca si un nodo esta dentro de una lista de una posicion especifica
     * 
     * @param nodo nodo a valuar
     * @param desde nodo desde que se va a buscar (no verifica que este
     * dentro de la lista) 
     * @return true si lo contieno o false si no
     */
    public synchronized boolean contieneNodo(DLNode<T> nodo, DLNode<T> desde) {
        boolean res = false;
        if (!estaVacio()) {
            DLNode<T> actual = desde;
            while (actual.getNodoProximo() != primerNodo) {
                if (actual.equals(nodo)) {
                    res = true;
                    break;
                }
                actual = actual.getNodoProximo();
            }
        }

        return res;
    }

    /**
     * Busca un determinado dato desde la posicion ingresada por el parametro
     * @param dato dato a buscar
     * @param posicion posicion desde que se debe buscar
     * @return Nodo que contiene el dato
     */
    public synchronized DLNode<T> contieneDato(T dato, int posicion){
        
        DLNode<T> res = null;

        DLNode<T> desde = null;

        if (!estaVacio()) {
            desde = getElemento(posicion);
        }

        res = contienDato(dato, desde);

        return res;
        
        
    }
    
    /**
     * Busca un determinado dato desde el inicio de la lista
     * @param dato dato a buscar
     * @return Nodo que contiene el dato
     */
    public synchronized DLNode<T> contienDato(T dato) {
        DLNode<T> res = null;

        DLNode<T> desde = null;

        if (!estaVacio()) {
            desde = primerNodo;
        }

        res = contienDato(dato, desde);

        return res;
    }

    /**
     * Determina si un dato esta en la lista desde la posicion expecificada
     *
     * @param dato dato a buscar
     * @param desde nodo desde donde busca (no verifica si el nodo pertenece a
     * la apresente lista)
     * @return nodo que contiene el dato o null en caso de no encontrarlo
     */
    public synchronized DLNode<T> contienDato(T dato, DLNode<T> desde) {
        DLNode<T> res = null;
        if (!estaVacio() && desde != null) {
            DLNode<T> actual = desde;
            while (actual.getNodoProximo() != primerNodo) {
                if (actual.getDato().equals(dato)) {
                    res = actual;
                    break;
                }
                //System.out.println("nodo:"+actual.getDato());
                actual = actual.getNodoProximo();
            }
        }

        return res;
    }

    /**
     * obtiene la posicion de un elemento
     *
     * @param data dato a buscar en la lista
     * @return un entero con la posicion del elemento o -1 en caso de que no
     * exista
     */
    public synchronized int obtienePosicion(T data) {
        int res = -1;

        if (!estaVacio()) {
            DLNode<T> actual = primerNodo;
            int indice = 0;
            while (actual.getNodoProximo() != primerNodo) {

                if (actual.getDato().equals(data)) {
                    res = indice;
                    break;
                }
                indice++;
                actual = actual.getNodoProximo();
            }
        }

        return res;
    }

    /**
     * Inserta un dato en la posicion especificada
     *
     * @param data dato a insertar
     * @param posicion poiscion en que se ingreso
     * @return true en caso de agregarlo correctamente o false en el caso
     * contrario
     */
    public boolean insertaPosicion(T data, int posicion) {
        boolean res = false;

        if (posicion >= 0 && posicion < tamanyo) {
            if (!estaVacio()) {
                DLNode<T> actual = primerNodo;
                int indice = 0;
                while (actual.getNodoProximo() != primerNodo) {

                    if (posicion == indice) {
                        insertar(actual.getNodoAnterior(), data);
                        break;
                    }
                    indice++;
                    actual = actual.getNodoProximo();
                }
            }
        } else {
            insertarFinal(data);
        }

        return res;
    }

    /**
     * reemplaza el dato en una posicion especifica
     *
     * @param data datoa ser reemplazado
     * @param posicion posicion en al que se reemplazara el dato
     * @return El nodo con el dato cambiado
     */
    public synchronized DLNode<T> reemplazaPosicio(T data, int posicion) {

        DLNode<T> res = null;

        res = getElemento(posicion);
        if (res != null) {

            res.setDato(data);

        }
        return res;

    }

    /**
     * remueve el ultimo dato de la lista
     *
     * @return elemento A Remover
     * @throws ExcepcionListaVacia
     * @deprecated solo remueve el ultimo y para eso recorre toda la lista
     */
    public synchronized T remover()
            throws ExcepcionListaVacia {
        DLNode NodoARemover = primerNodo;
        T elementoARemover = null;

        if (estaVacio()) {
            throw new ExcepcionListaVacia(nombre);
        }

        elementoARemover = primerNodo.getDato();

        if (primerNodo == primerNodo.getNodoProximo()) {
            primerNodo = null;
        } else {
            DLNode<T> actual = primerNodo;
            while (actual.getNodoProximo() != primerNodo) {
                actual = actual.getNodoProximo();
            }
            DLNode<T> ultimoNodo = actual;

            primerNodo = primerNodo.getNodoProximo();
            ultimoNodo.setNodoProximo(primerNodo);
            primerNodo.setNodoAnterior(ultimoNodo);
        }

        NodoARemover.setNodoProximo(null);
        NodoARemover.setNodoAnterior(null);

        tamanyo--;

        return elementoARemover;
    }
    
    /**
     * Remueve el nodo correspondiente a la posicion indicada
     * @param posicion posicion del nodo a remover
     */
    public synchronized void remover(int posicion){
        remover(getElemento(posicion));
    }
    
    /**
     * Remueve la serie de datos entre las posiciones ingresadas
     * @param inicia posicion desde que se debe remover datos
     * @param finaliza posicion hasta la que se debe remover datos
     */
    public synchronized void remover(int inicia, int finaliza){
        
        
        if (!this.estaVacio() && inicia > -1 && finaliza > -1 && finaliza < tamanyo) {

            if (inicia > finaliza) {
                int tem = inicia;
                
                inicia = finaliza;
                
                finaliza = tem;
                
            }
            
            
            DLNode<T> thisnododesde = getElemento(inicia);

            int cuantos = finaliza - inicia;
            
            int indice = 0;

            while (thisnododesde.getNodoProximo() != primerNodo) {
                if (indice <= cuantos) {
                    
                    remover(thisnododesde);
                    thisnododesde = thisnododesde.getNodoAnterior();
                    
                    indice++;
                } else {
                    break;
                }
                thisnododesde = thisnododesde.getNodoProximo();
            }

        }
        
    }
    
    /**
     * Remueve un nodo en especifico
     *
     * @param nodoARemover nodo A Remover
     * @throws ExcepcionListaVacia
     */
    public synchronized DLNode<T> remover(DLNode nodoARemover) throws ExcepcionListaVacia {

        DLNode<T> res = null;
        
        if (estaVacio()) {
            throw new ExcepcionListaVacia(nombre);
        }

        if (primerNodo == nodoARemover) {
            primerNodo = nodoARemover.getNodoProximo();
        } else if (nodoARemover != null) {
            DLNode<T> anterior = nodoARemover.getNodoAnterior();
            DLNode<T> proximo = nodoARemover.getNodoProximo();
            anterior.setNodoProximo(proximo);
            proximo.setNodoAnterior(anterior);
            
            res = proximo;
            
        } else {
            tamanyo++;
        }

        tamanyo--;

        return res;
    }

    /**
     * ingresa un sublista al final
     *
     * @param lista
     * @return si se logro ingresar a la lista
     */
    public synchronized boolean ingresaLista(ListaCircularDLGeneric lista) {
        boolean res = false;

        if (lista != null) {
            ListIterator iterator = lista.iterator();

            while (iterator.hasNext()) {
                T object = (T) iterator.next();
                insertarFinal(object);
            }
            res = true;
        }

        return res;
    }

    /**
     * reemplaza una lista desde la posicion establecida
     *
     * @param lista lista por la cual se va reemplazar
     * @param posicion posicion desde la que se va a reemplazar
     * @return verdadero si se logro reemplazar
     */
    public synchronized boolean reemplazaLista(ListaCircularDLGeneric lista, int posicion) {

        boolean res = false;

        if (lista != null && !estaVacio() && posicion >= 0) {

            if (posicion <= tamanyo) {

                ListIterator thisIterator = iterator();
                ListIterator listaIterator = lista.iterator();
                int indice = 0;
                int indiceLista = posicion;
                for (Iterator it = thisIterator; it.hasNext();) {
                    T objectThis = (T) it.next();
                    //System.out.println(objectThis+" indice:"+indice+" indicelista:"+indiceLista+" iguales:"+(posicion == indice));
                    if (indiceLista == indice && listaIterator.hasNext()) {
                        T objectList = (T) listaIterator.next();
                        //System.out.println("reemplaza "+objectThis +" por "+objectList);
                        thisIterator.set(objectList);

                        indiceLista++;
                    }
                    indice++;
                }

                res = true;
            }

        }

        return res;
    }

    /**
     * Busca una sublista realizando la busqueda desde el principio
     *
     * @param lista sublista que se desea buscar
     * @return retorna la posicion donde se encuentra la sublista o -1 en caso
     * contrario
     */
    public synchronized int encontrasLista(ListaCircularDLGeneric<T> lista) {
        return encontrasLista(lista, 0);
    }

    
    
    //TODO hay que crear una version reversa
    /**
     * Busca una sublista realizando la busqueda desde la posicion dada
     *
     * @param lista lista a buscar
     * @param desde posicion desde la que se va a buscar
     * @return
     */
    public synchronized int encontrasLista(ListaCircularDLGeneric<T> lista, int desde) {

        int res = -1;

        if (lista != null && !estaVacio() && !lista.estaVacio() && desde > -1 && desde <= tamanyo ) {

            DLNode<T> thisnododesde = getElemento(desde);
            
            if (lista.tamanyo() <= tamanyo && thisnododesde != null) {
                

                DLNode<T> listanododesde = lista.primerNodo;

                int indice = desde;
                int indicelista = 0;
                boolean anterior = false;
                while (thisnododesde.getNodoProximo() != primerNodo) {

                    //si los datos son iguales
                    T objectList = listanododesde.getDato();
                    T objectThis = thisnododesde.getDato();
                    if (objectList.equals(objectThis)) {
                        if (!anterior) {
                            res = indice;
                        }
                        anterior = true;
                        listanododesde = listanododesde.getNodoProximo();
                        indicelista++;
                    } else if (anterior) {
                        if (indicelista < lista.tamanyo) {
                            anterior = false;
                            res = -1;
                            listanododesde = lista.primerNodo;
                            indicelista = 0;
                        } else {
                            break;
                        }
                    }
                    thisnododesde = thisnododesde.getNodoProximo();
                    indice++;
                }

            }

        }

        return res;
    }

    

    /**
     * retorna el nodo en la posicion establecida
     *
     * @param posicion posision por la cual se esta preguntando
     * @return nodo en la posicion establecida o null en caso de no encotrarlo
     */
    public synchronized DLNode<T> getElemento(int posicion) {
        DLNode<T> res = null;

        if (!estaVacio() && posicion >= 0 && posicion < tamanyo) {

            DLNode<T> actual = primerNodo;
            int indicec = 0;
            do {

                if (posicion == indicec) {

                    res = actual;
                    break;
                }
                indicec++;
                actual = actual.getNodoProximo();
            } while (actual.getNodoProximo() != primerNodo);

        }

        return res;
    }

    /**
     * determina si la lista es vacia
     *
     * @return verdadero si la lista es vacia
     */
    public synchronized boolean estaVacio() {
        return primerNodo == null;
    }

    /**
     * imprime en consola la lista
     */
    public synchronized void imprimir() {
        if (estaVacio()) {
            System.out.println("Lista " + nombre + " Vacía");
            return;
        }

        System.out.print("La lista " + nombre + " es: ");

        DLNode<T> actual = primerNodo;

        do {
            System.out.print(actual.getDato().toString() + " ");
            actual = actual.getNodoProximo();
        } while (actual != primerNodo);

        System.out.println("\n");
    }

    /**
     * Retorna una sublista con los valores entre las posiciones ingresadas en 
     * los parametros
     * @param desde posicion desde la que se debe buscar la sublista
     * @param hasta posicion hasta la que se debe buscar la sublista
     * @return una nueva lista con los datos encontrados
     * @deprecated reemplazada por subHilera
     */
    public synchronized ListaCircularDLGeneric<T> sublista(int inicia, int finaliza) {
        ListaCircularDLGeneric<T> res = null;

        if (!this.estaVacio() && inicia > -1 && finaliza > -1 && finaliza < tamanyo) {

            if (inicia > finaliza) {
                int tem = inicia;
                
                inicia = finaliza;
                
                finaliza = tem;
                
            }
            
            
            res = new ListaCircularDLGeneric<T>();

            DLNode<T> thisnododesde = getElemento(inicia);

            int indice = inicia;

            while (thisnododesde.getNodoProximo() != primerNodo) {
                if (indice <= finaliza) {
                    
                    T objeto = thisnododesde.getDato();
                    
                    res.insertarFinal(objeto);
                } else {
                    break;
                }
                thisnododesde = thisnododesde.getNodoProximo();
            }

        }

        return res;
    }
    
    
    /**
     * Retorna una sublista con los valores entre las posiciones ingresadas en 
     * los parametros
     * @param desde posicion desde la que se debe buscar la sublista
     * @param hasta posicion hasta la que se debe buscar la sublista
     * @return una nueva lista con los datos encontrados
     */
    public synchronized ListaCircularDLGeneric<T> subHilera(int desde, int hasta){
        
        ListaCircularDLGeneric<T> lista = null;
        
        if (!estaVacio() && desde > -1 && hasta > -1) {
            if (hasta < desde) {
                int temp = hasta;
                hasta = desde;
                desde = temp;
            }
            
            lista = new ListaCircularDLGeneric<T>(this.nombre);
            
            int index = desde;
            
            for (Iterator it = iterator(desde); it.hasNext();) {
                T object = (T)it.next();
                if (index <= hasta) {
                    lista.insertarFinal(object);
                }else{
                    break;
                }
                index++;
            }
            
            
            
        }
        
        
        return lista;
    }
    
    
    @Override
    public String toString() {

        if (this.tamanyo != 0) {
            StringBuilder build = new StringBuilder();
            for (Iterator it = iterator(); it.hasNext();) {
                Object object = it.next();
                build.append(object);
            }

            return "ListaCircularDLGeneric1{" + "nombre=" + nombre + ", tamanyo=" + tamanyo + ", contenido: " + build.toString() + "}";
        }

        return "";

    }

    /**
     * Retorna un string que representa el objeto, si se le ingresa verdadero
     * como parametro entrega la representacion con nombre y tamanyo, en el caso
     * contrario entrega un string con solo los resultados de convertir a string
     * cada uno de los items de la lista
     * @param completo
     * @return 
     */
    public String toString(boolean completo) {
        if (completo) {
            return toString();
        } else {
            StringBuilder build = new StringBuilder();

            if (tamanyo != 0) {
                for (Iterator it = iterator(); it.hasNext();) {
                    Object object = it.next();
                    build.append(object);
                }
            }

            return build.toString();

        }

    }

    
    /**
     * Retorna un objeto iterator desde una posicion en especifico
     * @param desde
     * @return 
     */
    public ListIterator<T> iterator(int desde) {
        ListIterator<T> iterator = null;

        if (!estaVacio() && desde > -1) {
            //iterator = new DoublyLinkedListIterator(primerNodo,tamanyo);
            iterator = new DoubleLinkedListCircularIterator<T>(getElemento(desde), this);
        }

        return iterator;
    }
    
    /**
     * retorna un objeto iterator desde el primer nodo
     * @return 
     */
    public ListIterator<T> iterator() {

        ListIterator<T> iterator = null;

        if (primerNodo != null) {
            //iterator = new DoublyLinkedListIterator(primerNodo,tamanyo);
            iterator = new DoubleLinkedListCircularIterator<T>(primerNodo,  this);
        }

        return iterator;
    }

    /**
     * retorna un objeto iterator desde un nodo en expecifico
     * @param desde
     * @return 
     */
    public ListIterator<T> iterator(DLNode<T> desde) {

        ListIterator<T> iterator = null;

        if (desde != null) {
            //iterator = new DoublyLinkedListIterator(desde, tamanyo);
            iterator = new DoubleLinkedListCircularIterator<T>(desde,  this);
        }

        return iterator;
    }

    
//    
//    public static void main(String args[]) {
//        ListaCircularDLGeneric<Character> lista = crearListaString("por un caminito");
//        
//        ListaCircularDLGeneric<Character> lista2 = lista.subHilera(12, 0);
//        
//        for (Iterator it = lista2.iterator(0); it.hasNext();) {
//            Object object = it.next();
//            System.out.println(object);
//        }
//        
//    }
//    
//    public static void main5(String args[]) {
//        ListaCircularDLGeneric<Character> lista = crearListaString("otota");
//        
//        for (Iterator it = lista.iterator(lista.getElemento(2)); it.hasNext();) {
//            Object object = it.next();
//            System.out.println(object);
//        }
//        
//        
//        
//    }
//    
//    public static void main4(String args[]) {
//        ListaCircularDLGeneric<Character> lista = crearListaString("otota");
//        System.out.println("lista:" + lista.toString(false));
//
//        int posicion = 1;
//        ListaCircularDLGeneric<Character> instance = crearListaString("pollito");
//        System.out.println("instancia:" + instance.toString(false));
//        String expResult = "pototao";
//        instance.reemplazaLista(lista, posicion);
//        String result = instance.toString(false);
//        System.out.println("despues: " + instance.toString(false));
//
//        ListaCircularDLGeneric<Character> instance2 = new ListaCircularDLGeneric<>();
//
//        System.out.println(instance2);
//    }
//
//    public static ListaCircularDLGeneric<Character> crearListaString(String texto) {
//        ListaCircularDLGeneric<Character> lista = null;
//
//        if (texto != null && !texto.isEmpty()) {
//            lista = new ListaCircularDLGeneric<Character>("texto");
//
//            char[] array = texto.toCharArray();
//
//            for (char c : array) {
//                lista.insertarFinal(c);
//            }
//        }
//
//        return lista;
//
//    }
//
//    public static void main3(String args[]) {
//        ListaCircularDLGeneric<Character> lista = new ListaCircularDLGeneric<Character>("texto");
//
//        String texto = "un pollito comiendo pechuga";
//
//        char[] array = texto.toCharArray();
//
//        for (char c : array) {
//            lista.insertarFinal(c);
//        }
//
//        System.out.println(lista);
//
//        boolean contien_n = (lista.contienDato('n') != null) ? true : false;
//        System.out.println("contiene la n" + contien_n);
//
//        boolean contien_D = (lista.contienDato('D') != null) ? true : false;
//        System.out.println("contiene la D" + contien_D);
//
//        boolean contien_d = (lista.contienDato('d') != null) ? true : false;
//        System.out.println("contiene la d" + contien_d);
//
//    }
//
//    public static void main2(String args[]) {
////        ListaCircularDL lista = new ListaCircularDL();
////
////        Boolean booleano = Boolean.TRUE;
////        Character caracter = new Character('$');
////        Integer entero = new Integer(34567);
////        String cadena = "hola";
////        lista.insertar(booleano);
////        lista.imprimir();
////        lista.insertar(caracter);
////        lista.imprimir();
////        lista.insertar(entero);
////        lista.imprimir();
////        lista.insertar(cadena);
////        lista.imprimir();
////        Object objetoRemovido;
////        try {
////            objetoRemovido = lista.remover();
////            System.out.println(
////                    objetoRemovido.toString() + " removido");
////            lista.imprimir();
////            objetoRemovido = lista.remover();
////            System.out.println(
////                    objetoRemovido.toString() + " removido");
////            lista.imprimir();
////            objetoRemovido = lista.remover();
////            System.out.println(
////                    objetoRemovido.toString() + " removido");
////            lista.imprimir();
////            objetoRemovido = lista.remover();
////            System.out.println(
////                    objetoRemovido.toString() + " removido");
////            lista.imprimir();
////        } catch (ExcepcionListaVacia excepcionListaVacia) {
////            excepcionListaVacia.printStackTrace();
////        }
//
//        int N = 6;
//
//        // add elements 1, ..., tamanyo
//        System.out.println(N + " random integers between 0 and 99");
//        ListaCircularDLGeneric list = new ListaCircularDLGeneric();
//
//        for (int i = 0; i < N; i++) {
//            //int enteroRand = (int) (100 * Math.random());
//
//            //list.insertar(Integer.valueOf(enteroRand));
//            list.insertarFinal(i);
//        }
//
//        list.imprimir();
//
//        ListIterator iterator = list.iterator();
//
//        // go forwards with next() and set()
//        System.out.println("add 1 to each element via next() and set()");
//        while (iterator.hasNext()) {
//            int x = (int) iterator.next();
//            iterator.set(x + 1);
//        }
//        list.imprimir();
//
//        // go backwards with previous() and set()
//        System.out.println("multiply each element by 3 via previous() and set()");
//        while (iterator.hasPrevious()) {
//            int x = (int) iterator.previous();
//            iterator.set(x + x + x);
//        }
//        list.imprimir();
//
//        // remove all elements that are multiples of 4 via next() and remove()
//        System.out.println("remove elements that are a multiple of 4 via next() and remove()");
//        while (iterator.hasNext()) {
//            int x = (int) iterator.next();
//            if (x % 4 == 0) {
//                iterator.remove();
//            }
//        }
//        list.imprimir();
//
//        // remove all even elements via previous() and remove()
//        System.out.println("remove elements that are even via previous() and remove()");
//        while (iterator.hasPrevious()) {
//            int x = (int) iterator.previous();
//            if (x % 2 == 0) {
//                iterator.remove();
//            }
//        }
//        list.imprimir();
//
//        // add elements via next() and add()
//        System.out.println("add elements via next() and add() " + iterator.nextIndex());
//        while (iterator.hasNext()) {
//            int x = (int) iterator.next();
//            iterator.add(Integer.valueOf(x + 1));
//        }
//        list.imprimir();
//
//        // add elements via previous() and add()
//        System.out.println("add elements via previous() and add()");
//        while (iterator.hasPrevious()) {
//            int x = (int) iterator.previous();
//            iterator.add(Integer.valueOf(x * 10));
//            iterator.previous();
//        }
//        list.imprimir();
//    }
}
