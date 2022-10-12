package fr.bankcommon;


public class CalculInterface {
	
	 public boolean isInteger( String s) {
		
		boolean result=false;
		if(Integer.valueOf(s) instanceof Integer) {
			result =true;
			
		}
		return result;
	}

}
