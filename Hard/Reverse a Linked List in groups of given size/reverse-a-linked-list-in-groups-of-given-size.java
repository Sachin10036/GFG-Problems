//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prevNode = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }
    
    public static Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    
    public static Node reverse(Node node, int k) {
        Node head = node;
        Node temp = head;
        Node prevNode = null;
        boolean isFirstPass = true; // To handle the head of the entire list
        
        while (temp != null) {
            Node kthNode = getKthNode(temp, k);
            Node nextNode = (kthNode != null) ? kthNode.next : null;
            if (kthNode != null) {
                kthNode.next = null; // Temporarily break the list to reverse this part
            }
            Node reversedHead = reverseLinkedList(temp);
            if (isFirstPass) {
                head = reversedHead; // Update head for the first pass
                isFirstPass = false;
            } else {
                prevNode.next = reversedHead; // Link previous group to reversed head
            }
            temp.next = nextNode; // Fix the connection to the next segment
            prevNode = temp; // Update previous node to the end of the reversed part
            temp = nextNode; // Move to the next segment
        }
        
        return head; // Return new head of the reversed list
    }
}



