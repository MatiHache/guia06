package died.guia06;

import java.lang.Exception;

public class ExcepcionCupo extends Exception {

	public ExcepcionCupo() {
		super("El cupo de este curso se encuentra cubierto.");
	}
	
}
