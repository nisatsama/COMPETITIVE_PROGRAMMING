import java.util.Scanner;

public class SeparateChaining {
    static final int SIZE = 10;
    static final int CHAIN = 5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] hashTable = new int[SIZE][CHAIN];

        // Initialize table
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < CHAIN; j++) {
                hashTable[i][j] = -1;
            }
        }

        // Insert 5 numbers
        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {

            int key = sc.nextInt();

            int index = key % SIZE;

            // Find empty position in the chain
            for (int j = 0; j < CHAIN; j++) {

                if (hashTable[index][j] == -1) {
                    hashTable[index][j] = key;
                    break;
                }
            }
        }

        // Display hash table
        System.out.println("\nHash Table:");

        for (int i = 0; i < SIZE; i++) {

            System.out.print(i + " -> ");

            for (int j = 0; j < CHAIN; j++) {

                if (hashTable[i][j] != -1) {
                    System.out.print(hashTable[i][j] + " -> ");
                }
            }

            System.out.println("NULL");
        }

        sc.close();
    }
}