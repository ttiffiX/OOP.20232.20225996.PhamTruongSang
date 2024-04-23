package OtherProjects.hust.soict.globalict.lab01.Exercise2;

import javax.swing.*;

public class SecondDegree {
    public static void main(String[] args) {
        String strA, strB, strC, result;
        double a, b, c;
        strA = JOptionPane.showInputDialog(null, "Enter a: ", "Input of ax^2 + bx + c =0", JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Enter b: ", "Input of ax^2 + bx + c =0", JOptionPane.INFORMATION_MESSAGE);
        strC = JOptionPane.showInputDialog(null, "Enter c: ", "Input of ax^2 + bx + c =0", JOptionPane.INFORMATION_MESSAGE);
        a = Double.parseDouble(strA);
        b = Double.parseDouble(strB);
        c = Double.parseDouble(strC);

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result = "Many Solutions";
                } else {
                    result = "No Solution";
                }
            } else {
                result = "1 Solution:\nx = " + (-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "2 Solutions:\nx1 =" + x1 + "\nx2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Double Solutions:\nx1 = x2 = " + x;
            } else {
                result = "No Solution";
            }
        }
        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

