package OtherProjects.hust.soict.globalict.lab01;

import java.util.Scanner;

public class DisplayDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the month: ");
            String monthInput = input.nextLine();

            int month = getMonth(monthInput);
            if (month == -1) {
                System.out.println("Invalid month");
                continue;
            }

            System.out.print("Enter the year: ");
            int year = input.nextInt();
            input.nextLine();

            if (year <= 0) {
                System.out.println("Invalid year");
                continue;
            }

            int daysInMonth = getDaysInMonth(month, year);

            System.out.println("Number of days is: " + daysInMonth);
            break;
        }
    }

    public static int getMonth(String input) {
        return switch (input) {
            case "January", "Jan.", "Jan", "1" -> 1;
            case "February", "Feb.", "Feb", "2" -> 2;
            case "March", "Mar.", "Mar", "3" -> 3;
            case "April", "Apr.", "Apr", "4" -> 4;
            case "May", "5" -> 5;
            case "June", "Jun.", "Jun", "6" -> 6;
            case "July", "Jul.", "Jul", "7" -> 7;
            case "August", "Aug.", "Aug", "8" -> 8;
            case "September", "Sep.", "Sep", "9" -> 9;
            case "October", "Oct.", "Oct", "10" -> 10;
            case "November", "Nov.", "Nov", "11" -> 11;
            case "December", "Dec.", "Dec", "12" -> 12;
            default -> -1;
        };
    }

    public static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> -1;
        };
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}


