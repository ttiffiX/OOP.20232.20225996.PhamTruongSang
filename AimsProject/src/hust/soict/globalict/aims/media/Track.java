package AimsProject.src.hust.soict.globalict.aims.media;

import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
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
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length);

            return "\nPlaying Track: " + this.title + "\nTrack length: " + this.length;
        } else {
            System.err.println("ERROR: Track length is non-positive.");
            throw new PlayerException("ERROR: Track length is non-positive");
//            return "\nTrack: " + this.title + ", ERROR: Track length is non-positive";
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Track obj = (Track) o;
        if (!title.equals(obj.title)) {
            return false;
        }
        return length == obj.getLength();
    }

    public String toString() {
        return this.getTitle() + " - " + this.getLength();
    }
}
