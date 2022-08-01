package Interfaces;

import Clases.NodoComentario;

public interface IStack {
    public void apilar(String dato);
    public void desapilar();
    public boolean esVacia();
    public boolean esllena();
    public NodoComentario cima();
    public int elementos();
}
