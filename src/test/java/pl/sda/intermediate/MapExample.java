package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    @Test
    void maps() {
        Map<String, Long> map = new HashMap<>();
        map.put("a", 10L);
        map.put("b", 11L);
        map.put("abc", 7L);

        map.remove("b");

        Map<String, List<Long>> map2 = new HashMap<>();
        List<Long> innerList = new ArrayList<>();
        innerList.add(1L);
        innerList.add(2L);
        map2.put("a", innerList);
        System.out.println(map2);
        List<Long> inner = map2.get("a");
        inner.remove(1);
        System.out.println(map2);
        inner.add(3L);
        System.out.println(map2);
    }
}
