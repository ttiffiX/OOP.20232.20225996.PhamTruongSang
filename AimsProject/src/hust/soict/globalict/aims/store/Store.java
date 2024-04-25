package AimsProject.src.hust.soict.globalict.aims.store;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store{
    private ArrayList<Media> itemInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemInStore.contains(media)) {
            itemInStore.add(media);
            System.out.println("The media has been added.");
        }else System.out.println("The media is already exist.");
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
}
