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

		// registrierteStudierende.sh

		 Collections.shuffle(registrierteStudierende);
		ArrayList<Studi> reverseRegistrierteStudierende = new ArrayList<Studi>();
		reverseRegistrierteStudierende.addAll(registrierteStudierende);
		Collections.reverse(reverseRegistrierteStudierende);

		for (Studi itemA : registrierteStudierende) {
			//if (!itemA.partner) {
				reverseRegistrierteStudierende.remove(reverseRegistrierteStudierende.size() - 1);
				int gesamtItemAInf = 0;
				int gesamtItemAMathe = 0;
				int gesamtItemA = 0;

				int gesamtItemZInf = 0;
				int gesamtItemZMathe = 0;
				int gesamtItemZ = 0;

				int gesamtNutzen = 0;
				gesamtNutzenGlobal = 0;

				// if (!itemA.partner) {
				// Problem: itemZ ist nur ne Kopie also wird partner == true
				// nicht
				// funktionieren. Idee: Array machen und mit ItemZ auf Index
				// zugreifen
				for (Studi itemZ : reverseRegistrierteStudierende) {
					System.out.println(itemA.name + itemZ.name);

					// (A|B)= (B.info-A.info) + (B.mathe-A.mathe)
					if (!itemZ.partner && !itemA.partner) {

						if (itemA.fitnessInf - itemZ.fitnessInf < 0) {
							gesamtItemAInf = 0;
						} else {
							gesamtItemAInf = itemA.fitnessInf - itemZ.fitnessInf;
						}

						if (itemA.fitnessMathe - itemZ.fitnessMathe < 0) {
							gesamtItemAMathe = 0;
						} else {
							gesamtItemAMathe = itemA.fitnessMathe - itemZ.fitnessMathe;
						}

						gesamtItemA = gesamtItemAMathe + gesamtItemAInf;

						if (itemZ.fitnessInf - itemA.fitnessInf < 0) {
							gesamtItemZInf = 0;
						} else {
							gesamtItemZInf = itemZ.fitnessInf - itemA.fitnessInf;
						}

						if (itemZ.fitnessMathe - itemA.fitnessMathe < 0) {
							gesamtItemZMathe = 0;
						} else {
							gesamtItemZMathe = itemZ.fitnessMathe - itemZ.fitnessMathe;
						}

						gesamtItemZ = gesamtItemZMathe + gesamtItemZInf;

						gesamtNutzen = gesamtItemZ + gesamtItemA;
						System.out.println(gesamtNutzen);

						if (gesamtNutzen >= gesamtNutzenGlobal) {
							//System.out.println("ist größer");
							gesamtNutzenGlobal = gesamtNutzen;
							this.zwSp1 = itemA.name;
							this.zwSp2 = itemZ.name;
							zwSp1Obj = itemA;
							zwSp2Obj = itemZ;

							gesamtNutzenGlobalSumme = gesamtNutzenGlobalSumme + gesamtNutzenGlobal;
						}

						// System.out.println(gesamtNutzenGlobalSumme);
					} else {
						System.out.println(itemA.name + " oder " + itemZ.name + " schon gepartnert, " + itemA.flag + " "
								+ itemZ.flag);
						//System.out.println("schon gepartnert");
					}

				}
				System.out.println(zwSp1 + zwSp2 + " haben den höchsten Gesamtnutzen: " + gesamtNutzenGlobal);
				zwSp1Obj.partner = true;
				zwSp1Obj.flag = "gepartnert";
				zwSp2Obj.partner = true;
				zwSp2Obj.flag = "gepartnert";
				registrierteStudierende.set(registrierteStudierende.indexOf(zwSp1Obj), zwSp1Obj);
				registrierteStudierende.set(registrierteStudierende.indexOf(zwSp2Obj), zwSp2Obj);
				//gesamtNutzenGlobal = 0;
				// reverseRegistrierteStudierende.set(reverseRegistrierteStudierende.indexOf(zwSp1Obj),zwSp1Obj);
				// reverseRegistrierteStudierende.set(reverseRegistrierteStudierende.indexOf(zwSp2Obj),zwSp2Obj);
			//}
			//else
			//{
				//System.out.println("wurde schon gepartnert");
			//}
				

		}

		//System.out.println(gesamtNutzenGlobalSumme);

		// registrierteStudierende.notifyAll();

		// }

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
