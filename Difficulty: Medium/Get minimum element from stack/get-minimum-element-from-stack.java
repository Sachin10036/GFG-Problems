//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG {
    int minEle;
    Stack<Integer> st = new Stack<>();

    // Constructor    
    GfG() {
    }

    /* returns min element from stack */
    int getMin() {
        if (st.isEmpty()) {
            return -1; // If stack is empty, return -1 as specified
        }
        return minEle;
    }

    /* returns popped element from stack */
    int pop() {
        if (st.isEmpty()) {
            return -1; // If stack is empty, return -1 as specified
        }

        int val = st.pop();
        if (val < minEle) {
            int originalVal = minEle;
            minEle = 2 * minEle - val;
            return originalVal;
        } else {
            return val;
        }
    }

    /* push element x into the stack */
    void push(int x) {
        if (st.isEmpty()) {
            minEle = x;
            st.push(x);
        } else {
            if (x >= minEle) {
                st.push(x);
            } else {
                st.push(2 * x - minEle);
                minEle = x;
            }
        }
    }
}

/**
 * Your GfG object will be instantiated and called as such:
 * GfG obj = new GfG();
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.getMin();
 */


