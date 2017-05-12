import lejos.nxt.*;
import lejos.robotics.objectdetection.*;

public class ObjectDetect implements FeatureListener {

    public static int MAX_DETECT = 80;

    public static void main(String[] args) throws Exception {

        ObjectDetect listener = new ObjectDetect();
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
        RangeFeatureDetector fd = new RangeFeatureDetector(us, MAX_DETECT, 500);
        fd.addListener(listener);
        Button.ENTER.waitForPressAndRelease();
    }

    public void featureDetected(Feature feature, FeatureDetector detector) {
        int range = (int)feature.getRangeReading().getRange();
        Sound.playTone(1200 - (range * 10), 100);
        System.out.println("Range:" + range);
    }

    UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
    FeatureDetector detector1 = new RangeFeatureDetector(us, MAX_DETECT,RANGE_READING_DELAY);

    Touch leftBump = new TouchSensor(SensorPort.S2);
    FeatureDetector detector2 = new TouchFeatureDetector(leftBump, 10, TOUCH_Y_OFFSET); 

    Touch rightBump = new TouchSensor(SensorPort.S3);
    FeatureDetector detector3 = new TouchFeatureDetector(rightBump, -10, TOUCH_Y_OFFSET); 

    FusorDetector fusion = new FusorDetector();
    fusion.addDetector(detector1);
    fusion.addDetector(detector2);
    fusion.addDetector(detector3);

    fusion.addListener(myFeatureListener);
}