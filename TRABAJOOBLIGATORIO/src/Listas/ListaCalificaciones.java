/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import Clases.NodoCalificacion;

/**
 *
 * @author 59898
 */
public class ListaCalificaciones {
    
    private NodoCalificacion inicio;
    private NodoCalificacion ultimo;
    private int cantidad;

    //Constructor   
    public ListaCalificaciones() {
        inicio = null;
        ultimo = null;
        cantidad =0;
    }

    public boolean esVacia() {
        return getInicio() == null;
    }

    
    public void agregarInicio(int objeto) {
        NodoCalificacion nuevo = new NodoCalificacion(objeto); 
        if(this.esVacia()){
            inicio = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.setSiguiente(getInicio());
            inicio = nuevo;
        }   
        cantidad++;
    }

    /**
     * @return the inicio
     */
    public NodoCalificacion getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(NodoCalificacion inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the ultimo
     */
    public NodoCalificacion getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoCalificacion ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
