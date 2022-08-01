package Listas;

import Clases.Nodo;
import Clases.Reserva;
import Interfaces.ICola;


public class ListaColaEspera implements ICola<Reserva> {
    
    private Nodo<Reserva> primero;
    private Nodo<Reserva> ultimo;
    private int cantidad;
    

    @Override
    public void encolar(Reserva dato) {
        Nodo nuevo = new Nodo(dato);

        if (this.esVacia()) {
            ultimo = nuevo;
            primero = nuevo;
        }
        else{
            nuevo.setSiguiente(getPrimero());
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        cantidad++;
    }

    @Override
    public void desencolar() {
        if (!this.esVacia()) {
            if (cantidad == 1) {
                
                primero = null; //To change body of generated methods, choose Tools | Templates.
                ultimo = null;
                cantidad = 0;
            } else {
                Nodo actual = getPrimero();

                while (actual.getSiguiente() != ultimo) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
                ultimo.setAnterior(actual.getAnterior());
                ultimo = actual;
                cantidad--;
            } 
        }
    }
    
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
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public boolean esllena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }

    @Override
    public Reserva frente() {
        Reserva ret = null;

        if (!this.esVacia()) {
            ret = ultimo.getDato();
        }
        
        return ret;
    }
    
    public void borrarElemento(Reserva n) {
        if(!this.esVacia()){
            if(ultimo.getDato() == n){
                desencolar();
            }
            else{

                Nodo actual = getPrimero();

                while(actual.getSiguiente() != null && actual.getSiguiente().getDato() != n){
                     actual = actual.getSiguiente();
                }

                if(actual.getSiguiente()!= null){
                    Nodo aBorrar = actual.getSiguiente();
                    actual.setSiguiente(aBorrar.getSiguiente());
                    aBorrar.setSiguiente(null);
                }
            }
            cantidad--;
        }
    }

    @Override
    public String mostrarCola() {
        Nodo<Reserva> mostrar = getUltimo();
        String resultado = "";
        int contador=0;

        while (mostrar != null) {
            contador++;
            resultado += contador + " - " + mostrar.getDato().getCliente() + "\n";
            mostrar = mostrar.getAnterior();
        }
        return resultado; 
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
