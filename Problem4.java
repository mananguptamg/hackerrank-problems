import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();

        System.out.println("Enter the number of queries ");
        int q = sc.nextInt();

        int[] arr = new int[n];
        Arrays.fill(arr,0);

        int[][] query = new int[q][3];
        for(int i = 0;i<q;i++){
            for(int j = 0;j<3;j++){
                System.out.print("Query element [" + i + "][" + j + "]: ");
                query[i][j] = sc.nextInt();
            }
        }

        for(int[] e:query){
            int a=e[0];
            int b=e[1];
            int k=e[2];
            for(int i=a-1; i<b;i++){
                arr[i]+=k;
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(ans<arr[i]){
                ans = arr[i];
            }
        }
        System.out.println("Maximum element after operations "+ans);
    }
}
