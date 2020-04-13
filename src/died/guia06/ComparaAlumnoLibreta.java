package died.guia06;
import java.util.Comparator;

public class ComparaAlumnoLibreta implements Comparator<Alumno>{

	public int compare(Alumno a1, Alumno a2) {
		return a1.getNroLibreta().compareTo(a2.getNroLibreta());
	}
	
}
