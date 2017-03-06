// Time-stamp: <modified the 06/03/2017 (at 17:08) by Erwan Jahier> 

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(JUnitQuickcheck.class)
public class HeaterControlQuickCheck {
  
    @Property
    public void hotter_implies_no_rising_edge(
                                   @InRange(min="0.0", max="50.0") double tc, 
                                   @InRange(min="0.0", max="50.0") double t1, 
                                   @InRange(min="0.0", max="50.0") double t2, 
                                   @InRange(min="0.0", max="50.0") double t3) {
       
        System.out.printf("QC(hotter=>RE): tc=%f; t1=%f; t2=%f; t3=%f \n", tc,t1,t2,t3);

    }

    @Property
    public void sensors_commute( @InRange(min="0.0", max="50.0") double tc, 
                                 @InRange(min="0.0", max="50.0") double t1, 
                                 @InRange(min="0.0", max="50.0") double t2, 
                                 @InRange(min="0.0", max="50.0") double t3) {
        System.out.printf("QC(sensors_commute):  On=%b ;tc=%f; t1=%f; t2=%f; t3=%f \n", hc1.getOn(),tc,t1,t2,t3);
    }

}

