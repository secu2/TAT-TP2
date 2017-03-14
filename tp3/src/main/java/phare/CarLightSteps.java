package phare;
import org.jbehave.core.annotations.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarLightSteps{
    private CarLight cl;
    private double t = 0.0;

	@Given("a car light system")
	public void givenACarLightSystem(){
		 cl = new CarLight(0.0,SwitchMode.OFF);
       t = 0.0;
	}
	@When("the switch mode is ON")
	public void whenTheSwitchModeIsON(){
		 cl.setSwitch(SwitchMode.ON); 
       cl.step(); 
	}


    public void wait(CarLight cl,double tw) {
       double t = 0.0;
       while (t <= tw) {
          t = t + 0.5;
          cl.step();
       }
    }


	@Then("the light should be ON")
	public void thenTheLightShouldBeON(){
		 assertTrue(cl.isOn());
	}
	@Then("the light should be OFF")
	public void thenTheLightShouldBeOFF(){
		 assertFalse(cl.isOn());
	}
	@When("the light intensity is 65%")
	public void whenTheLightIntensityIs65(){
		 cl.setIntensity(65.0);
       cl.step(); 
	}
	@When("the light intensity is 72%")
	public void whenTheLightIntensityIs72(){
		 cl.setIntensity(72.0);
       cl.step(); 
	}
}