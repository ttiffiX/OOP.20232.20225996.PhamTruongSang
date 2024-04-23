package OtherProjects.hust.soict.globalict.lab01.Exercise2;

import javax.swing.*;

public class FirstDegree {
    public static void main(String[] args) {
        String strA, strB, result;
        double a, b;
        strA = JOptionPane.showInputDialog(null, "Enter a: ", "Input of ax +b = 0", JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Enter b: ", "Input of ax +b = 0", JOptionPane.INFORMATION_MESSAGE);
        a = Double.parseDouble(strA);
        b = Double.parseDouble(strB);
        if (a == 0) {
            if (b != 0)
                result = "No Solutions";
            else result = "Many Solutions";
        } else result = "1 Solution:\nx = " + (-b / a);
        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
