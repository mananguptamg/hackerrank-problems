import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rotations ");
        int d = sc.nextInt();

        System.out.println("Enter size of array ");
        int n = sc.nextInt();

        int [] arr = new int[n];

        System.out.println("Enter elements of array");
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        if(d==0){
            return;
        }

        d = d%n;

        int [] temparr = new int[d];

        for(int i = 0;i<d;i++){
            temparr[i] = arr[i];
        }

        for(int i = d;i<n;i++){
            arr[i-d] = arr[i];
        }

        for(int i = 0;i<d;i++){
            arr[n-d+i] = temparr[i];
        }

        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
