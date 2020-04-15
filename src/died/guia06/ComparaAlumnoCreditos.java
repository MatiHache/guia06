package died.guia06;
import java.util.Comparator;

public class ComparaAlumnoCreditos implements Comparator<Alumno> {
	
	public int compare(Alumno a1, Alumno a2) {
		return a2.creditosObtenidos() - a1.creditosObtenidos();
	}
}
