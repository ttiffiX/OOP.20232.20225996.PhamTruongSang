package Lab01;

import javax.swing.*;

public class CalculateTwoNumber {
    public static void main(String[] args) {
        String strNum1, strNum2, result;
        double num1, num2, sum, difference, product, quotient;
        strNum1 = JOptionPane.showInputDialog(null, "Enter a: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Enter b: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        num2 = Double.parseDouble(strNum2);
        sum = num1 + num2;
        result = "sum: " + sum + "\n";

        difference = num1 - num2;
        result += "difference: " + difference + "\n";

        product = num1 * num2;
        result += "product: " + product + "\n";

        if (num2 != 0) {
            quotient = num1 / num2;
            result += "quotient: " + quotient + "\n";
        } else result += "quotient: NULL";
        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
