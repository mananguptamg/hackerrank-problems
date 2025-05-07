import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            freq[c-'a']++;
        }

        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            freq[c-'a']--;
        }

        int cnt=0;

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                cnt+=Math.abs(freq[i]);
            }
            else{
                continue;
            }
        }
        System.out.println(cnt);
    }
}
