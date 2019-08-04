package pl.sda.intermediate.playlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Playlist implements Playable {
    private PlayMode playmode = PlayMode.SEQUENCE;
    private List<Playable> elements = new ArrayList<>();


    @Override
    public String play() {
        String result = "";
        if(playmode == PlayMode.SEQUENCE) {
            for (Playable element : elements) {
                result = result + element.play() + "\n" ;
            }
        }else if(playmode == PlayMode.RANDOM){
            List<Playable> tempList = new ArrayList<>(elements);
            Collections.shuffle(tempList);
            for (Playable element : tempList) {
                result = result + element.play() + "\n" ;
            }
        }
        return result;
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
