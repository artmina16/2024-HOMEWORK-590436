package it.uniroma3.diadia;

import org.junit.jupiter.api.*;

public class ComandoVaiTest {
	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	
	@BeforeEach
	public void setUp() {
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		p = new Partita();
		vai.setIo(new IOConsole());
		
	}
	
	@Test
	public void TestVaiNull() {
		p.setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());
	}
	
	public void testVaiDirezioneEsistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("sud-ovest");
		vai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
	}

	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("in fondo a destra");
		vai.esegui(p);
		assertNotEquals(s2, p.getStanzaCorrente());
	}
	
	public void testPartitaConComandoVai() {
		String[] righeDaLeggere = {"vai nord", "fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());

	}
}
