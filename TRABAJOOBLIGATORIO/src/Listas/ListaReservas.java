
package Listas;

import Clases.Nodo;
import Clases.Reserva;
import Interfaces.ILista;


public class ListaReservas implements ILista<Reserva> {

    private Nodo<Reserva> primero;
    private Nodo<Reserva> ultimo;
    private int cantidad;
    
    @Override
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public void agregarInicio(Reserva objeto) {
        Nodo nuevo = new Nodo(objeto);
        if (this.esVacia()) {
            ultimo = nuevo;
        }
        nuevo.setSiguiente(getPrimero());
        primero = nuevo;
        objeto.getLibro().restarEjemplares();
        cantidad++;
    }

    @Override
    public void agregarFinal(Reserva objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (cantidad == 1){
                primero = null;
                ultimo = primero;
            }
            else{
                Nodo aBorrar = primero;
                primero = getPrimero().getSiguiente();
                aBorrar.setSiguiente(null);
            }
            cantidad--;
        }
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {

            if (this.cantElementos() == 1) {
                primero = null;
                primero = ultimo;
            } else {
                Nodo actual = getPrimero();
                Nodo siguiente = getPrimero().getSiguiente();
                Nodo aBorrar = ultimo;
                aBorrar.setSiguiente(null);

                while (siguiente.getSiguiente() != null) {
                    
                    actual = siguiente;
                    siguiente = siguiente.getSiguiente();
                }
                
                actual.setSiguiente(null);

            }
            cantidad--;
        }
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }

    @Override
    public boolean estaElemento(Reserva n) {
        boolean esta = false;
        if (!this.esVacia()) {

            Nodo actual = getPrimero();
            boolean nose = actual.getDato().equals(n);
            while (actual != null && !nose) {
                actual = actual.getSiguiente();
            }
            if (actual != null) {
                esta = true;
            }
        }
        return esta;  
    }

    @Override
    public void borrarElemento(Reserva n) {
        if(!this.esVacia()){
            if(getPrimero().getDato().equals(n)){
                borrarInicio();
            }
            else{
                
                Nodo actual = getPrimero();
                
                while(actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(n)){
                    actual = actual.getSiguiente();
                }
                
                if(actual.getSiguiente()!= null){
                    Nodo aBorrar = actual.getSiguiente();
                    actual.setSiguiente(aBorrar.getSiguiente());
                    aBorrar.setSiguiente(null);
                }
                cantidad--;
            }
            n.getLibro().sumarEjemplares();
        }
    }

    /**
     * @return the primero
     */
    public Nodo<Reserva> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<Reserva> primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public Nodo<Reserva> getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo<Reserva> ultimo) {
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
    
     public Nodo<Reserva> obtenerNodoPorNumeroCliente(int numero, int cliente) {
        Nodo<Reserva> aux = this.primero;
        while (aux != null){
            if (aux.getDato().getNumeroReserva() == numero && aux.getDato().getCliente() == cliente){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    
}
