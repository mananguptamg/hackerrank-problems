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

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primeList = new ArrayList<>();

        int p = 2;
        while (primeList.size() < q) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(p); i++) {
                if (p % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(p);
            }
            p++;
        }

        Stack<Integer> tempStack = new Stack<>();
        for (int i = number.size() - 1; i >= 0; i--) {
            tempStack.push(number.get(i));
        }

        for (int i = 0; i < q; i++) {
            Stack<Integer> aStack = new Stack<>();
            Stack<Integer> bStack = new Stack<>();
            int prime = primeList.get(i);

            while (!tempStack.isEmpty()) {
                int plate = tempStack.pop();
                if (plate % prime == 0) {
                    bStack.push(plate);
                } else {
                    aStack.push(plate);
                }
            }
            Collections.reverse(bStack);

            while (!bStack.isEmpty()) {
                result.add(bStack.pop());
            }
            tempStack = aStack;
        }

        Collections.reverse(tempStack);

        while (!tempStack.isEmpty()) {
            result.add(tempStack.pop());
        }

        return result;
    }
}


public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
