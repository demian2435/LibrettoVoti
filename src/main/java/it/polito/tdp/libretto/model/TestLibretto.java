package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		
		// 0. Crea Libretto vuoto
		this.lib = new Libretto();
		
		// 1. Inserisci i voti
		Voto v1 = new Voto("Tecniche di programazzione", 28, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi II", 20, LocalDate.of(2020, 06, 28));
		Voto v3 = new Voto("Biochimica", 30, LocalDate.of(2020, 07, 01));
		lib.Add(v1);
		lib.Add(v2);
		lib.Add(v3);
		lib.Add(new Voto("Economia", 23, LocalDate.of(2020, 02, 15)));
		//System.out.println(this.lib);
		
		// 2. Stampa i voti pari a 28
		//System.out.println(this.lib.stampaVotiUguali(28));
		//System.out.println(this.lib.estraiVotiUguali(28));
		
		// 3. Cerca un esame conoscendo il corso
		//System.out.println(this.lib.cercaNomeCorso("Biochimica").getVoto());
		
		// 4 e 5. Metodo duplicato e Conflitto
		//System.out.println(this.lib.isDuplicato(new Voto("Biochimica", 20, null)));
		//System.out.println(this.lib.isConflitto(new Voto("Biochimica", 21, null)));
		
		// 6. Migliora libretto
		//System.out.println(this.lib.creaLibrettoMigliorato());
		//System.out.println(this.lib);
		
		// 7. Stampa in ordine alfabetico ed in ordine di voto
		//Libretto alfabetico = new Libretto(this.lib);
		//alfabetico.ordinaPerCorso();
		//Libretto valutazione = new Libretto(this.lib);
		//valutazione.ordinaPerVoto();
		//System.out.println(alfabetico);
		//System.out.println(valutazione);
		//System.out.println(this.lib);
		
		this.lib.cancellaVotiScarsi();
		System.out.println(this.lib);
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto();
		test.run();
	}

}
