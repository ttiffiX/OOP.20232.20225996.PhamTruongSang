package OtherProjects.hust.soict.globalict.lab01.Exercise2;

import javax.swing.*;

public class SystemOfFirstDegree {
    public static void main(String[] args) {

        String strA, strB, strC, strD, strE1, strE2, result;
        double a, b, c, d, e1, e2;
        strA = JOptionPane.showInputDialog(null, "Equation:\nax + by = e1\ncx + dy = e2 \nEnter a: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Equation:\nax + by = e1\ncx + dy = e2 \nEnter b: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strE1 = JOptionPane.showInputDialog(null, "Equation:\nax + by = e1\ncx + dy = e2 \nEnter e1: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strC = JOptionPane.showInputDialog(null, "Equation:\nax + by = e1\ncx + dy = e2 \nEnter c: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strD = JOptionPane.showInputDialog(null, "Equation:\nax + by = e1\ncx + dy = e2 \nEnter d: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strE2 = JOptionPane.showInputDialog(null, "Equation:\nax + by = e1\ncx + dy = e2 \nEnter e2: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        a = Double.parseDouble(strA);
        b = Double.parseDouble(strB);
        c = Double.parseDouble(strC);
        d = Double.parseDouble(strD);
        e1 = Double.parseDouble(strE1);
        e2 = Double.parseDouble(strE2);


        double D = a * d - b * c;
        double D1 = d * e1 - b * e2;
        double D2 = a * e2 - c * e1;

        if (D == 0 && (D2 == 0) && (D1 == 0)) {
            result = "Many Solutions";
        } else if (D == 0) {
            result = "No Solution";
        } else {
            double x = D1 / D;
            double y = D2 / D;
            result = "1 Solution:\nx = " + x + "\ny = " + y;
        }

        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

