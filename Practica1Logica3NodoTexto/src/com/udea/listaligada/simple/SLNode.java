/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.listaligada.simple;


import java.util.Objects;

/**
 *  Clase que representa un nodo  con liga doble que admite datos genericos
 * @author Andres Felipe Montoya
 */
public class SLNode<T> {
    
    /**
     * Dato del nodo
     */
    private T dato;
    
    /**
     * Proximo nodo (derecha)
     */
    private SLNode<T> nodoProximo;
    
    
    
    /**
     * Constructor con los valores nulos
     */
    SLNode(){
        nodoProximo=null;
        
        dato=null;
    }
    
    /**
     * Contrusctor con el valor y los nodo nulos
     * @param data Parametro generico que representa el dato en la lista
     */
    SLNode(T data) {
        this(data, null);
    }
    
    /**
     * Constructor con todos los parametros
     * @param data dato del nodo
     * @param next proximo dato
     * @param prev anterior dato
     */
    SLNode(T data, SLNode<T> next) {
        this.dato = data;
        this.nodoProximo = next;
        
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public SLNode<T> getNodoProximo() {
        return nodoProximo;
    }

    public void setNodoProximo(SLNode<T> nodoProximo) {
        this.nodoProximo = nodoProximo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.dato);
        hash = 59 * hash + Objects.hashCode(this.nodoProximo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SLNode<?> other = (SLNode<?>) obj;
        if (!Objects.equals(this.dato, other.dato)) {
            return false;
        }
        if (!Objects.equals(this.nodoProximo, other.nodoProximo)) {
            return false;
        }
        return true;
    }

    

    

   
}