package pl.sda.intermediate;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public List<CategoryDTO> searchAndSelect(String searchedText) {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        List<Category> categories = categoryDAO.getCategories();
        List<CategoryDTO> result = populateDtoList(categories);
        selectedAndOpenPopulator(searchedText, result);
        return result;
    }

    private List<CategoryDTO> populateDtoList(List<Category> categories) {
        List<CategoryDTO> result = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setParentId(category.getParentId());
            result.add(categoryDTO);
        }
        return result;
    }

    private void selectedAndOpenPopulator(String searchedText, List<CategoryDTO> result) {
        for (CategoryDTO categoryDTO : result) {
            if (categoryDTO.getName().contains(searchedText)) {
                categoryDTO.getState().setSelected(true);
                categoryDTO.getState().setOpened(true);
                openParent(categoryDTO.getParentId(), result);
            }
        }
    }

    private void openParent(Integer parentId, List<CategoryDTO> dtoList) {
        if (parentId == null) {
            return;
        }
        CategoryDTO parent = dtoList.stream()
                .filter(e -> e.getId().equals(parentId))
                .findFirst()
                .orElse(null);
        parent.getState().setOpened(true);
        openParent(parent.getParentId(), dtoList);
    }

}
