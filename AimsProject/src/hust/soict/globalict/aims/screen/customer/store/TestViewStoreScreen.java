package AimsProject.src.hust.soict.globalict.aims.screen.customer.store;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.media.Book;
import AimsProject.src.hust.soict.globalict.aims.media.CD;
import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Track;
import AimsProject.src.hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TestViewStoreScreen extends Application {
    private static Store store;

    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "AimsProject/src/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        DVD dvd1 = new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD(3, "Aladin", "Animation", 18.99f);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("HMD");
        Book book1 = new Book(4, "Sherlock Holmes", "Detective", 100.0f, authors);
        CD cd1 = new CD(5, "Story of my life", "Something", "Me", 200f);
        Track track1 = new Track("Baby Blue", 100);
        Track track2 = new Track("Free Bird",0);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);
        launch(args);
    }
}
