// Time-stamp: <modified the 06/03/2017 (at 17:08) by Erwan Jahier> 

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(JUnitQuickcheck.class)
public class HeaterControlQuickCheck {
	Sensor s1 = Mockito.mock(Sensor.class);
	Sensor s2 = Mockito.mock(Sensor.class);
	Sensor s3 = Mockito.mock(Sensor.class);
	Sensor s1Sup = Mockito.mock(Sensor.class);
	Sensor s1Inf = Mockito.mock(Sensor.class);

    @Property
    public void hotter_implies_no_rising_edge(
                                   @InRange(min="0.0", max="50.0") double tc, 
                                   @InRange(min="0.0", max="50.0") double t1, 
                                   @InRange(min="0.0", max="50.0") double t2, 
                                   @InRange(min="0.0", max="50.0") double t3) {
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
        System.out.printf("QC(hotter=>RE): tc=%f; t1=%f; t2=%f; t3=%f \n", tc,t1,t2,t3);

    }

    @Property
    public void sensors_commute( @InRange(min="0.0", max="50.0") double tc, 
                                 @InRange(min="0.0", max="50.0") double t1, 
                                 @InRange(min="0.0", max="50.0") double t2, 
                                 @InRange(min="0.0", max="50.0") double t3) {
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
        System.out.printf("QC(sensors_commute):  On=%b ;tc=%f; t1=%f; t2=%f; t3=%f \n", hc1.getOn(),tc,t1,t2,t3);
    }

}

