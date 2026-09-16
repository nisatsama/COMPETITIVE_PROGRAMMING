import java.util.Scanner;

public class ArrayDeletion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       
        System.out.print("Enter position to delete (0 to " + (n - 1) + "): ");
        int pos = sc.nextInt();

        
        if (pos < 0 || pos >= n) {
            System.out.println("Invalid position!");
            sc.close();
            return;
        }

        
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

       
        n--;

       
        System.out.println("Array after deletion:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}