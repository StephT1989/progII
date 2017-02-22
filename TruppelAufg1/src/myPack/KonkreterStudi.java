package myPack;

public class KonkreterStudi extends Studi{

	
	
	public KonkreterStudi(Vermittler v, String name, int fitnessInf, int fitnessMathe) {
		super(v);
		
		// wieso funktioniert hier super und this?
		super.name = name;
		super.fitnessInf = fitnessInf;
		super.fitnessMathe = fitnessMathe;
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
}
