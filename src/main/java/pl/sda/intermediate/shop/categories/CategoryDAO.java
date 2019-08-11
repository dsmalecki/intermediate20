package pl.sda.intermediate.shop.categories;

import lombok.Getter;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryDAO { // DATA ACCESS OBJECT

    @Getter //to dotyczy tylko pola
    private List<Category> categories = populateCategories();

    private static Integer categoryIdCounter = 0;

    private static CategoryDAO instance;

    private CategoryDAO() {

    }

    public static CategoryDAO getInstance() {
        if (instance == null) { // unikamy synchronized ze wzgledu na kosztownosc
            synchronized (CategoryDAO.class) {
                if (instance == null) {
                    instance = new CategoryDAO();
                }
            }
        }
        return instance;
    }

    private List<Category> populateCategories() {
        List<String> lines = readLinesFromFile();
        List<Category> categoriesList = changeLinesToListOfCategories(lines);
        Map<Integer, List<Category>> categoriesMap = createMapWithLevels(categoriesList);
        populateParentIdsUsingMap(categoriesMap);
        return categoriesList;
    }

    private void populateParentIdsUsingMap(Map<Integer, List<Category>> categoriesMap) {
        int level = 0;
        while (categoriesMap.containsKey(level)) {
            populateParents(categoriesMap, level);
            level++;
        }
    }

    private Map<Integer, List<Category>> createMapWithLevels(List<Category> categoriesList) {
        return categoriesList.stream()
                .collect(Collectors.groupingBy(x -> x.getLevel()));
    }

    private List<Category> changeLinesToListOfCategories(List<String> lines) {
        return lines.stream()
                .map(s -> buildCategory(s))
                .collect(Collectors.toList());
    }

    private List<String> readLinesFromFile() {
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
        return lines;
    }

    private void populateParents(Map<Integer, List<Category>> categoriesMap, int level) {
        List<Category> children = categoriesMap.get(level);

        List<Category> potentialParents = categoriesMap.get(level - 1);
        for (Category child : children) {
            if (potentialParents == null) {
                child.setParentId(null);
            } else {
                chooseParentIdIfPresent(potentialParents, child);
            }
        }
    }

    private void chooseParentIdIfPresent(List<Category> potentialParents, Category child) {
        List<Integer> parentsIds = potentialParents.stream()
                .map(e -> e.getId())
                .collect(Collectors.toList());
        Integer categoryParentId = parentsIds.stream()
                .filter(parentId -> parentId < child.getId())
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);
        child.setParentId(categoryParentId);
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
