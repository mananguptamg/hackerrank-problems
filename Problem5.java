import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j] == arr[i] * r && arr[k] == arr[j] * r) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
