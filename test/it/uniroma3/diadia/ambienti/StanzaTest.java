package it.uniroma3.diadia;
import diadia.ambienti.*;
import diadia.attrezzi.*;

import static org.junit.jupiter.api.Assertions.*;  

import org.junit.jupiter.api.*;

public class StanzaTest {
	public Stanza stanzaCorrente;
	public Stanza stanzaNord;
	public Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		this.stanzaCorrente = new Stanza("Aula 11");
		this.stanzaNord = new Stanza("Biblio");
		this.stanzaCorrente.impostaStanzaAdiacente("nord", this.stanzaNord);
		this.attrezzo = new Attrezzo("pc",1);		
		this.stanzaCorrente.addAttrezzo(this.attrezzo);
	}
	
	@Test
	public void testStanzaAdiacente() {
		assertEquals(this.stanzaNord, this.stanzaCorrente.getStanzaAdiacente("nord") );
	}
	
	@Test
	public void testAggiuntaAttrezzo() {
		assertTrue(this.stanzaCorrente.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAttrezzoNellaStanza() {
		assertEquals(this.attrezzo, this.stanzaCorrente.getAttrezzo("pc"));
	}
	

}
