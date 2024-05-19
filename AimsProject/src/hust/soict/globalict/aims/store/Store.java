package AimsProject.src.hust.soict.globalict.aims.store;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemInStore = new ArrayList<Media>();


    public ArrayList<Media> getItemsInStore() {
        return itemInStore;
    }

    public void addMedia(Media media) {
        if (!itemInStore.contains(media)) {
            itemInStore.add(media);
        } else System.out.println("The media is already exist.");
    }

    public void removeMedia(Media media) {
        if (itemInStore.isEmpty()) System.out.println("The Cart is empty.");
        else {
            for (Media i : itemInStore) {
                if (i.equals(media)) {
                    itemInStore.remove(media);
                    System.out.println("The media has been removed.");
                    return;
                }
            }
            System.out.println("The media does not exist.");
        }
    }

    public void displayStore() {
        System.out.println("******************************Store******************************");
        System.out.println("Items in store:");
        for (Media item : itemInStore) {
            System.out.println(item.toString());
        }
        System.out.println("*****************************************************************");
    }

    public Media searchStore(String title) {
        for (Media item : itemInStore) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null;
    }
}
