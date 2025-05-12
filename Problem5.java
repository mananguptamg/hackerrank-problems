import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s1=sc.nextLine();
        String s2=sc.nextLine();

        System.out.println(answer(s1,s2,0,0));
    }

    public static int answer(String s1, String s2, int i, int j){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }

        int cnt=0;
        if(s1.charAt(i)==s2.charAt(j)){
            cnt=1+answer(s1,s2,i+1,j+1);
        }
        else {
            cnt=Math.max(answer(s1,s2,i,j+1), answer(s1,s2,i+1,j));
        }

        return cnt;
    }
}
