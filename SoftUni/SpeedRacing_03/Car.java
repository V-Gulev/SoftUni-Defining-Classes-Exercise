package SoftUni.SpeedRacing_03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelCostFor1km;
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean isMoving(int distance) {
        double consumeFuel = fuelConsumptionPerKm * distance;
        return consumeFuel <= fuelAmount;
    }

    public double getRestFuel(int distance) {
        return fuelAmount - (distance * fuelConsumptionPerKm);
    }
}
