package AimsProject.src.hust.soict.globalict.aims.screen.manger;

import AimsProject.src.hust.soict.globalict.aims.media.Book;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
        JPanel authorPanel = addMedia("Author");

        btn.addActionListener(new btnAddBookListener());
        mainPanel.add(authorPanel, BorderLayout.CENTER);
        setTitle("Add Book");
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        menu.add(viewStore);
        viewStore.addActionListener(new AddBookToStoreScreen.btnMenuListener());

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        JMenuItem addCDItem = new JMenuItem("Add CD");

        menu.add(smUpdateStore);
        smUpdateStore.add(addDVDItem);
        smUpdateStore.add(addCDItem);

        addDVDItem.addActionListener(new AddBookToStoreScreen.btnMenuListener());
        addCDItem.addActionListener(new AddBookToStoreScreen.btnMenuListener());


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class btnAddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String title = null;
            String category = null;
            String author = null;
            float cost = 0f;
            for (JTextField tf : textList) {
                if (tf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (tf.getName().equals("ID")) {
                    id = Integer.parseInt(tf.getText());
                } else if (tf.getName().equals("Title")) {
                    title = tf.getText();
                } else if (tf.getName().equals("Category")) {
                    category = tf.getText();
                } else if (tf.getName().equals("Cost")) {
                    cost = Float.parseFloat(tf.getText());
                } else if (tf.getText().equals("Author")) {
                    author = tf.getText();
                }
            }

            Book book = new Book(id, title, category, cost);

            ArrayList<Media> mediaInStore = store.getItemsInStore();
            for (Media media : mediaInStore) {
                if (book.getId() == media.getId()) {
                    JOptionPane.showMessageDialog(null, "ID is already exist!", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            if (!mediaInStore.contains(book)) {
                book.addAuthor(author);
                store.addMedia(book);
                JOptionPane.showMessageDialog(null, "Add Book Successfully! ", "Alert", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new StoreManagerScreen(store);
            } else
                JOptionPane.showMessageDialog(null, "The Book is already exist!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btn = e.getActionCommand();
            dispose();
            if (btn.equals("Add CD")) new AddCompactDiscToStoreScreen(store);
            if (btn.equals("Add DVD")) new AddDigitalVideoDiscToStoreScreen(store);
            if (btn.equals("View store")) new StoreManagerScreen(store);

        }
    }
}
