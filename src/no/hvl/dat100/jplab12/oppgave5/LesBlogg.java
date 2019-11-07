package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.NumberFormatException;

import static java.lang.Integer.parseInt;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		
		Blogg b = new Blogg();

		try {
			
			FileReader leser = new FileReader(MAPPE + filnavn);
			BufferedReader buffer = new BufferedReader(leser);
			
			String line;
			
			int ant = parseInt(buffer.readLine());
			
			int id;
			String bruker;
			String dato;
			int likes;
			String tekst;
			String url;
			
			b = new Blogg(ant);
			
			while((line = buffer.readLine()) != null) {
								
				if(line.equals(TEKST)) {
					
					id = parseInt(buffer.readLine());
					bruker = buffer.readLine();
					dato = buffer.readLine();
					likes = parseInt(buffer.readLine());
					tekst = buffer.readLine();
					
					Innlegg a = new Tekst(id,bruker,dato,likes,tekst);
					b.leggTilUtvid(a);
					
				}else {
					
					id = parseInt(buffer.readLine());
					bruker = buffer.readLine();
					dato = buffer.readLine();
					likes = parseInt(buffer.readLine());
					tekst = buffer.readLine();
					url = buffer.readLine();
					
					Innlegg c = new Bilde(id,bruker,dato,likes,tekst,url);
					b.leggTilUtvid(c);
					
				}
				
			}
			
			buffer.close();
			
		}catch(IOException e) {
			
			System.out.println(e);
			
		}
			
		return b;

	}
}
