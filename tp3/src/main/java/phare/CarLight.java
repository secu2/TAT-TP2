package phare;

public class CarLight {
    private double intensity;      //input
    private SwitchMode switch_pos; //input
    private boolean is_on;         //output

    public CarLight(double li, SwitchMode sm) {
        setIntensity(li);
        switch_pos = sm;
    }
    public void setIntensity(double li) {
        intensity=li;
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
        is_on = false;
        // finish me
        switch (switch_pos) {
        case ON: 
            break;
            
        case OFF: 
            break;
            
        case AUTO:
            break;
        }
    }

}
