package died.guia06;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	private Alumno puedeInscribir;
	private Alumno noPuedeInscribir;
	private Alumno puedeInscribir2;
	private Curso c1;
	
	@BeforeEach
	void setUp() {
		c1 = new Curso();
		c1.setCreditosRequeridos(5);
		c1.setCupo(20);
		
		puedeInscribir = new Alumno("Matías Hillar", 25315) {
			@Override
			public int creditosObtenidos() {
				return 5;
			}
		};
		noPuedeInscribir = new Alumno("Juan Perez", 12345) {
			@Override
			public int creditosObtenidos() {
				return 4;
			}
		};
		puedeInscribir2 = new Alumno("Alberto Sanchez", 14245) {
			@Override
			public int creditosObtenidos() {
				return 10;
			}
		};
		 	
	
	}

	@After
	void tearDown() {
	}

	@Test
	void testPuedeInscribir() {
		assertTrue(c1.inscribir(puedeInscribir));
		
	}
	
	@Test
	void testNoPuedeInscribir() {
		assertFalse(c1.inscribir(noPuedeInscribir));
		
	}

	@Test
	void testImprimirInscriptos() {
		List<Alumno> inscriptosTest = new ArrayList<>();
		c1.inscribir(puedeInscribir);
		c1.inscribir(puedeInscribir2);
		inscriptosTest.add(puedeInscribir2);
		inscriptosTest.add(puedeInscribir);
		c1.imprimirInscriptos();
		assertEquals(c1.getInscriptos(), inscriptosTest);
		
	}

}
