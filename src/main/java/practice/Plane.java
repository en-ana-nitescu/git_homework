package practice;

public class Plane {

    public String type;
    public String brand;
    public String model;
    public Integer capacity;
    public String fuelType;
    public Integer luggageNumber;

    public Plane(String type, String brand, String model, Integer capacity, String fuelType) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.fuelType = fuelType;
    }

    public Plane(String type, String brand, String model, Integer capacity, String fuelType, Integer luggageNumber) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.luggageNumber = luggageNumber;
    }

    public void showPlaneDetails() {
        System.out.println("Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Capacity: " + capacity);
        System.out.println("Fuel Type: " + fuelType);
        if(luggageNumber != null) {
            System.out.println("Luggage number: " + luggageNumber);
        } else {
            System.out.println("No luggage");
        }
        System.out.println();

    }
}
