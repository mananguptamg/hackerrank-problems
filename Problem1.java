import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    // Inner class to represent current number and how many steps taken
    static class State {
        int number; // current number
        int steps;  // number of operations taken to reach this number

        public State(int number, int steps) {
            this.number = number;
            this.steps = steps;
        }
    }


    public static int downToZero(int n) {
        // queue for bfs
        Queue<State> queue = new LinkedList<>();

        // Visited set to avoid same number
        Set<Integer> visited = new HashSet<>();

        // start with n
        queue.add(new State(n, 0));
        visited.add(n);

        while (!queue.isEmpty()) {
            State current = queue.poll(); // queue se ek element nikalo

            int value = current.number;
            int stepCount = current.steps;

            // got step count if value is 0
            if (value == 0) {
                return stepCount;
            }

            // if number is less than
            if (!visited.contains(value - 1)) {
                visited.add(value - 1);
                queue.add(new State(value - 1, stepCount + 1));
            }

            // get max factors of value
            for (int i = 2; i * i <= value; i++) {
                if (value % i == 0) {
                    int factor1 = i;
                    int factor2 = value / i;
                    int next = Math.max(factor1, factor2);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(new State(next, stepCount + 1));
                    }
                }
            }
        }
        return -1;
    }
}

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
