package pl.sda.intermediate;

import java.math.BigDecimal;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private BigDecimal salary;


    public Customer(String firstName, String lastName, int age, String salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = new BigDecimal(salary);
    }

    public Customer(String firstName, String lastName, int age, int salary) {

    }
}
