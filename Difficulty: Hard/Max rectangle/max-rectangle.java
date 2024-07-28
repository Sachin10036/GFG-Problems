//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int maxArea = 0;
        int pSum[][] = new int[n][m];
        for(int j=0; j<m; j++){
            int sum=0;
            for(int i=0; i<n; i++){
                sum += M[i][j];
                if(M[i][j] == 0) sum = 0;
                pSum[i][j] = sum;
            }
        }
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, largestHist(pSum[i]));
        }
        return maxArea;
    }
    
    public int largestHist(int arr[]){
        int n = arr.length;
        int maxArea =0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, arr[element]*(nse - pse -1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, arr[element]*(nse - pse -1));
        }
        return maxArea;
    }
}