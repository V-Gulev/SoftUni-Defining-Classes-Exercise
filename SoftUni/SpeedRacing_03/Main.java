package SoftUni.SpeedRacing_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String model = data[0];
            double fuel = Double.parseDouble(data[1]);
            double consumptionPerKm = Double.parseDouble(data[2]);
            int distance = 0;
            Car currentCar = new Car(model, fuel, consumptionPerKm, distance);
            cars.add(currentCar);
        }

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String currentCarModel = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);
            boolean isMoving = getCurrentCar(currentCarModel, cars).isMoving(distance);

            if (isMoving) {
                Car currentCar = getCurrentCar(currentCarModel, cars);
                double restFuel = currentCar.getRestFuel(distance);
                currentCar.setFuelAmount(restFuel);
                int currentDistance = currentCar.getDistanceTraveled();
                currentCar.setDistanceTraveled(currentDistance + distance);
            } else {

                System.out.println("Insufficient fuel for the drive");
            }
            input = sc.nextLine();
        }


        cars.forEach(car -> System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTraveled()));
    }

    private static Car getCurrentCar(String currentCarModel, List<Car> cars) {
        Car currentCar = null;
        for (Car car : cars) {
            if (car.getModel().equals(currentCarModel)) {
                currentCar = car;
            }
        }
        return currentCar;
    }
}
