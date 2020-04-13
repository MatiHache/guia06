package died.guia06;

import java.util.List;
import java.util.ArrayList;

import org.junit.platform.commons.util.StringUtils;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

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
	
	public int creditosObtenidos() {

		int creditos = 0;
		for(Curso unCurso: this.aprobados) {
			creditos += unCurso.getCreditos();
		}
		
		return creditos;
		}

	public void aprobar(Curso c) {
		this.cursando.remove(c);
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	@Override
	public boolean equals(Object a) {
		Alumno al = (Alumno) a;
		if(this.nroLibreta ==  al.nroLibreta) return true;
		else return false;
	}
	
	@Override
	public int compareTo(Alumno a) {
		return this.getNombre().compareTo(a.getNombre());
	}

}
