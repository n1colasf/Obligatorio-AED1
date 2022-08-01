
package Interfaces;

import Clases.Reserva;


public interface ICola<T> {
    
    public void encolar(T dato);
    public void desencolar() ;  
    public boolean esVacia(); 
    public boolean esllena();
    public int  cantElementos() ;  
    public Reserva frente();
    public String mostrarCola();
}
