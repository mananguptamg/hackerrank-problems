import java.util.*;

class Problem2 {
    static class QueueNode {
        Node node;
        int hd;

        QueueNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if(root==null) return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();

        queue.add(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode qNode = queue.poll();
            Node current = qNode.node;
            int hd = qNode.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, current.data);
            }
            if (current.left != null) {
                queue.add(new QueueNode(current.left, hd - 1));
            }
            if (current.right != null) {
                queue.add(new QueueNode(current.right, hd + 1));
            }
        }

        for(int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}