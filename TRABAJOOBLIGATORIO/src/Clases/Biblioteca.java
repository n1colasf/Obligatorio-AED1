package Clases;

import Listas.ListaLibros;
import Listas.ListaStackComentarios;



public class Biblioteca {
    
    private String nombre;
    private ListaLibros listaLibros = new ListaLibros();
    private ListaStackComentarios listaStackComentarios = new ListaStackComentarios();
    
     //Constructor
    public Biblioteca(String nombre){
        this.setNombre(nombre);
        this.setListaLibros(this.listaLibros);
        this.setListaStackComentarios(this.listaStackComentarios);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the listaLibros
     */
    public ListaLibros getListaLibros() {
        return listaLibros;
    }

    /**
     * @param listaLibros the listaLibros to set
     */
    public void setListaLibros(ListaLibros listaLibros) {
        this.listaLibros = listaLibros;
    }

    /**
     * @return the listaStackComentarios
     */
    public ListaStackComentarios getListaStackComentarios() {
        return listaStackComentarios;
    }

    /**
     * @param listaStackComentarios the listaStackComentarios to set
     */
    public void setListaStackComentarios(ListaStackComentarios listaStackComentarios) {
        this.listaStackComentarios = listaStackComentarios;
    }
    
    
    public boolean equals(Object o){
        return this.getNombre().equalsIgnoreCase(((Biblioteca)o).getNombre());
    }
    
    
}
