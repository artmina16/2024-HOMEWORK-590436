package diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import diadia.ambienti.*;

public class LabirintoTest {
    
    private Labirinto labirinto;
    
    @BeforeEach
    public void setUp() {
        this.labirinto = new Labirinto();
        this.labirinto.creaStanze();
        Stanza nuovaStanza = new Stanza("Nuova Stanza");
        this.labirinto.setStanzaCorrente(nuovaStanza);
    }
    
    @Test
    public void testGetStanzaCorrente() {
        assertNotNull(this.labirinto.getStanzaCorrente());
    }
    
    @Test
    public void testSetStanzaCorrente() {
        
        assertEquals( this.nuovaStanza , labirinto.getStanzaCorrente());
    }
    
    @Test
    public void testGetStanzaVincente() {
        assertNotNull(this.labirinto.getStanzaVincente());
    }

    
   