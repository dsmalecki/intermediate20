package pl.sda.intermediate;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer level;

    public static int counter;
}
