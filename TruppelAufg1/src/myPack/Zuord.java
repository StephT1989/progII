package myPack;

import java.util.ArrayList;
import java.util.HashMap;

public class Zuord {

	// HashMap<String, Long> praeferenzMatrix = new HashMap<String, Long>();
	ArrayList<ArrayList<Long>> praeferenzMatrix = new ArrayList<ArrayList<Long>>();
	ArrayList<Long> gesamtNutzenArr = new ArrayList<Long>();

	public void praeferenzMatrixBerechnen(Studi studi, ArrayList<Studi> registrierteStudierende) {
		int i = 0;
		for (Studi s : registrierteStudierende) {
			System.out.println("Aktuelles Obj in Schleife: " + s.name);
			int gesamtNutzenS = 0;
			int gesamtNutzenStudi = 0;
			long gesamtNutzen = 0;
			gesamtNutzenArr = null;
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
					// if ((studi.fitnessInf == s.fitnessInf &&
					// studi.fitnessMathe == s.fitnessMathe ))
					// {
					// }
				}

				gesamtNutzen = gesamtNutzenStudi + gesamtNutzenS;
				// gesamtNutzenArr.add(gesamtNutzen);
				System.out
						.println("name: " + studi.name + " inf: " + studi.fitnessInf + " mathe: " + studi.fitnessMathe);
				System.out.println("name: " + s.name + " inf: " + s.fitnessInf + " mathe: " + s.fitnessMathe);
				System.out.println(s.name + " profitiert mit " + studi.name + " : " + gesamtNutzenS);
				System.out.println(studi.name + " profitiert mit " + s.name + " : " + gesamtNutzenStudi);
				System.out.println("Gesamtnutzen zw. " + studi.name + " und " + s.name + " : " + gesamtNutzen);
				System.out.println("--------");
				// System.out.println(gesamtNutzen);

			} else {
				gesamtNutzen = 0;

			}

		}
	}

}
