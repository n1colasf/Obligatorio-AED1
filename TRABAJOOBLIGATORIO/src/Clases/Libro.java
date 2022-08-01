package Clases;

import Listas.ListaCalificaciones;
import Listas.ListaColaEspera;
import Listas.ListaReservas;



public class Libro implements Comparable<Libro> {
 
    private String titulo;
    private String editorial;
    private int cantEjemplares;
    private String nombreBiblioteca;
    private ListaReservas reservas = new ListaReservas();
    private ListaColaEspera colaEspera = new ListaColaEspera();
    private ListaCalificaciones listaCalificaciones = new ListaCalificaciones();
    private double promedioCalificaciones;
    private int cantidadReservas;
    
    public Libro(String titulo,String editorial,int ejemplares,String biblioteca){
        this.setTitulo(titulo);
        this.setEditorial(editorial);
        this.setCantEjemplares(ejemplares);
        this.setNombreBiblioteca(biblioteca);
        this.setReservas(reservas);
        this.setColaEspera(colaEspera);
        this.setListaCalificaciones(listaCalificaciones);
        this.setCantidadReservas(0);
    }
    
    public Libro(String titulo,String editorial,String biblioteca){
        this.setTitulo(titulo);
        this.setEditorial(editorial);
        this.setNombreBiblioteca(biblioteca);
        this.setReservas(reservas);
        this.setColaEspera(colaEspera);
    }
    
    public Libro(){}
    
    public void Promedio(int calificacion){
        listaCalificaciones.agregarInicio(calificacion);
        double promedio = 0;
        int largo = listaCalificaciones.getCantidad();
        NodoCalificacion actual = listaCalificaciones.getInicio();
        while (actual !=null){
            promedio = promedio + actual.getDato();
            actual = actual.getSiguiente();
        }
        promedio = promedio / largo;
        setPromedioCalificaciones(promedio);
    }
    
    
    public void SetearCantReservas (){
        this.setCantidadReservas(this.reservas.getCantidad() + this.colaEspera.getCantidad());
    }
    
    public void restarEjemplares(){
        cantEjemplares--;
    }
    
    public void sumarEjemplares(){
        cantEjemplares++;
    }
    
    @Override
    public int compareTo(Libro libro){
        if(this.promedioCalificaciones < libro.promedioCalificaciones){
            return -1;
        }
        else if(libro.promedioCalificaciones < this.promedioCalificaciones){
            return 1;
        }else{
            return 0;
        }
    }
    
      public int compareToReserva(Libro libro){
        if(this.cantidadReservas < libro.cantidadReservas){
            return -1;
        }
        else if(libro.cantidadReservas < this.cantidadReservas){
            return 1;
        }else{
            return 0;
        }
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }


    /**
     * @return the cantEjemplares
     */
    public int getCantEjemplares() {
        return cantEjemplares;
    }

    /**
     * @param cantEjemplares the cantEjemplares to set
     */
    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    /**
     * @return the nombreBiblioteca
     */
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    /**
     * @param nombreBiblioteca the nombreBiblioteca to set
     */
    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    /**
     * @return the reservas
     */
    public ListaReservas getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(ListaReservas reservas) {
        this.reservas = reservas;
    }

    /**
     * @return the colaEspera
     */
    public ListaColaEspera getColaEspera() {
        return colaEspera;
    }

    /**
     * @param colaEspera the colaEspera to set
     */
    public void setColaEspera(ListaColaEspera colaEspera) {
        this.colaEspera = colaEspera;
    }
    
    @Override
    public boolean equals(Object o){
           boolean ret = false;
           if (this.getEditorial().equalsIgnoreCase(((Libro)o).getEditorial()) && this.getTitulo().equalsIgnoreCase(((Libro)o).getTitulo()) && 
               this.getNombreBiblioteca().equalsIgnoreCase(((Libro)o).getNombreBiblioteca()) ){
               ret = true;
           }
           return ret;
    }
    
    public boolean equalsTituloEditorial(Object o){
           boolean ret = false;
           if (this.getEditorial().equalsIgnoreCase(((Libro)o).getEditorial()) && this.getTitulo().equalsIgnoreCase(((Libro)o).getTitulo())){
               ret = true;
           }
           return ret;
    }
       /**
     * @return the promedioCalificaciones
     */
    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    /**
     * @param promedioCalificaciones the promedioCalificaciones to set
     */
    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    /**
     * @return the cantidadReservas
     */
    public int getCantidadReservas() {
        return cantidadReservas;
    }

    /**
     * @param cantidadReservas the cantidadReservas to set
     */
    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    /**
     * @return the listaCalificaciones
     */
    public ListaCalificaciones getListaCalificaciones() {
        return listaCalificaciones;
    }

    /**
     * @param listaCalificaciones the listaCalificaciones to set
     */
    public void setListaCalificaciones(ListaCalificaciones listaCalificaciones) {
        this.listaCalificaciones = listaCalificaciones;
    }
    
}
