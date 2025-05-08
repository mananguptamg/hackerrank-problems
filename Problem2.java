import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        StringBuilder rev = new StringBuilder(str).reverse();
        System.out.println(str.toString().contentEquals(rev));
    }
}