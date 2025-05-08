import java.util.Scanner;

public class Problem1 {
    public static int getLargestRectangle(int[] arr) {
        int res = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            for (int j = i - 1; j >= 0 && arr[j] >= arr[i]; j--)
                curr += arr[i];

            for (int j = i + 1; j < n && arr[j] >= arr[i]; j++)
                curr += arr[i];

            res = Math.max(res, curr);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getLargestRectangle(arr));
    }
}
