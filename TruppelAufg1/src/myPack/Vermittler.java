package myPack;

import java.util.ArrayList;

public abstract class Vermittler {
	
	public Zuord zuordnung;
	
	public Vermittler(Zuord z){
		zuordnung = z;
	}
	
	public abstract void registrieren(Studi studi);
	public abstract void vermitteln(Studi studi);
	public abstract ArrayList<Long> praefMatrixAusgeben(Studi studi);
	
	
		
	}

