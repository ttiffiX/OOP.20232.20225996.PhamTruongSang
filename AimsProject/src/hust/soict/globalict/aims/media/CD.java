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

    public CD() {
        super();
    }

    public CD(String artist, List<Track> tracks) {
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


    @Override
    public void play() {
        for (Track track : tracks){
            System.out.println("Playing Track: "+  track.getTitle());
            System.out.println("Track length: "+ track.getLength());
        }
    }
}
