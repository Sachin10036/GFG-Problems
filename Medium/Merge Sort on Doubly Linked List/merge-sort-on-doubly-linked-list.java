//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    static Node sortDoubly(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node l1 = sortDoubly(head);
        Node l2 = sortDoubly(mid);
        return merge(l1, l2);
    }
    static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        mid.prev = null; 
        return mid;
    }
    static Node merge(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node dummyHead = new Node(-1);
        Node tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                l1.prev = tail;
                tail.next = l1;
                l1 = l1.next;
            } else {
                l2.prev = tail;
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            l1.prev = tail;
            tail.next = l1;
        }
        if (l2 != null) {
            l2.prev = tail;
            tail.next = l2;
        }
        Node head = dummyHead.next;
        head.prev = null;
        return head;
    }
}