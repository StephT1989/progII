package myPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	public void vermitteln(Studi studi){
		int infGesamtNutzen = 0;
		int matheGesamtNutzen = 0;
		int gesamtNutzen = 0;
		int neuerGesamtNutzen = 0;
		//zugeteilteStudierende.put(studi, null);
		
		for (Studi s : this.registrierteStudierende)
		{
			// Studierender kann nicht sich selbst als Lerpartner zugeordnet werden
			if (!s.equals(studi))
			{
				infGesamtNutzen = s.fitnessInf + studi.fitnessInf;
				matheGesamtNutzen = s.fitnessMathe + studi.fitnessMathe;
				neuerGesamtNutzen = infGesamtNutzen + matheGesamtNutzen;
				
				if (neuerGesamtNutzen > gesamtNutzen){
					gesamtNutzen = neuerGesamtNutzen;
					zugeteilteStudierende.put(studi, s);
				}
				
			}
		}
		System.out.println(gesamtNutzen);
		
		
	}
	
	
	public void registrierteStudisAusgeben(){
		for(Studi s : registrierteStudierende){
		//System.out.println(Arrays.toString(s.toArray()));
		//}
		
		System.out.println(s.name);
		}
	}


	

	
	
}
