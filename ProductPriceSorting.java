import java.util.Arrays;
import java.util.Scanner;

public class ProductPriceSorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        double[] prices = new double[n];

        System.out.println("Enter product prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        // Sort in ascending order
        Arrays.sort(prices);

        System.out.println("\nPrices in ascending order:");

        for (int i = 0; i < n; i++) {
            System.out.print(prices[i] + " ");
        }

        sc.close();
    }
}