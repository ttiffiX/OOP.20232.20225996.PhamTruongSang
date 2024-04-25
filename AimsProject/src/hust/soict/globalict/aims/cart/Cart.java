package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added.");
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
        if (itemsOrdered.isEmpty()) System.out.println("The cart is empty.");
        else {
            int i = 0;
            System.out.println("******************************Cart******************************\nOrdered Items:");
            for (Media media : itemsOrdered){
                System.out.println(i + 1 + ". Media - " + media.toString());
                i++;
            }
            System.out.printf("%-10s %.2f$\n", "Total Cost", totalCost());
            System.out.println("****************************************************************");


        }
    }

//    public void searchDVD(int id) {
//        if (itemsOrdered.isEmpty()) System.out.println("The cart is empty.");
//        else {
//            for (Media media : itemsOrdered){
//                if (media.getId() == id) {
//                    System.out.println("Result for media have id '" + id + "' is: " +
//                            media.toString());
//                    return;
//                }
//            }
//            System.out.println("No result for media have id '" + id + "'.");
//        }
//    }
//
//    public void searchDVD(String title) {
//        if (itemsOrdered.isEmpty()) System.out.println("The cart is empty.");
//        else {
//            for (Media media : itemsOrdered){
//                if (media.isMatch(title)) {
//                    System.out.println("Result: " + itemOrdered[i].toString());
//                    return;
//                }
//            }
//            System.out.println("No Result.");
//        }
//    }

}
