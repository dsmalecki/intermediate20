package pl.sda.intermediate.others;

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

    public static Map<BigDecimal, List<Customer>> convertToSalaryStatisticsMapWithStream() {
        return convertToList().stream()
                .collect(Collectors.groupingBy(customer -> customer.getSalary()));
    }

    //6. Napisz metodę, która zwróci
    // mapę map <imię,<zarobki, liczba_osób_z_takimi_zarobkami>>

    public static Map<String, Map<BigDecimal, Integer>> convertToMapiontko() {
        Map<String, Map<BigDecimal, Integer>> veryGoodMap = new HashMap<>();
        for (Customer person : people) {
            if (veryGoodMap.containsKey(person.getFirstName())) {
                Map<BigDecimal, Integer> innerMap = veryGoodMap.get(person.getFirstName());
                if (innerMap.containsKey(person.getSalary())) {
                    Integer counter = innerMap.get(person.getSalary());
                    counter = counter + 1;
                    innerMap.put(person.getSalary(), counter);
                } else {
                    innerMap.put(person.getSalary(), 1);
                }
            } else {
                Map<BigDecimal, Integer> innerMap = new HashMap<>();
                innerMap.put(person.getSalary(), 1);
                veryGoodMap.put(person.getFirstName(), innerMap);
            }
        }
        return veryGoodMap;
    }

    public static Map<String, Map<BigDecimal, Long>> convertToMapiontkoWithStream() {
       return convertToList().stream()
                .collect(
                        Collectors.groupingBy(p -> p.getFirstName(),
                                Collectors.groupingBy(p -> p.getSalary(),
                                        Collectors.counting())
                        ));
    }
}

