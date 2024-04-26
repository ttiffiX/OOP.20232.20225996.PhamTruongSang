package AimsProject.src.hust.soict.globalict.aims.media;

public class Media extends java.lang.Object {
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media() {
        super();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return title.equals(((Media) o).title);
    }

    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
}
