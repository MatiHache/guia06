package died.guia06;

import java.util.List;
import java.util.ArrayList;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno() {
		super();
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
//Getters y Setters
	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}
	
	//Metodos de Negocio
	
	public int creditosObtenidos() {
		int creditos = 0;
		for(Curso unCurso: this.aprobados) {
			creditos += unCurso.getCreditos();
		}
		
		return creditos;
	
	}

	public void aprobar(Curso c) {
		if(this.cursando.contains(c)) {
		this.cursando.remove(c);
		this.aprobados.add(c);
		}
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	//Sobreescribe equals
	@Override
	public boolean equals(Object a) {
		Alumno al = (Alumno) a;
		if(this.nroLibreta ==  al.nroLibreta) return true;
		else return false;
	}
	//Sobreescribe compareTo
	@Override
	public int compareTo(Alumno a) {
		return this.getNombre().compareTo(a.getNombre());
	}

	//Sobreescribe toString
	@Override
	public String toString() {
		return "Alumno: "+this.nombre+" Libreta: "+this.nroLibreta+" Créditos: "+this.creditosObtenidos();
	}
}
