package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.*;

import diadia.Partita;

public class PartitaTest {
	private static final int CFU_DEFAULT = 10;
	public Partita vinta;
	public Partita finita;
	public Partita cfu;
	
	@BeforeEach
	public void setUp() {
		this.vinta = new Partita();
		this.vinta.getLabirinto().setStanzaCorrente(this.vinta.getLabirinto().getStanzaVincente());
		
		this.finita = new Partita();
		this.finita.setFinita();
		
		this.cfu = new Partita();
		this.cfu.getGiocatore().setCfu(CFU_DEFAULT);
	}
	
	@Test
	public void testVinta() {
		assertTrue(this.vinta.vinta());
	}
    
	@Test
	public void testIsFinita() {
		assertTrue(this.finita.isFinita());
	}
	
	@Test
	public void testSetCfu() {
		assertEquals(this.cfu.getGiocatore().getCfu(),10);
	}
	

}
