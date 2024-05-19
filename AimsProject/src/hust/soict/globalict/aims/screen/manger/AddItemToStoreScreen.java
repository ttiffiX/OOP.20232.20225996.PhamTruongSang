package AimsProject.src.hust.soict.globalict.aims.screen.manger;

import AimsProject.src.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame {
    public Store store;
    public ArrayList<JTextField> textList = new ArrayList<>();
    public JButton btn = new JButton();
    public JPanel mainPanel = new JPanel();
    public JPanel container = new JPanel();

    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        return menuBar;
    }

    JPanel addMedia(String text) {
        JPanel pn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField tf = new JTextField(23);
        tf.setName(text);
        textList.add(tf);
        JLabel lbTextField = new JLabel(text);

        pn.add(lbTextField);
        pn.add(tf);
        pn.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        return pn;
    }

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        add(createMenuBar(), BorderLayout.NORTH);


        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        btn = new JButton("Add");
        container.add(btn);
        this.add(container, BorderLayout.SOUTH);

        mainPanel = createPanel();
        add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(5,5,4,4));

        JPanel idPanel = addMedia("ID");
        JPanel titlePanel = addMedia("Title");
        JPanel categoryPanel = addMedia("Category");
        JPanel costPanel = addMedia("Cost");

        centerPanel.add(idPanel);
        centerPanel.add(titlePanel);
        centerPanel.add(categoryPanel);
        centerPanel.add(costPanel);

        return centerPanel;
    }
}
