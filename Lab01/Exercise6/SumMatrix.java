package Lab01.Exercise6;

import java.util.Scanner;

public class SumMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r, c;
        System.out.print("Enter matrix row: r = ");
        r = input.nextInt();
        System.out.print("Enter matrix column: c = ");
        c = input.nextInt();

        int[][] a = new int[r][c], b = new int[r][c], result = new int[r][c];
        System.out.println("Enter matrix A");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter matrix B");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = input.nextInt();
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
