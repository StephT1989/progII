package myPack;

public abstract class Studi {
	
	// Frage: Wieso darf das Attribut Vermittler nicht privat sein
	public Vermittler vermittler; // Referenz auf den Vermittler
	public String name;
	public int fitnessInf;
	public int fitnessMathe;
	public String partner;
	
	public void setzePartner(String partnerName){}
	
	public Studi(Vermittler v) {
		vermittler = v;
	}
	
	
	// Wird von den ableitenden Klassen ueberschrieben
		public void registrieren() {
			vermittler.registrieren(this); // Vermittler informiert
		}

		
}
