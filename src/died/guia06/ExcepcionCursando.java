package died.guia06;

import java.lang.Exception;

public class ExcepcionCursando extends Exception {

	public ExcepcionCursando() {
		super("El alumno ya está inscripto en 3 (tres) cursos.");
	}
	
}
