import java.util.Scanner;

public class StudentNameSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        sc.nextLine(); // consume newline

        String[] names = new String[n];

        System.out.println("Enter student names:");

        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }

        System.out.print("\nEnter name to search: ");
        String searchName = sc.nextLine();

        // Case-sensitive search
        int caseSensitivePosition = -1;

        for (int i = 0; i < n; i++) {

            if (names[i].equals(searchName)) {
                caseSensitivePosition = i;
                break;
            }
        }

        // Case-insensitive search
        int caseInsensitivePosition = -1;

        for (int i = 0; i < n; i++) {

            if (names[i].equalsIgnoreCase(searchName)) {
                caseInsensitivePosition = i;
                break;
            }
        }

        System.out.println("\n--- Case-Sensitive Search ---");

        if (caseSensitivePosition != -1) {
            System.out.println("Student found.");
            System.out.println("Position: " + (caseSensitivePosition + 1));
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\n--- Case-Insensitive Search ---");

        if (caseInsensitivePosition != -1) {
            System.out.println("Student found.");
            System.out.println("Position: " + (caseInsensitivePosition + 1));
        } else {
            System.out.println("Student not found.");
        }

        sc.close();
    }
}