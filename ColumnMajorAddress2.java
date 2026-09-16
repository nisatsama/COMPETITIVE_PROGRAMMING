import java.util.Scanner;

public class ColumnMajorAddress2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base address: ");
        int base = sc.nextInt();

        System.out.print("Enter row index (i): ");
        int i = sc.nextInt();

        System.out.print("Enter column index (j): ");
        int j = sc.nextInt();

        System.out.print("Enter k (where number of rows n = 2^k): ");
        int k = sc.nextInt();

        System.out.print("Enter size of each element in bytes: ");
        int w = sc.nextInt();

        // Number of rows
        int n = 1 << k;

        // Column-major offset
        int offset = (j << k) + i;

        // Address calculation
        int address = base + (offset * w);

        System.out.println("\n--- Column Major Calculation ---");

        System.out.println("Number of rows (n) = " + n);

        System.out.println("Offset = (j << k) + i");

        System.out.println("Offset = (" + j + " << " + k + ") + " + i);

        System.out.println("Offset = " + offset);

        System.out.println("Address = Base + Offset × Element Size");

        System.out.println("Address = " + base + " + "
                + offset + " × " + w);

        System.out.println("Address = " + address);

        sc.close();
    }
}