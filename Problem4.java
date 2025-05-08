import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            String pair = a + " " + b;

            set.add(pair);
            System.out.println(set.size());
        }

        sc.close();
    }
}
