package pl.sda.intermediate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO { //DTO - data transfer object
    private Integer id;
    private String name;
    private Integer parentId;

    private boolean selected;
    private boolean open;

}
