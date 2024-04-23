package OtherProjects.hust.soict.globalict.lab01;

import javax.swing.*;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Bạn vừa nhập: ";
        strNum1 = JOptionPane.showInputDialog(null, "Vui lòng nhập số đầu tiên: ", "Nhập số đầu tiên", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " và ";
        strNum2 = JOptionPane.showInputDialog(null, "Vui lòng nhập số thứ hai: ", "Nhập số thứ hai", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        JOptionPane.showMessageDialog(null, strNotification, "Hiển thị hai số", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
