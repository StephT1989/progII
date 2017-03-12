/**
* Stephan Truppel
* 12.03.2017, V1.0
* Erechnet den geeigneten Lernpartner und ordnet beide Partner in er HashMap zu
* 
* Open points/ ToDo: keine
*/
package myPack;

import java.util.ArrayList;

public class Zuord {

	public ArrayList<KonkreterStudi> registrierteStudierende = new ArrayList<KonkreterStudi>();

	/**
	 * @param studi
	 *            Studi-Objekt für das die Matrix ausgegeben werden soll
	 * @param registrierteStudierende
	 *            Liste der Studis fuer die der Nutzwert ermittelt werden soll
	 * @return Liste mit einzelnen Nutzwerten
	 */
	public ArrayList<Long> praefMatrixAusgeben(Kollege studi, ArrayList<Kollege> registrierteStudierende) {
		ArrayList<Long> nutzWerteStudi = new ArrayList<Long>();

		for (Kollege s : registrierteStudierende) {
			nutzWerteStudi.add((long) berechneEinzelNutzen(studi, s));
		}
		return nutzWerteStudi;
	}

	/**
	 * Gesamtnutzen zw. zwei Lernpartnern berechnen
	 * 
	 * @param studi
	 *            Lernpartner1
	 * @param kollege
	 *            Lernpartner2
	 * @return Gesamtnutzen der beiden Partner
	 */
	public int berechneGesNutzen(Kollege studi, Kollege kollege) {

		int nutzenMathe;
		int nutzenInf;
		int gesamtNutzen;

		if (kollege.getFitnessMathe() > studi.getFitnessMathe()) {
			nutzenMathe = kollege.getFitnessMathe() - studi.getFitnessMathe();
		} else {
			nutzenMathe = studi.getFitnessMathe() - kollege.getFitnessMathe();
		}
		if (kollege.getFitnessInf() > studi.getFitnessInf()) {
			nutzenInf = kollege.getFitnessInf() - studi.getFitnessInf();
		} else {
			nutzenInf = studi.getFitnessInf() - kollege.getFitnessInf();
		}
		gesamtNutzen = nutzenMathe + nutzenInf;
		return gesamtNutzen;
	}

	/**
	 * Nutzen eines einzelnen Studis berechnen.
	 * 
	 * @param studi
	 *            Studi fuer den Nutzen ermittelt werden soll
	 * @param kollege
	 * @return
	 */
	public int berechneEinzelNutzen(Kollege studi, Kollege kollege) {
		int mathe = 0;
		int informatik = 0;
		int einzelNutzen;

		/* Einzelnutzen Mathe */
		if (studi.getFitnessMathe() < kollege.getFitnessMathe()) {
			mathe = kollege.getFitnessMathe() - studi.getFitnessMathe();
		}
		/* Einzelnutzen Informatik */
		if (studi.getFitnessInf() < kollege.getFitnessInf()) {
			informatik = kollege.getFitnessInf() - studi.getFitnessInf();
		}
		einzelNutzen = mathe + informatik;
		return einzelNutzen;
	}
}
