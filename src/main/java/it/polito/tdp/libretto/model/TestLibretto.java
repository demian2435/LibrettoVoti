package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		this.lib = new Libretto(); // Crea Libretto vuoto
		
		Voto v1 = new Voto("Tecniche di programazzione", 28, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28));
		Voto v3 = new Voto("Biochimica", 20, LocalDate.of(2020, 07, 01));

		lib.Add(v1);
		lib.Add(v2);
		lib.Add(v3);
		lib.Add(new Voto("Economia", 24, LocalDate.of(2020, 02, 15)));
		
		System.out.println(this.lib);
		
		System.out.println(this.lib.stampaVotiUguali(28));
		
		System.out.println(this.lib.estraiVotiUguali(28));
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto();
		test.run();
	}

}
