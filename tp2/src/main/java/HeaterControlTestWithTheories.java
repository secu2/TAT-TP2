// Time-stamp: <modified the 06/03/2017 (at 17:03) by Erwan Jahier> 
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Theories.class)
public class HeaterControlTestWithTheories {
    @DataPoints
    public static double[] some_temp() {
        return new double[]{16.1,16.1,16.62,17,18,19,20,21,22,0,-23,152};
    } 
    @Theory
    public void hotter_implies_no_rising_edge(double tc,
                                              double t1,
                                              double t2,
                                              double t3) {
        
        System.out.printf("test theories 1 : tc=%f; t1=%f; t2=%f; t3=%f \n", tc,t1,t2,t3);
    }
    @Theory
    public void sensors_commute(double tc, double t1, double t2, double t3) {
        System.out.printf("test theories 2: tc=%f; t1=%f; t2=%f; t3=%f \n", tc,t1,t2,t3);
    }
}

