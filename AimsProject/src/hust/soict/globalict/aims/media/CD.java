package AimsProject.src.hust.soict.globalict.aims.media;

import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
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
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            java.util.Iterator iterator = tracks.iterator();
            Track nextTrack;
                String result = "";
            while (iterator.hasNext()) {
                nextTrack = (Track) iterator.next();
                result += nextTrack.play();

            }
            return "Now Playing: " + this.getTitle() + result;
        } else {
            System.err.println("ERROR: CD length is non-positive.");
            throw new PlayerException("ERROR: CD length is non-positive");

        }
    }

    public String toString() {
        return "CD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " +
                this.getArtist() + " - " + this.getLength() + " - " + this.getCost() + "$ "
                + "(Track list: " + this.tracks + ")";
    }
}
