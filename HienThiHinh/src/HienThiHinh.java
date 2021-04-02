import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        int choice = 1;
        while (choice != 4) {
            Scanner input = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    int TriChoice;
                    System.out.println("1. Bottom - left");
                    System.out.println("2. Top - left)");
                    System.out.println("3. Top - right");
                    System.out.println("4. Bottom - right");
                    TriChoice = input.nextInt();
                    switch (TriChoice) {
                        case 1:
                            for (int i = 1; i <= 5; i++) {
                                for (int j = 1; j < i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (int i = 7; i >= 1; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println("");
                            }
                            break;
                        case 3:
                            int space = 1;
                            int pattern = 5;
                            for (int i = 0; i < 5; i++) {
                                for (int k = 1; k < space; k++) {
                                    System.out.print("  ");
                                }
                                for (int j = pattern; j > 0; j--) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                                space++;
                                pattern--;
                            }
                            break;
                        case 4:
                            space = 5;
                            pattern = 1;
                            for (int i = 0; i < 5; i++) {
                                for (int k = space; k > 0; k--) {
                                    System.out.print("  ");
                                }
                                for (int j = 0; j < pattern; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                                space--;
                                pattern++;
                            }
                            break;

                    }
                    break;
                case 3:
                    int space = 1;
                    int pattern = 5;
                    for (int i = 0; i < 5; i++) {
                        for (int k = 1; k < space; k++) {
                            System.out.print(" ");
                        }
                        for (int j = pattern; j > 0; j--) {
                            System.out.print("* ");
                        }
                        System.out.println();
                        space++;
                        pattern--;
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
