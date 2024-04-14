package diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.giocatore.Giocatore;

public class GiocatoreTest {
    
    private Giocatore giocatore;
    
    @BeforeEach
    public void setUp() {
        this.giocatore = new Giocatore();
        this.giocatore.setCfu(10);
    }
    
    @Test
    public void testGetCfu() {
        assertEquals(10, this.giocatore.getCfu());
    }
    
    @Test
    public void testSetCfu() {
        
        assertEquals(10, this.giocatore.getCfu());
    }
    
    @Test
    public void testGetBorsa() {
        assertNotNull(this.giocatore.getBorsa());
    }
}
