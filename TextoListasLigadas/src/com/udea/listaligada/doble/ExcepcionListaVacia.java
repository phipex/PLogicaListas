/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.listaligada.doble;

/**
 * Exepction lanzada cuando una lista ligada no contiene nodos
 * @author Andres Felipe Montoya
 */
public class ExcepcionListaVacia extends RuntimeException {

   // inicializa an ExcepcionListaVacia
   public ExcepcionListaVacia( String nombre )
   {
      super( "La lista " + nombre + " esta vacía" );
   }

}  // fin de la clase ExcepcionListaVacia

