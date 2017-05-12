import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class TravelTest {
    DifferentialPilot pilot;
    TouchSensor bump = new TouchSensor(SensorPort.S1);

    public void drawSquare(float length) 
    {
        for (int i=0; i < 4; i++)
        {
            pilot.travel(length);
            pilot.rotate(-90);
        }
    }

    public static void main(String[] args) {
        TravelTest traveler = new TravelTest();
        traveler.pilot = new DifferentialPilot(2.25f, 6.5f, Motor.B, Motor.C);
        traveler.drawSquare(15);
    }
}