package myPack;

public class Testfaelle {
	
	public static void main(String[] args) {
		
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler();
		
		KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, "A", 0, 10);
		KonkreterStudi konkreterStudi1 = new KonkreterStudi(konkreterVermittler, "B", 3, 7);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "C", 6, 6);
		KonkreterStudi konkreterStudi3 = new KonkreterStudi(konkreterVermittler, "D", 10, 0);
		
		konkreterStudi3.vermitteln();
		//konkreterStudi1.vermitteln();
		
		//konkreterStudi.registrieren();
		//konkreterStudi2.registrieren();
		//konkreterStudi2.registrieren();
		
		//konkreterVermittler.registrierteStudisAusgeben();
		
	}
	

}
