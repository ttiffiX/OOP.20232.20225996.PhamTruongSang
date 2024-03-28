package Lab02.AimsProject.src;

public class DVD {
    private static int nbDVDs = 0;

    private int id;
    private String title;
    private  String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public DVD(String title) {
        this.title = title;

        nbDVDs++;
        this.id = nbDVDs;
    }
    public DVD(String title,String category,String director,int length,float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDVDs++;
        this.id = nbDVDs;
    }


    public DVD(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;

        nbDVDs++;
        this.id = nbDVDs;
    }

    public DVD(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;

        nbDVDs++;
        this.id = nbDVDs;
    }
}
