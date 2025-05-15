import java.util.*;

class Problem2 {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int n = container.size();
        int[] row = new int[n];
        int[] col = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += container.get(i).get(j);
                col[j] += container.get(i).get(j);
            }
        }

        Arrays.sort(row);
        Arrays.sort(col);

        return Arrays.equals(row, col) ? "Possible" : "Impossible";

    }
}