package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The Cart is already full.");
            return;
        }
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
        }else System.out.println("The media is already exist.");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) System.out.println("The Cart is empty.");
        else {
            for (Media i : itemsOrdered) {
                if (i.equals(media)) {
                    itemsOrdered.remove(media);
                    System.out.println("The media has been removed.");
                    return;
                }
            }
            System.out.println("The media does not exist.");
        }
    }

    public float totalCost() {
        float cost = 0;
        for (Media media : itemsOrdered){
            cost += media.getCost();
        }
        return cost;
    }

    public void displayItem() {
            int i = 0;
            System.out.println("******************************Cart******************************\nOrdered Items:");
            for (Media media : itemsOrdered){
                System.out.println(i + 1 + ". Media - " + media.toString());
                i++;
            }
            System.out.printf("%-10s %.2f$\n", "Total Cost", totalCost());
            System.out.println("****************************************************************");
    }

    public Media searchCart(String title) {
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null;
    }

    public Media searchCart(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void sortByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void sortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public int sizeCart() {
        return itemsOrdered.size();
    }

}
