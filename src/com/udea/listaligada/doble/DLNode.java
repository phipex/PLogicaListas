/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.listaligada.doble;

import java.util.Objects;

/**
 *  Clase que representa un nodo  con liga doble que admite datos genericos
 * @author Andres Felipe Montoya
 */
public class DLNode<T> {
    
    /**
     * Dato del nodo
     */
    private T dato;
    
    /**
     * Proximo nodo (derecha)
     */
    private DLNode<T> nodoProximo;
    
    /**
     * Anterior nodo (izquierda)
     */
    private DLNode<T> nodoAnterior;
    
    /**
     * Constructor con los valores nulos
     */
    DLNode(){
        nodoProximo=null;
        nodoAnterior=null;
        dato=null;
    }
    
    /**
     * Contrusctor con el valor y los nodo nulos
     * @param data Parametro generico que representa el dato en la lista
     */
    DLNode(T data) {
        this(data, null, null);
    }
    
    /**
     * Constructor con todos los parametros
     * @param data dato del nodo
     * @param next proximo dato
     * @param prev anterior dato
     */
    DLNode(T data, DLNode<T> next, DLNode<T> prev) {
        this.dato = data;
        this.nodoProximo = next;
        this.nodoAnterior = prev;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public DLNode<T> getNodoProximo() {
        return nodoProximo;
    }

    public void setNodoProximo(DLNode<T> nodoProximo) {
        this.nodoProximo = nodoProximo;
    }

    public DLNode<T> getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(DLNode<T> nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.dato);
        hash = 37 * hash + Objects.hashCode(this.nodoProximo);
        hash = 37 * hash + Objects.hashCode(this.nodoAnterior);
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
        final DLNode<T> other = (DLNode<T>) obj;
        if (!Objects.equals(this.dato, other.dato)) {
            return false;
        }
        if (!Objects.equals(this.nodoProximo, other.nodoProximo)) {
            return false;
        }
        if (!Objects.equals(this.nodoAnterior, other.nodoAnterior)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (dato != null && nodoAnterior != null && nodoProximo != null) {
            return "DLNode{" + "dato=" + dato + ", nodoProximo=" + nodoProximo + ", nodoAnterior=" + nodoAnterior + '}';
        } else {
            return "DLNode{ Nodo Vacio )";
        }
    }

   
}