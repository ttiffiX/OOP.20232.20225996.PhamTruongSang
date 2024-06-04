package AimsProject.src.hust.soict.globalict.aims.screen.customer.controller;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.src.hust.soict.globalict.aims.media.CD;
import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.play.Playable;
import AimsProject.src.hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getId().equals("btnPlay")) {
//            if (tblMedia.getSelectionModel().getSelectedItem() instanceof Playable) {
//                ((Playable) tblMedia.getSelectionModel().getSelectedItem()).play();
            if (tblMedia.getSelectionModel().getSelectedItem() instanceof Playable) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Media Information");
                alert.setHeaderText(null);
                if (tblMedia.getSelectionModel().getSelectedItem() instanceof DVD) {
                    try {
                        alert.setContentText(((DVD) tblMedia.getSelectionModel().getSelectedItem()).play());
                    } catch (PlayerException e) {
                        alert.setContentText(e.getMessage());
                    }
                } else if (tblMedia.getSelectionModel().getSelectedItem() instanceof CD) {
                    try {
                        alert.setContentText(((CD) tblMedia.getSelectionModel().getSelectedItem()).play());
                    } catch (PlayerException e) {
                        alert.setContentText(e.getMessage());
                    }
                }
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "../view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTotalCost() {
        float totalCost = 0;
        for (Media media : cart.getItemsOrdered()) {
            totalCost += media.getCost();
        }
        costLabel.setText(totalCost + " $");
    }

    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("Place Order succesfully!");
        alert.showAndWait();

        cart.clear();
        updateTotalCost();
    }


}