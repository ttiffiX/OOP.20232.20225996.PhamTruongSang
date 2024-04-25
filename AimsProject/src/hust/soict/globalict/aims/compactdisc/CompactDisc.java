package AimsProject.src.hust.soict.globalict.aims.compactdisc;

import AimsProject.src.hust.soict.globalict.aims.media.Disc;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
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

    public CompactDisc() {
        super();
    }

    public CompactDisc(String artist, List<Track> tracks) {
        super();
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("The track has been added.");
        } else System.out.println("The track is already exist.");
    }

    public void removeAuthor(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track has been removed.");
        } else System.out.println("The track does not exist.");
    }


}
