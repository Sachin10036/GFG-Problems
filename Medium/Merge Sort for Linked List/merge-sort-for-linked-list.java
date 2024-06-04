//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static Node mergeTwoLists(Node list1, Node list2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null) temp.next = list1;
        else temp.next = list2;
        
        return dummyNode.next;
    }
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        return mergeTwoLists(left, right);
    }
}


