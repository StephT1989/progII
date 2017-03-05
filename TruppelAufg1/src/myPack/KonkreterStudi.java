package myPack;

import java.util.ArrayList;

public class KonkreterStudi extends Studi{

	
	
	public KonkreterStudi(Vermittler v, String name, int fitnessInf, int fitnessMathe, Zuord zuordnung) {
		super(v);
		
		// wieso funktioniert hier super und this?
		super.name = name;
		super.fitnessInf = fitnessInf;
		super.fitnessMathe = fitnessMathe;
		//super.zuordnung = zuordnung;
		// alle Studis werden initial registriert
		registrieren();
		
		// TODO Auto-generated constructor stub
	}

	public void registrieren(){
		super.registrieren();
	}
	
	public void vermitteln(){
		super.vermitteln();
	}
	
	public void setzePartner(String partnerName)
	{
		super.partner = partnerName;
	}
	
	
	public boolean equals(Studi studi){
		
		  if (this.name == studi.name && this.fitnessInf == studi.fitnessInf && this.fitnessMathe == studi.fitnessMathe) {
		    return true;
		  }
		  return false;
		
	}
	
	public ArrayList<Long> praefMatrixAusgeben(){
		return super.praefMatrixAusgeben();
	}
}
