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

	public int gesamtNutzenGlobal = 0;
	public int gesamtNutzenGlobalSumme = 0;
	public String zwSp1;
	public String zwSp2;
	Studi zwSp1Obj;
	Studi zwSp2Obj;

	public void vermittlungBerechnen(ArrayList<Studi> registrierteStudierende) {

		ArrayList<Studi> reverseRegistrierteStudierende = new ArrayList<Studi>();
		reverseRegistrierteStudierende.addAll(registrierteStudierende);
		Collections.reverse(reverseRegistrierteStudierende);

		for (Studi itemA : registrierteStudierende) {
			reverseRegistrierteStudierende.remove(reverseRegistrierteStudierende.size() - 1);
			int gesamtNutzenS = 0;
			int gesamtNutzenStudi = 0;
			int gesamtNutzen = 0;
			gesamtNutzenGlobal = 0;

			//if (!itemA.partner) {
			// Problem: itemZ ist nur ne Kopie also wird partner == true nicht funktionieren. Idee: Array machen und mit ItemZ auf Index zugreifen
				for (Studi itemZ : reverseRegistrierteStudierende) {
					System.out.println(itemA.name + itemZ.name);
					if (!itemZ.partner && !itemA.partner) {
						
						if (itemA.fitnessInf < itemZ.fitnessInf && itemA.fitnessMathe < itemZ.fitnessMathe) {
							gesamtNutzenStudi = (itemZ.fitnessInf - itemA.fitnessInf)
									+ (itemZ.fitnessMathe - itemA.fitnessMathe);
							gesamtNutzenS = 0;
						}
						if (itemA.fitnessInf > itemZ.fitnessInf && itemA.fitnessMathe > itemZ.fitnessMathe) {
							gesamtNutzenS = (itemA.fitnessInf - itemZ.fitnessInf)
									+ (itemA.fitnessMathe - itemZ.fitnessMathe);
							gesamtNutzenStudi = 0;
						}
						if (itemA.fitnessInf < itemZ.fitnessInf && itemA.fitnessMathe > itemZ.fitnessMathe) {
							gesamtNutzenStudi = itemZ.fitnessInf - itemA.fitnessInf;
							gesamtNutzenS = itemA.fitnessMathe - itemZ.fitnessMathe;

						}
						if (itemA.fitnessInf > itemZ.fitnessInf && itemA.fitnessMathe < itemZ.fitnessMathe) {
							gesamtNutzenS = itemA.fitnessInf - itemZ.fitnessInf;
							gesamtNutzenStudi = itemZ.fitnessMathe - itemA.fitnessMathe;

						}

						gesamtNutzen = gesamtNutzenStudi + gesamtNutzenS;
						// gesamtNutzenGlobal = gesamtNutzenGlobal +
						// gesamtNutzen;
						// System.out.println(gesamtNutzen);

						if (gesamtNutzen > gesamtNutzenGlobal) {
							gesamtNutzenGlobal = gesamtNutzen;
							this.zwSp1 = itemA.name;
							this.zwSp2 = itemZ.name;
							zwSp1Obj = itemA;
							zwSp2Obj = itemZ;
							gesamtNutzenGlobalSumme = gesamtNutzenGlobalSumme + gesamtNutzenGlobal;
						}

					}
					else{
						System.out.println(itemA.name + " oder "+ itemZ.name + " schon gepartnert, " + itemA.flag + " "+ itemZ.flag);
					}
				}
				System.out.println(zwSp1 + zwSp2 + " haben den höchsten Gesamtnutzen: " + gesamtNutzenGlobal);
				zwSp1Obj.partner = true;
				zwSp1Obj.flag = "gepartnert";
				zwSp2Obj.partner = true;
				zwSp2Obj.flag = "gepartnert";
				registrierteStudierende.set(registrierteStudierende.indexOf(zwSp1Obj),zwSp1Obj);
				registrierteStudierende.set(registrierteStudierende.indexOf(zwSp2Obj),zwSp2Obj);
			}
			
			
			
			
			
			
			//registrierteStudierende.notifyAll();

		//}
		System.out.println(gesamtNutzenGlobalSumme);
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
			// System.out.println(gesamtNutzen);
		}
		// praeferenzMatrix.put(studi, nutzWerte);
		// System.out.println("Inhalt: " + praeferenzMatrix.values());
		// nutzWerteStudi.clear();

		return nutzWerteStudi;
	}
}
