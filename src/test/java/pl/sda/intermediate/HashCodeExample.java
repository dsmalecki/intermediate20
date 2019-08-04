package pl.sda.intermediate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {
    @Test
    void constantHashCodeTest() {
        CarConstantHashCode car1 = new CarConstantHashCode("Audi");
        CarConstantHashCode car2 = new CarConstantHashCode("BMW");
        CarConstantHashCode car3 = new CarConstantHashCode("Skoda");
        CarConstantHashCode car4 = new CarConstantHashCode("Audi");
        CarConstantHashCode car5 = new CarConstantHashCode("Audi");
        CarConstantHashCode car6 = new CarConstantHashCode("Audi");

        Set<CarConstantHashCode> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        System.out.println(cars.size());
    }
    @RepeatedTest(100)
    void randomHashCodeTest() {
        CarRandomHashCode car1 = new CarRandomHashCode("Audi");
        CarRandomHashCode car2 = new CarRandomHashCode("Audi");
        CarRandomHashCode car3 = new CarRandomHashCode("Audi");
        CarRandomHashCode car4 = new CarRandomHashCode("Audi");
        CarRandomHashCode car5 = new CarRandomHashCode("Audi");
        CarRandomHashCode car6 = new CarRandomHashCode("Audi");

        Set<CarRandomHashCode> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        System.out.println(cars.size());
        System.out.println(cars.contains(car1));
    }
}
