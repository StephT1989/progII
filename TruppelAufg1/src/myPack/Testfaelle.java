package myPack;

import java.util.ArrayList;
import java.util.Arrays;

public class Testfaelle {
	
	public static void main(String[] args) {
		Zuord z = new Zuord();
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler(z);
		
		
		KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, "A", 0, 10,z);
		KonkreterStudi konkreterStudi1 = new KonkreterStudi(konkreterVermittler, "B", 3, 7,z);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "C", 6, 6,z);
		KonkreterStudi konkreterStudi3 = new KonkreterStudi(konkreterVermittler, "D", 10, 1,z);
		
		System.out.println(konkreterVermittler.registrierteStudierende.toString());
		
		System.out.println("So sieht das dann aus: " + konkreterStudi.praefMatrixAusgeben().toString());
		System.out.println("So sieht das dann aus: " + konkreterStudi1.praefMatrixAusgeben().toString());
		System.out.println("So sieht das dann aus: " + konkreterStudi2.praefMatrixAusgeben().toString());
		System.out.println("So sieht das dann aus: " + konkreterStudi3.praefMatrixAusgeben().toString());
		
		
		
		
		
		
	}
	

}
