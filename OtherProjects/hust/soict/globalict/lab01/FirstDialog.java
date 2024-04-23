package OtherProjects.hust.soict.globalict.lab01;

import javax.swing.*;

public class FirstDialog {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Hello my friend, u doing good?");
        String result;
        result = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + result + "!");
        System.exit(0);

    }
}


