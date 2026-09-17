import java.util.Scanner;

public class AttendanceAnalysis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] attendance = new double[n];

        System.out.println("Enter attendance percentages:");

        for (int i = 0; i < n; i++) {
            attendance[i] = sc.nextDouble();
        }

        System.out.print("Enter attendance threshold: ");
        double threshold = sc.nextDouble();

        int belowThreshold = 0;
        double lowest = attendance[0];
        int lowestPosition = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {

            // Count below threshold
            if (attendance[i] < threshold) {
                belowThreshold++;
            }

            // Find lowest attendance
            if (attendance[i] < lowest) {
                lowest = attendance[i];
                lowestPosition = i;
            }

            sum += attendance[i];
        }

        double average = sum / n;

        System.out.println("\nStudents below threshold: " + belowThreshold);
        System.out.println("Lowest attendance: " + lowest + "%");
        System.out.println("Position: " + (lowestPosition + 1));
        System.out.printf("Average attendance: %.2f%%\n", average);

        sc.close();
    }
}