import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int[] result = new int[n];

        for (int windowSize = 1; windowSize <= n; windowSize++) {
            int maxOfMins = Integer.MIN_VALUE;

            for (int i = 0; i <= n - windowSize; i++) {
                int minInWindow = Integer.MAX_VALUE;
                for (int j = i; j < i + windowSize; j++) {
                    minInWindow = Math.min(minInWindow, arr[j]);
                }

                maxOfMins = Math.max(maxOfMins, minInWindow);
            }

            result[windowSize - 1] = maxOfMins;
        }

        for(int i = 0;i<n;i++){
            System.out.println(result[i]+" ");
        }
    }
}
