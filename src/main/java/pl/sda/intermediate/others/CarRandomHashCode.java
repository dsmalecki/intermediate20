package pl.sda.intermediate.others;

import lombok.AllArgsConstructor;

import java.util.Random;
@AllArgsConstructor
public class CarRandomHashCode {
    String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRandomHashCode that = (CarRandomHashCode) o;
        return model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return new Random().nextInt(5);
    }

}
