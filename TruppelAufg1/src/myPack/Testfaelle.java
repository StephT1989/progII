package myPack;

import java.util.Arrays;

public class Testfaelle {
	
	public static void main(String[] args) {
		Zuord z = new Zuord();
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler(z);
		
		
		KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, "A", 0, 10,z);
		KonkreterStudi konkreterStudi1 = new KonkreterStudi(konkreterVermittler, "B", 3, 7,z);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "C", 6, 6,z);
		KonkreterStudi konkreterStudi3 = new KonkreterStudi(konkreterVermittler, "D", 10, 1,z);
		
		
		
		konkreterStudi1.vermitteln();
		konkreterStudi3.vermitteln();
		konkreterStudi2.vermitteln();
		
		//konkreterStudi.registrieren();
		//konkreterStudi2.registrieren();
		//konkreterStudi2.registrieren();
		
		//konkreterVermittler.registrierteStudisAusgeben();
		
		//Studi[] Studenten = { konkreterStudi,konkreterStudi1,konkreterStudi2,konkreterStudi3 };
		//System.out.println((Arrays.deepToString(Studenten)).toString());
		
		//System.out.println(konkreterStudi.toString());
		
		
		
	}
	

}
