package died.guia06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class AlumnoTest {

	private Alumno a1;
	private Curso c1;
	private Curso c2;

	public AlumnoTest() {};
	
	@BeforeEach
	public void setUp() {
		
		a1 = new Alumno("Matías Hillar",25315);
		c1 = new Curso();
		c2 = new Curso();
		c1.setCreditos(6);
		c2.setCreditos(8);
		c1.setCreditosRequeridos(0);
		c2.setCreditosRequeridos(0);
		c1.setCupo(20);
		c2.setCupo(20);
		assertDoesNotThrow(() -> c1.inscribir(a1));
		assertDoesNotThrow(() -> c2.inscribir(a1));
		
	}
	@After
	public void tearDown() {
	}
	 
	
	//Test de método: CreditosObtenido()
	@Test 
	public void testCreditosObtenidos() {
		a1.aprobar(c1);
		a1.aprobar(c2);
		int Creditos = a1.creditosObtenidos();
		assertEquals(14,Creditos);
	}
	
	//Test de método: Aprobar()
	@Test
	void testAprobar() {
		a1.aprobar(c1);
		a1.aprobar(c2);
		List<Curso> prueba = new ArrayList<>();
		prueba.add(c1);
		prueba.add(c2);
		assertEquals(prueba, a1.getAprobados());
	}
	
	//Test de método: InscripcionAceptada()
	@Test
	void testInscripcionAceptada() {
		List<Curso> prueba = new ArrayList<>();
		prueba.add(c1);
		prueba.add(c2);
		assertEquals(prueba, a1.getCursando());
	}

}
