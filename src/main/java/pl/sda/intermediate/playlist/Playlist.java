package pl.sda.intermediate.playlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Playlist implements Playable {
    private PlayMode playmode = PlayMode.SEQUENCE;
    private List<Playable> elements = new ArrayList<>();


    @Override
    public String play() {
        String result = "";
        if (playmode == PlayMode.SEQUENCE) {
            result = populateResult(result, elements);
        } else if (playmode == PlayMode.RANDOM) {
            List<Playable> tempList = new ArrayList<>(elements);
            Collections.shuffle(tempList);
            result = populateResult(result, tempList);
        } else if (playmode == PlayMode.LOOP) {
            for (int i = 0; i < 10; i++) {
                result = populateResult(result, elements);
            }
        }
        return result;
    }

    private String populateResult(String result, List<Playable> tempList) {
//        for (Playable element : tempList) {
//            result = result + element.play() + "\n";
//        }
//        return result.trim();
        return tempList.stream()
                .map(e -> e.play())
                .collect(Collectors.joining("\n"));

    }

    public void addElementToList(Playable playable) {
        elements.add(playable);
    }

    public void addElementToList(Playable... playables) { //varargs
        elements.addAll(Arrays.asList(playables));
    }

    public void changePlayMode(PlayMode playMode) {
        this.playmode = playMode;
    }

}
