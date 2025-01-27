package SoftUni.CarConstructors_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String brand = input[0];

            if (input.length > 1) {
                String model = input[1];
                int hp = Integer.parseInt(input[2]);
                cars.add(new Car(brand, model,hp));
            } else {
                cars.add(new Car(brand));
            }

        }

        cars.forEach(car -> System.out.println(car.carInfo()));

    }
}
