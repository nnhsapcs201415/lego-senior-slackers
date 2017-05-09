import lejos.nxt.Button;
import lejos.nxt.LCD; 
import lejos.nxt.Motor; 
public class MotorTutor1
{
    public static void main(String[] args)
    {
        LCD.drawString("Program 1",0,0);
        Button.waitForAnyPress();
        LCD.clear();
        Motor.B.forward();
        Motor.C.forward();
        LCD.drawString("FORWARD",0,0); 
        Button.waitForAnyPress();
        LCD.drawString("BACKWARD",0,0);
        Motor.B.backward();
        Motor.C.backward();
        Button.waitForAnyPress();
        Motor.B.stop();
        Motor.C.stop(); 
    }

}