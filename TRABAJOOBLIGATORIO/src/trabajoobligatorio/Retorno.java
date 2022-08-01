package trabajoobligatorio;



public class Retorno {
	enum Resultado {
		OK, ERROR, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
         boolean valorbooleano;
	Resultado resultado;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
