package no.hvl.dat100.jplab12.oppgave1;

import no.hvl.dat100.jplab12.common.TODO;

public abstract class Innlegg {
	
	private int id;
	private String bruker;
	private String dato;
	private int likes;
	
	public Innlegg(int id, String bruker, String dato) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		likes = 0;
		
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
		
	}
	
	public String getBruker() {
		
		return bruker;

	}

	public void setBruker(String bruker) {
		
		this.bruker = bruker;
		
	}

	public String getDato() {
		
		return dato;
		
	}

	public void setDato(String dato) {
		
		this.dato = dato;
		
	}

	public int getId() {
		
		return id;

	}

	public int getLikes() {
		
		return likes;

	}
	
	public void doLike () {
		
		likes ++;
		
	}
	
	public boolean erLik(Innlegg innlegg) {
		
		boolean t = false;
		
		if(id == innlegg.getId()) {
			
			t = true;
			
		}
		
		return t;

	}
	
	@Override
	public String toString() {
		
		String str;
		
		str = id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
		
		return str;
				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		String html;
		html = "<h2>" + bruker + "@" + dato + " [" + likes + "]" + "</h2>";
		
		return html;
				
	}
}
