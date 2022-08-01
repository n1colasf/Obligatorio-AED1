
package Clases;


public class NodoComentario {
      //Atributos
    private String comentario;
    private NodoComentario siguiente;
    
    //Constructor
    public NodoComentario(String elComentario){
        this.setDato(elComentario);
        this.setSiguiente(null);
    }


    public String getDato() {
        return comentario;
    }


    public void setDato(String dato) {
        this.comentario = dato;
    }


    public NodoComentario getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoComentario siguiente) {
        this.siguiente = siguiente;
    }
}
