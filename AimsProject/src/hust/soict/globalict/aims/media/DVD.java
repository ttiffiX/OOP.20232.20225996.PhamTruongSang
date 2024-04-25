package AimsProject.src.hust.soict.globalict.aims.media;

public class DVD extends Media{
    private static int nbDVDs = 0;
    private String director;
    private int length;

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public DVD(String title) {
        this.setTitle(title);

        nbDVDs++;
        this.setId(nbDVDs);
    }

    public DVD(String title, String category, String director, int length, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
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
        this.director = director;
        this.setCost(cost);

        nbDVDs++;
        this.setId(nbDVDs);
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getCategory() + " - " +
                this.director + " - " + this.length + "m: " +
                this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

    public boolean isMatch(DVD disc) {
        return this.getTitle().equals(disc.getTitle()) &&
                this.getCategory().equals(disc.getCategory()) &&
                this.director.equals(disc.getDirector()) &&
                this.length == disc.getLength() &&
                this.getCost() == disc.getCost();
    }

}
