import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Problem2 {
    public static Node insertAtPosition(Node head, int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }


        if (current == null) {
            System.out.println("Invalid Position");
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;


        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(sc.nextLine());
            head = insertAtPosition(head, val, i);
        }

        int data = Integer.parseInt(sc.nextLine());

        int pos = Integer.parseInt(sc.nextLine());

        head = insertAtPosition(head, data, pos);
        printList(head);
    }
}
