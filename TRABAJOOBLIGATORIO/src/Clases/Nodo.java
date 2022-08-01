
package Clases;


public class Nodo<T> {
     //Atributos
    private T dato;
    private Nodo siguiente;
    private Nodo anterior;
    
    //Constructor
    public Nodo(T elDato){
        this.setDato(elDato);
        this.setSiguiente(null);
        this.setAnterior(null);
    }


    public T getDato() {
        return dato;
    }


    public void setDato(T dato) {
        this.dato = dato;
    }


    public Nodo getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public Nodo getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
}
