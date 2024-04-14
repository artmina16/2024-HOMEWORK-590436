package diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.attrezzi.*;
import diadia.giocatore.*;

public class BorsaTest {
    
    private Borsa borsa;
    
    @BeforeEach
    public void setUp() {
        this.borsa = new Borsa();
    }
    
    @Test
    public void testAddAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Martello", 5);
        assertTrue(this.borsa.addAttrezzo(attrezzo));
    }
    
    @Test
    public void testGetAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Chiave", 2);
        this.borsa.addAttrezzo(attrezzo);
        assertEquals(attrezzo, this.borsa.getAttrezzo("Chiave"));
    }
    
    @Test
    public void testGetPeso() {
        Attrezzo attrezzo1 = new Attrezzo("Libro", 3);
        Attrezzo attrezzo2 = new Attrezzo("Penna", 1);
        this.borsa.addAttrezzo(attrezzo1);
        this.borsa.addAttrezzo(attrezzo2);
        assertEquals(4, this.borsa.getPeso());
    }
    
    