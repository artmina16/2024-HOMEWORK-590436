package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.attrezzi.*;
import diadia.giocatore.*;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo falce;
	Attrezzo sega;
	
	@BeforeEach
	public void setUp() {
		falce = new Attrezzo("falce", 2);
		sega = new Attrezzo("sega", 16);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(sega));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));

	}
}
