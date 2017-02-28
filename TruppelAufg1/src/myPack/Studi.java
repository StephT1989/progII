package myPack;

public abstract class Studi {
	
	// Frage: Wieso darf das Attribut Vermittler nicht privat sein
	public Vermittler vermittler; // Referenz auf den Vermittler
	public String name;
	public int fitnessInf;
	public int fitnessMathe;
	public String partner;
	public Studi konkrPartner;
	
	
	
	
	
	public void setzePartner(String partnerName){}
	
	public Studi(Vermittler v) {
		vermittler = v;
	}
	
	
	// Wird von den ableitenden Klassen ueberschrieben
		public void registrieren() {
			vermittler.registrieren(this); // Vermittler informiert
		}
		
		
		public void vermitteln() {
			vermittler.vermitteln(this); // Vermittler informiert
		}
		
		
		@Override
		   public String toString() {
		        return ("[name="+this.name+
		                    ", fitnessInf="+ this.fitnessInf +
		                    ", fitnessMathe="+ this.fitnessMathe+
		                    "]");
		   }

		
}
