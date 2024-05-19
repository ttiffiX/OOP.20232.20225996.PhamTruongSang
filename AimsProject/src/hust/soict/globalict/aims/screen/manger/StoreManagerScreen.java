package AimsProject.src.hust.soict.globalict.aims.screen.manger;

import AimsProject.src.hust.soict.globalict.aims.media.*;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        menu.add(viewStore);
        viewStore.addActionListener(new btnMenuListener());

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        menu.add(smUpdateStore);
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        addBookItem.addActionListener(new btnMenuListener());
        addCDItem.addActionListener(new btnMenuListener());
        addDVDItem.addActionListener(new btnMenuListener());


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Store store = new Store();
        defaultStore(store);
        new StoreManagerScreen(store);
    }

    public static void defaultStore(Store store) {
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
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btn = e.getActionCommand();
            dispose();
            if (btn.equals("Add CD")) new AddCompactDiscToStoreScreen(store);
            if (btn.equals("Add Book")) new AddBookToStoreScreen(store);
            if (btn.equals("Add DVD")) new AddDigitalVideoDiscToStoreScreen(store);
            if (btn.equals ("View store")) new StoreManagerScreen(store);

        }
    }
}
