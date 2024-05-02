//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void deletetree(Node root) {
        if (root == null) return;
        deletetree(root.left);
        deletetree(root.right);
        root.left = null;
        root.right = null;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree tr = new Tree();
            ArrayList<Integer> A = tr.serialize(root);
            deletetree(root);
            root = null;

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> sol = new ArrayList<>();
        inOrder(root, sol);
        // System.out.println("InOrder:"+sol);
        return sol;
    }
    
    protected void inOrder(Node root, List<Integer> sol){
        if(root == null)
            return;
            
        inOrder(root.left, sol);
        sol.add(root.data);
        inOrder(root.right, sol);
    } 

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        int minIndex = findMin(A, 0, A.size()-1);
        
        // System.out.println("Min index root:"+minIndex);
        
        Node root = new Node(A.get(minIndex));
        insertLeft(root, A, 0, minIndex-1);
        insertRight(root, A, minIndex+1, A.size()-1);
        return root;
    }
    
    public int findMin(List<Integer> list, int start, int end){
        int minIndex = start;
        for(int i = start; i<=end; i++){
            if(list.get(i) < list.get(minIndex))
                minIndex = i;
        }
        return minIndex;
    }
    
    protected void insertLeft(Node root, List<Integer> list, int start, int end){
        if(start> end)
            return;
        
        int minIndex = findMin(list, start, end);
        // System.out.println("Min index insertLeft:"+minIndex);
        root.left = new Node(list.get(minIndex));
        insertLeft(root.left, list, start, minIndex-1);
        insertRight(root.left, list, minIndex+1, end);
    }
    
    protected void insertRight(Node root, List<Integer> list, int start, int end){
        if(start> end)
            return;
        
        int minIndex = findMin(list, start, end);
        // System.out.println("Min index insertRight:"+minIndex);
        root.right = new Node(list.get(minIndex));
        insertLeft(root.right, list, start, minIndex-1);
        insertRight(root.right, list, minIndex+1, end);
    }
};