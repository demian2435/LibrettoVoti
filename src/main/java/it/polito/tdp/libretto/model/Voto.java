package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe {@link Voto}, contiene le informazioni su un esame superato
 * 
 * @author D2435
 *
 */


public class Voto implements Comparable<Voto>{
	
	private String corso; // Tecniche di Programmazione
	private int voto; // 28
	private LocalDate data; // 15.06.2020

	/**
	 * Costruisce un nuovo {@link Voto}
	 * 
	 * @param corso nome del corso superato
	 * @param voto valore del voto acquisito
	 * @param data data di superamento corso
	 */
	public Voto(String corso, int voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}
	
	/**
	 * Copy Constructor di {@link Voto}
	 * @param v {@link Voto} da copiare
	 */
	public Voto(Voto _v) {
		super();
		this.corso = _v.corso;
		this.voto = _v.voto;
		this.data = _v.data;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String toString() {
		return corso + ": " + voto + " (" + data + ")";
	}
	
	/**
	 * Crea un clone dell'oggetto {@link Voto}
	 */
	public Voto clone() {
		Voto v = new Voto(this.corso, this.voto, this.data);
		return v;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}

	@Override
	public int compareTo(Voto other) {
		/*
		* 0 this < other
		* = 0 this == other
		* > 0 this > other
		*/
		return this.corso.compareTo(other.corso);
	}
	
}
