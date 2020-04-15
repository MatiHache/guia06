package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.TestInstance.Lifecycle;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	private Registro log;
	
	public Curso() {
		super();
	}
	
	public Curso(int id, String nombre, int cicloLectivo) {
		super();
		this.id = id;
		this.cicloLectivo = cicloLectivo;
		this.nombre = nombre;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	//Getters y setters
	public String getNombre() {
	return nombre;	
	}
	
	public Integer getCupo() {
		return cupo;
	}


	public Integer getCreditos() {
		return creditos;
	}

	public List<Alumno> getInscriptos() {
		return inscriptos;
	}	

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		boolean retorno = false;
		try {
		if(a.creditosObtenidos()>=this.creditosRequeridos &&
						 this.inscriptos.size()<this.cupo &&
						 a.getCursando().size()<3 &&
						 !(this.inscriptos.contains(a))) {
		a.inscripcionAceptada(this);
		this.inscriptos.add(a);
		log.registrar(this, "inscribir ",a.toString());
		return true;
		}
		}
		catch(IOException e) {
			System.out.println("Hubo un problema: "+e.getMessage());
			e.printStackTrace();
		}
		return retorno;
	}

	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			 Collections.sort(this.inscriptos);			
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		System.out.println(this.inscriptos);
		}
		catch(IOException e) {
			System.out.println("Hubo un problema: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void imprimirInscriptos(Comparator<Alumno> c) {
		try {
			 Collections.sort(this.inscriptos, c);			
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		System.out.println(this.inscriptos);
		}
		catch(IOException e) {
			System.out.println("Hubo un problema: "+e.getMessage());
			e.printStackTrace();
		}
	}
}



