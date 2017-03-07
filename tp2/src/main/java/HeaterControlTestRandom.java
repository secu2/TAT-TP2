// Time-stamp: <modified the 06/03/2017 (at 16:17) by Erwan Jahier> 
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import org.mockito.Mockito;


public class HeaterControlTestRandom {
	private Random randSensorTemp;
	private Random randTCTemp;
	Sensor s1 = Mockito.mock(Sensor.class);
	Sensor s2 = Mockito.mock(Sensor.class);
	Sensor s3 = Mockito.mock(Sensor.class);
	Sensor s1Sup = Mockito.mock(Sensor.class);
	Sensor s1Inf = Mockito.mock(Sensor.class);
	
	@Before public void setUp(){
		this.randSensorTemp = new Random();
		randSensorTemp.setSeed(12098294);
		this.randTCTemp = new Random();
		randTCTemp.setSeed(9483984);
	}
	@Test
	public void test_alea1() {
		double t1,t2,t3;
		
		double[] t_list = new double[] {16,17,18,19,20,21,22,21,20,19,18,17,16};
		for (double t : t_list) {
			
			t1 = t+randSensorTemp.nextDouble()-0.5 ;
			t2 = t+randSensorTemp.nextDouble()-0.5;
			t3 = t+randSensorTemp.nextDouble()-0.5;

			Mockito.when(s1.getT()).thenReturn(t1);
			Mockito.when(s2.getT()).thenReturn(t2);
			Mockito.when(s3.getT()).thenReturn(t3);
			Mockito.when(s1Sup.getT()).thenReturn(t1+1);
			Mockito.when(s1Inf.getT()).thenReturn(t1-1);
			
			HeaterControl hc = new HeaterControl(t, s1, s2, s3);
			HeaterControl hcSup = new HeaterControl(t, s1Sup, s2, s3);
			HeaterControl hcInf = new HeaterControl(t, s1Inf, s2, s3);
			
			if(!hc.getOn()){
				assertFalse(hcSup.getOn());
			}
			
			if(hc.getOn()){
				assertTrue(hcInf.getOn());
			}
		}
	}

	@Test
	public void test_alea2() {
		double t1,t2,t3, RC;

		for (int i = 0; i < 200; i++) {
			RC = randTCTemp.nextDouble()*20+10;
			t1 = RC+randSensorTemp.nextDouble()-0.5;
			t2 = RC+randSensorTemp.nextDouble()-0.5;
			t3 = RC+randSensorTemp.nextDouble()-0.5;
			
			Mockito.when(s1.getT()).thenReturn(t1);
			Mockito.when(s2.getT()).thenReturn(t2);
			Mockito.when(s3.getT()).thenReturn(t3);
			Mockito.when(s1Sup.getT()).thenReturn(t1+1);
			Mockito.when(s1Inf.getT()).thenReturn(t1-1);
			
			HeaterControl hc = new HeaterControl(RC, s1, s2, s3);
			HeaterControl hcSup = new HeaterControl(RC, s1Sup, s2, s3);
			HeaterControl hcInf = new HeaterControl(RC, s1Inf, s2, s3);
			
			if(!hc.getOn()){
				assertFalse(hcSup.getOn());
			}
			
			if(hc.getOn()){
				assertTrue(hcInf.getOn());
			}
			

			System.out.printf("test alea 2: t=%f  \n", RC);
		}
	}
} 



