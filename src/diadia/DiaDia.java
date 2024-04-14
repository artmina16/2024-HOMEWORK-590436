package diadia;



import java.util.Scanner;

import diadia.attrezzi.*;
import diadia.ambienti.*;



/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai <direzione> ", "aiuto", "fine", "posa <nome attrezzo>","prendi <nome attrezzo>"};

	private Partita partita;
	public static IOConsole IOConsole;
	
	public DiaDia() {
		this.partita = new Partita();
		
		
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		IOConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = IOConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		if(istruzione.isEmpty()) return false;
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		}
		else if(comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
		}
		else
			IOConsole.mostraMessaggio("comando sconosciuto");
		if (this.partita.vinta()) {
			this.partita.setFinita();
			IOConsole.mostraMessaggio("Hai vinto!!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	private void prendi(String nomeAttrezzo) {
		
		if(nomeAttrezzo == null) {
			IOConsole.mostraMessaggio("Quale attrezzo vuoi prendere?");
			
		}
		
		Attrezzo attrezzoPreso = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoPreso);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso);
		IOConsole.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	}
	
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			IOConsole.mostraMessaggio("Quale attrezzo vuoi posare?");	
		}
		Attrezzo attrezzoPosato = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPosato);
		
		IOConsole.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().toString());
		
	}
	
	

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IOConsole.mostraMessaggio(elencoComandi[i]);
		IOConsole.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IOConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IOConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		IOConsole.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.partita.setFinita();
		IOConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole = new IOConsole();
		gioco.getPartita().getLabirinto().creaStanze();
		gioco.gioca();
		
	}

	public Partita getPartita() {
		// TODO Auto-generated method stub
		return this.partita;
	}
}
