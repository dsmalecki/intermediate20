package pl.sda.intermediate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @Test
    void shouldProperlyPopulateListAndMarkAsSelectedAndOpen() {
        String searchText = "Klasa druga";

        CategoryService categoryService = new CategoryService();
        List<CategoryDTO> categoryDTOS = categoryService.searchAndSelect(searchText);

        CategoryDTO cat6 = categoryDTOS.stream()
                .filter(e -> e.getId().equals(6))
                .findFirst()
                .orElse(null);
        CategoryDTO cat4 = categoryDTOS.stream()
                .filter(e -> e.getId().equals(4))
                .findFirst()
                .orElse(null);


        Assertions.assertTrue(cat6.getState().isSelected());
        Assertions.assertTrue(cat4.getState().isOpened());

    }
}
