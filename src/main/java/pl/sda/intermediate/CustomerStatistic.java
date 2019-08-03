package pl.sda.intermediate;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerStatistic {

    static Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250 "),
            new Customer("Adam", "Twardowski", 33, "4100 "),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333),
            new Customer("Adam", "Nowak ", 15, null)
    };

    public static List<Customer> convertToList() {
        return Arrays.asList(people);
    }

    //    2. Napisz metodę, która przyjmie tablicę people i zwróci
//    listę Stringów <imię nazwisko> (elementem listy będzie np "Anna Nowak")
    public static List<String> returnStringList() {
        return convertToList().stream()
                .map(a -> a.getFirstName() + " " + a.getLastName())
                .collect(Collectors.toList());
    }

    //    3. Napisz metodę, która zwróci mapę osób <id,osoba>
    public static Map<Integer, Customer> convertToMap() {
        Map<Integer, Customer> resultMap = new HashMap<>();
        for (Customer person : people) {
            resultMap.put(person.getId(), person);
        }
        return resultMap;
    }

    public static Map<Integer, Customer> convertToMapWithStream() {
        return convertToList().stream()
                .collect(Collectors.toMap(c -> c.getId(), c -> c));
    }

    // 4. Napisz metodę, która zwróci mapę osób
    // według zarobków <zarobki,osoby_z_zarobkami>
    public static Map<BigDecimal, List<Customer>> convertToSalaryStatisticsMap() {
        Map<BigDecimal, List<Customer>> resultMap = new HashMap<>();
        for (Customer customer : people) { // iteracja po ludziach
            if (resultMap.containsKey(customer.getSalary())) {
                List<Customer> customers = resultMap.get(customer.getSalary());
                customers.add(customer);
//                resultMap.put(customer.getSalary(), customerList);
            } else {
                List<Customer> customerList = new ArrayList<>();
                customerList.add(customer);
                resultMap.put(customer.getSalary(), customerList);
            }
        }
        return resultMap;
    }
}


