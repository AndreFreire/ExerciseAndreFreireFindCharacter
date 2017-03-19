package com.ExercicioAndreFreireFindCharacter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamImpl implements Stream {
	String string;
	int stringLength;
	int index;

	public StreamImpl(String string){		
		this.string = string.replaceAll(" ", "").toLowerCase();		
		this.stringLength = string.length();
		this.index = 0;
	}

	public char findFirstChar(){	
		if(!isValidateInput()){
			System.out.println("Invalid input");
			return '1';
		}
		char aux1 = 0;
		char aux2 = 0;
		char aux3 = 0;
		while(hasNext()){
			aux3 = aux2;
			aux2 = aux1;			
			aux1 = getNext();
			if(isVowel(aux1)){
				if(checkConditional(aux1, aux2, aux3)){
					System.out.println(String.format("Character found: %s", aux1));
					return aux1;
				}			
			}
		}
		System.out.println("Character not found");
		return '0';
	}

	public boolean isValidateInput(){
		Pattern pattern = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(this.string);
	    if (matcher.find()) {
	        return false;
	    }
		return true;
	}
	public boolean checkConditional(char aux1, char aux2, char aux3){
		if(!isVowel(aux1)) return false;
		if(isVowel(aux2)) return false;
		if(!isVowel(aux3)) return false;
		if(!isUniqueChar(aux1)) return false;
		return true;
	}

	public boolean isVowel(char c){
		return "aeiou".indexOf(c) >= 0;
	}

	public boolean isUniqueChar(char c){
		if(this.string.indexOf(c) == this.string.lastIndexOf(c))
			return true;		
		return false;
	}

	@Override
	public char getNext() {
		char response = string.charAt(index);
		index++;
		return response;		
	}

	@Override
	public boolean hasNext() {
		if(stringLength > index)
			return true;
		return false;
	}

}
