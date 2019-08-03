package pl.sda.intermediate;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal salary;

    static int counter = 0;

    { //blok inicjalizujący - uruchomi się ZAWSZE przy towrzeniu nowego obiektu
        System.out.println("Blok inicjalizujący");
        id = ++counter;
    }

    public Customer(String firstName, String lastName, int age, String salary) {
        this(firstName, lastName, age, Integer.parseInt(salary));
        System.out.println("Konstruktor 1");
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.salary = BigDecimal.valueOf(Double.valueOf(salary));
    }

    public Customer(String firstName, String lastName, int age, int salary) {
        System.out.println("Konstruktor 2");
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = BigDecimal.valueOf(salary);
    }

}
