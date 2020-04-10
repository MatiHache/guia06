package died.guia06;

import java.util.List;

import org.junit.platform.commons.util.StringUtils;


public class Alumno implements Comparator<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno() {}
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	public StringUtilsing getNombre() {
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
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	
	@Override
	public boolean equals(Alumno a) {
		if(this.nroLibreta == (Alumno) a.nroLibreta) return true;
		else return false;
	}
	
	@Override
	public int compare(Alumno a1, Alumno a2) {
		a1 = this;		
		return a1.getNombre().compareTo(a2.getNombre());
	}

}
