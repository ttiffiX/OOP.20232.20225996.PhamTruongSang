package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DVD itemOrdered[] = new DVD[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDVD(DVD disc) {
        if (qtyOrdered > 20) {
            System.out.println("The cart is almost full.");
        } else {
            itemOrdered[qtyOrdered++] = disc;
            System.out.println("The DVD: '" + disc.getTitle() + "' has been added.");
        }
    }

    public void addDVD(DVD... dvdList) {
        for (DVD dvd : dvdList)
            addDVD(dvd);
    }

//    public void addDVD(DVD [] dvdList){
//        for (DVD dvd : dvdList)
//            addDVD(dvd);
//    }

    public void addDVD(DVD dvd1, DVD dvd2) {
        addDVD(dvd1);
        addDVD(dvd2);
    }

    public void removeDVD(DVD disc) {
        if (qtyOrdered == 0) System.out.println("The cart is empty.");
        else {
            for (int i = 0; i < qtyOrdered - 1; i++) {
                if (itemOrdered[i].equals(disc)) {
                    while (i < qtyOrdered - 1) {
                        itemOrdered[i] = itemOrdered[i + 1];
                        i++;
                    }
                    qtyOrdered--;
                    System.out.println("The disc " + disc.getTitle() + " has been removed.");
                    return;
                }
            }
            System.out.println("Nothing to remove.");
        }
    }

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            cost += itemOrdered[i].getCost();
        }
        return cost;
    }

    public void displayItem() {
        if (qtyOrdered == 0) System.out.println("The cart is empty.");
        else {
            for (int i = 0; i < itemOrdered[0].toString().length() / 2 + 4; i++) {
                System.out.print("*");
            }
            System.out.print("CART");
            for (int i = 0; i < itemOrdered[0].toString().length() / 2 + 4; i++) {
                System.out.print("*");
            }
            System.out.println("\nOrdered Items:");
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.println(i + 1 + ". DVD - " + itemOrdered[i].toString());
            }
            System.out.printf("%-10s %.2f\n", "Total Cost", totalCost());
            for (int i = 0; i < itemOrdered[0].toString().length() + 12; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void searchDVD(int id) {
        if (qtyOrdered == 0) System.out.println("The cart is empty.");
        else {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemOrdered[i].getId() == id) {
                    System.out.println("Result for DVD have id '" + id + "' is: " +
                            itemOrdered[i].toString());
                    return;
                }
            }
            System.out.println("No result for DVD have id '" + id + "'.");
        }
    }

    public void searchDVD(String title) {
        if (qtyOrdered == 0) System.out.println("The cart is empty.");
        else {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemOrdered[i].isMatch(title)) {
                    System.out.println("Result: " + itemOrdered[i].toString());
                    return;
                }
            }
            System.out.println("No Result.");
        }
    }

}
