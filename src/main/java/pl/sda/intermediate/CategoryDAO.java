package pl.sda.intermediate;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDAO { // DATA ACCESS OBJECT

    private List<Category> categories;

    private Integer categoryIdCounter = 0;

    private List<Category> populateCategories() {
        List<String> lines;
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            URI uri = classLoader.getResource("kategorie.txt").toURI();
            Path path = Paths.get(uri);
            lines = Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            lines = new ArrayList<>();
        }
//        List<Category> resultList = new ArrayList<>();
//        for (String line : lines) {
//            Category category = new Category();
//            category.set...
//            resultList.add(category);
//        }

        List<Category> categoriesList = lines.stream()
                .map(s ->buildCategory(s))
                .collect(Collectors.toList());

        return null;
    }

    private Category buildCategory(String line) {
        Category category = new Category();
        if (!line.startsWith(" ")) {
            category.setLevel(0);
        } else {
            String[] split = line.split("\\S+");
            int level = split[0].length();
            category.setLevel(level);
        }
        category.setId(++categoryIdCounter);
        category.setName(line.trim());
        return category;
    }
}
