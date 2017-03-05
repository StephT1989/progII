package myPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class KonkreterVermittler extends Vermittler{
	
	public KonkreterVermittler(Zuord z)
	{
		super(z);
		//System.out.println("KonkreterVermittler: instanziiert");
	}
	public ArrayList<Studi> registrierteStudierende = new ArrayList<Studi>();
	
	HashMap<Studi, Studi> zugeteilteStudierende = new HashMap<Studi, Studi>();
	
	public ArrayList<Studi> regStudierendeAusgeben(){
		
		return this.registrierteStudierende;
		
	}
	
	
	@Override
	public void registrieren(Studi s){
		//System.out.println("wird registriert");
		this.registrierteStudierende.add(s);
		

	}
	
	
	
	public ArrayList<Long> praefMatrixAusgeben(Studi studi){
		
		return this.zuordnung.praefMatrixAusgeben(studi,this.registrierteStudierende);
		
		
		
	}
	
	
	public void registrierteStudisAusgeben(){
		for(Studi s : registrierteStudierende){
		//System.out.println(Arrays.toString(s.toArray()));
		//}
		
		System.out.println(s.name);
		}
	}



	@Override
	public void vermitteln(Studi studi) {
		zuordnung.vermittlungBerechnen();
		
	}


	

	
	
}
