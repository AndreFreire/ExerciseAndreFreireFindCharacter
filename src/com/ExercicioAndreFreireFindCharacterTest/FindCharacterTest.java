package com.ExercicioAndreFreireFindCharacterTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.ExercicioAndreFreireFindCharacter.StreamImpl;

public class FindCharacterTest {
	@Test
	public void findCharacterSuccess() {
		StreamImpl streamImpl = new StreamImpl("aAbBABacafe");
		char response = streamImpl.findFirstChar();
		assertEquals('e', response);		
	}
	@Test
	public void findCharacterNotFound() {
		StreamImpl streamImpl = new StreamImpl("aAbBABacafa");
		char response = streamImpl.findFirstChar();
		assertEquals('0', response);		
	}
	@Test
	public void findCharacterInvalidInput() {
		StreamImpl streamImpl = new StreamImpl("aAbBABaca%a");
		char response = streamImpl.findFirstChar();
		assertEquals('1', response);
	}

}