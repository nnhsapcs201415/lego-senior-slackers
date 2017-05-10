import lejos.nxt.Button;
import lejos.nxt.LCD; 
import lejos.nxt.Motor; 

/**
 * Write a description of class MotorController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MotorController
{
    public static void moveForward(int v)
    {
        Motor.B.setSpeed(v);
        Motor.C.setSpeed(v); 
        Motor.B.forward();
        Motor.C.forward();
        Button.waitForAnyPress();
        Motor.B.stop();
        Motor.C.stop();
    }
    public static void moveBackward(int v)
    {
        Motor.B.setSpeed(v);
        Motor.C.setSpeed(v); 
        Motor.B.backward();
        Motor.C.backward();
        Button.waitForAnyPress();
        Motor.B.stop();
        Motor.C.stop();
    }
    public static void turnleft(int degrees)
    {
        Motor.C.rotate(degrees);
    }
    public static void turnRight(int degrees)
    {
        Motor.B.rotate(degrees);
    }
    public static void main (String[] args)
    {
        moveForward(1000);
        turnleft(1440); 
        moveBackward(2000); 
    }
}
