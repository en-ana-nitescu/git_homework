package practice;

import org.junit.jupiter.api.Test;

public class PlaneTest {

    @Test
    public void testPlaneDetails() {
        Plane plane1 = new Plane("passengers","Boeing","B-127",260,"kerosene");
        plane1.showPlaneDetails();

        Plane plane2 = new Plane("passengers","Airbus","A-2025",354,"hydrogen");
        plane2.showPlaneDetails();

        Plane plane3 = new Plane("passengers","Airbus","A-2025",354,"hydrogen",100);
        plane3.showPlaneDetails();
    }
}
