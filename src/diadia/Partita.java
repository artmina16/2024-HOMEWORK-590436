 package diadia;
import diadia.ambienti.*;
import diadia.giocatore.*;

public class Partita {
	
	
	private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	

 
public Partita() {	
	this.labirinto = new Labirinto();
	this.labirinto.creaStanze();
	this.finita = false;
	this.giocatore = new Giocatore();	
}

public Labirinto getLabirinto() {
	return labirinto;
}



public void setLabirinto(Labirinto labirinto) {
	this.labirinto = labirinto;
}

/**
 * Restituisce vero se e solo se la partita e' stata vinta
 * @return vero se partita vinta
 */
public boolean vinta() {
	return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
}

/**
 * Restituisce vero se e solo se la partita e' finita
 * @return vero se partita finita
 */
public boolean isFinita() {
	return finita || vinta() || (this.giocatore.getCfu() == 0);
}

/**
 * Imposta la partita come finita
 *
 */
public void setFinita() {
	this.finita = true;
}

public  Giocatore getGiocatore() {
	return this.giocatore;
}



}

