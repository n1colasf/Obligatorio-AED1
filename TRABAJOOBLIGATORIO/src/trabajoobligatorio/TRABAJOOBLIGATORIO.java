package trabajoobligatorio;

public class TRABAJOOBLIGATORIO {


public static void main(String[] args) {
        Prueba p = new Prueba();
        Obligatorio o = new Obligatorio();
        CrearSistemaObligatorio(o,p);
        
        Test1AgregarBibliotecas(o,p);
        Test2AgregarLIbros(o,p);
        Test3EliminarLIbro(o,p);
        Test4RealizarReservas(o,p);
        Test5CancelarReservas(o,p);
        Test6EliminarBibliotecas(o,p);
        Test7RegistrarCalificaciones(o,p);
        Test8ListarLibrosPorBiblioteca(o,p);
        Test9MostrarComentarios(o,p);
        Test10ListarColaEspera(o,p);
        Test11ListarLibrosBiblioteca(o,p);
        Test12ListarBibliotecaRanking(o,p);
        Test13Matriz(o,p);

//        Matriz(o,p);
        }

        public static void CrearSistemaObligatorio(Obligatorio o, Prueba p){
            p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
            p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
            p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");

        // p.imprimirResultadosPrueba();

        }
       
        public static void Test1AgregarBibliotecas(Obligatorio o, Prueba p) {
            Retorno registrarBiblioteca1 = o.registrarBiblioteca("Biblioteca Horacio Quiroga");
            Retorno registrarBiblioteca2 = o.registrarBiblioteca("Biblioteca Delmira Agustini");
            Retorno registrarBiblioteca3 = o.registrarBiblioteca("Biblioteca Carlos Roxlo");
            Retorno registrarBiblioteca4 = o.registrarBiblioteca("Biblioteca Delmira Agustini");
            Retorno registrarBiblioteca5 = o.registrarBiblioteca("Biblioteca Centro");
            Retorno registrarBiblioteca6 = o.registrarBiblioteca("Biblioteca Cordón");
            Retorno registrarBiblioteca7 = o.registrarBiblioteca("Biblioteca Paso Molino");
            Retorno registrarBiblioteca8 = o.registrarBiblioteca("Biblioteca La Comercial");
            Retorno registrarBiblioteca9 = o.registrarBiblioteca("Biblioteca Horacio Quiroga");
            Retorno registrarBiblioteca10 = o.registrarBiblioteca("Biblioteca Salto");
            Retorno registrarBiblioteca11 = o.registrarBiblioteca("Biblioteca Paysandú");
            Retorno registrarBiblioteca12 = o.registrarBiblioteca("Biblioteca Soriano");

            p.ver(registrarBiblioteca1.resultado, Retorno.Resultado.OK, "Se registra biblioteca: Biblioteca Horacio Quiroga - Resultado: " + registrarBiblioteca1.valorEntero);
            p.ver(registrarBiblioteca2.resultado, Retorno.Resultado.OK, "Se registra biblioteca: Biblioteca Delmira Agustini - Resultado: " + registrarBiblioteca2.valorEntero);
            p.ver(registrarBiblioteca3.resultado, Retorno.Resultado.OK, "Se registra biblioteca: Biblioteca Carlos Roxlo - Resultado: " + registrarBiblioteca3.valorEntero);
            p.ver(registrarBiblioteca4.resultado, Retorno.Resultado.ERROR, "Ya existe Biblioteca Delmira Agustini - Resultado: " + registrarBiblioteca4.valorEntero);
            p.ver(registrarBiblioteca5.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca Centro - Resultado: " + registrarBiblioteca5.valorEntero);
            p.ver(registrarBiblioteca6.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca Cordón - Resultado: " + registrarBiblioteca6.valorEntero);
            p.ver(registrarBiblioteca7.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca Paso Molino - Resultado: " + registrarBiblioteca7.valorEntero);
            p.ver(registrarBiblioteca8.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca La Comercial - Resultado: " + registrarBiblioteca8.valorEntero);
            p.ver(registrarBiblioteca9.resultado, Retorno.Resultado.ERROR, "Ya existe Biblioteca Horacio Quiroga - Resultado: " + registrarBiblioteca9.valorEntero);
            p.ver(registrarBiblioteca10.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca Salto - Resultado " + registrarBiblioteca10.valorEntero);
            p.ver(registrarBiblioteca11.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca Paysandú - Resultado " + registrarBiblioteca11.valorEntero);
            p.ver(registrarBiblioteca12.resultado, Retorno.Resultado.OK, "Se registra biblioteca Biblioteca Soriano - Resultado " + registrarBiblioteca12.valorEntero);

             p.imprimirResultadosPrueba();
        }
        
        public static void Test2AgregarLIbros(Obligatorio o, Prueba p) {

            Retorno registroLibro1 = o.registrarLibro("El Principito", "Editorial Santillana", "Biblioteca Horacio Quiroga", 2);
            Retorno registroLibro2 = o.registrarLibro("Los padecientes", "Editorial Fin de Siglo", "Biblioteca Delmira Agustini", 15);
            Retorno registroLibro3 = o.registrarLibro("Los padecientes", "Editorial Fin de Siglo", "Biblioteca Delmira Agustini", 30);
            Retorno registroLibro4 = o.registrarLibro("Los padecientes", "Editorial Fin de Siglo", "Biblioteca Cordón", 19);
            Retorno registroLibro5 = o.registrarLibro("Microbiologia", "Editorial Santillana", "Biblioteca Horacio Quiroga", 100);
            Retorno registroLibro6 = o.registrarLibro("Juegos del hambre", "Editorial Maguire", "Biblioteca Delmira Agustini", 20);
            Retorno registroLibro7 = o.registrarLibro("Juegos del hambre", "Editorial Maguire", "Biblioteca Horacio Quiroga", 25);
            Retorno registroLibro8 = o.registrarLibro("La célula", "Editorial Omega", "Biblioteca Paysandú", 20);
            Retorno registroLibro9 = o.registrarLibro("Paulina cocina", "Editorial gastronómica", "Biblioteca Paysandú", 18);
            Retorno registroLibro10 = o.registrarLibro("Las venas abiertas", "Editorial Fin de Siglo", "Biblioteca Cordón", 56);
            Retorno registroLibro11 = o.registrarLibro("Las venas abiertas", "Editorial Fin de Siglo", "Biblioteca La invisible", 20);
            Retorno registroLibro12 = o.registrarLibro("Paulina cocina", "Editorial gastronómica", "Biblioteca Paysandú", 20);
            Retorno registroLibro13 = o.registrarLibro("El Principito", "Editorial Santillana", "Biblioteca Delmira Agustini", 0);
            Retorno registroLibro14 = o.registrarLibro("Spiderman", "Editorial Marvel", "Biblioteca Delmira Agustini", 500);
            Retorno registroLibro15 = o.registrarLibro("Juegos del 2", "Editorial Maguire", "Biblioteca Delmira Agustini", 50);
            Retorno registroLibro16 = o.registrarLibro("Microbiologia", "Editorial Santillana", "Biblioteca Paysandú", 123);
            Retorno registroLibro17 = o.registrarLibro("Microbiologia", "Editorial Santillana", "Biblioteca Soriano", 35);
            Retorno registroLibro18 = o.registrarLibro("Juegos del hambre", "Editorial Maguire", "Biblioteca Salto", 90);
            Retorno registroLibro19 = o.registrarLibro("Juegos del hambre", "Editorial Maguire", "Biblioteca La Comercial", 50);

            p.ver(registroLibro1.resultado, Retorno.Resultado.OK, "Se agrega el libro El Principito a biblioteca H.Q - resultado: " + registroLibro1.valorEntero);
            p.ver(registroLibro2.resultado, Retorno.Resultado.OK, "Se agrega el libro Los padecientes a Biblioteca D.A - resultado: " + registroLibro2.valorEntero);
            p.ver(registroLibro3.resultado, Retorno.Resultado.ERROR, "Ya existe el libro Los Padecientes en la Biblioteca D.A - resultado: "+registroLibro3.valorEntero);
            p.ver(registroLibro4.resultado, Retorno.Resultado.OK, "Se agrega el libro Los Padecientes a la biblioteca Biblioteca Cordón - resultado: "+registroLibro4.valorEntero);
            p.ver(registroLibro5.resultado, Retorno.Resultado.OK, "Se agrega el libro Microbiologia a biblioteca H.Q - resultado: "+registroLibro5.valorEntero);
            p.ver(registroLibro6.resultado, Retorno.Resultado.OK, "Se agrega el libro Juegos del Hambre a Biblioteca D.A - resultado: "+registroLibro6.valorEntero);
            p.ver(registroLibro7.resultado, Retorno.Resultado.OK, "Se agrega el libro Juegos del Hambre a Biblioteca H.Q - resultado: " + registroLibro7.valorEntero);
            p.ver(registroLibro8.resultado, Retorno.Resultado.OK, "Se agrega el libro La célula a Biblioteca Paysandú - resultado: " + registroLibro8.valorEntero);
            p.ver(registroLibro9.resultado, Retorno.Resultado.OK, "Se agrega el libro Paulina cocina a Biblioteca Paysandú - resultado: " + registroLibro9.valorEntero);
            p.ver(registroLibro10.resultado, Retorno.Resultado.OK, "Se agrega el libro Las venas abiertas a Biblioteca Cordón - resultado: " + registroLibro10.valorEntero);
            p.ver(registroLibro11.resultado, Retorno.Resultado.ERROR, "No existe la biblioteca La invisible - resultado: " + registroLibro11.valorEntero);
            p.ver(registroLibro12.resultado, Retorno.Resultado.ERROR, "Ya existe el libro Paulina cocina en la Biblioteca Paysandú - resultado: " + registroLibro12.valorEntero);
            p.ver(registroLibro13.resultado, Retorno.Resultado.OK, "Se agrega el libro El Principito a Biblioteca D.A - resultado: " + registroLibro13.valorEntero);
            p.ver(registroLibro14.resultado, Retorno.Resultado.OK, "Se agrega el libro Spiderman a Biblioteca D.A - resultado: " + registroLibro14.valorEntero);
            p.ver(registroLibro15.resultado, Retorno.Resultado.OK, "Se agrega el libro Juegos del 2 a Biblioteca D.A - resultado: " + registroLibro15.valorEntero);
            p.ver(registroLibro16.resultado, Retorno.Resultado.OK, "Se agrega el libro Microbiología a Biblioteca Paysandú - resultado: " + registroLibro16.valorEntero);
            p.ver(registroLibro17.resultado, Retorno.Resultado.OK, "Se agrega el libro Microbiología a Biblioteca Soriano - resultado: " + registroLibro17.valorEntero);
            p.ver(registroLibro18.resultado, Retorno.Resultado.OK, "Se agrega el libro Juegos del hambre a Biblioteca Salto - resultado: " + registroLibro18.valorEntero);
            p.ver(registroLibro19.resultado, Retorno.Resultado.OK, "Se agrega el libro Juegos del hambre a Biblioteca La Comercial - resultado: " + registroLibro19.valorEntero);

//            p.imprimirResultadosPrueba();
        }
        
        public static void Test3EliminarLIbro(Obligatorio o, Prueba p) {
            Retorno eliminarLibro1 = o.eliminarLibro("Las venas abiertas", "Editorial Fin de Siglo", "Biblioteca Cordón");
            Retorno eliminarLibro2 = o.eliminarLibro("Come Reza", "Editorial Santillana", "Biblioteca Horacio Quiroga");
            Retorno eliminarLibro3 = o.eliminarLibro("Paulina Cocina", "Editorial Verde", "Biblioteca Paysandú");
            Retorno eliminarLibro4 = o.eliminarLibro("El principito", "Editorial Santillana", "Biblioteca Cordón");
            Retorno eliminarLibro5 = o.eliminarLibro("Paulina Cocina", "Editorial gastronómica", "Biblioteca Paysandú");

            p.ver(eliminarLibro1.resultado, Retorno.Resultado.OK, "Se eliminó el libro Las Venas Abiertas - resultado: " + eliminarLibro1.valorEntero);
            p.ver(eliminarLibro2.resultado, Retorno.Resultado.ERROR, "Los datos del libro no son correctos - resultado: " + eliminarLibro2.valorEntero);
            p.ver(eliminarLibro3.resultado, Retorno.Resultado.ERROR, "La editorial no es correcta - resultado: " + eliminarLibro3.valorEntero);
            p.ver(eliminarLibro4.resultado, Retorno.Resultado.ERROR, "La biblioteca no es correcta - resultado: " + eliminarLibro4.valorEntero);
            p.ver(eliminarLibro5.resultado, Retorno.Resultado.OK, "Se eliminó el libro Paulina Cocina - resultado: " + eliminarLibro5.valorEntero);

//             p.imprimirResultadosPrueba();
        }
        
        public static void Test4RealizarReservas(Obligatorio o, Prueba p) {
            Retorno realizarReserva1 = o.realizarReserva(45544061, 1, "Biblioteca Horacio Quiroga", "El Principito", "Editorial Santillana", "12/05/2022");
            Retorno realizarReserva2 = o.realizarReserva(45544122, 2, "Biblioteca Horacio Quiroga", "El Principito", "Editorial Santillana", "12/12/2021");
            Retorno realizarReserva3 = o.realizarReserva(45544234, 3, "Biblioteca Horacio Quiroga", "El Principito", "Editorial Santillana", "11/12/2021");
            Retorno realizarReserva4 = o.realizarReserva(45544123, 4, "Biblioteca Horacio Quiroga", "El NIIdea", "Editorial Santillana", "12/05/2022");
            Retorno realizarReserva5 = o.realizarReserva(45544061, 1, "Biblioteca Horacio Quiroga", "El Principito", "Editorial Santillana", "29/11/2022");
            Retorno realizarReserva6 = o.realizarReserva(45544061, 1, "Biblioteca Horacio Quiroga", "El Principito", "Editorial Santillana", "02/05/2022");
            Retorno realizarReserva17 = o.realizarReserva(25542122, 222, "Biblioteca Horacio Quiroga", "El Principito", "Editorial Santillana", "12/12/2021");        
            Retorno realizarReserva8 = o.realizarReserva(51239212, 41,"Biblioteca Delmira Agustini", "Spiderman", "Editorial Marvel", "03/05/2022");
            Retorno realizarReserva9 = o.realizarReserva(502388921, 7,"Biblioteca Delmira Agustini", "Spiderman", "Editorial Marvel", "04/05/2022");
            Retorno realizarReserva10 = o.realizarReserva(50123982, 11,"Biblioteca Delmira Agustini", "Spiderman", "Editorial Marvel", "07/05/2022");
            Retorno realizarReserva14 = o.realizarReserva(512388922, 61,"Biblioteca Delmira Agustini", "Spiderman", "Editorial Marvel", "04/07/2022");
            Retorno realizarReserva18 = o.realizarReserva(512311111, 221,"Biblioteca Delmira Agustini", "Spiderman", "Editorial Marvel", "08/07/2022");
            Retorno realizarReserva11 = o.realizarReserva(42524061, 512211, "Biblioteca Horacio Quiroga", "Microbiologia", "Editorial Santillana", "12/05/2022");
            Retorno realizarReserva16 = o.realizarReserva(41514161, 91, "Biblioteca Horacio Quiroga", "Microbiologia", "Editorial Santillana", "12/05/2022");
            Retorno realizarReserva20 = o.realizarReserva(92522061, 511, "Biblioteca Horacio Quiroga", "Microbiologia", "Editorial Santillana", "12/07/2022");         
            Retorno realizarReserva12 = o.realizarReserva(42524969, 5121, "Biblioteca Delmira Agustini", "Juegos del 2", "Editorial Maguire", "12/05/2022");
            Retorno realizarReserva13 = o.realizarReserva(41514111, 521, "Biblioteca Delmira Agustini", "Juegos del 2", "Editorial Maguire", "14/05/2022");
            Retorno realizarReserva15 = o.realizarReserva(42222969, 14, "Biblioteca Delmira Agustini", "Juegos del 2", "Editorial Maguire", "12/05/2022");
            Retorno realizarReserva19 = o.realizarReserva(61514111, 921, "Biblioteca Delmira Agustini", "Juegos del 2", "Editorial Maguire", "19/05/2022");
            Retorno realizarReserva21 = o.realizarReserva(92522061, 3122, "Biblioteca Delmira Agustini", "Juegos del hambre", "Editorial Maguire", "24/07/2022");
            Retorno realizarReserva22 = o.realizarReserva(922522091, 321, "Biblioteca Delmira Agustini", "Juegos del hambre", "Editorial Maguire", "01/07/2022");
            Retorno realizarReserva23 = o.realizarReserva(455423, 1123, "Biblioteca Delmira Agustini", "El Principito", "Editorial Santillana", "21/05/2022");
            Retorno realizarReserva24 = o.realizarReserva(4554232, 13123, "Biblioteca Delmira Agustini", "El Principito", "Editorial Santillana", "22/05/2022");
            Retorno realizarReserva25 = o.realizarReserva(11812412, 21231, "Biblioteca Carlos Roxlo", "La iliada", "Editorial Santilli", "22/11/2022");
            Retorno realizarReserva26 = o.realizarReserva(11812412, 21231, "Biblioteca Paysandú", "Microbiologia", "Editorial Santillana", "22/11/2022");
            Retorno realizarReserva27 = o.realizarReserva(11812412, 21231, "Biblioteca Soriano", "Microbiologia", "Editorial Santillana", "22/11/2022");
            Retorno realizarReserva28 = o.realizarReserva(11812412, 21231, "Biblioteca Salto", "Juegos del hambre", "Editorial Maguire", "22/11/2022");
            Retorno realizarReserva29 = o.realizarReserva(11812412, 21231, "Biblioteca la Comercial", "Juegos del hambre", "Editorial Maguire", "22/11/2022");

            p.ver(realizarReserva1.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva ");
            p.ver(realizarReserva2.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva3.resultado, Retorno.Resultado.OK, "La reserva queda en cola de espera");
            p.ver(realizarReserva4.resultado, Retorno.Resultado.ERROR, "Los datos del libro no son correctos - Resultado " + realizarReserva4.valorEntero);
            p.ver(realizarReserva5.resultado, Retorno.Resultado.OK, "La reserva queda en cola de espera");
            p.ver(realizarReserva6.resultado, Retorno.Resultado.OK, "La reserva queda en cola de espera");
            p.ver(realizarReserva8.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva9.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva10.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva11.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva12.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva13.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva14.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva15.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva16.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva17.resultado, Retorno.Resultado.OK, "La reserva queda en cola de espera");
            p.ver(realizarReserva18.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva19.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva20.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva21.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva22.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva23.resultado, Retorno.Resultado.OK, "La reserva quedó en cola de espera");
            p.ver(realizarReserva24.resultado, Retorno.Resultado.OK, "La reserva quedó en cola de espera");
            p.ver(realizarReserva25.resultado, Retorno.Resultado.ERROR, "No existe el libro ingresado - Resultado " + realizarReserva25.valorEntero);
            p.ver(realizarReserva26.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva27.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva28.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");
            p.ver(realizarReserva29.resultado, Retorno.Resultado.OK, "Se efectuó correctamente la reserva");

//         p.imprimirResultadosPrueba();
        }
        
        public static void Test5CancelarReservas(Obligatorio o, Prueba p) {
            Retorno cancelarReserva1 = o.cancelarReserva(45544061, 1, "Biblioteca Horacio Quiroga");
            Retorno cancelarReserva2 = o.cancelarReserva(444122, 22, "Biblioteca Horacio Quiroga");
            Retorno cancelarReserva3 = o.cancelarReserva(45544061, 1, "Biblioteca invisible");

            p.ver(cancelarReserva1.resultado, Retorno.Resultado.OK, "Se cancela la reserva 1 del cliente 45544061");
            p.ver(cancelarReserva2.resultado, Retorno.Resultado.ERROR, "La reserva no existe - Resultado: " + cancelarReserva2.valorEntero);
            p.ver(cancelarReserva3.resultado, Retorno.Resultado.ERROR, "No existe la biblioteca invisible - Resultado: " + cancelarReserva3.valorString);

//             p.imprimirResultadosPrueba();
        }
        
        public static void Test6EliminarBibliotecas(Obligatorio o, Prueba p) {
            
            Retorno eliminarBiblioteca1 = o.eliminarBiblioteca("Biblioteca Atlántida");
            Retorno eliminarBiblioteca2 = o.eliminarBiblioteca("Biblioteca Centro");
            Retorno eliminarBiblioteca3 = o.eliminarBiblioteca("Biblioteca Horacio Quiroga");
            Retorno eliminarBiblioteca4 = o.eliminarBiblioteca("Biblioteca Cordón");
            Retorno eliminarBiblioteca5 = o.eliminarBiblioteca("Biblioteca Paysandú");

            p.ver(eliminarBiblioteca1.resultado, Retorno.Resultado.ERROR, "No existe la Biblioteca Atlántida - Resultado: " + eliminarBiblioteca1.valorEntero);
            p.ver(eliminarBiblioteca2.resultado, Retorno.Resultado.OK, "Se elimina la Biblioteca Centro - Resultado: " + eliminarBiblioteca2.valorEntero);
            p.ver(eliminarBiblioteca3.resultado, Retorno.Resultado.ERROR, "La Biblioteca Horacio Quiroga tiene reservas, no se puede eliminar - Resultado: " + eliminarBiblioteca3.valorEntero);
            p.ver(eliminarBiblioteca4.resultado, Retorno.Resultado.OK, "Se elimina la Biblioteca Cordón - Resultado: " + eliminarBiblioteca4.valorEntero);
            p.ver(eliminarBiblioteca5.resultado, Retorno.Resultado.ERROR, "La Biblioteca Paysandú tiene reservas, no se puede eliminar - Resultado: " + eliminarBiblioteca5.valorEntero);

//             p.imprimirResultadosPrueba();
        }
        
        public static void Test7RegistrarCalificaciones(Obligatorio o, Prueba p) {
            Retorno calificacion10 = o.RegistrarCalificacion("Microbiologia", "Editorial Santillana", 1, "Biblioteca Horacio Quiroga", "Malo malo");
            Retorno calificacion9 = o.RegistrarCalificacion("Microbiologia", "Editorial Santillana", 3, "Biblioteca Horacio Quiroga", "Flojito");
            Retorno calificacion1 = o.RegistrarCalificacion("El Principito", "Editorial Santillana", 4, "Biblioteca Horacio Quiroga", "Muy completo el libro");
            Retorno calificacion2 = o.RegistrarCalificacion("El Principito", "Editorial Santillana", 5, "Biblioteca Horacio Quiroga", "Ya lo habia leido");
            Retorno calificacion3 = o.RegistrarCalificacion("Los padecientes", "Editorial Fin de Siglo", 4, "Biblioteca Delmira Agustini", "Muy completo el libro");
            Retorno calificacion4 = o.RegistrarCalificacion("El Principito", "Editorial Santillana", 21, "Biblioteca Horacio Quiroga", "Muy completo el libro");
            Retorno calificacion5 = o.RegistrarCalificacion("El jefe", "Santillana", 5, "Biblioteca Horacio Quiroga", "Muy completo el libro");
            Retorno calificacion6 = o.RegistrarCalificacion("Microbiologia", "Editorial Santillana", 5, "Biblioteca Horacio Quiroga", "Esssspectacular");
            Retorno calificacion7 = o.RegistrarCalificacion("El Principito", "Editorial Santillana", 1, "Biblioteca Horacio Quiroga", "No me gusta para nada");
            Retorno calificacion8 = o.RegistrarCalificacion("Juegos del 2", "Editorial Maguire", 3, "Biblioteca Delmira Agustini", "No esta mal");
            Retorno calificacion11 = o.RegistrarCalificacion("Spiderman", "Editorial Marvel", 5, "Biblioteca Delmira Agustini", "Está re zarpado");
            Retorno calificacion12 = o.RegistrarCalificacion("La célula", "Editorial Omega", 2, "Biblioteca Paysandú", "Medio pelo");
            Retorno calificacion13 = o.RegistrarCalificacion("Juegos del hambre", "Editorial Maguire", 1, "Biblioteca Delmira Agustini", "Me dormí leyendo");
            Retorno calificacion14 = o.RegistrarCalificacion("Juegos del hambre", "Editorial Maguire", 3, "Biblioteca Horacio Quiroga", "Maso");
            Retorno calificacion15 = o.RegistrarCalificacion("Juegos del hambre", "Editorial Maguire", 1, "Biblioteca Horacio Quiroga", "Pésimo");
            Retorno calificacion16 = o.RegistrarCalificacion("Microbiologia", "Editorial Santillana", 5, "Biblioteca Soriano", "Excelente");
            Retorno calificacion17 = o.RegistrarCalificacion("Microbiologia", "Editorial Santillana", 4, "Biblioteca Soriano", "Impresionante el libro");

            p.ver(calificacion1.resultado, Retorno.Resultado.OK, "Se agrega calificacion 4 al libro El Principito");
            p.ver(calificacion2.resultado, Retorno.Resultado.OK, "Se agrega califiacion 5 al libro El Principito");
            p.ver(calificacion3.resultado, Retorno.Resultado.OK, "Se agrega califiacion 4 al libro Los padecientes");
            p.ver(calificacion4.resultado, Retorno.Resultado.ERROR, "La calificación agregada no es correcta - Resultado: " + calificacion4.valorEntero);
            p.ver(calificacion5.resultado, Retorno.Resultado.ERROR, "No existe el libro ingresado - Resultado: " + calificacion5.valorEntero);
            p.ver(calificacion6.resultado, Retorno.Resultado.OK, "Se agrega calificacion 5" + calificacion6.valorEntero);
            p.ver(calificacion7.resultado, Retorno.Resultado.OK, "Se agrega calificacion 1 al libro El Principito");
            p.ver(calificacion8.resultado, Retorno.Resultado.OK, "Se agrega califiacion 3 a los juegos del 2");
            p.ver(calificacion9.resultado, Retorno.Resultado.OK, "Se agrega califiacion 3 a microbiología");
            p.ver(calificacion10.resultado, Retorno.Resultado.OK, "Se agrega califiacion 1 a microbiología");
            p.ver(calificacion11.resultado, Retorno.Resultado.OK, "Se agrega califiacion 5 a Spiderman");
            p.ver(calificacion12.resultado, Retorno.Resultado.OK, "Se agrega califiacion 2 a La célula");
            p.ver(calificacion13.resultado, Retorno.Resultado.OK, "Se agrega califiacion 1 a Juegos del hambre");
            p.ver(calificacion14.resultado, Retorno.Resultado.OK, "Se agrega califiacion 3 a Juegos del hambre");
            p.ver(calificacion15.resultado, Retorno.Resultado.OK, "Se agrega califiacion 1 a Juegos del hambre");
            p.ver(calificacion16.resultado, Retorno.Resultado.OK, "Se agrega califiacion 5 a Microbiologia");
            p.ver(calificacion17.resultado, Retorno.Resultado.OK, "Se agrega califiacion 4 a Microbiologia");

//             p.imprimirResultadosPrueba();
        }

        public static void Test8ListarLibrosPorBiblioteca(Obligatorio o, Prueba p) {
            Retorno listarLibro1 = o.listarLibros("Biblioteca Horacio Quiroga");
            Retorno listarLibro2 = o.listarLibros("Biblioteca Delmira Agustini");
            Retorno listarLibro3 = o.listarLibros("Biblioteca Calamuchita");
            Retorno listarLibro4 = o.listarLibros("Biblioteca Carlos Roxlo");

            p.ver(listarLibro1.resultado, Retorno.Resultado.OK, "Libros biblioteca H.Q: \n Resultado: " + listarLibro1.valorString);
            p.ver(listarLibro2.resultado, Retorno.Resultado.OK, "Libros biblioteca D.A: \n Resultado: " + listarLibro2.valorString);
            p.ver(listarLibro3.resultado, Retorno.Resultado.ERROR, "No existe la biblioteca Biblioteca Calamuchita - \n Resultado: " + listarLibro3.valorString + " - " + listarLibro3.valorEntero);
            p.ver(listarLibro4.resultado, Retorno.Resultado.OK, "No existen libros en la biblioteca Carlos Roxlo - \n Resultado: " + listarLibro4.valorString);

//             p.imprimirResultadosPrueba();
        }

        public static void Test9MostrarComentarios(Obligatorio o, Prueba p) {
            Retorno comentarios1 = o.listarComentarios("Biblioteca Horacio Quiroga");
            Retorno comentarios2 = o.listarComentarios("Biblioteca Carlos Roxlo");
            Retorno comentarios3 = o.listarComentarios("Biblioteca La Incomible");
            Retorno comentarios4 = o.listarComentarios("Biblioteca Delmira Agustini");
            
            

            p.ver(comentarios1.resultado, Retorno.Resultado.OK, "Comentarios de la biblioteca Horacio Quiroga: " + comentarios1.valorString);
            p.ver(comentarios2.resultado, Retorno.Resultado.OK, "La biblioteca Carlos Roxlo no tiene comentarios: " + comentarios2.valorString);
            p.ver(comentarios3.resultado, Retorno.Resultado.ERROR, "No existe la biblioteca La Incomible: " + comentarios3.valorEntero);
            p.ver(comentarios4.resultado, Retorno.Resultado.OK, "Comentarios de la Biblioteca D.A: " + comentarios4.valorString);

             p.imprimirResultadosPrueba();
        }

        public static void Test10ListarColaEspera(Obligatorio o, Prueba p) {
            Retorno listaEspera1 = o.listarEspera("El Principito", "Editorial Santillana", "Biblioteca Horacio Quiroga");
            Retorno listaEspera4 = o.listarEspera("El Principito", "Editorial Santillana", "Biblioteca Delmira Agustini");
            Retorno listaEspera2 = o.listarEspera("Juego del hambre", " Santillana", "Biblioteca Calamuchita");
            Retorno listaEspera3 = o.listarEspera("Los padecientes", "Editorial Fin de Siglo", "Biblioteca Delmira Agustini");

            p.ver(listaEspera1.resultado, Retorno.Resultado.OK, "Lista de espera del libro El Principito de ls Biblioteca H.Q: \n" + listaEspera1.valorString);
            p.ver(listaEspera2.resultado, Retorno.Resultado.ERROR, listaEspera2.valorString + "No existe la biblioteca Calamuchita - Resultado: " + listaEspera2.valorEntero);
            p.ver(listaEspera3.resultado, Retorno.Resultado.OK, "Resultado: " + listaEspera3.valorString);
            p.ver(listaEspera4.resultado, Retorno.Resultado.OK, "Lista de espera del libro El Principito de ls Biblioteca D.A: \n" + listaEspera4.valorString);


//         p.imprimirResultadosPrueba();
        }

        public static void Test11ListarLibrosBiblioteca(Obligatorio o, Prueba p) {
        Retorno listadoLibros1 = o.listarLibrosBiblioteca("Biblioteca Horacio Quiroga");
        Retorno listadoLibros2 = o.listarLibrosBiblioteca("Biblioteca Calamuchita");
        Retorno listadoLibros3 = o.listarLibrosBiblioteca("Biblioteca Carlos Roxlo");
        Retorno listadoLibros4 = o.listarLibrosBiblioteca("Biblioteca Delmira Agustini");

        p.ver(listadoLibros1.resultado, Retorno.Resultado.OK, "Lista de libros de la biblioteca H.Q ordenados por ranking: \n" + listadoLibros1.valorString);
        p.ver(listadoLibros2.resultado, Retorno.Resultado.ERROR, listadoLibros2.valorString + "No existe la biblioteca - Resultado: " + listadoLibros2.valorEntero);
        p.ver(listadoLibros3.resultado, Retorno.Resultado.OK, listadoLibros3.valorString + "La biblioteca no tiene libros");
        p.ver(listadoLibros4.resultado, Retorno.Resultado.OK, "Lista de libros de la biblioteca D.A ordenados por ranking: \n" + listadoLibros4.valorString);

         p.imprimirResultadosPrueba();
        }

        public static void Test12ListarBibliotecaRanking(Obligatorio o, Prueba p) {
        Retorno rankingTotal1 = o.listarBibliotecaRanking();

        p.ver(rankingTotal1.resultado, Retorno.Resultado.OK, "Lista de libros de todas las bibliotecas ordenados por ranking: \n" + rankingTotal1.valorString);

//        p.imprimirResultadosPrueba();
        }
        
        public static void Test13Matriz(Obligatorio o, Prueba p) {
        Retorno MatrizReservas = o.mostrarReservasBiblioteca();

        p.ver(MatrizReservas.resultado, Retorno.Resultado.OK, "5 libros mas solicitados: \n" + MatrizReservas.valorString);

        p.imprimirResultadosPrueba();
        
        }
}