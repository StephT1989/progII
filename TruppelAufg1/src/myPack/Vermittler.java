/**
* Stephan Truppel
* 12.03.2017, V1.0
* Dient als Oberklasse für die Klasse KonkreterVermittler.
* 
* Open points/ ToDo: keine
*/
package myPack;

import java.util.ArrayList;

public abstract class Vermittler {
	public Zuord zuordnung;

	public Vermittler(Zuord z) {
		zuordnung = z;
	}

	public abstract void registrieren(Kollege kollege);

	public abstract void zuteilenEinfach(Kollege kollege);

	public abstract void zuteilenKomplex(ArrayList<Kollege> registrierteStudierende);

	public abstract ArrayList<Long> praefMatrixAusgeben(Kollege kollege);

}
