package AimsProject.src.hust.soict.globalict.aims.media;

import AimsProject.src.hust.soict.globalict.aims.play.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }


    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else {
            System.out.println("This track can't be played");
        }
    }
}
