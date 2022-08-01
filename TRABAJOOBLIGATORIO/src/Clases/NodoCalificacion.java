/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author 59898
 */
public class NodoCalificacion {
     //Atributos
    private int dato;
    private NodoCalificacion siguiente;
    
    //Constructor
    public NodoCalificacion(int elDato){
        this.setDato(elDato);
        this.setSiguiente(null);
    }


    public int getDato() {
        return dato;
    }


    public void setDato(int dato) {
        this.dato = dato;
    }


    public NodoCalificacion getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoCalificacion siguiente) {
        this.siguiente = siguiente;
    }
}
