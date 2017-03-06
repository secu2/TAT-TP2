// Time-stamp: <modified the 06/03/2017 (at 15:52) by Erwan Jahier> 
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class HeaterControlTest {
	@Test
	public void ca_chauffe_sil_fait_froid() {
       // XXX finish me!
       assertEquals(hc.getOn(),true);
       System.out.printf("ca_chauffe_sil_fait_froid: ok.\n");
	}
	@Test
	public void ca_chauffe_pas_sil_fait_chaud() {
       // XXX finish me!
       assertEquals(hc.getOn(),false);
       System.out.printf("ca_chauffe_pas_sil_fait_chaud:  ok.\n");
	}
}

}
