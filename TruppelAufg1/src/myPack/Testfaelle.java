package myPack;

public class Testfaelle {
	
	public static void main(String[] args) {
		
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler();
		
		KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, "Penis", 1, 9);
		KonkreterStudi konkreterStudi1 = new KonkreterStudi(konkreterVermittler, "Penis", 1, 9);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "Penis", 1, 9);
		
		//konkreterStudi.registrieren();
		//konkreterStudi2.registrieren();
		//konkreterStudi2.registrieren();
		
		konkreterVermittler.registrierteStudisAusgeben();
		
	}
	

}
