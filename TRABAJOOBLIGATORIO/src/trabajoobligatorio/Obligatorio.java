
package trabajoobligatorio;

import Clases.Biblioteca;
import Clases.Libro;
import Clases.Matriz;
import Clases.Nodo;
import Clases.Reserva;
import Interfaces.IObligatorio;
import Listas.ListaBibliotecas;
import Listas.ListaLibros;
import Listas.ListaStackComentarios;

public class Obligatorio  implements IObligatorio{
    
    private ListaBibliotecas bibliotecas;
   
    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        bibliotecas = new ListaBibliotecas();
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
         bibliotecas.vaciar();
         return ret;
    }

    @Override
    public Retorno registrarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        ret.valorEntero = 0;
        
        Biblioteca b = new Biblioteca(Biblioteca);
        if(!bibliotecas.estaElemento(b)){
            bibliotecas.agregarInicio(b);
            System.out.println("Se registró la biblioteca " + Biblioteca);
            ret.resultado = Retorno.Resultado.OK;
        }
        else{
            ret.resultado = Retorno.Resultado.ERROR;
            System.out.println("Ya existe la biblioteca " + Biblioteca);
            ret.valorEntero = 1;
        }
        return ret;
    }

    @Override
    public Retorno eliminarBiblioteca(String Biblioteca) {
         Retorno ret = new Retorno(Retorno.Resultado.ERROR);
         ret.valorEntero = 1;
         Nodo<Biblioteca> nodoBiblioteca = bibliotecas.obtenerNodoPorNombre(Biblioteca);
         if(nodoBiblioteca != null){
            Biblioteca biblioteca = nodoBiblioteca.getDato();
            if (!biblioteca.getListaLibros().tieneReserva()) {
                bibliotecas.borrarElemento(biblioteca);
                System.out.println("Se borro la biblioteca: "+ Biblioteca);
                ret.resultado = Retorno.Resultado.OK;
                ret.valorEntero = 0;
            }
            else{
                ret.valorString = "No se puede eliminar la biblioteca, tiene reservas asociadas";             
            }
        }
        else{
            System.out.println("No existe la biblioteca");
        }
        return ret;
    }
    
    @Override
    public Retorno registrarLibro(String titulo, String editorial, String biblioteca, int ejemplares) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        ret.valorEntero = 0;
        Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
        if(bibliotecaEncontrada != null){
            Libro libro = new Libro(titulo,editorial,ejemplares,biblioteca);
            
            ListaLibros listaLibros = bibliotecaEncontrada.getDato().getListaLibros();
            if (!listaLibros.estaElemento(libro)) {
                listaLibros.agregarInicio(libro);
                System.out.println("Se agregó correctamente el libro " + libro.getTitulo() + " a la biblioteca");
                ret.resultado = Retorno.Resultado.OK;
            }
            else{
                System.out.println("Ya existe el libro " + libro.getTitulo() + " en la biblioteca");
                ret.valorEntero = 1;
            }
        }
        else{
            System.out.println("No existe la biblioteca");
            ret.valorEntero = 2;
            ret.resultado = Retorno.Resultado.ERROR;
            return ret;
        }
        return ret;
    }

    @Override
    public Retorno eliminarLibro(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        ret.valorEntero = 0;
        Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
        if(bibliotecaEncontrada != null){
            Nodo<Libro> nodoLibro = bibliotecaEncontrada.getDato().getListaLibros().obtenerNodoPorNombre(titulo, editorial);
            if (nodoLibro == null){
                System.out.println("No existe el libro " + titulo + " en la biblioteca");
                ret.valorEntero = 1;
                ret.resultado = Retorno.Resultado.ERROR;
            }
            else{
                Libro libro = nodoLibro.getDato();
                ListaLibros listaLibros = bibliotecaEncontrada.getDato().getListaLibros();
                if (listaLibros.estaElemento(libro)) {
                    listaLibros.borrarElemento(libro);
                    System.out.println("Se borró correctamente el libro " + titulo + " de la biblioteca");
                    ret.resultado = Retorno.Resultado.OK;
                }
            }
        }
        else{
            System.out.println("No existe la biblioteca " + biblioteca);
        }
        return ret;
    }

    @Override
    public Retorno RegistrarCalificacion(String titulo, String editorial, int calificacion, String biblioteca, String comentario) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        ret.valorEntero = 0;
        
        Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
        if(bibliotecaEncontrada != null){
            
            Nodo<Libro> libroEncontrado = bibliotecaEncontrada.getDato().getListaLibros().obtenerNodoPorNombre(titulo, editorial);
            ListaStackComentarios stackComentarios = bibliotecaEncontrada.getDato().getListaStackComentarios();
            
            if (libroEncontrado != null) {
                Libro libro = libroEncontrado.getDato();
                if (calificacion >= 0 && calificacion <= 5){
                    
                    stackComentarios.apilar(comentario);
                    libro.Promedio(calificacion);
                    ListaLibros listaLibros = bibliotecaEncontrada.getDato().getListaLibros();
                    listaLibros.borrarElemento(libro);
                    listaLibros.agregarOrd(libro);
                    System.out.println("Se ingresó la calificación correctamente");
                    ret.resultado = Retorno.Resultado.OK;  
                }
                else{
                    System.out.println("La calificación debe estar entre 0 y 5"); // agregar este error a valorString
                    ret.valorEntero = 2;
                    ret.resultado = Retorno.Resultado.ERROR;
                }
            }
            else{
                System.out.println("No existe el libro " + titulo + " en la biblioteca"); // agregar este error a valorString
                ret.valorEntero = 1;
                ret.resultado = Retorno.Resultado.ERROR;
            }
        }
        else{
            System.out.println("No existe la biblioteca" + biblioteca); // agregar este error a valorString
        }
        return ret;
    }
    
    @Override
    public Retorno realizarReserva(int cliente, int numero, String biblioteca, String titulo, String editorial, String fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
        if(bibliotecaEncontrada != null){
            Nodo<Libro> nodoLibroEncontrado = bibliotecaEncontrada.getDato().getListaLibros().obtenerNodoPorNombre(titulo, editorial);
            if (nodoLibroEncontrado != null){
                Libro libro = nodoLibroEncontrado.getDato();
                Reserva reserva = new Reserva(cliente,numero, libro);
                if (libro.getCantEjemplares() == 0){
                    libro.getColaEspera().encolar(reserva);
                    ret.resultado = Retorno.Resultado.OK;
                    System.out.println("La reserva quedó en lista de espera");
                }
                else{
                    libro.getReservas().agregarInicio(reserva);
                    ret.resultado = Retorno.Resultado.OK;
                    System.out.println("Se efectuó la reserva correctamente"); 
                }
                    libro.SetearCantReservas();
            }
            else{
                System.out.println("No existe el libro " + titulo + " en la biblioteca");
                ret.valorEntero = 1;
                ret.resultado = Retorno.Resultado.ERROR;
            }
        }
        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, int numero, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
        if (bibliotecaEncontrada == null) {
            ret.valorString = "Biblioteca no encontrada";
            return ret;
        }
        else{
            ListaLibros librosBiblioteca = bibliotecaEncontrada.getDato().getListaLibros();
            Nodo<Libro> nodoLibro = librosBiblioteca.buscarLibroReserva(cliente, numero);
            if (nodoLibro != null) {
                Libro libro = nodoLibro.getDato();
                Nodo<Reserva> nodoReserva = libro.getReservas().obtenerNodoPorNumeroCliente(numero, cliente);
                Reserva reserva = nodoReserva.getDato();
                libro.getReservas().borrarElemento(reserva);
                libro.SetearCantReservas();
                if (!libro.getColaEspera().esVacia()) {
                    Reserva ultimaReserva = libro.getColaEspera().getUltimo().getDato();
                    libro.getReservas().agregarInicio(ultimaReserva);
                    libro.SetearCantReservas();
                }                   
                ret.resultado = Retorno.Resultado.OK;
            }
            else{
                Nodo<Libro> nodoLibro2 = librosBiblioteca.buscarLibroColaEspera(cliente, numero);
                if (nodoLibro2 != null) {
                    Libro libro2 = nodoLibro2.getDato();
                    Nodo<Reserva> nodoReserva = libro2.getColaEspera().obtenerNodoPorNumeroCliente(numero, cliente);
                    Reserva reserva2 = nodoReserva.getDato();
                    nodoLibro2.getDato().getColaEspera().borrarElemento(reserva2);
                    libro2.SetearCantReservas();
                    ret.resultado = Retorno.Resultado.OK;
                }
                else{
                    ret.valorEntero = 1;
                    ret.valorString = "No se encontro la reserva";
                }
            }
        }
       
         return ret;
    }

    @Override
    public Retorno listarLibros(String biblioteca) {
         Retorno ret = new Retorno(Retorno.Resultado.ERROR);
         ret.valorEntero = 0;
         
         Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
         if(bibliotecaEncontrada != null){
             ret.resultado = Retorno.Resultado.OK;
             ListaLibros listaLibros = bibliotecaEncontrada.getDato().getListaLibros();
             if(listaLibros.esVacia()){
                 ret.valorString = "No existen libros registrados en la biblioteca " + biblioteca;
             }
             else{
                 ret.valorString = "Libros de la biblioteca " + biblioteca + ": \n" + listaLibros.mostrar();
             }
         }
         else{
            ret.valorString = "No existe la biblioteca " + biblioteca;
            ret.valorEntero = 1;
            ret.resultado = Retorno.Resultado.ERROR;       
         }
         return ret;
    }

    @Override
    public Retorno listarLibrosBiblioteca(String biblioteca) {
          Retorno ret = new Retorno(Retorno.Resultado.ERROR);
          ret.valorEntero = 0;
         
         Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
         if(bibliotecaEncontrada != null){
             ret.resultado = Retorno.Resultado.OK;
             ListaLibros listaLibros = bibliotecaEncontrada.getDato().getListaLibros();
             if(listaLibros.esVacia()){
                 ret.valorString = "No existen libros registrados en la biblioteca " + biblioteca;
             }
             else{
                 ret.valorString = "Libros de la biblioteca " + biblioteca + ": \n";
                 ret.valorString = listaLibros.mostrarConCalif();
             }
         }else{
            ret.valorString = "No existe la biblioteca " + biblioteca;
            ret.valorEntero = 1;
            ret.resultado = Retorno.Resultado.ERROR;  
         }
         return ret;
    }

    @Override
    public Retorno listarBibliotecaRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "Bibliotecas ordenadas por ranking";
        ListaLibros listadoLibrosGeneral = bibliotecas.listaLibrosGeneral();
        if (listadoLibrosGeneral.esVacia()) {
            ret.valorString = "No hay registros de libros en el sistema";
        }
        else
        {
            ret.valorString = ret.valorString + ": \n" + listadoLibrosGeneral.mostrarConCalif();
        }
   
        return ret;
    }

    @Override
    public Retorno listarComentarios(String biblioteca) {
         Retorno ret = new Retorno(Retorno.Resultado.ERROR);
         ret.valorEntero = 0;
         
         Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
         if(bibliotecaEncontrada != null){
             ret.resultado = Retorno.Resultado.OK;
             ListaStackComentarios listaComentarios = bibliotecaEncontrada.getDato().getListaStackComentarios();
             if(listaComentarios.esVacia()){
                 ret.valorString = "No se han agregado comentarios a la " + biblioteca;
                 ret.resultado = Retorno.Resultado.OK;           
             }
             else{
                 ret.valorString = "Comentarios de la biblioteca " + biblioteca + ":";
                 ret.valorString = listaComentarios.Mostrar();
                 ret.resultado = Retorno.Resultado.OK;        

             }
         }
         else{
            ret.valorString = "No existe la biblioteca " + biblioteca;
            ret.valorEntero = 1;
            ret.resultado = Retorno.Resultado.ERROR;           
         }
         return ret;
    }

    @Override
    public Retorno listarEspera(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        ret.valorEntero = 0;
        ret.valorString ="";
        Nodo<Biblioteca> bibliotecaEncontrada = bibliotecas.obtenerNodoPorNombre(biblioteca);
        if (bibliotecaEncontrada != null){
            ListaLibros listaLibros = bibliotecaEncontrada.getDato().getListaLibros();
            Nodo<Libro> libroEncontrado = listaLibros.obtenerNodoPorNombre(titulo, editorial);
            if (libroEncontrado != null) {
                String listaColaEspera = libroEncontrado.getDato().getColaEspera().mostrarCola();
                if (listaColaEspera != ""){
                    ret.valorString = "Lista de espera del libro " + titulo + " de la editorial "+ editorial+" en la "+ biblioteca+ " :  \n"+ listaColaEspera;
                }
                else{
                    ret.valorString = "No existen reservas pendientes para el título " +titulo+ " de la " +editorial+ " en la biblioteca " + biblioteca;
                }
                ret.resultado = Retorno.Resultado.OK;
            }
            else{
                ret.valorString = "No existe el libro " + titulo + " de la " + editorial + " en la " + biblioteca;
                ret.valorEntero = 1;
            }
        }
        else{
            ret.valorString = "No existe la " + biblioteca;
        }

        return ret;
    }

    @Override
    public Retorno mostrarReservasBiblioteca() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
          ListaLibros top5 = bibliotecas.ListaLibrosUnicos();
//          ListaLibros top5 = bibliotecas.top5Libros();
          String Matriz[ ][ ] = new String[6][(bibliotecas.getCantElementos()+2)];
          Matriz[0][0] = "Reservas/biblioteca";
          Matriz[0][bibliotecas.getCantElementos()+1] = "Total";
          Nodo<Biblioteca> bibliotecaActual = bibliotecas.getPrimero();
          for(int i=1; i<=bibliotecas.getCantElementos() && bibliotecaActual !=null;i++){ 
               Matriz[0][i] = bibliotecaActual.getDato().getNombre();
              ListaLibros listaActual = bibliotecaActual.getDato().getListaLibros();
              Nodo<Libro> libroActual = top5.getPrimero();
              for (int j=1; j<6 && libroActual !=null ;j++) {
                  Matriz[j][0] = libroActual.getDato().getTitulo();
                  if (listaActual.estaElementoTituloEditorial(libroActual.getDato())) {     
                      Nodo<Libro> libroEnLaLista = listaActual.obtenerNodoPorNombre(libroActual.getDato().getTitulo(), libroActual.getDato().getEditorial());
                      Matriz[j][i] = ""+libroEnLaLista.getDato().getCantidadReservas();                  
                  }
                  else{
                      Matriz[j][i] = ""+0;                  
                      }                    
                        Matriz[j][bibliotecas.getCantElementos()+1] =""+libroActual.getDato().getCantidadReservas();
                        libroActual = libroActual.getSiguiente();
              }
              bibliotecaActual = bibliotecaActual.getSiguiente();
              }
              
        Matriz matriz = new Matriz();  
        ret.valorString = matriz.mostrarmtriz(Matriz);

        return ret;
    }
    
    
}