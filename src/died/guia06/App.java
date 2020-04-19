package died.guia06;

import java.io.IOException;
import junit.runner.Version;

public class App {

	public static void main(String[] args) {
	
	Alumno a1 = new Alumno("Matías Hillar", 25315);
	Alumno a2 = new Alumno("José Martinez", 12345);
	Alumno a3 = new Alumno("Pepe Gonzalez",54852);
	Alumno a4 = new Alumno("Juan Perez",25845);
	Alumno a5 = new Alumno("Mario Hernandez",15548);
	
	Curso c1 = new Curso(23, "DIED", 2020);
	c1.setCreditos(6);
	c1.setCreditosRequeridos(0);
	c1.setCupo(4);
	Curso c2 = new Curso(12, "Economía", 2020);
	c2.setCreditos(8);
	c2.setCreditosRequeridos(3);
	c2.setCupo(20);
	Curso c3 = new Curso(43, "SyO", 2020);
	c3.setCreditos(8);
	c3.setCreditosRequeridos(3);
	c3.setCupo(20);
	Curso c4 = new Curso(24, "Matemática Superior", 2020);
	c4.setCreditos(8);
	c4.setCreditosRequeridos(3);
	c4.setCupo(20);
	Curso c5 = new Curso(65, "Gestión de Datos", 2020);
	c5.setCreditos(4);
	c5.setCreditosRequeridos(0);
	c5.setCupo(20);
	
	try {
	//Acepta inscripción
	c1.inscribir(a1);
	System.out.println("Alumno "+a1.getNombre()+" inscripto en curso "
			+ c1.getNombre());
		a1.aprobar(c1);
	//Acepta inscripción con creditos obtenidos
	c2.inscribir(a1);
	System.out.println("Alumno "+a1.getNombre()+" inscripto en curso "
			+ c2.getNombre());
	c3.inscribir(a1);
	System.out.println("Alumno "+a1.getNombre()+" inscripto en curso "
			+ c3.getNombre());
	c4.inscribir(a1);
	System.out.println("Alumno "+a1.getNombre()+" inscripto en curso "
			+ c4.getNombre());
	//Falla inscripción por cantidad de cursados
	c5.inscribir(a1);
	System.out.println("Alumno "+a1.getNombre()+" inscripto en curso "
			+ c5.getNombre());
	
	//Falla inscripción por creditos obtenidos	
	c2.inscribir(a2);
	System.out.println("Alumno "+a2.getNombre()+" inscripto en curso "
			+ c2.getNombre());
	//Inscribe alumnos a un curso
	c1.inscribir(a3);
	c1.inscribir(a4);
	c1.inscribir(a5);
	//Falla inscripción por cupo
	c1.inscribir(a2);
	System.out.println("Alumno "+a2.getNombre()+" inscripto en curso "
			+ c1.getNombre());
	
	//Imprimir inscriptos a un curso en distintos ordenes
	c1.imprimirInscriptos();
	c1.imprimirInscriptos(new ComparaAlumnoCreditos());
	c1.imprimirInscriptos(new ComparaAlumnoLibreta());
	}
	catch(ExcepcionCreditos|ExcepcionCupo|ExcepcionInscripto|ExcepcionCursando e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	catch(ExcepcionRegistroAuditoria e) {
		System.out.println("Hubo un problema: "+e.getMessage());
		e.printStackTrace();
		
	}
	}
}
