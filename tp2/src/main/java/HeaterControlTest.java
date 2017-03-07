// Time-stamp: <modified the 06/03/2017 (at 15:52) by Erwan Jahier> 
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.pholser.junit.quickcheck.When;


@RunWith(MockitoJUnitRunner.class)
public class HeaterControlTest {
	@Test
	public void ca_chauffe_sil_fait_froid() {
		Sensor sensor1 = Mockito.mock(Sensor.class);
		Sensor sensor2 = Mockito.mock(Sensor.class);
		Sensor sensor3 = Mockito.mock(Sensor.class);

		Mockito.when(sensor1.getT()).thenReturn((double) 15);
		Mockito.when(sensor2.getT()).thenReturn((double) 17);
		Mockito.when(sensor3.getT()).thenReturn((double) 21);

		HeaterControl hc = new HeaterControl(18, sensor1, sensor2, sensor3);

		assertEquals(hc.getOn(),true);
		System.out.printf("ca_chauffe_sil_fait_froid: ok.\n");
	}
	@Test
	public void ca_chauffe_pas_sil_fait_chaud() {
		Sensor sensor1 = Mockito.mock(Sensor.class);
		Sensor sensor2 = Mockito.mock(Sensor.class);
		Sensor sensor3 = Mockito.mock(Sensor.class);

		Mockito.when(sensor1.getT()).thenReturn((double) 18);
		Mockito.when(sensor2.getT()).thenReturn((double) 17);
		Mockito.when(sensor3.getT()).thenReturn((double) 24);

		HeaterControl hc = new HeaterControl(18, sensor1, sensor2, sensor3);

		assertEquals(hc.getOn(),false);
		System.out.printf("ca_chauffe_pas_sil_fait_chaud:  ok.\n");
	}
}

}
