package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di {@link Voto} superati
 * 
 * @author D2435
 *
 */
public class Libretto {
	
	private List<Voto> voti = new ArrayList<>();
	
	/**
	 * Crea un nuovo {@link Libretto} vuoto
	 * 
	 * @param voti
	 */
	public Libretto() {
		super();
	}
	
	/**
	 * Copy Contructor della classe {@link Libretto}
	 * "Shallow" (Lista nuova, Voti condivisi) e non "Deep"
	 * (Lista nuova, voti clonati)
	 * 
	 * @param lib {@link Libretto} da copiare
	 */
	public Libretto(Libretto lib) {
		super();
		this.voti.addAll(lib.voti);
	}

	/**
	 * Aggiunge un nuovo {@link Voto} al {@link Libretto}
	 * 
	 * @param _v {@link Voto} da aggiungere
	 * @return Ritorna {@code true} se aggiunge il {@link Voto},
	 * ritorna {@code false} nel caso di conflitto o duplicato
	 */
	public boolean Add(Voto _v) {
		if(this.isConflitto(_v) || this.isDuplicato(_v)){
			// Non inserire il voto
			return false;
		} else {
			// Inserisci il voto
			this.voti.add(_v);
			return true;
		}
	}
	
	/**
	 * Dato un {@link Libretto} restituisce una stringa nella quale 
	 * ci sono solo le stringe dei {@link Voto} pari al parametro passato
	 * 
	 * @param _voto numero valore specifico della votazione
	 * @return stringa formattata per visualizzare il sotto-{@link Libretto}
	 */
	public String stampaVotiUguali (int _voto) {
		String s = "";
		for(Voto v: this.voti) {
			if(v.getVoto() == _voto) {
				s += v + "\n";
			}
		}
		return s;
	}
	
	
	/**
	 * Genera un {@link Libretto}, a partire da quello esistente
	 * che conterrà esclusivamente i {@link Voto} uguali al volore specificato
	 * 
	 * @param _voto numero valore specifico della votazione
	 * @return nuovo {@link Libretto} "ridotto"
	 */
	public Libretto estraiVotiUguali(int _voto) {
		Libretto nuovo = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto() == _voto) {
				nuovo.Add(v);
			}
		}
		return nuovo;
	}
	
	/**
	 * Override del metodo tostring()
	 */
	public String toString() {
		String s = "";
		for(Voto v: this.voti) {
			s += v + "\n";
		}
		return s;
	}

	/**
	 * Dato il suo nome cerca l'oggetto {@link Voto} nel {@link Libretto}
	 * 
	 * @param _nome Nome del corso da cercare nel {@link Libretto}
	 * @return Ritorna l'oggetto {@link Voto} corrispondente, se non presente {@code null}
	 */
	public Voto cercaNomeCorso(String _nome) {
		/* Vecchio metodo
		for(Voto v: this.voti) {
			if(v.getCorso().equals(_nome)) {
				return v;
			}
		}
		return null;
		*/
		
		// Nuovo Metodo
		int pos = this.voti.indexOf(new Voto(_nome, 0, null));
		if(pos != -1) {
			return this.voti.get(pos);
		} else {
			return null;
		}
	}
	
	/**
	 * Ritorna {@code true} se il corso specificato dal {@link Voto} esiste nel {@link Libretto}
	 * con la stessa valutazione, Se valutazione diversa o non esiste ritorna {@code false}
	 * 
	 * @param _v {@link Voto} da cercare
	 * @return l'esistenza di un duplicato
	 */
	public boolean isDuplicato(Voto _v) {
		Voto duplicato = this.cercaNomeCorso(_v.getCorso());
		if(duplicato == null) {
			return false;
		}		
		return duplicato.getVoto() == _v.getVoto();
	}
	
	/**
	 * Determina se esiste un {@link Voto} con lo stesso nome corso ma con valutazione diversa
	 * 
	 * @param _v {@link Voto} da controllare
	 * @return l'esistenza di un conflitto
	 */
	public boolean isConflitto(Voto _v) {
		Voto duplicato = this.cercaNomeCorso(_v.getCorso());
		if(duplicato == null) {
			return false;
		}		
		return duplicato.getVoto() != _v.getVoto();
	}
	
	/**
	 * Crea un {@link Libretto} migliorato, aumentando i {@link Voto} presenti
	 *
	 * @return Un {@link Libretto} migliorato
	 */
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo = new Libretto();
		
		for(Voto v : this.voti) {
			// Voto v2 = new Voto(v);
			Voto v2 = v.clone();
			
			if(v2.getVoto() >= 24) {
				v2.setVoto(v2.getVoto() + 2);
				if(v2.getVoto() > 30) {
					v2.setVoto(30);
				}
			} else {
				v2.setVoto(v2.getVoto() + 1);
			}
			
			nuovo.Add(v2);
		}
		return nuovo;
	}
	
	/**
	 * Ordina i {@link Voto} nel {@link Libretto} in ordine alfabetico del corso 
	 */
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	/**
	 * Ordina i {@link Voto} nel {@link Libretto} per voto dei corsi
	 */
	public void ordinaPerVoto() {
		this.voti.sort((v1, v2) -> v2.getVoto() - v1.getVoto());
		//Collections.sort(this.voti, new ConfrontaVotiPerValutazione());
	}
	
	
	/**
	 * Elimina tutti i {@link Voto} dal {@link Libretto} inferioiri a 24
	 */
	public void cancellaVotiScarsi() {
		Libretto rimuovere = new Libretto();
		
		for(Voto v : this.voti) {
			if(v.getVoto() < 24) {
				rimuovere.Add(v);
			}
		}
		
		this.voti.removeAll(rimuovere.voti);
	}

}
