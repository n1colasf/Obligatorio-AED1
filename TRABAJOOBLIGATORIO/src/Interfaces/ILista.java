
package Interfaces;

import Clases.Nodo;

public interface ILista<T> {
        
    public boolean esVacia();
    public void agregarInicio(T objeto);
    public void agregarFinal(T objeto);
    public void borrarInicio(); 
    public void borrarFin();
    public void vaciar();
    public String mostrar();    
    public int cantElementos();
    public boolean estaElemento(T n);
    public void borrarElemento(T n);
    
}
