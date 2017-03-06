// Time-stamp: <modified the 06/03/2017 (at 16:17) by Erwan Jahier> 
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


public class HeaterControlTestRandom {
    private Random r;
   // XXX
    @Before public void setUp(){
      this.r = new Random();
      // XXX
    }
	@Test
	public void test_alea1() {
       double t1,t2,t3;
       // XXX
       double[] t_list = new double[] {16,17,18,19,20,21,22,21,20,19,18,17,16};
       for (double t : t_list) {
           t1 = t+r.nextDouble()-0.5 ;
           t2 = t+r.nextDouble()-0.5;
           t3 = t+r.nextDouble()-0.5;
          // XXX
           System.out.printf("test alea 1: t=%f  \n", t);
       }
   }

    	public void test_alea2() {
       // XXX
       System.out.printf("test alea 2: t=%f  \n", t);
       }
   } 
}



