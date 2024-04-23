package AimsProject.src.hust.soict.globalict.aims;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.disc.DVD;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DVD dvd1 = new DVD("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);

        anOrder.addDVD(dvd1);

        DVD dvd2 = new DVD("Star War", "Science Fiction",
                "George Lucas", 87, 24.95f);

        anOrder.addDVD(dvd2);

        DVD dvd3 = new DVD("Aladin", "Animation",
                18.99f);

        anOrder.addDVD(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDVD(dvd1);
        anOrder.displayItem();

        System.out.println("The ID of dvd1 is:");
        System.out.println(dvd1.getId());
    }
}
