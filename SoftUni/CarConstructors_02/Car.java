package SoftUni.CarConstructors_02;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand){
        this(brand, "unknown", -1);
    }

    public Car(String brand, int horsePower){
        this(brand, "unknown", horsePower);
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", brand, model, horsePower);
    }

}