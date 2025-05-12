import java.util.Scanner;
import java.util.Stack;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(!st.isEmpty() &&st.peek()=='('){
                    st.pop();
                }
            }
            else if(s.charAt(i)=='}'){
                if(!st.isEmpty() &&st.peek()=='{'){
                    st.pop();
                }

            }
            else if(s.charAt(i)==']'){
                if(!st.isEmpty() &&st.peek()=='['){
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        if(st.isEmpty()){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
