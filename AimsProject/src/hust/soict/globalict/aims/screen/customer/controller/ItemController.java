package AimsProject.src.hust.soict.globalict.aims.screen.customer.controller;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.src.hust.soict.globalict.aims.media.CD;
import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.play.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.naming.LimitExceededException;

public class ItemController {
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws Exception {
        Button btnClicked = (Button) event.getSource();
        if (btnClicked.getId().equals("btnAddToCart")) {
//            cart.addMedia(media);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            try{
            alert.setContentText(cart.addMedia(media));
        }catch (Exception e){
                alert.setContentText(e.getMessage());
            }
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        Button btnClicked = (Button) event.getSource();
        if (btnClicked.getId().equals("btnPlay")) {
            if (media instanceof Playable) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Media Information");
                if (media instanceof DVD) {
                    try {
                        alert.setContentText(((DVD) media).play());
                    } catch (PlayerException e) {
                        alert.setContentText(e.getMessage());
                    }
                } else if (media instanceof CD) {
                    try {
                        alert.setContentText(((CD) media).play());
                    } catch (PlayerException e) {
                        alert.setContentText(e.getMessage());
                    }
                }
                alert.showAndWait();
            }

        }
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

}
