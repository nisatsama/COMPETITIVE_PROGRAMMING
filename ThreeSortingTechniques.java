import java.util.Scanner;

public class ThreeSortingTechniques {

    // ---------------- BUBBLE SORT ----------------

    static void bubbleSort(double[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    // ---------------- SELECTION SORT ----------------

    static void selectionSort(double[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            double temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    // ---------------- INSERTION SORT ----------------

    static void insertionSort(double[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            double key = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];

                j--;
            }

            arr[j + 1] = key;
        }
    }


    // ---------------- DISPLAY ARRAY ----------------

    static void display(double[] arr) {

        for (double price : arr) {
            System.out.print(price + " ");
        }

        System.out.println();
    }


    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        double[] prices = new double[n];

        System.out.println("Enter product prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        // Create copies
        double[] bubble = prices.clone();
        double[] selection = prices.clone();
        double[] insertion = prices.clone();

        // Bubble Sort
        bubbleSort(bubble);

        // Selection Sort
        selectionSort(selection);

        // Insertion Sort
        insertionSort(insertion);

        // Display results
        System.out.println("\nBubble Sort:");
        display(bubble);

        System.out.println("Selection Sort:");
        display(selection);

        System.out.println("Insertion Sort:");
        display(insertion);

        sc.close();
    }
}