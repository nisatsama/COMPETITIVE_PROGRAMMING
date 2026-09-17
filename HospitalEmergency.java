import java.util.Scanner;

public class HospitalEmergency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of hours: ");
        int n = sc.nextInt();

        int[] patients = new int[n];

        System.out.println("Enter number of patients for each hour:");

        for (int i = 0; i < n; i++) {
            System.out.print("Hour " + (i + 1) + ": ");
            patients[i] = sc.nextInt();
        }

        int max = patients[0];
        int min = patients[0];
        int peakHour = 0;
        int sum = 0;

        // Find max, min and sum
        for (int i = 0; i < n; i++) {

            if (patients[i] > max) {
                max = patients[i];
                peakHour = i;
            }

            if (patients[i] < min) {
                min = patients[i];
            }

            sum += patients[i];
        }

        double average = (double) sum / n;

        int aboveAverage = 0;

        for (int i = 0; i < n; i++) {
            if (patients[i] > average) {
                aboveAverage++;
            }
        }

        System.out.println("\nMaximum patients: " + max);
        System.out.println("Hour of maximum: " + (peakHour + 1));

        System.out.println("Minimum patients: " + min);

        System.out.println("Peak hour: " + (peakHour + 1));

        System.out.printf("Average patients: %.2f\n", average);

        System.out.println("Hours above average: " + aboveAverage);

        sc.close();
    }
}