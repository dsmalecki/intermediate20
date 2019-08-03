package pl.sda.intermediate;

import java.math.BigDecimal;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
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
