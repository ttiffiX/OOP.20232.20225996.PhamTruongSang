package AimsProject.src.hust.soict.globalict.aims.media;

import AimsProject.src.hust.soict.globalict.aims.play.Playable;

import java.util.ArrayList;
import java.util.List;

public class CD extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    private int totalLength = 0;

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        for (Track track : tracks) {
            this.totalLength += track.getLength();
        }
        return totalLength;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public CD() {
        super();
    }

    public CD(int id, String title) {
        super(id, title);
    }

    public CD(int id, String title, String category, String artist, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public CD(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else System.out.println("The track is already exist.");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track has been removed.");
        } else System.out.println("The track does not exist.");
    }


    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("This track can't be played.");
        } else {
            for (Track track : tracks) {
                track.play();
            }
        }
    }

    public String toString() {
        return "CD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " +
                this.getArtist() + " - " + this.getLength() + " - " + this.getCost() + "$ "
                + "(Track list: " + this.tracks + ")";
    }
}
