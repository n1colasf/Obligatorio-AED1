package Interfaces;
import trabajoobligatorio.Retorno;

public interface IObligatorio {
    
    //post:crea una instancia del sistema de reservas
   Retorno crearSistemaReservas();
   
   //post: se elimina el sistema de reservas
   Retorno destruirSistemaReservas();
   
   //pre: recibe un string biblioteca
   //post: agrega la biblioteca al sistema
   Retorno registrarBiblioteca(String Biblioteca);
   
   //pre: recibe un string biblioteca
   //post: elimina la biblioteca del sistema
   Retorno eliminarBiblioteca(String Biblioteca);
   
   // pre:recibe string titulo, string editorial, string biblioteca, y int ejemplares mayor o igual a 0
   // post: registra el libro en la biblioteca indicada
   Retorno registrarLibro(String titulo, String editorial, String biblioteca, int ejemplares);
   
   // pre: recibe string titulo, string editorial, string biblioteca
   //post: elimina el libro y todos sus ejemplares de la biblioteca indicada
   Retorno eliminarLibro(String titulo, String editorial, String biblioteca);
   
   // pre: recibe string titulo, string editorial, string biblioteca,string comentario,int calificacion
   // pre: el int calificacion debe estar entre 0 y 5
   //post: registra la calificacion y el comentario a el libro correspondiente que pertenece a la biblioteca ingresada
   Retorno RegistrarCalificacion(String titulo, String editorial, int calificacion, String biblioteca, String comentario);
   
   //pre: recibe int cliente, int numero, string biblioteca, string titulo, string editorial y string fecha
   //pre: la fecha debe ser >= a hoy
   //post: se da de alta la reserva según datos del libro indicado, asociada al cliente correspondiente.
   Retorno realizarReserva(int cliente, int numero, String biblioteca, String titulo, String editorial, String fecha);
   
   //pre: recibe int cliente, int numero, string biblioteca
   //post: cancela la reserva del cliente correspondiente
   Retorno cancelarReserva(int cliente, int numero, String biblioteca);
   
   //pre: recibe un string biblioteca
   //post: retorna una lista con los libros de la biblioteca, o en su defecto un mensaje indicando que no hay libros en la biblioteca indicada.
   Retorno listarLibros(String biblioteca);
   
   //pre: recibe un string biblioteca
   //post: retorna una lista con los libros de la biblioteca ordenados por ranking, o en su defecto un mensaje indicando que no hay libros en la biblioteca indicada.
   Retorno listarLibrosBiblioteca (String biblioteca);
   
   //post: retorna una lista de todos los libros ordenados por ranking descendente.
   Retorno listarBibliotecaRanking();
   
   //pre :recibe un string biblioteca
   //post: retorna una lista con todos los comentarios sobre la biblioteca, mostrando los más recientes en primer lugar. En su defecto un mensaje indicando que no hay comentarios en la bib.
   Retorno listarComentarios (String biblioteca);
   
   //pre: recibe un string titulo, string editorial, string biblioteca
   //post: retorna una lista de clientes ordenada por antiguedad de la reserva para el titulo, editorial y la biblioteca correspondiente. En caso de que no haya clientes en lista de espera 
//   se indicará.
   Retorno listarEspera (String titulo, String editorial, String biblioteca);
   
   //post: retorna una tabla con los 5 libros más reservados, su cantidad de reservas en cada biblioteca y el total.
   Retorno mostrarReservasBiblioteca ();
   

}