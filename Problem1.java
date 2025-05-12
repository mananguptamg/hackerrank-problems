import java.util.*;

public class Problem1 {
    public static List<Integer> readList(Scanner sc, int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }
        return list;
    }

    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        Collections.sort(mergedList);
        return mergedList;
    }

    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            List<Integer> list1 = readList(sc, n);

            int m = Integer.parseInt(sc.nextLine());
            List<Integer> list2 = readList(sc, m);

            List<Integer> mergedList = mergeLists(list1, list2);
            printList(mergedList);
        }

        sc.close();
    }
}
