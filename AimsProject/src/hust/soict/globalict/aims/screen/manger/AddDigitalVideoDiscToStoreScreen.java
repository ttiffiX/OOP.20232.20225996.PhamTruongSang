package AimsProject.src.hust.soict.globalict.aims.screen.manger;

import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        JPanel lengthPanel = addMedia("Length");
        JPanel directorPanel = addMedia("Director");


        mainPanel.add(directorPanel, BorderLayout.CENTER);
        mainPanel.add(lengthPanel, BorderLayout.CENTER);
        add(createMenuBar(), BorderLayout.SOUTH);

        btn.addActionListener(new btnAddDVDListener());

        setTitle("Add DVD");
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        menu.add(viewStore);
        viewStore.addActionListener(new AddDigitalVideoDiscToStoreScreen.btnMenuListener());

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");

        menu.add(smUpdateStore);
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);

        addBookItem.addActionListener(new AddDigitalVideoDiscToStoreScreen.btnMenuListener());
        addCDItem.addActionListener(new AddDigitalVideoDiscToStoreScreen.btnMenuListener());


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class btnAddDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String title = null;
            String category = null;
            String director = null;
            int length = 0;
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
                } else if (tf.getName().equals("Director")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else director = tf.getText();
                } else if (tf.getName().equals("Length")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else length = Integer.parseInt(tf.getText());
                } else if (tf.getName().equals("Cost")) {
                    if (tf.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else cost = Float.parseFloat(tf.getText());
                }
            }

            DVD dvd = new DVD(id, title, category, director, length, cost);

            ArrayList<Media> mediaInStore = store.getItemsInStore();
            for (Media media : mediaInStore) {
                if (dvd.getId() == media.getId()) {
                    JOptionPane.showMessageDialog(null, "ID is already exist!", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            if (!mediaInStore.contains(dvd)) {
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(null, "Add DVD Successfully! ", "Alert", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new StoreManagerScreen(store);
            } else
                JOptionPane.showMessageDialog(null, "The DVD is already exist!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btn = e.getActionCommand();
            dispose();
            if (btn.equals("Add CD")) new AddCompactDiscToStoreScreen(store);
            if (btn.equals("Add Book")) new AddBookToStoreScreen(store);
            if (btn.equals("View store")) new StoreManagerScreen(store);

        }
    }
}