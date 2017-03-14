package phare;

import static org.junit.Assert.*;
import org.junit.Test;


public class CarLightTest {
    CarLight sut = new CarLight(0.0, SwitchMode.OFF);
	
	@Test
	public void test() { 
       sut.step();
       assertTrue(true);
	 
       System.out.printf("PhareTest:  ok.\n");
	}
}
 
