package AimsProject.src.hust.soict.globalict.test.cart;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.media.*;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class CartTest {
    public static void main(String[] args) throws Exception {
        Cart anOrder = new Cart();

        DVD dvd1 = new DVD(1, "The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);

        anOrder.addMedia(dvd1);

        DVD dvd2 = new DVD(2, "Star War", "Science Fiction",
                "George Lucas", 87, 24.95f);

        anOrder.addMedia(dvd2);

        DVD dvd3 = new DVD(3, "Aladin", "Animation",
                18.99f);
        anOrder.addMedia(dvd3);

        Book book1 = new Book(4, "Something", "HMMM", 20f);
        book1.addAuthor("a");
        book1.addAuthor("b");
        book1.addAuthor("c");
        book1.addAuthor("d");

        CD cd1 = new CD(5, "Story of my life", "Something", "Me", 200f);
        Track track = new Track("The songggg", 87);
        Track track1 = new Track("The second songggggg", 88);
        cd1.addTrack(track);
        cd1.addTrack(track1);
        anOrder.addMedia(book1);
        anOrder.addMedia(cd1);
        anOrder.displayItem();

//        anOrder.searchMedia(1);
//        anOrder.searchMedia("star war");
        System.out.println();

        anOrder.sortByCost();
        anOrder.displayItem();

        System.out.println();

        anOrder.sortByTitle();
        anOrder.displayItem();
//        System.out.println();
//        List<Media> mediae = new ArrayList<Media>();
//
//        mediae.add(dvd1);
//        mediae.add(dvd2);
//        mediae.add(dvd3);
//        mediae.add(book1);
//        mediae.add(cd1);
//
//        for (Media m:mediae){
//            System.out.println(m.toString());
//        }

    }
}
