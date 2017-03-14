package phare;import java.security.GeneralSecurityException;
import java.util.Date;

public class CarLight {
	private double intensity;      //input
	private SwitchMode switch_pos; //input
	private boolean is_on;         //output
	private Date last_intensity_change;

	public CarLight(double li, SwitchMode sm) {
		setIntensity(li);
		last_intensity_change = new Date();
		switch_pos = sm;
	}
	public void setIntensity(double li) {
		intensity=li;
		last_intensity_change = new Date();
	} 
	public void setSwitch(SwitchMode sm) {
		switch_pos = sm;
	} 
	public SwitchMode getSwitch() {
		return switch_pos;
	} 
	public boolean isOn() {
		return is_on;
	}
	public void dump() {
		System.out.printf("[car light] i=%f ; sw=%s ; On=%s \n",
				intensity, switch_pos, is_on);
	}


	// calcule is_on en fonction de intensity et switch_pos
	public void step() {
		// is_on = false;
		// finish me
		switch (switch_pos) {
		case ON: 
			is_on = true;
			break;

		case OFF: 
			is_on = false;
			break;

		case AUTO:
			if((is_on == true && intensity < 70) || intensity <= 70){
				is_on = true;					
			}else if((is_on == false && intensity >= 60) || intensity > 70){
				is_on = false;
			}
			break;
		}
	}

}
