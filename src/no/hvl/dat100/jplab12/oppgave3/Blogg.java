package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import java.util.regex.*;

public class Blogg {

	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	public Blogg() {
		
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
		
	}

	public Blogg(int lengde) {
		
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
		
	}

	public int getAntall() {
		
		return nesteledig;
		
	}
	
	public Innlegg[] getSamling() {
		
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int pos = -1;

		for(int i = 0; i < nesteledig; i++) {
			
			if(innleggtabell[i].erLik(innlegg)) {
				
				pos = i;
				
			}
			
		}
		
		return pos;
	
	}

	public boolean finnes(Innlegg innlegg) {
		
		boolean t = false;
		
		int i = finnInnlegg(innlegg);
		
		if(i != -1) {
			
			t = true;
			
		}
		
		return t;
		
	}

	public boolean ledigPlass() {
		
		if(nesteledig < innleggtabell.length) {
			
			return true;
			
		}else{
			
			return false;
			
		}

	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if(!finnes(innlegg) && ledigPlass()) {
			
			innleggtabell[nesteledig] = innlegg;
			nesteledig ++;
			return true;
			
		}else {
			
			return false;
			
		}

	}
	
	public String toString() {
		
		String txt = nesteledig + "\n";
		
		for(int i = 0; i < nesteledig; i++) {
			
			txt += innleggtabell[i].toString();
			
		}
		
		return txt;
		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] kast = innleggtabell;
		
		innleggtabell = new Innlegg[innleggtabell.length * 2];
		
		for(int i = 0; i < nesteledig; i++) {
			
			innleggtabell[i] = kast[i];
			
		}
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(finnes(innlegg)) {
			
			return false;
			
		}else {
			
			if(nesteledig >= innleggtabell.length) {
				
				utvid();
				innleggtabell[nesteledig] = innlegg;
				nesteledig ++;
				
			}else {
				
				innleggtabell[nesteledig] = innlegg;
				nesteledig ++;
				
			}
			
			return true;
			
		}
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		if(finnes(innlegg)) {
			
			int i = finnInnlegg(innlegg);
			innleggtabell[i] = null;
			
			innleggtabell[i] = innleggtabell[nesteledig-1];
			nesteledig --;
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public int[] search(String keyword) {
		
		Pattern p = Pattern.compile(keyword);
		
		int[] j = new int[nesteledig];
		int k = 0;
		
		for(int i = 0; i < nesteledig; i++) {
			
			Matcher m = p.matcher(innleggtabell[i].toString());
			
			if(m.find()) {
				
				j[k] = i;
				k++;
				
			}
			
		}
		
		return j;

	}
}
