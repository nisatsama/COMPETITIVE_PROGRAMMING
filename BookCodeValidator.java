import java.util.Scanner;

public class BookCodeValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book code: ");
        String code = sc.nextLine();

        String pattern = "[A-Z]{3}-[0-9]{4}-[0-9]{3}";

        if (code.matches(pattern)) {
            System.out.println("Valid book code.");
        } else {
            System.out.println("Invalid book code.");
        }

        sc.close();
    }
}