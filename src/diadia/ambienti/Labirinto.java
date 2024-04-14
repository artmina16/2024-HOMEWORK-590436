package diadia.ambienti;



import java.util.function.BooleanSupplier;

import diadia.attrezzi.*;



public class Labirinto {
 private Stanza stanzaCorrente ;
 private Stanza stanzaVincente ;
 
public Labirinto() {
	this.stanzaCorrente = new Stanza("atrio");
	this.stanzaVincente = new Stanza("biblioteca");
	
}
public Stanza getStanzaCorrente() {
	return stanzaCorrente;
}
public void setStanzaCorrente(Stanza stanzaIniziale) {
	this.stanzaCorrente = stanzaIniziale;
}
public Stanza getStanzaVincente() {
	return stanzaVincente;
}
public void setStanzaVincente(Stanza stanzaFinale) {
	this.stanzaVincente = stanzaFinale;
}
 public void creaStanze() {
	 /* crea gli attrezzi */
 	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
 	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

     /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
 }
public BooleanSupplier getLabirinto(Labirinto labirinto) {
	// TODO Auto-generated method stub
	return null;
}
}
