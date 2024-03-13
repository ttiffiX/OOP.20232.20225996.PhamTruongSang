package Lab01.Exercise6;

import java.util.Scanner;

public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Enter n = ");
        n = input.nextInt();

        for (int i = 1; i <= 2 * n; i += 2) {
            int j = (2 * n - i) / 2, k = i;
            while (j > 0) {
                System.out.print(" ");
                j--;
            }
            while (k > 0) {
                System.out.print("*");
                k--;
            }

            System.out.println();
        }


    }
}
