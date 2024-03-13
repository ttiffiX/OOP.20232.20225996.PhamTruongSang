package Lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(
                null,
                "Do you want to change to the first class ticket?",
                "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"I do", "I don't"}, null);
        // with "yes" and "no" I just change inside the String[] to "Yes" and "No".
        JOptionPane.showMessageDialog(null, (option == JOptionPane.YES_NO_OPTION ? "OkaYYYY" : "Why?????"));
        System.exit(0);

    }
}
