package AimsProject.src.hust.soict.globalict.aims.store;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;

public class Store{
    public static final int MAX_NUMBERS_DVD = 100;
    DVD itemInStore[] = new DVD[MAX_NUMBERS_DVD];
    private int qtyItem = 0;

    public void addDVDts(DVD disc) {
        if (qtyItem > MAX_NUMBERS_DVD) {
            System.out.println("The store is almost full.");
        } else {
            for (int i = 0; i < qtyItem; i++) {
                if (itemInStore[i].isMatch(disc)) {
                    System.out.println("The DVD already exist.");
                    return;
                }
            }
            itemInStore[qtyItem++] = disc;
            System.out.println("The DVD: '" + disc.getTitle() + "' has been added.");
        }
    }

    public void removeDVDfs(DVD disc) {
        if (qtyItem == 0) System.out.println("The store is empty.");
        else {
            for (int i = 0; i < qtyItem - 1; i++) {
                if (itemInStore[i].equals(disc)) {
                    while (i < qtyItem - 1) {
                        itemInStore[i] = itemInStore[i + 1];
                        i++;
                    }
                    qtyItem--;
                    System.out.println("The disc " + disc.getTitle() + " has been removed.");
                    return;
                }
            }
            System.out.println("Nothing to remove.");
        }
    }
}
