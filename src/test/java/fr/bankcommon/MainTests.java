package fr.bankcommon;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class MainTests {
	
	
	@Before
	public void up() {
		
		
	}
	
	@InjectMocks
	Main main;
	
	
	@Test
	public void getListInteger() {
		System.out.println(main);
		int sum =main.getListInteger();
		System.out.println(sum);
	}
	@Test
	public void getListString() {
		System.out.println(main);
		List<String> sum =main.getListString();
		System.out.println(sum);
	}
	
}
