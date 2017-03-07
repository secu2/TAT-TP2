// Time-stamp: <modified the 06/03/2017 (at 17:03) by Erwan Jahier> 
import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Theories.class)
public class HeaterControlTestWithTheories {
	Sensor s1 = Mockito.mock(Sensor.class);
	Sensor s2 = Mockito.mock(Sensor.class);
	Sensor s3 = Mockito.mock(Sensor.class);
	Sensor s1Sup = Mockito.mock(Sensor.class);
	Sensor s1Inf = Mockito.mock(Sensor.class);

    @DataPoints
    public static double[] some_temp() {
        return new double[]{16.1,16.1,16.62,17,18,19,20,21,22,0,-23,152};
    } 
    @Theory
    public void hotter_implies_no_rising_edge(double tc,
                                              double t1,
                                              double t2,
                                              double t3) {
    	Mockito.when(s1.getT()).thenReturn(t1);
		Mockito.when(s2.getT()).thenReturn(t2);
		Mockito.when(s3.getT()).thenReturn(t3);
		Mockito.when(s1Sup.getT()).thenReturn(t1+1);
		Mockito.when(s1Inf.getT()).thenReturn(t1-1);
		
		HeaterControl hc = new HeaterControl(tc, s1, s2, s3);
		HeaterControl hcSup = new HeaterControl(tc, s1Sup, s2, s3);
		HeaterControl hcInf = new HeaterControl(tc, s1Inf, s2, s3);
		
		if(!hc.getOn()){
			Assume.assumeFalse(hcSup.getOn());
		}
		
		if(hc.getOn()){
			Assume.assumeTrue(hcInf.getOn());
		}
        System.out.printf("test theories 1 : tc=%f; t1=%f; t2=%f; t3=%f \n", tc,t1,t2,t3);
    }
 
    @Theory
    public void sensors_commute(double tc, double t1, double t2, double t3) {
    	Mockito.when(s1.getT()).thenReturn(t1);
		Mockito.when(s2.getT()).thenReturn(t2);
		Mockito.when(s3.getT()).thenReturn(t3);

    	HeaterControl hc1 = new HeaterControl(tc, s1, s2, s3);
    	HeaterControl hc2 = new HeaterControl(tc, s1, s3, s2);
    	HeaterControl hc3 = new HeaterControl(tc, s2, s1, s3);
    	HeaterControl hc4 = new HeaterControl(tc, s2, s3, s1);
    	HeaterControl hc5 = new HeaterControl(tc, s3, s2, s1);
    	HeaterControl hc6 = new HeaterControl(tc, s3, s1, s2);
    	
    	assertEquals(hc1.getOn(), hc2.getOn());
    	assertEquals(hc1.getOn(), hc3.getOn());
    	assertEquals(hc1.getOn(), hc4.getOn());
    	assertEquals(hc1.getOn(), hc5.getOn());
    	assertEquals(hc1.getOn(), hc6.getOn());
        System.out.printf("test theories 2: tc=%f; t1=%f; t2=%f; t3=%f \n", tc,t1,t2,t3);
    }
}

