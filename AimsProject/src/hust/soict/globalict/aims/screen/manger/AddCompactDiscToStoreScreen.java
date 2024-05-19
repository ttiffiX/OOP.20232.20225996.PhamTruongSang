package AimsProject.src.hust.soict.globalict.aims.screen.manger;

import AimsProject.src.hust.soict.globalict.aims.media.CD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.Track;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        JPanel artistPanel = addMedia("Artist");
        JPanel titleTrackPanel = addMedia("Title of Track");
        JPanel lengthTrackPanel = addMedia("Length of Track");


        mainPanel.add(artistPanel, BorderLayout.CENTER);
        mainPanel.add(titleTrackPanel, BorderLayout.CENTER);
        mainPanel.add(lengthTrackPanel, BorderLayout.CENTER);

        btn.addActionListener(new btnAddCDListener());
        setTitle("Add CD");
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        menu.add(viewStore);
        viewStore.addActionListener(new AddCompactDiscToStoreScreen.btnMenuListener());

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        menu.add(smUpdateStore);
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addDVDItem);

        addBookItem.addActionListener(new AddCompactDiscToStoreScreen.btnMenuListener());
        addDVDItem.addActionListener(new AddCompactDiscToStoreScreen.btnMenuListener());


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class btnAddCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String title = null;
            String category = null;
            String artist = null;
            String titleTrack = null;
            int lengthTrack = 0;
            float cost = 0;
            for (JTextField tf : textList) {
                if (tf.getName().equals("ID")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else id = Integer.parseInt(tf.getText());
                } else if (tf.getName().equals("Title")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else title = tf.getText();
                } else if (tf.getName().equals("Category")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else category = tf.getText();
                } else if (tf.getName().equals("Cost")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else cost = Float.parseFloat(tf.getText());
                } else if (tf.getName().equals("Artist")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else artist = tf.getText();
                } else if (tf.getName().equals("Title of Track")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else titleTrack = tf.getText();
                } else if (tf.getName().equals("Length of Track")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else lengthTrack = Integer.parseInt(tf.getText());
                }
            }

            CD cd = new CD(id, title, category, artist, cost);

            ArrayList<Media> mediaInStore = store.getItemsInStore();
            for (Media media : mediaInStore) {
                if (cd.getId() == media.getId()) {
                    JOptionPane.showMessageDialog(null, "ID is already exist!", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            if (!mediaInStore.contains(cd)) {
                Track track = new Track(titleTrack, lengthTrack);
                cd.addTrack(track);
                store.addMedia(cd);
                JOptionPane.showMessageDialog(null, "Add CD Successfully! ", "Alert", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new StoreManagerScreen(store);
            } else
                JOptionPane.showMessageDialog(null, "The CD is already exist!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btn = e.getActionCommand();
            dispose();
            if (btn.equals("Add DVD")) new AddDigitalVideoDiscToStoreScreen(store);
            if (btn.equals("Add Book")) new AddBookToStoreScreen(store);
            if (btn.equals("View store")) new StoreManagerScreen(store);

        }
    }
}
