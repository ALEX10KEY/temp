package it.polito.recursion;

import java.util.LinkedList;
import java.util.List;

public class EspandiX {

	public void expand(String s, List<String> expansions) {
		int pos = s.indexOf('X') ;
		if(pos == -1) {
			// no 'X' -> expansion terminated!
			expansions.add(s) ;
		} else {
			String with0 = s.substring(0,pos)+'0'+s.substring(pos+1) ;
			String with1 = s.substring(0,pos)+'1'+s.substring(pos+1) ;
			
			expand( with0, expansions) ;
			expand( with1, expansions) ;
		}
	}
	
	public void test() {
		String prova = "X11XX00X" ;
		
		List<String> all = new LinkedList<String>() ;
		
		expand(prova, all) ;
		
		for(String s : all)
			System.out.println(s) ; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EspandiX ex = new EspandiX() ;
		ex.test() ;

	}

}
