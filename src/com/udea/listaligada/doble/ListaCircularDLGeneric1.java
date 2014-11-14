/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.listaligada.doble;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Felipe
 */
public class ListaCircularDLGeneric1<T> {

    private SLNode<T> primerNodo;
    private String nombre;

    private int tamanyo;        // number of elements on list

    public ListaCircularDLGeneric1(String cadena) {
        nombre = cadena;
        primerNodo = null;
    }

    public ListaCircularDLGeneric1() {
        this("Circular DE");
    }

    /**
     * retorna el tamanyo de la lista
     *
     * @return
     */
    public int tamanyo() {
        return tamanyo;
    }

    public synchronized SLNode<T> insertarInicio(T elementoAInsertar) {
        SLNode<T> res = null;

        res = insertarFinal(elementoAInsertar);

        if (res != null) {
            primerNodo = res;
        }

        return res;
    }

    public synchronized SLNode<T> insertarFinal(T elementoAInsertar) {
        SLNode<T> res = null;

        SLNode<T> anterior = null;
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
     * @param anterior
     * @param elementoAInsertar
     * @return Nuevo nodo
     *
     */
    public synchronized SLNode<T> insertar(SLNode<T> anterior, T elementoAInsertar) {
        SLNode<T> res = null;

        if (elementoAInsertar != null) {
            if (estaVacio()) {
                primerNodo = new SLNode<T>(elementoAInsertar);
                primerNodo.setNodoProximo(primerNodo);
                primerNodo.setNodoAnterior(primerNodo);

                res = primerNodo;

            } else if (anterior != null) {

                SLNode<T> proximo = anterior.getNodoProximo();
                SLNode<T> nuevoNodo = new SLNode<>(elementoAInsertar, proximo, anterior);
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
     * @param nodo nodo a evaluar
     * @return true en caso de que exista o falso en el caso contrario
     * @deprecated
     */
    public synchronized boolean contieneNodo(SLNode<T> nodo) {
        boolean res = false;
        if (!estaVacio()) {
            SLNode<T> actual = primerNodo;
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
     * @param nodo
     * @param desde
     * @return
     */
    public synchronized boolean contieneNodo(SLNode<T> nodo, SLNode<T> desde) {
        boolean res = false;
        if (!estaVacio()) {
            SLNode<T> actual = desde;
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

    public synchronized SLNode<T> contieneDato(T dato, int posicion){
        
        SLNode<T> res = null;

        SLNode<T> desde = null;

        if (!estaVacio()) {
            desde = getElemento(posicion);
        }

        res = contienDato(dato, desde);

        return res;
        
        
    }
    
    public synchronized SLNode<T> contienDato(T dato) {
        SLNode<T> res = null;

        SLNode<T> desde = null;

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
    public synchronized SLNode<T> contienDato(T dato, SLNode<T> desde) {
        SLNode<T> res = null;
        if (!estaVacio() && desde != null) {
            SLNode<T> actual = desde;
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
            SLNode<T> actual = primerNodo;
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
                SLNode<T> actual = primerNodo;
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
    public synchronized SLNode<T> reemplazaPosicio(T data, int posicion) {

        SLNode<T> res = null;

        res = getElemento(posicion);
        if (res != null) {

            res.setDato(data);

        }
        return res;

    }

    /**
     * remueve el ultimo dato de la lista
     *
     * @return
     * @throws ExcepcionListaVacia
     * @deprecated
     */
    public synchronized T remover()
            throws ExcepcionListaVacia {
        SLNode NodoARemover = primerNodo;
        T elementoARemover = null;

        if (estaVacio()) {
            throw new ExcepcionListaVacia(nombre);
        }

        elementoARemover = primerNodo.getDato();

        if (primerNodo == primerNodo.getNodoProximo()) {
            primerNodo = null;
        } else {
            SLNode<T> actual = primerNodo;
            while (actual.getNodoProximo() != primerNodo) {
                actual = actual.getNodoProximo();
            }
            SLNode<T> ultimoNodo = actual;

            primerNodo = primerNodo.getNodoProximo();
            ultimoNodo.setNodoProximo(primerNodo);
            primerNodo.setNodoAnterior(ultimoNodo);
        }

        NodoARemover.setNodoProximo(null);
        NodoARemover.setNodoAnterior(null);

        tamanyo--;

        return elementoARemover;
    }
    
    public synchronized void remover(int posicion){
        remover(getElemento(posicion));
    }
    
    
    /**
     * Remueve un nodo en especifico
     *
     * @param nodoARemover
     * @throws ExcepcionListaVacia
     */
    public synchronized void remover(SLNode nodoARemover) throws ExcepcionListaVacia {

        if (estaVacio()) {
            throw new ExcepcionListaVacia(nombre);
        }

        if (primerNodo == nodoARemover) {
            primerNodo = nodoARemover.getNodoProximo();
        } else if (nodoARemover != null) {
            SLNode<T> anterior = nodoARemover.getNodoAnterior();
            SLNode<T> proximo = nodoARemover.getNodoProximo();
            anterior.setNodoProximo(proximo);
            proximo.setNodoAnterior(anterior);

        } else {
            tamanyo++;
        }

        tamanyo--;

    }

    /**
     * ingresa un sublista al final
     *
     * @param lista
     * @return
     */
    public synchronized boolean ingresaLista(ListaCircularDLGeneric1 lista) {
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
     * @param lista
     * @param posicion
     * @return
     */
    public synchronized boolean reemplazaLista(ListaCircularDLGeneric1 lista, int posicion) {

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
     * @param lista
     * @return retorna la posicion donde se encuentra la sublista o -1 en caso
     * contrario
     */
    public synchronized int encontrasLista(ListaCircularDLGeneric1<T> lista) {
        return encontrasLista(lista, 0);
    }

    
    
    //TODO hay que crear una version reversa
    /**
     * Busca una sublista realizando la busqueda desde la posicion dada
     *
     * @param lista
     * @param desde
     * @return
     */
    public synchronized int encontrasLista(ListaCircularDLGeneric1<T> lista, int desde) {

        int res = -1;

        if (lista != null && !estaVacio() && !lista.estaVacio()) {

            if (lista.tamanyo() <= tamanyo) {
                SLNode<T> thisnododesde = getElemento(desde);

                SLNode<T> listanododesde = lista.primerNodo;

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

    //TODO funcion sublista
    public synchronized ListaCircularDLGeneric1<T> sublista(int inicia, int finaliza) {
        ListaCircularDLGeneric1<T> res = null;

        if (!this.estaVacio() && inicia > -1 && finaliza > -1 && finaliza < tamanyo) {

            if (inicia > finaliza) {
                int tem = inicia;
                
                inicia = finaliza;
                
                finaliza = tem;
                
            }
            
            
            res = new ListaCircularDLGeneric1<T>();

            SLNode<T> thisnododesde = getElemento(inicia);

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
     * retorna el nodo en la posicion establecida
     *
     * @param posicion
     * @return nodo en la posicion establecida o null en caso de no encotrarlo
     */
    public synchronized SLNode<T> getElemento(int posicion) {
        SLNode<T> res = null;

        if (!estaVacio() && posicion >= 0 && posicion < tamanyo) {

            SLNode<T> actual = primerNodo;
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
     * @return
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

        SLNode<T> actual = primerNodo;

        do {
            System.out.print(actual.getDato().toString() + " ");
            actual = actual.getNodoProximo();
        } while (actual != primerNodo);

        System.out.println("\n");
    }

    
    //TODO crear prueba unitaria
    public synchronized ListaCircularDLGeneric1<T> subHilera(int desde, int hasta){
        
        ListaCircularDLGeneric1<T> lista = null;
        
        if (!estaVacio() && desde > -1 && hasta > -1) {
            if (hasta < desde) {
                int temp = hasta;
                hasta = desde;
                desde = temp;
            }
            
            lista = new ListaCircularDLGeneric1<T>(this.nombre);
            
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

    //TODO hay que cambiar los metodos que llaman el iterator con el nodo
    //TODO hay que hacerle prueba unitario
    public ListIterator<T> iterator(int desde) {
        ListIterator<T> iterator = null;

        if (!estaVacio() && desde > -1) {
            //iterator = new DoublyLinkedListIterator(primerNodo,tamanyo);
            //iterator = new DoubleLinkedListCircularIterator<T>(getElemento(desde), tamanyo, this);
        }

        return iterator;
    }
    
    public ListIterator<T> iterator() {

        ListIterator<T> iterator = null;

        if (primerNodo != null) {
            //iterator = new DoublyLinkedListIterator(primerNodo,tamanyo);
//            iterator = new DoubleLinkedListCircularIterator<T>(primerNodo, tamanyo, this);
        }

        return iterator;
    }

    public ListIterator<T> iterator(SLNode<T> desde) {

        ListIterator<T> iterator = null;

        if (desde != null) {
            //iterator = new DoublyLinkedListIterator(desde, tamanyo);
//            iterator = new DoubleLinkedListCircularIterator<T>(desde, tamanyo, this);
        }

        return iterator;
    }

    
    
    public static void main(String args[]) {
        ListaCircularDLGeneric1<Character> lista = crearListaString("por un caminito");
        
        ListaCircularDLGeneric1<Character> lista2 = lista.subHilera(12, 0);
        
        for (Iterator it = lista2.iterator(0); it.hasNext();) {
            Object object = it.next();
            System.out.println(object);
        }
        
    }
    
    public static void main5(String args[]) {
        ListaCircularDLGeneric1<Character> lista = crearListaString("otota");
        
        for (Iterator it = lista.iterator(lista.getElemento(2)); it.hasNext();) {
            Object object = it.next();
            System.out.println(object);
        }
        
        
        
    }
    
    public static void main4(String args[]) {
        ListaCircularDLGeneric1<Character> lista = crearListaString("otota");
        System.out.println("lista:" + lista.toString(false));

        int posicion = 1;
        ListaCircularDLGeneric1<Character> instance = crearListaString("pollito");
        System.out.println("instancia:" + instance.toString(false));
        String expResult = "pototao";
        instance.reemplazaLista(lista, posicion);
        String result = instance.toString(false);
        System.out.println("despues: " + instance.toString(false));

        ListaCircularDLGeneric1<Character> instance2 = new ListaCircularDLGeneric1<>();

        System.out.println(instance2);
    }

    public static ListaCircularDLGeneric1<Character> crearListaString(String texto) {
        ListaCircularDLGeneric1<Character> lista = null;

        if (texto != null && !texto.isEmpty()) {
            lista = new ListaCircularDLGeneric1<Character>("texto");

            char[] array = texto.toCharArray();

            for (char c : array) {
                lista.insertarFinal(c);
            }
        }

        return lista;

    }

    public static void main3(String args[]) {
        ListaCircularDLGeneric1<Character> lista = new ListaCircularDLGeneric1<Character>("texto");

        String texto = "un pollito comiendo pechuga";

        char[] array = texto.toCharArray();

        for (char c : array) {
            lista.insertarFinal(c);
        }

        System.out.println(lista);

        boolean contien_n = (lista.contienDato('n') != null) ? true : false;
        System.out.println("contiene la n" + contien_n);

        boolean contien_D = (lista.contienDato('D') != null) ? true : false;
        System.out.println("contiene la D" + contien_D);

        boolean contien_d = (lista.contienDato('d') != null) ? true : false;
        System.out.println("contiene la d" + contien_d);

    }

    public static void main2(String args[]) {
//        ListaCircularDL lista = new ListaCircularDL();
//
//        Boolean booleano = Boolean.TRUE;
//        Character caracter = new Character('$');
//        Integer entero = new Integer(34567);
//        String cadena = "hola";
//        lista.insertar(booleano);
//        lista.imprimir();
//        lista.insertar(caracter);
//        lista.imprimir();
//        lista.insertar(entero);
//        lista.imprimir();
//        lista.insertar(cadena);
//        lista.imprimir();
//        Object objetoRemovido;
//        try {
//            objetoRemovido = lista.remover();
//            System.out.println(
//                    objetoRemovido.toString() + " removido");
//            lista.imprimir();
//            objetoRemovido = lista.remover();
//            System.out.println(
//                    objetoRemovido.toString() + " removido");
//            lista.imprimir();
//            objetoRemovido = lista.remover();
//            System.out.println(
//                    objetoRemovido.toString() + " removido");
//            lista.imprimir();
//            objetoRemovido = lista.remover();
//            System.out.println(
//                    objetoRemovido.toString() + " removido");
//            lista.imprimir();
//        } catch (ExcepcionListaVacia excepcionListaVacia) {
//            excepcionListaVacia.printStackTrace();
//        }

        int N = 6;

        // add elements 1, ..., tamanyo
        System.out.println(N + " random integers between 0 and 99");
        ListaCircularDLGeneric1 list = new ListaCircularDLGeneric1();

        for (int i = 0; i < N; i++) {
            //int enteroRand = (int) (100 * Math.random());

            //list.insertar(Integer.valueOf(enteroRand));
            list.insertarFinal(i);
        }

        list.imprimir();

        ListIterator iterator = list.iterator();

        // go forwards with next() and set()
        System.out.println("add 1 to each element via next() and set()");
        while (iterator.hasNext()) {
            int x = (int) iterator.next();
            iterator.set(x + 1);
        }
        list.imprimir();

        // go backwards with previous() and set()
        System.out.println("multiply each element by 3 via previous() and set()");
        while (iterator.hasPrevious()) {
            int x = (int) iterator.previous();
            iterator.set(x + x + x);
        }
        list.imprimir();

        // remove all elements that are multiples of 4 via next() and remove()
        System.out.println("remove elements that are a multiple of 4 via next() and remove()");
        while (iterator.hasNext()) {
            int x = (int) iterator.next();
            if (x % 4 == 0) {
                iterator.remove();
            }
        }
        list.imprimir();

        // remove all even elements via previous() and remove()
        System.out.println("remove elements that are even via previous() and remove()");
        while (iterator.hasPrevious()) {
            int x = (int) iterator.previous();
            if (x % 2 == 0) {
                iterator.remove();
            }
        }
        list.imprimir();

        // add elements via next() and add()
        System.out.println("add elements via next() and add() " + iterator.nextIndex());
        while (iterator.hasNext()) {
            int x = (int) iterator.next();
            iterator.add(Integer.valueOf(x + 1));
        }
        list.imprimir();

        // add elements via previous() and add()
        System.out.println("add elements via previous() and add()");
        while (iterator.hasPrevious()) {
            int x = (int) iterator.previous();
            iterator.add(Integer.valueOf(x * 10));
            iterator.previous();
        }
        list.imprimir();
    }
}
