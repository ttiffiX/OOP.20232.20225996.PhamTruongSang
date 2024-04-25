package AimsProject.src.hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        this.setId(id);
        this.setCategory(category);
        this.setCost(cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Add author complete.");
        }else System.out.println("The author is already exist.");
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author has been removed.");
        }else System.out.println("The author does not exist.");
    }
}
