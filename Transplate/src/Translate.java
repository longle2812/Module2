import java.util.Scanner;

public class Translate {
    public static void main(String[] args) {
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the number?");
        input = sc.nextInt();
        if ((input < 0) || (input > 999)) {
            System.out.println("out of ability");
        }
        else if ((input < 10) && (input >= 0)){
            switch (input) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
                case 0:
                    System.out.println("zero");
                    break;
            }
        }
        else if ((input >= 10) && (input < 20)) {
            int residue = input % 10;
            String txt ="";
            switch (residue) {
                case 1:
                    txt = "eleven";
                    break;
                case 2:
                    txt = "twelve";
                    break;
                case 3:
                    txt = "thirdteen";
                    break;
                case 4:
                    txt = "fourteen";
                    break;
                case 5:
                    txt = "fifthteen";
                    break;
                case 6:
                    txt = "sixteen";
                    break;
                case 7:
                    txt = "seventeen";
                    break;
                case 8:
                    txt = "eightteen";
                    break;
                case 9:
                    txt = "nineteen";
                    break;
                case 0:
                    txt = "ten";
                    break;
            }
            System.out.println(txt);
        }
        else if ((input >= 20) && (input <100)) {
            // ab
            int a = input / 10;
            String txt1 = "";
            int b = input % 10;
            String txt2 = "";
            switch (a) {
                case 2:
                    txt1 = "twenty";
                    break;
                case 3:
                    txt1 = "thirty";
                    break;
                case 4:
                    txt1 = "forty";
                    break;
                case 5:
                    txt1 = "fifty";
                    break;
                case 6:
                    txt1 = "sixty";
                    break;
                case 7:
                    txt1 = "seventy";
                    break;
                case 8:
                    txt1 = "eighty";
                    break;
                case 9:
                    txt1 = "ninety";
                    break;
            }
            switch (b) {
                case 0:
                    txt2 = "";
                    break;
                case 1:
                    txt2 = "one";
                    break;
                case 2:
                    txt2 = "two";
                    break;
                case 3:
                    txt2 = "three";
                    break;
                case 4:
                    txt2 = "four";
                    break;
                case 5:
                    txt2 = "five";
                    break;
                case 6:
                    txt2 = "six";
                    break;
                case 7:
                    txt2 = "seven";
                    break;
                case 8:
                    txt2 = "eight";
                    break;
                case 9:
                    txt2 = "nine";
                    break;
            }
            System.out.println(txt1 + " " +txt2);
        }
        else if (input >= 100) {
            //abc
            int a = input / 100;
            int b = input / 10;
                b = b % 10;
            int c = input % 100;
                c = c % 10;
            String txt1 = "", txt2 = "", txt3 ="";
            switch (c) {
                case 0:
                    txt3 = "";
                    break;
                case 1:
                    txt3 = "one";
                    break;
                case 2:
                    txt3 = "two";
                    break;
                case 3:
                    txt3 = "three";
                    break;
                case 4:
                    txt3 = "four";
                    break;
                case 5:
                    txt3 = "five";
                    break;
                case 6:
                    txt3 = "six";
                    break;
                case 7:
                    txt3 = "seven";
                    break;
                case 8:
                    txt3 = "eight";
                    break;
                case 9:
                    txt3 = "nine";
                    break;
            }
            switch (b) {
                case 2:
                    txt2 = "twenty";
                    break;
                case 3:
                    txt2 = "thirty";
                    break;
                case 4:
                    txt2 = "forty";
                    break;
                case 5:
                    txt2 = "fifty";
                    break;
                case 6:
                    txt2 = "sixty";
                    break;
                case 7:
                    txt2 = "seventy";
                    break;
                case 8:
                    txt2 = "eighty";
                    break;
                case 9:
                    txt2 = "ninety";
                    break;
            }
            switch (a) {
                case 1:
                    txt1 = "one hundred";
                    break;
                case 2:
                    txt1 = "two hundred";
                    break;
                case 3:
                    txt1 = "three hundred";
                    break;
                case 4:
                    txt1 = "four hundred";
                    break;
                case 5:
                    txt1 = "five hundred";
                    break;
                case 6:
                    txt1 = "six hundred";
                    break;
                case 7:
                    txt1 = "seven hundred";
                    break;
                case 8:
                    txt1 = "eight hundred";
                    break;
                case 9:
                    txt1 = "nine hundred";
                    break;
            }
            System.out.println(txt1+ " " +txt2+ " " +txt3);
        }
    }
}
