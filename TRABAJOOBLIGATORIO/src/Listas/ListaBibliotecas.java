package Listas;

import Clases.Biblioteca;
import Clases.Libro;
import Clases.Nodo;
import Interfaces.ILista;


public class ListaBibliotecas implements ILista<Biblioteca> {
    
    private Nodo<Biblioteca> primero;
    private Nodo<Biblioteca> ultimo;
    private int cantElementos;
    
    public ListaBibliotecas(){
        primero = null;
        ultimo = null;
        cantElementos = 0;
    }
    
    @Override
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public void agregarInicio(Biblioteca objeto) {
        Nodo nuevo = new Nodo(objeto);

        if (this.esVacia()) {
            ultimo = nuevo;
        }
        nuevo.setSiguiente(getPrimero());
        primero = nuevo;
        cantElementos++;

    }

    @Override
    public void agregarFinal(Biblioteca objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarInicio() {
   if (!this.esVacia()) {
            
            if(primero == ultimo){
                ultimo = null;
            }
            
            primero = getPrimero().getSiguiente();   
            cantElementos--;
            
        } else {
            System.out.println("Esta vacia");
        }    }

    @Override
    public void borrarFin() {
            if (!this.esVacia()) {

            if (cantElementos == 1) {
                vaciar();
            } else {
               
                Nodo actual = getPrimero();

                while (actual.getSiguiente() != ultimo) {                   
                    actual = actual.getSiguiente();
                }
                
                actual.setSiguiente(null);
                ultimo = actual;
                
                cantElementos--;
            }              

        }    
    }

    @Override
    public void vaciar() {
        setPrimero(null); //To change body of generated methods, choose Tools | Templates.
        setUltimo(null);
        cantElementos = 0;
    }

    @Override
    public String mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantElementos() {
        return cantElementos;
    }
    
    @Override
    public boolean estaElemento(Biblioteca n) {
        boolean esta = false;

        if (!this.esVacia()) {

            Nodo actual = getPrimero();

            while (actual != null && !actual.getDato().equals(n)) {
                actual = actual.getSiguiente();
            }
            if (actual != null) {
                esta = true;
            }
        }
        return esta;    
    }
    
    @Override
    public void borrarElemento(Biblioteca n) {
       
        if(!this.esVacia()){
            if(getPrimero().getDato().equals(n)){
                borrarInicio();
            }
            else{
                if(ultimo.getDato().equals(n)){
                    borrarFin();
                }
                else{
                    Nodo actual = getPrimero().getSiguiente();
                    while(actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(n)){
                         actual = actual.getSiguiente();
                    }
                    if(actual.getSiguiente()!= null){
                        Nodo aBorrar = actual.getSiguiente();
                        actual.setSiguiente(aBorrar.getSiguiente());
                        aBorrar.setSiguiente(null);
                        cantElementos--;
                    }
                }
            }
        }
    }
    
    public ListaLibros listaLibrosGeneral(){
        ListaLibros listaLibrosGeneral = new ListaLibros();
        Nodo<Biblioteca> actual = getPrimero();
        while (actual != null) {
            Biblioteca bibliotecaActual = actual.getDato();
            ListaLibros ListaLibrosBibActual = bibliotecaActual.getListaLibros();
            Nodo<Libro> libroActualListaActual = ListaLibrosBibActual.getPrimero();
            while (libroActualListaActual != null && !listaLibrosGeneral.estaElemento(libroActualListaActual.getDato())) {
                listaLibrosGeneral.agregarOrd(libroActualListaActual.getDato());
                libroActualListaActual = libroActualListaActual.getSiguiente();                  
            }
            actual = actual.getSiguiente();
        }
        return listaLibrosGeneral;
    }   
    
    public ListaLibros ListaLibrosUnicos(){
        ListaLibros lista = listaLibrosGeneral();
        ListaLibros listaUnicaOrdenada = new ListaLibros();
        Nodo<Libro> actual = lista.getPrimero();
        while(actual !=null){
            int cantidad = actual.getDato().getCantidadReservas();
            Libro libro = new Libro();
            libro.setTitulo(actual.getDato().getTitulo());
            libro.setEditorial(actual.getDato().getEditorial());
            libro.setCantidadReservas(cantidad);
            Nodo<Libro> proximo = actual.getSiguiente();
            while(proximo != null && !listaUnicaOrdenada.estaElementoTituloEditorial(libro)){
                if (actual.getDato().equalsTituloEditorial(proximo.getDato())) {                   
                    cantidad = cantidad + proximo.getDato().getCantidadReservas();
                    libro.setCantidadReservas(cantidad);             
                }
                
                proximo = proximo.getSiguiente();
            }
            if (!listaUnicaOrdenada.estaElementoTituloEditorial(libro)) {
                listaUnicaOrdenada.agregarOrdReserva(libro);
            }
            actual = actual.getSiguiente();
        }
        return listaUnicaOrdenada;
    } 
    
    /**
     * @return the primero
     */
    public Nodo<Biblioteca> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<Biblioteca> primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public Nodo<Biblioteca> getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo<Biblioteca> ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the cantElementos
     */
    public int getCantElementos() {
        return cantElementos;
    }

    /**
     * @param cantElementos the cantElementos to set
     */
    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }
   
    
    public Nodo<Biblioteca> obtenerNodoPorNombre(String nombre) {
        Nodo<Biblioteca> aux = this.primero;
        while (aux != null){
            if (aux.getDato().getNombre().equalsIgnoreCase(nombre)){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

}
