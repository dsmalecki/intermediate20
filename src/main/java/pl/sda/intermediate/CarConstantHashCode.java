package pl.sda.intermediate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarConstantHashCode {
    String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarConstantHashCode that = (CarConstantHashCode) o;
        return model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return 5;
    }
}
