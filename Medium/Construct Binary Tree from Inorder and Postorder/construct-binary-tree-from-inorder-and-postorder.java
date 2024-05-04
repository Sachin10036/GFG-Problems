//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        if(n == 0 || in ==null)
            return null;
        Node root = new Node(post[n-1]);
        int rootIndex = search(in, post[n-1]);
        if(rootIndex<0) return null;
        

//Right Tree
        int rightIn[] = Arrays.copyOfRange(in, rootIndex+1, n);
        int rightPost[] = Arrays.copyOfRange(post, n-rightIn.length-1, n);
        root.right = buildTree( rightIn, rightPost, rightIn.length);

 

// Left Tree      
        int leftIn[] = Arrays.copyOfRange(in, 0, rootIndex);
        int leftPost[] = Arrays.copyOfRange(post, 0, leftIn.length);
        root.left =buildTree(leftIn, leftPost, leftIn.length);
        
        return root;
    }
    int search(int[] arr, int v){
        for(int i=0; i<arr.length; i++)
            if(v == arr[i])
                return i;
                
        return -1;
    }
}
