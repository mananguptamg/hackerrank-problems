import java.util.HashMap;
import java.util.Scanner;

public class Problem1 {
    public static boolean isSubset(String[] arr1, String[] arr2) {

        boolean[] visited = new boolean[arr1.length];

        for (String word : arr2) {
            boolean found = false;

            for (int i = 0; i < arr1.length; i++) {
                if (!visited[i] && arr1[i].equals(word)) {
                    visited[i] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first note: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second note: ");
        String s2 = sc.nextLine();

        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        boolean result = isSubset(arr1, arr2);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("No");
        }
    }
}

