package myPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Zuord {

	// HashMap<String, Long> praeferenzMatrix = new HashMap<String, Long>();
	// ArrayList<Studi, ArrayList<Long>> praeferenzMatrix = new
	// ArrayList<Studi,ArrayList<Long>>();
	HashMap<Studi, ArrayList<Long>> praeferenzMatrix = new HashMap<Studi, ArrayList<Long>>();

	//ArrayList<Long> gesamtNutzenArr = new ArrayList<Long>();
	//public int[] nutzWerte = new int[];
	
	ArrayList<Long> nutzWerte = new ArrayList<Long>();
	 

	public void praeferenzMatrixBerechnen(Studi studi, ArrayList<Studi> registrierteStudierende) {
		
		int i = 0;
		for (Studi s : registrierteStudierende) {
			
			//praeferenzMatrix.clear();
			System.out.println("Aktuelles Obj in Schleife: " + s.name);
			int gesamtNutzenS = 0;
			int gesamtNutzenStudi = 0;
			long gesamtNutzen = 0;
			

			int z = 0;
			//gesamtNutzenArr = null;
			if (!studi.equals(s)) {
				if (studi.fitnessInf < s.fitnessInf && studi.fitnessMathe < s.fitnessMathe) {
					gesamtNutzenStudi = (s.fitnessInf - studi.fitnessInf) + (s.fitnessMathe - studi.fitnessMathe);
					gesamtNutzenS = 0;
				}
				if (studi.fitnessInf > s.fitnessInf && studi.fitnessMathe > s.fitnessMathe) {
					gesamtNutzenS = (studi.fitnessInf - s.fitnessInf) + (studi.fitnessMathe - s.fitnessMathe);
					gesamtNutzenStudi = 0;
				}
				if (studi.fitnessInf < s.fitnessInf && studi.fitnessMathe > s.fitnessMathe) {
					gesamtNutzenStudi = s.fitnessInf - studi.fitnessInf;
					gesamtNutzenS = studi.fitnessMathe - s.fitnessMathe;

				}
				if (studi.fitnessInf > s.fitnessInf && studi.fitnessMathe < s.fitnessMathe) {
					gesamtNutzenS = studi.fitnessInf - s.fitnessInf;
					gesamtNutzenStudi = s.fitnessMathe - studi.fitnessMathe;

				}

				gesamtNutzen = gesamtNutzenStudi + gesamtNutzenS;

				System.out
						.println("name: " + studi.name + " inf: " + studi.fitnessInf + " mathe: " + studi.fitnessMathe);
				System.out.println("name: " + s.name + " inf: " + s.fitnessInf + " mathe: " + s.fitnessMathe);
				System.out.println(s.name + " profitiert mit " + studi.name + " : " + gesamtNutzenS);
				System.out.println(studi.name + " profitiert mit " + s.name + " : " + gesamtNutzenStudi);
				System.out.println("Gesamtnutzen zw. " + studi.name + " und " + s.name + " : " + gesamtNutzen);
				System.out.println("--------");

				nutzWerte.add((long) gesamtNutzenStudi);

			} else {
				gesamtNutzen = 0;
				nutzWerte.add((long) 0);
				

			}
			
			
			
		}
		praeferenzMatrix.put(studi, nutzWerte);
		
		
		
		//System.out.println(registrierteStudierende.toString());
		
		// zunaechst mit keySet alle Schluessel ausgeben (studi-objekte) und dann toString-Methode aus Studi-Klasse anwenden.
		System.out.println(praeferenzMatrix.keySet().toString());
		System.out.println(praeferenzMatrix.values());
		nutzWerte.clear();
		//System.out.println(nutzWerte.toString());
		//System.out.println(nutzWerte.size());
	}
	
	

}
