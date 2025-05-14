import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    private static boolean validString(String s) {
        for (int i = 1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }

    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        List<Character> chars = new ArrayList<>(uniqueChars);
        int max = 0;

        for (int i =0;i<chars.size();i++) {
            for (int j =i+1;j<chars.size();j++) {
                char c1 = chars.get(i);
                char c2 = chars.get(j);

                StringBuilder sb = new StringBuilder();
                for (char c:s.toCharArray()) {
                    if (c==c1 || c==c2) {
                        sb.append(c);
                    }
                }

                if (validString(sb.toString())) {
                    max = Math.max(max,sb.length());
                }
            }
        }
        return max;
    }

}

public class Problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
