
package com.udea.listaligada.doble;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Clase que implementa la interface java.util.ListIterator para recorrer listas
 * doblemente ligadas circulares
 * @author Andres Felipe Montoya
 */
public class DoubleLinkedListCircularIterator<T>  implements ListIterator<T>{
          
       //TODO convertir para crear una version reversa segun parametro
        
        /**
         * contructor de la clase
         * @param desde nodo desde donde empieza a iterar por la lista
         * @param size tamaño de la lista
         * @param lista lista a la cual debe 
         */
        public DoubleLinkedListCircularIterator(DLNode<T> desde, ListaCircularDLGeneric<T> lista){
            this.current =  desde;
            this.size = lista.tamanyo();
            this.lista = lista;
        }
        
        /**
         * Lista por la cual se va a iterar
         */
        private ListaCircularDLGeneric<T> lista;
        
        /**
         * tamañio de la lista
         */
        private int size;
        
        /**
         * nodo actual en la iteracion
         */
        private DLNode<T> current =  null;  // the node that is returned by next()

        /**
         * nodo previamente accedido
         */
        private DLNode<T> lastAccessed = null;      // the last node to be returned by prev() or next()
        // reset to null upon intervening remove() or add()
        
        /**
         * Indice del recorrido
         */
        public int index = 0;
        
        /**
         * Retorna verdadero si continua mas elementos
         * @return verdadero si continua mas elementos
         */
        @Override
        public boolean hasNext() {
            return (index < size) &&
                    ((lastAccessed == null)||//empezo desde el primero
                    //(current != null) &&
                    (current != lista.getElemento(0)));
        }
        
        /**
         * Retorna verdadero si hay elementos previos
         * @return verdadero si hay elementos previos
         */
        @Override
        public boolean hasPrevious() {
            return (index > 0) &&
                    ((lastAccessed == null)||//empezo desde el primero
                    //(current != null) &&
                    (current != lista.getElemento(0)));
        }
        
        /**
         * Retorna el anterior indice
         * @return anterior indice
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }
        
        /**
         * Retorna el proximo indice
         * @return proximo indice
         */
        @Override
        public int nextIndex() {
            return index;
        }
        
        /**
         * Retorna el siguiente elemento en el recorrido
         * @return siguiente elemento en el recorrido
         */ 
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastAccessed = current;
            T item = (T)current.getDato();
            current = current.getNodoProximo();
            index++;
            return item;
        }
        
        /**
         * Retorna el elemento previo en el recorrido
         * @return elemento previo
         */
        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = current.getNodoAnterior();
            index--;
            lastAccessed = current;
            return (T)current.getDato();
        }
        
        /**
         * Remueve el elemento el ultimo elemento retornado
         */
        @Override
        public void remove() {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            lista.remover(lastAccessed);
            if (current == lastAccessed) {
                current = lastAccessed.getNodoProximo();
            } else {
                index--;
            }
            lastAccessed = null;
        }
        
        /**
         * Cambia el dato del ultimo nodo visitado
         * @param e dato a ser ingresado
         */
        @Override
        public void set(T e) {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            lastAccessed.setDato(e);
        }
        
        /**
         * Ingresa un nuevo nodo en la lista en la ultima ubicacion
         * @param e dato a ser ingresado
         */
        @Override
        public void add(T e) {
            lista.insertar(current, e);
            index++;
            lastAccessed = null;
        }

        
        
        
    }
    