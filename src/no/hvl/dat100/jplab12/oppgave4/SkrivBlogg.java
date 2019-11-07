package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {

		try {
			
			PrintWriter skriver = new PrintWriter(MAPPE + filnavn);
			Innlegg[] b = samling.getSamling();
			
			skriver.println(samling.getAntall());
			
			for(int i = 0; i < samling.getAntall(); i++) {
				
				skriver.println(b[i].toString());
				
			}
			
			skriver.close();
			
			return true;
			
		}catch(FileNotFoundException e) {
			
			System.out.println("Finner ikke filen");
			
			return false;
			
		}
		
	}
}
