package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati
 * @author D2435
 *
 */
public class Libretto {
	
	private List<Voto> voti;
	
	/**
	 * Crea un nuovo Libretto vuoto
	 * @param voti
	 */
	public Libretto() {
		this.voti = new ArrayList<>();
	}

	/**
	 * Aggiunge un nuovo Voto al Libretto
	 * @param v Voto da aggiungere
	 */
	public void Add(Voto v) {
		this.voti.add(v);
	}
	
	/**
	 * Dato un Libretto restituisce una stringa nella quale 
	 * ci sono solo voti pari al parametro passato
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali (int voto) {
		String s = "";
		for(Voto v: this.voti) {
			if(v.getVoto() == voto) {
				s += v + "\n";
			}
		}
		return s;
	}
	
	
	/**
	 * Genera un libretto, a partire da quello esistente
	 * che conterrà esclusivamente i Voti uguali al volore specificato
	 * @param voto votazione specifica
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto() == voto) {
				nuovo.Add(v);
			}
		}
		return nuovo;
	}
	
	public String toString() {
		String s = "";
		for(Voto v: this.voti) {
			s += v + "\n";
		}
		return s;
	}

}
