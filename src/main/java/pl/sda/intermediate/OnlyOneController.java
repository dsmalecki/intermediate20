package pl.sda.intermediate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.intermediate.shop.categories.CategoryDTO;
import pl.sda.intermediate.shop.categories.CategoryService;

import java.util.List;

@Controller //ta adnotacja powoduje, że klasa będzie przechwytywać requesty
public class OnlyOneController {
    private CategoryService categoryService = new CategoryService();

    @RequestMapping("/categories")
    String categories(String input, Model model){
        List<CategoryDTO> dtos = categoryService.searchAndSelect(input);
        model.addAttribute("catsdata", dtos);
        return "catspage"; //to jest nazwa pliku html, który wyświetlimy
    }

}
