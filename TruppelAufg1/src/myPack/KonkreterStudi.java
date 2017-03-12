/**
* Stephan Truppel
* 12.03.2017, V1.0
* Dient zur Erstellung eines Studenten mit verschiedenen Eigenschaften, Kommuniziert ausschlieﬂlich mit 
* einem geeigneten Vermittler.
* 
* Open points/ ToDo: keine
*/
package myPack;

import java.util.ArrayList;

public class KonkreterStudi extends Kollege {

	private String name;
	private int fitnessInf;
	private int fitnessMathe;
	private Kollege partner;

	/**
	 * Konstruktor
	 * 
	 * @param v
	 *            Vermittlerobjekt, ueber das kommuniziert werden soll
	 * @param name
	 *            Name des Studis
	 * @param fitnessInf
	 *            Faehigkeiten Informatik
	 * @param fitnessMathe
	 *            Faheigkeiten Mathe
	 * @param zuordnung
	 *            z-Objekt, das den Nutzen eines Lernpartners ermitteln kann.
	 */
	public KonkreterStudi(Vermittler v, String name, int fitnessInf, int fitnessMathe, Zuord zuordnung) {
		super(v);
		this.name = name;
		this.fitnessInf = fitnessInf;
		this.fitnessMathe = fitnessMathe;

		registrieren();

	}

	public void registrieren() {
		super.registrieren();
	}

	/*
	 * Studi fordert Lernpartner an
	 * 
	 * (non-Javadoc)
	 * 
	 * @see myPack.Kollege#zuteilenEinfach()
	 * 
	 * 
	 */
	public void zuteilenEinfach() {
		System.out.println(
				"KonkreterStudi " + this.getName() + " moechte zugeteilt werden und informiert den Vermittler");
		super.zuteilenEinfach();
	}

	/**
	 * eigene equals-Methode um zwei Studis miteinander vergleichen zu koennen
	 * 
	 * @param studi
	 * @return Objekt identisch, ja/nein
	 */
	public boolean equals(KonkreterStudi studi) {

		if (this.name == studi.name && this.fitnessInf == studi.fitnessInf && this.fitnessMathe == studi.fitnessMathe) {
			return true;
		}
		return false;

	}

	/*
	 * Ausgabe der Attribute des Studis laut Anforderungen (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("[name=" + this.name + ", fitnessInf=" + this.fitnessInf + ", fitnessMathe=" + this.fitnessMathe + "]");
	}

	public ArrayList<Long> praefMatrixAusgeben() {
		return super.praefMatrixAusgeben();
	}

	/*
	 * Wird aufgerufen sobald ein Studi durch eine Zuteilungsanfrage eines
	 * anderen Studis gepartnert wird. (non-Javadoc)
	 * 
	 * @see myPack.Kollege#passiveAenderung(myPack.Kollege)
	 */
	public void passiveAenderung(Kollege kol) {
		kol.partner = this.partner;

	}

	/*
	 * Wird aufgerufen, wenn ein Studi eine Aenderung angefragt hat.
	 * Gleichzeitig wird auch der Partner informiert. (non-Javadoc)
	 * 
	 * @see myPack.Kollege#aktiveAenderung(myPack.Kollege)
	 */
	public void aktiveAenderung(Kollege neuerPartner) {
		this.partner = neuerPartner;
		System.out.println("KonkreterStudi " + this.name + " wurde durch Zuteilungsanfrage geaendert. KonkreterStudi "
				+ this.partner.getName() + " wird durch den Vermittler informiert");

		this.passiveAenderung(this.partner);

	}

	/*
	 * 
	 * SETTER - METHODEN
	 * 
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setFitnessInf(int fintessInf) {
		this.fitnessInf = fintessInf;
	}

	public void setFitnessMathe(int fitnessMathe) {
		this.fitnessMathe = fitnessMathe;
	}

	public void setPartner(KonkreterStudi partner) {
		this.partner = partner;
	}

	/*
	 * 
	 * 
	 * GETTER - METHODEN
	 * 
	 */

	public String getName() {
		return this.name;
	}

	public int getFitnessInf() {
		return this.fitnessInf;
	}

	public int getFitnessMathe() {
		return this.fitnessMathe;
	}

	public Kollege getPartner() {
		return this.partner;
	}

}
