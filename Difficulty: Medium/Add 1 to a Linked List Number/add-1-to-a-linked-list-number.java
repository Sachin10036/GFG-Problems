//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverseLL(Node head){
        if(head == null || head.next == null)
            return head;
        Node prev=null;
        Node temp=head;
        while(temp != null){
            Node nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        return prev;
    }
    public Node addOne(Node head) {
      
        Node newHead=new Node(1);
       
        Node reverseHead=reverseLL(head);
        Node temp=reverseHead;
        while(temp != null){
            if(temp.data <= 8){
                temp.data=temp.data+1;
                return reverseLL(reverseHead);
            }
            else
                temp.data=0;
            temp=temp.next;
        }
        newHead.next=reverseLL(reverseHead);
        return newHead;
    }
}
