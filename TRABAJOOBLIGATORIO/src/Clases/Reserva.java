package Clases;


public class Reserva {
    
    private int cliente;
    private int numeroReserva;
    private Libro libro;
    
    
    public Reserva(int cliente, int numeroReserva,Libro libro){
        this.setCliente(cliente);
        this.setNumeroReserva(numeroReserva);
        this.setLibro(libro);
    }

    public Reserva(int cliente, int numeroReserva){
        this.setCliente(cliente);
        this.setNumeroReserva(numeroReserva);
    }
    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the reserva
     */
    public int getNumeroReserva() {
        return numeroReserva;
    }

    /**
     * @param numeroReserva the numeroReserva to set
     */
    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public boolean equals(Object o){
           boolean ret = false;
           if (this.getNumeroReserva() == ((Reserva)o).getNumeroReserva() &&  this.getCliente() == ((Reserva)o).getCliente() 
                   && this.getLibro().getNombreBiblioteca().equalsIgnoreCase(((Reserva)o).getLibro().getNombreBiblioteca())){
               ret = true;
           }
           return ret;
    }
}
