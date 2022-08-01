package Listas;

import Clases.Libro;
import Clases.Nodo;
import Interfaces.ILista;


public class ListaLibros implements ILista<Libro> {

    private Nodo<Libro> primero;
    private Nodo<Libro> ultimo;
    private int cantidad;
    
    
    public boolean tieneReserva(){
        boolean tiene = false;
        if (!this.esVacia()) {
            Nodo<Libro> actual = getPrimero();
            while(actual != null && actual.getDato().getCantidadReservas() == 0){
                actual = actual.getSiguiente();
            }
            if (actual !=null) {
                tiene = true;
            }
        }
        return tiene;
    }

    @Override
    public void agregarInicio(Libro objeto) {
        
        Nodo<Libro> nuevo = new Nodo(objeto);

        if (this.esVacia()) {   
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
        cantidad++;
    }
    
    @Override
    public boolean esVacia() {
       return getPrimero() == null;
    }
    
    public Nodo<Libro> buscarLibroReserva(int cliente, int numero){                      
        Nodo <Libro> actual = getPrimero();
                while(actual.getDato().getReservas().obtenerNodoPorNumeroCliente(numero, cliente) == null && actual.getSiguiente() != null){
                     actual = actual.getSiguiente();
                }
                if(actual.getDato().getReservas().obtenerNodoPorNumeroCliente(numero, cliente) != null){
                    return actual;
                }
        return null;
    }
    
    public Nodo<Libro> buscarLibroColaEspera(int cliente, int numero){                      
            Nodo <Libro> actual = getPrimero();
                    while(actual.getDato().getColaEspera().obtenerNodoPorNumeroCliente(numero, cliente) == null && actual.getSiguiente() != null){
                         actual = actual.getSiguiente();
                    }
                    if(actual.getDato().getColaEspera().obtenerNodoPorNumeroCliente(numero, cliente) != null){
                        return actual;
                    } 
            return null;
    }
    
    @Override
    public void agregarFinal(Libro libro) {
        Nodo<Libro> nuevo = new Nodo(libro);
        
        if (this.esVacia()) {
            primero = nuevo;
            primero = ultimo;
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        cantidad++;
    }

    @Override
    public void borrarInicio() {
        
        if (!this.esVacia()) {

            if (primero == ultimo) {
                ultimo = null;
                primero = null;
            }
            else{
                Nodo borrar = primero;
                primero = borrar.getSiguiente();
                primero.setAnterior(null);
                borrar.setSiguiente(null);
            }
            cantidad--;
        }
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {

            if (cantidad == 1) {
                vaciar();
            } else {
                Nodo borrar = ultimo;
                ultimo = borrar.getAnterior();
                ultimo.setSiguiente(null);
                borrar.setAnterior(null);
 
                cantidad--;
            }
        }
    }

    @Override
    public void vaciar() {
        ultimo = null;
        primero = null;
        cantidad = 0;
    }

    @Override
    public String mostrar() {
        String ret = "";
        Nodo<Libro> actual = getPrimero();
        int contador = 0;

        while (actual != null) {
            contador++;
            ret += contador + " - " + actual.getDato().getTitulo() + "\n" ;
            actual = actual.getSiguiente();
        }
        return ret;
    }
    
    public String mostrarConCalif() {
        String ret = "";
        Nodo<Libro> actual = getPrimero();

        while (actual != null) {
            ret += actual.getDato().getTitulo() + " - " + actual.getDato().getEditorial() + "  " + actual.getDato().getNombreBiblioteca() + " - " + actual.getDato().getPromedioCalificaciones() + "\n" ;
            actual = actual.getSiguiente();
        }
        return ret;
    }

    @Override
    public int cantElementos() {
        return getCantidad();
    }

    @Override
    public boolean estaElemento(Libro n) {
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

      public boolean estaElementoTituloEditorial(Libro n) {
        boolean esta = false;
        if (!this.esVacia()) {
            Nodo<Libro> actual = getPrimero();
            while (actual != null && !actual.getDato().equalsTituloEditorial(n)) {
                actual = actual.getSiguiente();
            }
            if (actual != null) {
                esta = true;
            }
        }
        return esta;      
    }

    @Override
    public void borrarElemento(Libro n) {
        if (!this.esVacia()) {
            if (primero.getDato().equals(n)) {
                borrarInicio();
            } 
            else{
                if (ultimo.getDato().equals(n)) {
                    borrarFin();
                } 
                else{
                    Nodo actual = getPrimero();
                    while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(n)) {
                        actual = actual.getSiguiente();
                    }
                    if (actual.getSiguiente() != null) {

                       Nodo aBorrar = actual.getSiguiente();
                       aBorrar.getAnterior().setSiguiente(aBorrar.getSiguiente());
                       aBorrar.getSiguiente().setAnterior(aBorrar.getAnterior());

                       aBorrar.setSiguiente(null);
                       aBorrar.setAnterior(null);

                       cantidad--;
                   }
                }
            }
        }
    }
   
    
    public Nodo<Libro> obtenerNodoPorNombre(String titulo, String editorial) {
        
        Nodo<Libro> aux = this.primero;
        while (aux != null){
            if (aux.getDato().getTitulo().equalsIgnoreCase(titulo) && aux.getDato().getEditorial().equalsIgnoreCase(editorial)){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public void agregarOrd(Libro libro) {  
        if (this.esVacia()) {
            agregarInicio(libro);
        }
        else{
            primero = agregarOrdRecursivo(primero,libro);
        }
    }
    
    private Nodo<Libro> agregarOrdRecursivo (Nodo<Libro> nodo, Libro dato){
        if (nodo == null || (nodo.getDato().compareTo(dato) < 0)) {
            Nodo<Libro> nuevo = new Nodo(dato);
            if (nodo != null) {
                nodo.setAnterior(nuevo);
            }
            nuevo.setSiguiente(nodo);
            this.agregarFinal(nuevo.getDato());
            return nuevo;
        }
        Nodo llamada = agregarOrdRecursivo(nodo.getSiguiente(), dato);
        llamada.setAnterior(nodo);
        nodo.setSiguiente(llamada);
        
        return nodo;
    }
    
     public void agregarOrdReserva(Libro libro) {  
        if (this.esVacia()) {
            agregarInicio(libro);
        }
        else{
            primero = agregarOrdRecursivoReserva(primero,libro);

        }
    }
    
    private Nodo<Libro> agregarOrdRecursivoReserva (Nodo<Libro> nodo, Libro dato){
        if (nodo == null || (nodo.getDato().compareToReserva(dato) < 0)) {
            Nodo<Libro> nuevo = new Nodo(dato);
            if (nodo != null) {
                nodo.setAnterior(nuevo);
            }
            nuevo.setSiguiente(nodo);
            this.agregarFinal(nuevo.getDato());
            return nuevo;
        }
        Nodo llamada = agregarOrdRecursivoReserva (nodo.getSiguiente(),dato);
        llamada.setAnterior(nodo);
        nodo.setSiguiente(llamada);
        return nodo;
    }

    /**
     * @return the primero
     */
    public Nodo<Libro> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<Libro> primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public Nodo<Libro> getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo<Libro> ultimo) {
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
