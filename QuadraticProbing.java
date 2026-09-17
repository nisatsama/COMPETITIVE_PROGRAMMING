import java.util.Scanner;

public class QuadraticProbing {
    static final int SIZE = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] hashTable = new int[SIZE];

        // Initialize hash table
        for (int i = 0; i < SIZE; i++) {
            hashTable[i] = -1;
        }

        // Insert 5 numbers
        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {

            int key = sc.nextInt();

            int index = key % SIZE;
            int j = 0;

            // Quadratic probing
            while (hashTable[index] != -1) {
                j++;
                index = (key % SIZE + j * j) % SIZE;
            }

            hashTable[index] = key;
        }

        // Display hash table
        System.out.println("\nHash Table:");

        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " -> " + hashTable[i]);
        }

        sc.close();
    }
}