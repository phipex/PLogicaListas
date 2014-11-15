
package com.udea.listaligada.simple;

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

