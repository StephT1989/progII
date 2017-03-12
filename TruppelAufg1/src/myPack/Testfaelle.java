/**
* Stephan Truppel
* 12.03.2017, V1.0
* Enthaelt die Testfaelle laut Anforderung.
* 
* Open points/ ToDo: keine
*/
package myPack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class Testfaelle {

	/**
	 * zu bereits registrierten Studis kommt ein neuer hinzu. Dieser wird zu
	 * einem geeigneten Partner zugeteilt. Beide Partner werden informiert.
	 */
	@Test
	public void test1() {
		System.out.println("-- Testfall 1 --");
		Zuord z = new Zuord();

		KonkreterVermittler konkreterVermittler = new KonkreterVermittler(z);
		KonkreterStudi expected = new KonkreterStudi(konkreterVermittler, "A", 0, 10, z);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "B", 3, 7, z);
		KonkreterStudi konkreterStudi3 = new KonkreterStudi(konkreterVermittler, "C", 6, 6, z);
		System.out.println(
				"Ausgabe registrierte Studierende: " + konkreterVermittler.getRegistrierteStudierende().toString());
		KonkreterStudi actual = new KonkreterStudi(konkreterVermittler, "D", 10, 1, z);
		actual.zuteilenEinfach();
		assertEquals(expected, actual.getPartner());
	}

	/**
	 * Ausgabe einer Praeferenzmatrix pro registriertem Studi und anschließend
	 * geeignete Partnerzuweisung.
	 */
	@Test
	public void test2() {
		System.out.println("\n-- Testfall 2 ---");
		Zuord z = new Zuord();
		ArrayList<Kollege> arrayliststudiTestfall2 = new ArrayList<Kollege>();
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler(z);

		KonkreterStudi konkreterStudi1 = new KonkreterStudi(konkreterVermittler, "A", 0, 10, z);
		KonkreterStudi konkreterStudi2 = new KonkreterStudi(konkreterVermittler, "B", 3, 7, z);
		KonkreterStudi konkreterStudi3 = new KonkreterStudi(konkreterVermittler, "C", 6, 6, z);
		KonkreterStudi konkreterStudi4 = new KonkreterStudi(konkreterVermittler, "D", 10, 1, z);
		int expected = 23;

		System.out.println(
				"Ausgabe registrierte Studierende: " + konkreterVermittler.getRegistrierteStudierende().toString());
		System.out.print("Praeferenzmatrix: [");
		for (Kollege k : konkreterVermittler.getRegistrierteStudierende()) {
			System.out.print(k.praefMatrixAusgeben().toString());
		}

		System.out.println("]\n");

		arrayliststudiTestfall2.add(konkreterStudi1);
		arrayliststudiTestfall2.add(konkreterStudi2);
		arrayliststudiTestfall2.add(konkreterStudi3);
		arrayliststudiTestfall2.add(konkreterStudi4);

		konkreterVermittler.zuteilenKomplex(arrayliststudiTestfall2);
		int actual = konkreterVermittler.getGesamtnutzenGlobal();

		assertEquals(expected, actual);
	}

	/**
	 * Ermittlung einer geeigneten Partnerzuweisung für 26 Studenten
	 * (Näherungslösung). Ermittlung und Ausgabe eines möglichst hohen
	 * Gesamtnutzens.
	 * 
	 * ACHTUNG: Dieser Testfall ist nicht immer reproduzierbar, weil in Klasse
	 * KonkreterVermittler, Zeile 62 eine zufaellige Reihenfolge der Studenten
	 * definiert wird. Wenn diese Reihenfolge ungünstig ist, kann der Wert auch
	 * unter 114 liegen und der Testfall schlaegt fehl. Ich habe meinen
	 * Näherungsalgorithmus mehere 100.000 Mal ausgeführt, ein Gesamtnutzen von
	 * 114 wurde niemals überschritten, insofern wird diese Zahl für den
	 * Testfall verwendet.
	 */
	@Test
	public void test3() {
		System.out.println("\n-- Testfall 3 --");
		Zuord z = new Zuord();
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler(z);
		ArrayList<Kollege> arrayliststudi = new ArrayList<Kollege>();
		int expected = 114;
		Random rand1 = new Random(123);
		Random rand2 = new Random(123);
		int pseudoZufall1;
		int pseudoZufall2;
		int i = 0;
		char alphabet = 'A';
		while (i <= 25 && alphabet <= 'Z') {

			pseudoZufall1 = rand1.nextInt(10);
			pseudoZufall2 = rand2.nextInt(10);
			String name = String.valueOf(alphabet);
			KonkreterStudi konkreterStudi = new KonkreterStudi(konkreterVermittler, name, pseudoZufall1, pseudoZufall2,
					z);
			arrayliststudi.add(konkreterStudi);
			i++;
			alphabet++;

		}

		konkreterVermittler.zuteilenKomplex(arrayliststudi);
		int actual = konkreterVermittler.getGesamtnutzenGlobal();
		assertEquals(expected, actual);
	}

}
