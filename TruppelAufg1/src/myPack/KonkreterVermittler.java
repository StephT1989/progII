package myPack;

import java.util.ArrayList;

public class KonkreterVermittler extends Vermittler{
	
	
	public ArrayList<Studi> registrierteStudierende = new ArrayList<Studi>();
	
	public KonkreterVermittler() {
		System.out.println("KonkreterVermittler: instanziiert");
	}
	
	
	@Override
	public void registrieren(Studi s){
		System.out.println("wird registriert");
		this.registrierteStudierende.add(s);
		
		// Todo: andere Objekte informieren 
		
	}
	
	
	public void registrierteStudisAusgeben(){
		for(Studi s : registrierteStudierende){
		System.out.println(s.name);
		}
	}


	

	@Override
	public void vermitteln(Studi studi) {
		// TODO Auto-generated method stub
		
	}
	
}
