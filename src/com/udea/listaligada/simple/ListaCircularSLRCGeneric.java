package com.udea.listaligada.simple;


import java.util.Iterator;
import java.util.ListIterator;

/**
 * Clase que representa una lista circular simple ligada con registro cabeza
 * en la que sus datos son campos genericos
 * @author Andres Felipe Montoya
 */
public class ListaCircularSLRCGeneric<T> {

    /**
     * Primer nodo de la lista
     */
    private SLNode<T> registroCabeza;
    
    
    /**
     * Primer nodo de la lista
     */
//    private SLNode<T> primerNodo;
    
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
    public ListaCircularSLRCGeneric(String cadena) {
        nombre = cadena;
        registroCabeza = new SLNode<>();
        registroCabeza.setNodoProximo(registroCabeza);
//        primerNodo = null;
    }

    /**
     * Constructor de la clase con nombre generico
     */
    public ListaCircularSLRCGeneric() {
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
     * 
     */
    public synchronized SLNode<T> insertarInicio(T elementoAInsertar) {
        SLNode<T> res = null;

        res = insertar(registroCabeza,elementoAInsertar);

        
        return res;
    }

    /**
     * Inserta un dato al final de lista
     * @param elementoAInsertar elemento generico a insertar
     * @return el nodo que acaba de ingresar
     *  
     */
    public synchronized SLNode<T> insertarFinal(T elementoAInsertar) {
        SLNode<T> res = null;

        SLNode<T> anterior = null;
        

        anterior = ultimo();

        

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
    public synchronized SLNode<T> insertar(SLNode<T> anterior, T elementoAInsertar) {
        SLNode<T> res = null;

        if (elementoAInsertar != null) {
            SLNode<T> proximo = null;
            if(anterior == null){
                proximo = registroCabeza;
                anterior = registroCabeza;
            }else{
                proximo = anterior.getNodoProximo();
            }

            
            SLNode<T> nuevoNodo = new SLNode<>(elementoAInsertar, proximo);
            anterior.setNodoProximo(nuevoNodo);

            res = nuevoNodo;
            
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
    public synchronized boolean contieneNodo(SLNode<T> nodo) {
        boolean res = false;
        if (!estaVacio()) {
            SLNode<T> actual = registroCabeza.getNodoProximo();
            while (actual.getNodoProximo() != registroCabeza) {
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
     * 
     */
    public synchronized boolean contieneNodo(SLNode<T> nodo, SLNode<T> desde) {
        boolean res = false;
        if (!estaVacio()) {
            SLNode<T> actual = desde;
            while (actual.getNodoProximo() != registroCabeza) {
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
     * 
     */
    public synchronized SLNode<T> contieneDato(T dato, int posicion){
        
        SLNode<T> res = null;

        SLNode<T> desde = null;

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
     * 
     */
    public synchronized SLNode<T> contienDato(T dato) {
        SLNode<T> res = null;

        SLNode<T> desde = null;

        if (!estaVacio()) {
            desde = registroCabeza.getNodoProximo();
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
     *  
     */
    public synchronized SLNode<T> contienDato(T dato, SLNode<T> desde) {
        SLNode<T> res = null;
        if (!estaVacio() && desde != null) {
            SLNode<T> actual = desde;
            while (actual.getNodoProximo() != registroCabeza) {
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
     *  
     */
    public synchronized int obtienePosicion(T data) {
        int res = -1;

        if (!estaVacio()) {
            SLNode<T> actual = registroCabeza.getNodoProximo();
            int indice = 0;
            while (actual.getNodoProximo() != registroCabeza) {

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
     * 
     */
    public boolean insertaPosicion(T data, int posicion) {
        boolean res = false;

        if (posicion >= 0 && posicion < tamanyo) {
            if (!estaVacio()) {
                SLNode<T> actual = registroCabeza.getNodoProximo();
                SLNode<T> anterior = registroCabeza;
                int indice = 0;
                while (actual.getNodoProximo() != registroCabeza) {

                    if (posicion == indice) {
                        insertar(anterior, data);
                        break;
                    }
                    indice++;
                    anterior = actual;
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
     * 
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
     * @return elemento A Remover
     * @throws ExcepcionListaVacia
     * @deprecated solo remueve el ultimo y para eso recorre toda la lista
     */
//    public synchronized T remover()
//            throws ExcepcionListaVacia {
//        SLNode NodoARemover = registroCabeza.getNodoProximo();
//        T elementoARemover = null;
//
//        if (estaVacio()) {
//            throw new ExcepcionListaVacia(nombre);
//        }
//
//        elementoARemover = primerNodo.getDato();
//
//        if (primerNodo == primerNodo.getNodoProximo()) {
//            primerNodo = null;
//        } else {
//            SLNode<T> actual = primerNodo;
//            while (actual.getNodoProximo() != primerNodo) {
//                actual = actual.getNodoProximo();
//            }
//            SLNode<T> ultimoNodo = actual;
//
//            primerNodo = primerNodo.getNodoProximo();
//            ultimoNodo.setNodoProximo(primerNodo);
//            primerNodo.setNodoAnterior(ultimoNodo);
//        }
//
//        NodoARemover.setNodoProximo(null);
//        NodoARemover.setNodoAnterior(null);
//
//        tamanyo--;
//
//        return elementoARemover;
//    }
    
    /**
     * Remueve el nodo correspondiente a la posicion indicada
     * @param posicion posicion del nodo a remover
     * @deprecated 
     */
    public synchronized void remover(int posicion){
        remover(getElemento(posicion));
    }
    
    /**
     * Remueve la serie de datos entre las posiciones ingresadas
     * @param inicia posicion desde que se debe remover datos
     * @param finaliza posicion hasta la que se debe remover datos
     * @drecated 
     */
    public synchronized void remover(int inicia, int finaliza){
        
        
        if (!this.estaVacio() && inicia > -1 && finaliza > -1 && finaliza < tamanyo) {

            if (inicia > finaliza) {//intercambia los 
                int tem = inicia;
                
                inicia = finaliza;
                
                finaliza = tem;
                
            }
            
            SLNode<T> anteriordesde = getElemento(inicia-1);
            
            SLNode<T> thisnododesde = anteriordesde.getNodoProximo();
            
            int cuantos = finaliza - inicia;
            
            int indice = 0;

            while (thisnododesde.getNodoProximo() != registroCabeza) {
                if (indice <= cuantos) {
                    
                    anteriordesde.setNodoProximo(thisnododesde.getNodoProximo());
                    
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
     *  
     */
    public synchronized SLNode<T> remover(SLNode nodoARemover) throws ExcepcionListaVacia {

        SLNode<T> res = null;
        
        if (estaVacio()) {
            throw new ExcepcionListaVacia(nombre);
        }

        if (nodoARemover != null) {
            SLNode<T> anterior = anterior(nodoARemover);
            
            if (anterior != null) {//nodo dentro de la lista
                SLNode<T> proximo = nodoARemover.getNodoProximo();
                anterior.setNodoProximo(proximo);
                res = proximo;
                tamanyo--;
            }
            
        } 

        

        return res;
    }

    
    
    /**
     * ingresa un sublista al final
     *
     * @param lista
     * @return si se logro ingresar a la lista
     *  
     */
    public synchronized boolean ingresaLista(ListaCircularSLRCGeneric lista) {
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
     *  
     */
    public synchronized boolean reemplazaLista(ListaCircularSLRCGeneric lista, int posicion) {

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
     *  
     */
    public synchronized int encontrasLista(ListaCircularSLRCGeneric<T> lista) {
        return encontrasLista(lista, 0);
    }

    
    
    //TODO hay que crear una version reversa
    /**
     * Busca una sublista realizando la busqueda desde la posicion dada
     *
     * @param lista lista a buscar
     * @param desde posicion desde la que se va a buscar
     * @return
     *  
     */
    public synchronized int encontrasLista(ListaCircularSLRCGeneric<T> lista, int desde) {

        int res = -1;

        if (lista != null && !estaVacio() && !lista.estaVacio() && desde > -1 && desde <= tamanyo ) {

            SLNode<T> thisnododesde = getElemento(desde);
            
            if (lista.tamanyo() <= tamanyo && thisnododesde != null) {
                

                SLNode<T> listanododesde = lista.getElemento(0);
                SLNode<T> finallista = lista.ultimo();
                int indice = desde;
                int indicelista = 0;
                boolean anterior = false;
                while ((thisnododesde.getNodoProximo() != registroCabeza) && (listanododesde != finallista )) {

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
                            listanododesde = lista.getElemento(0);
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
     * retorna el nodo en la posicion establecida, comienza desde 0
     *
     * @param posicion posision por la cual se esta preguntando
     * @return nodo en la posicion establecida o null en caso de no encotrarlo
     *  
     */
    public synchronized SLNode<T> getElemento(int posicion) {
        SLNode<T> res = null;

        if (!estaVacio() && posicion >= 0 && posicion < tamanyo) {

            SLNode<T> actual = registroCabeza.getNodoProximo();
            int indicec = 0;
            do {

                if (posicion == indicec) {

                    res = actual;
                    break;
                }
                indicec++;
                actual = actual.getNodoProximo();
            } while (actual.getNodoProximo() != registroCabeza);

        }

        return res;
    }

    /**
     * determina si la lista es vacia
     *
     * @return verdadero si la lista es vacia
     */
    public synchronized boolean estaVacio() {
        return (registroCabeza == registroCabeza.getNodoProximo());
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

        SLNode<T> actual = registroCabeza.getNodoProximo();

        do {
            System.out.print(actual.getDato().toString() + " ");
            actual = actual.getNodoProximo();
        } while (actual != registroCabeza);

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
    public synchronized ListaCircularSLRCGeneric<T> sublista(int inicia, int finaliza) {
        ListaCircularSLRCGeneric<T> res = null;

//        if (!this.estaVacio() && inicia > -1 && finaliza > -1 && finaliza < tamanyo) {
//
//            if (inicia > finaliza) {
//                int tem = inicia;
//                
//                inicia = finaliza;
//                
//                finaliza = tem;
//                
//            }
//            
//            
//            res = new ListaCircularSLRCGeneric<T>();
//
//            SLNode<T> thisnododesde = getElemento(inicia);
//
//            int indice = inicia;
//
//            while (thisnododesde.getNodoProximo() != primerNodo) {
//                if (indice <= finaliza) {
//                    
//                    T objeto = thisnododesde.getDato();
//                    
//                    res.insertarFinal(objeto);
//                } else {
//                    break;
//                }
//                thisnododesde = thisnododesde.getNodoProximo();
//            }
//
//        }

        return res;
    }
    
    
    /**
     * Retorna una sublista con los valores entre las posiciones ingresadas en 
     * los parametros
     * @param desde posicion desde la que se debe buscar la sublista
     * @param hasta posicion hasta la que se debe buscar la sublista
     * @return una nueva lista con los datos encontrados
     * @deprecated 
     */
    public synchronized ListaCircularSLRCGeneric<T> subHilera(int desde, int hasta){
        
        ListaCircularSLRCGeneric<T> lista = null;
        
        if (!estaVacio() && desde > -1 && hasta > -1) {
            if (hasta < desde) {
                int temp = hasta;
                hasta = desde;
                desde = temp;
            }
            
            lista = new ListaCircularSLRCGeneric<T>(this.nombre);
            
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
     * @deprecated 
     */
    public ListIterator<T> iterator(int desde) {
        ListIterator<T> iterator = null;

        if (!estaVacio() && desde > -1) {
            //iterator = new DoublyLinkedListIterator(primerNodo,tamanyo);
            iterator = new SimpleLinkedListCircularRCIterator<T>(getElemento(desde), this);
        }

        return iterator;
    }
    
    /**
     * retorna un objeto iterator desde el primer nodo
     * @return 
     * @deprecated 
     */
    public ListIterator<T> iterator() {

        ListIterator<T> iterator = null;

        SLNode<T> primerNodo = registroCabeza.getNodoProximo();
        if (primerNodo != registroCabeza) {
            //iterator = new DoublyLinkedListIterator(primerNodo,tamanyo);
            iterator = new SimpleLinkedListCircularRCIterator<T>(primerNodo,  this);
        }

        return iterator;
    }

    /**
     * retorna un objeto iterator desde un nodo en expecifico
     * @param desde
     * @return 
     * @deprecated 
     */
    public ListIterator<T> iterator(SLNode<T> desde) {

        ListIterator<T> iterator = null;

        if (desde != null) {
            //iterator = new DoublyLinkedListIterator(desde, tamanyo);
            iterator = new SimpleLinkedListCircularRCIterator<T>(desde,  this);
        }

        return iterator;
    }

    /**
     * Retorna el ultimo elemento de la lista o null si la lista es vacia
     * @return 
     */
    public SLNode<T> ultimo(){
    
        SLNode<T> ultimo = null;
        
        if (!estaVacio()) {
            ultimo = registroCabeza.getNodoProximo();
            while (ultimo.getNodoProximo() != registroCabeza) {
                
                ultimo = ultimo.getNodoProximo();
            }
        }
        
        
        return ultimo;
        
    }
    
    /**
     * Retorna el registro anterior al ingresado por el parametro, si el
     * nodo no pertenece a la lista retorna null
     * @param actual
     * @return 
     */
    public SLNode<T> anterior(SLNode<T> actual){
    
        SLNode<T> anterior = null;
        
        if (actual != null) {
            SLNode<T> temp = null;
            
            anterior = registroCabeza;
            
            temp = registroCabeza.getNodoProximo();
            
            while ((temp != registroCabeza) && (temp != actual)) {
                anterior = temp;
                temp= temp.getNodoProximo();
                
            }
            
            if(temp == registroCabeza){
                anterior = null;
            }
        }
        
        return anterior;
        
    }
    
    
    public SLNode<T> remover(){
    
         SLNode<T> ultimo = null;
        
        if (!estaVacio()) {
            SLNode<T> anterior = registroCabeza;
            ultimo = registroCabeza.getNodoProximo();
            while (ultimo.getNodoProximo() != registroCabeza) {
                anterior = ultimo;
                ultimo = ultimo.getNodoProximo();
            }
            anterior.setNodoProximo(ultimo.getNodoProximo());
            
        }
        
        return ultimo;
        
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
