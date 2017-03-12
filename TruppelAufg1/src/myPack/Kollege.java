/**
* Stephan Truppel
* 12.03.2017, V1.0
* Dient als Oberklasse für die Klasse KonkreterStudi.
* 
* Open points/ ToDo: keine
*/

package myPack;

import java.util.ArrayList;

public abstract class Kollege {

	protected Vermittler vermittler;

	protected Kollege partner;

	protected boolean boolPartner = false;

	public Kollege(Vermittler v) {
		vermittler = v;
	}

	public abstract int getFitnessMathe();

	public abstract int getFitnessInf();

	public abstract String getName();

	public abstract void passiveAenderung(Kollege kollege);

	public abstract void aktiveAenderung(Kollege kollege);

	public void registrieren() {
		vermittler.registrieren(this); // Vermittler informiert
	}

	public ArrayList<Long> praefMatrixAusgeben() {
		return vermittler.praefMatrixAusgeben(this);
	}

	public void zuteilenEinfach() {
		vermittler.zuteilenEinfach(this); // Vermittler informiert
	}

}
