package AimsProject.src.hust.soict.globalict.aims.compactdisc;

public class Track {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }


    public Track(){}

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
}
