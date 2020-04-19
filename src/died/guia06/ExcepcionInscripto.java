package died.guia06;

import java.lang.Exception;

public class ExcepcionInscripto extends Exception {

	public ExcepcionInscripto() {
		super("El alumno ya se encuentra inscripto en este curso");
		
	}
	
}
