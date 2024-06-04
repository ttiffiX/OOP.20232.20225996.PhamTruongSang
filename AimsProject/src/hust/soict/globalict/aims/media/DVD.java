package AimsProject.src.hust.soict.globalict.aims.media;

import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.src.hust.soict.globalict.aims.play.Playable;

public class DVD extends Disc implements Playable {
    public DVD(int id, String title) {
        super(id, title);
    }

    public DVD(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DVD(int id, String title, String category, String director, float cost) {
        super(id, title, category, director, cost);
    }

    public DVD(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    @Override
    public String toString() {
        return "DVD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " +
                this.getDirector() + " - " + this.getLength() + "m: " +
                this.getCost() + "$";
    }

    public boolean isMatch(DVD disc) {
        return this.getTitle().equals(disc.getTitle()) &&
                this.getCategory().equals(disc.getCategory()) &&
                this.getDirector().equals(disc.getDirector()) &&
                this.getLength() == disc.getLength() &&
                this.getCost() == disc.getCost();
    }

    @Override
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());

            return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
        } else {
            System.err.println("ERROR: DVD length is non-positive.");
            throw new PlayerException("ERROR: DVD length is non-positive.");
        }
    }
}
