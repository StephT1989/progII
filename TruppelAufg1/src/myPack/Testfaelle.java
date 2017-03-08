package myPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random ;

public class Testfaelle {
	
	public static void main(String[] args) {
		Zuord z = new Zuord();
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler(z);
		
		
		ArrayList<Studi> arrayliststudi = new ArrayList<Studi>();
		Studi[] arrStudis = new Studi[26];
		Random rand1 = new Random(123);
		Random rand2 = new Random(123);
		//rand1 = new Random(123);
		int  pseudoZufall1;
		int  pseudoZufall2;
		int i = 0;
		char alphabet = 'A';
		while (i <=25 && alphabet<= 'Z'){
			
			pseudoZufall1 = rand1.nextInt(10);
			pseudoZufall2 = rand2.nextInt(10);
			String name = String.valueOf(alphabet);
			KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, name, pseudoZufall1, pseudoZufall2, z);
			arrayliststudi.add(konkreterStudi);
			arrStudis[i] = konkreterStudi;
			i++;
			alphabet++;
			
		}
		//System.out.println(arrStudis.toString());
		/*
		KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, "A", 0, 10,z);
		KonkreterStudi konkreterStudi1 = new KonkreterStudi(konkreterVermittler, "B", 3, 7,z);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "C", 6, 6,z);
		KonkreterStudi konkreterStudi3 = new KonkreterStudi(konkreterVermittler, "D", 10, 1,z);
		
		KonkreterStudi konkreterStudi4 = new KonkreterStudi(konkreterVermittler, "E", 0, 10,z);
		KonkreterStudi konkreterStudi5 = new KonkreterStudi(konkreterVermittler, "F", 3, 7,z);
		KonkreterStudi konkreterStudi6 = new KonkreterStudi(konkreterVermittler, "g", 6, 6,z);
		KonkreterStudi konkreterStudi7 = new KonkreterStudi(konkreterVermittler, "h", 10, 1,z);
		KonkreterStudi konkreterStudi8= new KonkreterStudi(konkreterVermittler, "i", 0, 10,z);
		KonkreterStudi konkreterStudi9= new KonkreterStudi(konkreterVermittler, "ä", 0, 10,z);
		KonkreterStudi konkreterStudi10 = new KonkreterStudi(konkreterVermittler, "j", 3, 7,z);
		KonkreterStudi konkreterStudi11 = new KonkreterStudi(konkreterVermittler, "k", 6, 6,z);
		KonkreterStudi konkreterStudi12 = new KonkreterStudi(konkreterVermittler, "l", 10, 1,z);
		KonkreterStudi konkreterStudi13 = new KonkreterStudi(konkreterVermittler, "m", 0, 10,z);
		KonkreterStudi konkreterStudi14 = new KonkreterStudi(konkreterVermittler, "n", 3, 7,z);
		KonkreterStudi konkreterStudi15 = new KonkreterStudi(konkreterVermittler, "o", 6, 6,z);
		KonkreterStudi konkreterStudi16 = new KonkreterStudi(konkreterVermittler, "p", 10, 1,z);
		KonkreterStudi konkreterStudi17 = new KonkreterStudi(konkreterVermittler, "q", 0, 10,z);
		KonkreterStudi konkreterStudi18 = new KonkreterStudi(konkreterVermittler, "r", 3, 7,z);
		KonkreterStudi konkreterStudi19 = new KonkreterStudi(konkreterVermittler, "s", 6, 6,z);
		KonkreterStudi konkreterStudi20 = new KonkreterStudi(konkreterVermittler, "t", 10, 1,z);
		KonkreterStudi konkreterStudi21 = new KonkreterStudi(konkreterVermittler, "u", 0, 10,z);
		KonkreterStudi konkreterStudi22 = new KonkreterStudi(konkreterVermittler, "v", 3, 7,z);
		KonkreterStudi konkreterStudi23 = new KonkreterStudi(konkreterVermittler, "w", 6, 6,z);
		KonkreterStudi konkreterStudi24 = new KonkreterStudi(konkreterVermittler, "x", 10, 1,z);
		KonkreterStudi konkreterStudi25= new KonkreterStudi(konkreterVermittler, "y", 0, 10,z);
		KonkreterStudi konkreterStudi26 = new KonkreterStudi(konkreterVermittler, "z", 3, 7,z);
		*/
		
		
		//System.out.println(konkreterVermittler.registrierteStudierende.toString());
		
		/*System.out.println("So sieht das dann aus: " + konkreterStudi.praefMatrixAusgeben().toString());
		System.out.println("So sieht das dann aus: " + konkreterStudi1.praefMatrixAusgeben().toString());
		System.out.println("So sieht das dann aus: " + konkreterStudi2.praefMatrixAusgeben().toString());
		System.out.println("So sieht das dann aus: " + konkreterStudi3.praefMatrixAusgeben().toString());
		*/
		
		
		/*
		
		arrayliststudi.add(konkreterStudi);
		arrayliststudi.add(konkreterStudi1);
		arrayliststudi.add(konkreterStudi2);
		arrayliststudi.add(konkreterStudi3);
		
		arrayliststudi.add(konkreterStudi4);
		arrayliststudi.add(konkreterStudi5);
		arrayliststudi.add(konkreterStudi6);
		arrayliststudi.add(konkreterStudi7);
		arrayliststudi.add(konkreterStudi8);
		arrayliststudi.add(konkreterStudi9);
		arrayliststudi.add(konkreterStudi10);
		arrayliststudi.add(konkreterStudi11);
		arrayliststudi.add(konkreterStudi12);
		arrayliststudi.add(konkreterStudi13);
		arrayliststudi.add(konkreterStudi14);
		arrayliststudi.add(konkreterStudi15);
		arrayliststudi.add(konkreterStudi16);
		arrayliststudi.add(konkreterStudi17);
		arrayliststudi.add(konkreterStudi18);
		arrayliststudi.add(konkreterStudi19);
		arrayliststudi.add(konkreterStudi20);
		arrayliststudi.add(konkreterStudi21);
		arrayliststudi.add(konkreterStudi22);
		arrayliststudi.add(konkreterStudi23);
		arrayliststudi.add(konkreterStudi24);
		arrayliststudi.add(konkreterStudi25);
		arrayliststudi.add(konkreterStudi26);
		*/
		
		z.vermittlungBerechnen(arrayliststudi);
		//z.vermittlungBerechnen(arrStudis);
		
		
		
		
		
	}
	

}
