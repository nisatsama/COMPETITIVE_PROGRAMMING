import java.util.*;

class Solution {
    public int minScholarships(int[] score) {
        int n = score.length;

        int[] scholarship = new int[n];

        // Everyone gets at least 1
        Arrays.fill(scholarship, 1);

        // Left to right
        for (int i = 1; i < n; i++) {
            if (score[i] > score[i - 1]) {
                scholarship[i] = scholarship[i - 1] + 1;
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (score[i] > score[i + 1]) {
                scholarship[i] =
                    Math.max(scholarship[i], scholarship[i + 1] + 1);
            }
        }

        int total = 0;

        for (int x : scholarship) {
            total += x;
        }

        return total;
    }
}