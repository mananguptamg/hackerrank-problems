import java.util.Scanner;

public class Problem2 {

    public static boolean containsSubstring(char[] arr1,char[] arr2){
        int m = arr1.length;
        int n = arr2.length;

        boolean found = false;

        for(char c2:arr2){
            for (char c1 : arr1) {
                if (c1 == c2) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i= 0;i<n;i++){
            System.out.print("Enter first string: ");
            String s1 = sc.nextLine();
            System.out.print("Enter second string: ");
            String s2 = sc.nextLine();

            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            boolean result = containsSubstring(arr1, arr2);
            System.out.println(result);
        }
    }
}
