package AimsProject.src.hust.soict.globalict.aims.media;

import AimsProject.src.hust.soict.globalict.aims.play.Playable;

public class DVD extends Disc implements Playable {
    private static int nbDVDs = 0;

    public DVD(String title) {
        this.setTitle(title);

        nbDVDs++;
        this.setId(nbDVDs);
    }

    public DVD(String title, String category, String director, int length, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);

        nbDVDs++;
        this.setId(nbDVDs);
    }


    public DVD(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);

        nbDVDs++;
        this.setId(nbDVDs);
    }

    public DVD(String title, String category, String director, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setCost(cost);

        nbDVDs++;
        this.setId(nbDVDs);
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getCategory() + " - " +
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
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
