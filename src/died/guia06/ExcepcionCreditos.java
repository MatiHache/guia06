package died.guia06;

import java.lang.Exception;

public class ExcepcionCreditos extends Exception{
	
	public ExcepcionCreditos() {
			super("El alumno no posee los suficientes créditos.");
	}
}
