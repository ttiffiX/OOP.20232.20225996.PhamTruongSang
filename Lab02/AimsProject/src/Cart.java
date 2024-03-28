package Lab02.AimsProject.src;

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

    public void addDVD(DVD... dvdList){
        for (DVD dvd : dvdList)
            addDVD(dvd);
    }

//    public void addDVD(DVD [] dvdList){
//        for (DVD dvd : dvdList)
//            addDVD(dvd);
//    }

    public void addDVD(DVD dvd1,DVD dvd2){
            addDVD(dvd1);
            addDVD(dvd2);
    }

    public void removeDVD(DVD disc) {
        if (qtyOrdered == 0) System.out.println("The cart is empty.");
        else {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemOrdered[i].equals(disc)) {
                    itemOrdered[i] = itemOrdered[qtyOrdered - 1];
                    itemOrdered[qtyOrdered--] = null;
                    break;
                }
            }
            System.out.println("The disc " + disc.getTitle() + " has been removed.");
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
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.printf("%-2d %-15s %.2f\n", i + 1, itemOrdered[i].getTitle(), itemOrdered[i].getCost());
            }
            System.out.printf("   %-15s %.2f\n", "Total Cost", totalCost());
        }
    }


}
