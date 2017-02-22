package myPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class KonkreterVermittler extends Vermittler{
	
	
	public ArrayList<Studi> registrierteStudierende = new ArrayList<Studi>();
	
	HashMap<Studi, Studi> zugeteilteStudierende = new HashMap<Studi, Studi>();
	
	public KonkreterVermittler() {
		System.out.println("KonkreterVermittler: instanziiert");
	}
	
	
	@Override
	public void registrieren(Studi s){
		System.out.println("wird registriert");
		this.registrierteStudierende.add(s);
		

	}
	
	
	@Override
	public void vermitteln(Studi s){
		
	}
	
	
	public void registrierteStudisAusgeben(){
		//for(ArrayList<Studi> s : registrierteStudierende){
		//System.out.println(Arrays.toString(s.toArray()));
		//}
		
		System.out.println(registrierteStudierende.get(0));
	}


	

	
	
}
