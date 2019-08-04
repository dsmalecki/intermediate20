package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {


    @Test
    void name() {
        Set<String> strings = new TreeSet<>();
        strings.add("b");
        strings.add("c");
        strings.add("a");
        System.out.println(strings);
    }

    @Test
    void treeSet() {
        Set<Category> categories = new TreeSet<>();

        Category category = new Category();
        category.setId(4);
        category.setName("Pierwsza");

        categories.add(category);

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Druga");

        categories.add(category2);
        System.out.println(categories);
    }
}
