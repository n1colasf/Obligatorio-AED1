package Listas;

import Clases.Nodo;
import Clases.NodoComentario;
import Interfaces.IStack;


public class ListaStackComentarios implements IStack {
    
    private NodoComentario ultimo;
    

    @Override
    public void apilar(String comentario) {
        NodoComentario nuevo = new NodoComentario(comentario);
        nuevo.setSiguiente(getUltimo());
        setUltimo(nuevo);
    }
    
    public String Mostrar(){
        String ret = "\n";
        NodoComentario actual = getUltimo();
        while (actual != null) {
            ret = ret + actual.getDato() + "\n ";
            actual = actual.getSiguiente();
        }
        return ret;
    }

    @Override
    public void desapilar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esVacia() {
       return getUltimo() == null;
    }

    @Override
    public boolean esllena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodoComentario cima() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int elementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the ultimo
     */
    public NodoComentario getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoComentario ultimo) {
        this.ultimo = ultimo;
    }
    
}
