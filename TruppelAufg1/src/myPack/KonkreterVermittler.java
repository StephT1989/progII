/**
* Stephan Truppel
* 12.03.2017, V1.0
* Sorgt für die Kommunikation zwischen den Studi-Objekten 
* 
* Open points/ ToDo: keine
*/
package myPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KonkreterVermittler extends Vermittler {
	/* Zwischenspeicher für Gesamtnutzen */
	private int gesamtNutzenGlobalHochzaehlen = 0;
	/* hoechster Gesamtnutzen ueber alle Studis */
	private int gesamtNutzenGlobal = 0;
	private ArrayList<Kollege> registrierteStudierende = new ArrayList<Kollege>();
	/* key-value für Lernpartnerzuordnung */
	private HashMap<Kollege, Kollege> zugeteilteStudierende = new HashMap<Kollege, Kollege>();

	/* Temporaere Objekte um Partnerzuteilung zwischenzuspeichern */
	Kollege tempObjKoll1;
	Kollege tempObjKoll2;

	/**
	 * Konstruktor
	 * 
	 * @param Objekt,
	 *            das die Zuordnung der Kollegen berechnet
	 */
	public KonkreterVermittler(Zuord z) {
		super(z);
	}

	/*
	 * eines KonkreterStudi-Objektes automatisch ueber den Konstruktor
	 * aufgerufen (non-Javadoc)
	 * 
	 * @see myPack.Vermittler#registrieren(myPack.Kollege)
	 * 
	 * 
	 * @param kollege
	 * 
	 */
	@Override
	public void registrieren(Kollege kollege) {
		this.registrierteStudierende.add(kollege);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see myPack.Vermittler#zuteilenEinfach(myPack.Kollege) einfache Zuteilung
	 * eines Studis
	 * 
	 * @param kollege Studi der auf Basis bereits registrierter Studies
	 * zugeteilt werden moechte
	 * 
	 */
	@Override
	public void zuteilenEinfach(Kollege kollege) {
		System.out.println("KonkreterVermittler berechnet Zuteilung");
		int einzelNutzen = 0;
		int einzelNutzenGesamt = 0;
		Kollege partner = null;
		/* fuer jeden Kollegen in registrierteStudierende */
		for (Kollege k : this.registrierteStudierende) {
			/* Wenn Lernpartner nicht identisch */
			if (!kollege.equals(k)) {
				/* Einzelnutzen berechnen und speichern */
				einzelNutzen = this.zuordnung.berechneEinzelNutzen(kollege, k);
				if (einzelNutzen > einzelNutzenGesamt) {
					einzelNutzenGesamt = einzelNutzen;
					partner = k;
				}
			}

		}
		/* beide Lernpartner ueber Zuteilung informieren */
		this.informiereUberAenderung(partner, kollege);

	}

	/**
	 * Sobald ein Studi geaendert wird, werden beide Lernpartner informiert.
	 * 
	 * @param partner
	 *            Studi, der aufgrund eine Anfrage eines anderen Studis
	 *            zugeteilt wurde.
	 * @param kollege
	 *            Studi, der Zuteilung angefordert hat.
	 */
	public void informiereUberAenderung(Kollege partner, Kollege kollege) {
		kollege.aktiveAenderung(partner);
		System.out.println("Zuordnung: " + kollege.getName() + " zu " + partner.getName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see myPack.Vermittler#zuteilenKomplex(java.util.ArrayList) Die Methode
	 * ermitteln für jeden Studi in einer Liste den geeigneten Lernpartner. Es
	 * handelt sich hierbei lediglich um eine Naeherungsloesung. Der Berechnung
	 * liegt die Formel n!/((n-m)!* m!) = 325 zu Grunde, was der Anzahl der
	 * Möglichkeiten aus 26 Studis entspricht
	 * 
	 * @param registrierteStudierende Beinhaltet eine Liste von Studis die
	 * jeweils den moeglichst besten Lernpartner erhalten sollen.
	 * 
	 * 
	 */
	@Override
	public void zuteilenKomplex(ArrayList<Kollege> registrierteStudierende) {

		gesamtNutzenGlobal = 0;
		/*
		 * Objekte zufaellig anordnen um spaeter besseren Gesamtnutzen zu
		 * erzielen
		 */
		Collections.shuffle(registrierteStudierende);
		/*
		 * Kopie der Liste erstellen und Objekte umgekehrt anordnen. Die
		 * Schleife vergleicht dann: A mit Z, A mit Y, usw
		 */
		ArrayList<Kollege> reverseRegistrierteStudierende = new ArrayList<Kollege>();
		reverseRegistrierteStudierende.addAll(registrierteStudierende);
		Collections.reverse(reverseRegistrierteStudierende);

		/* fuer jeden Studi in unsortierter Liste */
		for (Kollege objA : registrierteStudierende) {
			/*
			 * immer das letzte Element loeschen, weil es mit ObjA bereits
			 * beruecksichtigt ist
			 */
			reverseRegistrierteStudierende.remove(reverseRegistrierteStudierende.size() - 1);

			int gesamtNutzen = 0;
			gesamtNutzenGlobalHochzaehlen = 0;

			/* fuer jedes Element in umgedrehter Liste */
			for (Kollege objZ : reverseRegistrierteStudierende) {
				/* Beide Studis duerfen nicht gepartnert sein */
				if (!objZ.boolPartner && !objA.boolPartner) {

					/* Gesamtnutzen der aktuellen Objekte berechnen */
					gesamtNutzen = this.zuordnung.berechneGesNutzen(objA, objZ);

					/*
					 * Wenn Gesamtnutzen für objA am hoechsten (zB. fuer ObjB =
					 * Z->B), dann wird das Ergebnis zwischengespeichert
					 */
					if (gesamtNutzen >= gesamtNutzenGlobalHochzaehlen) {
						gesamtNutzenGlobalHochzaehlen = gesamtNutzen;

						tempObjKoll1 = objA;
						tempObjKoll2 = objZ;
					}
				}
			}
			/* Lerpartner ist zugeteilt */
			tempObjKoll1.boolPartner = true;
			tempObjKoll2.boolPartner = true;
			/*
			 * fuer naechsten Schleifendurchlauf muss zwingend die zu
			 * iterierende Liste aktualisiert werden
			 */
			registrierteStudierende.set(registrierteStudierende.indexOf(tempObjKoll1), tempObjKoll1);
			registrierteStudierende.set(registrierteStudierende.indexOf(tempObjKoll2), tempObjKoll2);
			/* Ermittlung des Gesamtnutzens */
			gesamtNutzenGlobal = gesamtNutzenGlobal + gesamtNutzenGlobalHochzaehlen;

			if (gesamtNutzenGlobalHochzaehlen != 0) {
				int indexStudiObj1 = registrierteStudierende.indexOf(tempObjKoll1);
				int indexStudiObj2 = registrierteStudierende.indexOf(tempObjKoll2);
				/* Partnerzuweisung in HashMap */
				zugeteilteStudierende.put(registrierteStudierende.get(indexStudiObj1),
						registrierteStudierende.get(indexStudiObj2));
			}
		}
		/* Alle Studis ueber Vermittlung informieren */
		alleStudisInformieren(this.zugeteilteStudierende);

		System.out.println("Gesamtnutzen: " + gesamtNutzenGlobal);

	}

	/**
	 * Sobald ein Studi geaendert wird, werden beide Lernpartner informiert.
	 * 
	 * @param zugeteilteStudierende
	 *            Uber key-value Beziheung sind Lernpartner definiert. Diese
	 *            werden informiert.
	 */
	public void alleStudisInformieren(HashMap<Kollege, Kollege> zugeteilteStudierende) {

		for (Kollege s : zugeteilteStudierende.keySet()) {
			Kollege kollPartner = zugeteilteStudierende.get(s);
			informiereUberAenderung(kollPartner, s);
		}
	}

	/*
	 * Ausgabe einer Matrix über den Einzelnutzen eines Studis
	 * 
	 * (non-Javadoc) * @see
	 * myPack.Vermittler#praefMatrixAusgeben(myPack.Kollege)
	 * 
	 * @param studi Studi, dessen Einzelnutzen ausgegeben werden soll
	 */
	@Override
	public ArrayList<Long> praefMatrixAusgeben(Kollege studi) {
		return this.zuordnung.praefMatrixAusgeben(studi, this.registrierteStudierende);
	}

	/*
	 * GETTER - METHODEN
	 */

	public int getGesamtNutzenGlobalHochzaehlen() {
		return this.gesamtNutzenGlobalHochzaehlen;
	}

	public int getGesamtnutzenGlobal() {
		return this.gesamtNutzenGlobal;
	}

	public ArrayList<Kollege> getRegistrierteStudierende() {
		return this.registrierteStudierende;
	}

	public HashMap<Kollege, Kollege> getZugeteilteStudierende() {
		return this.zugeteilteStudierende;
	}

	/*
	 * SETTER - METHODEN
	 * 
	 */

	public void setGesamtNutzenGlobalHochzaehlen(int gesamtNutzenGlobalHochzaehlen) {
		this.gesamtNutzenGlobalHochzaehlen = gesamtNutzenGlobalHochzaehlen;
	}

	public void setGesamtnutzenGlobal(int gesamtnutzenGlobal) {
		this.gesamtNutzenGlobal = gesamtnutzenGlobal;
	}

	public void setRegistrierteStudierende(ArrayList<Kollege> registrierteStudierende) {
		this.registrierteStudierende = registrierteStudierende;
	}

	public void setZugeteilteStudierende(HashMap<Kollege, Kollege> zugeteilteStudierende) {
		this.zugeteilteStudierende = zugeteilteStudierende;

	}
}
