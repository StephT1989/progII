package myPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class Zuord {

	// HashMap<String, Long> praeferenzMatrix = new HashMap<String, Long>();
	// ArrayList<Studi, ArrayList<Long>> praeferenzMatrix = new
	// ArrayList<Studi,ArrayList<Long>>();

	// alt
	// HashMap<Studi, ArrayList<Long>> praeferenzMatrix = new HashMap<Studi,
	// ArrayList<Long>>();
	// ArrayList<Long> nutzWerte = new ArrayList<Long>();
	// ArrayList<ArrayList<Long>> NEUnutzWerte = new
	// ArrayList<ArrayList<Long>>();

	// ArrayList<ArrayList<Long>> nutzWerteGesamt = new
	// ArrayList<ArrayList<Long>>();
	
	
	
	public void vermittlungBerechnen(Studi studi, ArrayList<Studi> registrierteStudierende){
		
		
	}

	public ArrayList<Long> praefMatrixAusgeben(Studi studi, ArrayList<Studi> registrierteStudierende) {
		ArrayList<Long> nutzWerteStudi = new ArrayList<Long>();

		int i = 0;
		for (Studi s : registrierteStudierende) {
			// System.out.println("Beginn Schleife RegStudi " + s.name);
			// System.out.println("Schleifencounter: " +i);
			// System.out.println(" Akt. Studi: " + studi.name);
			int gesamtNutzenS = 0;
			int gesamtNutzenStudi = 0;
			long gesamtNutzen = 0;

			int z = 0;
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

				nutzWerteStudi.add((long) gesamtNutzenStudi);

			} else {
				gesamtNutzen = 0;
				nutzWerteStudi.add((long) 0);

			}
			// System.out.println("nutzWerte: " + nutzWerteStudi.toString());
			// System.out.println("Ende Schleife");
			i++;
			System.out.println(gesamtNutzen);
		}
		// praeferenzMatrix.put(studi, nutzWerte);
		// System.out.println("Inhalt: " + praeferenzMatrix.values());
		// nutzWerteStudi.clear();
		
		
		return nutzWerteStudi;
	}
}
