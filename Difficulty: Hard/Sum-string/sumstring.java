class Solution {
    boolean helper(String s,int index,int prevNum,int currNum) {
        int n = s.length();
        if(index >= n) return true;
        if(s.charAt(index) == '0') return false;
    
        int sum = prevNum + currNum;
        for(int i = index + 1; i <= n; ++i) {
            int num = Integer.parseInt(s.substring(index,Math.min(index + 8,i)));
            if(num > sum) return false;
            if(num == sum && helper(s,i,currNum,sum)) return true;
        }
        
        return false;
    }
    
    public boolean isSumString(String s) {
        int n = s.length();
        int half = n / 2;
        for(int i = 1; i <= half; ++i) {
            int prevNum = Integer.parseInt(s.substring(0,Math.min(8,i)));
            for(int j = i + 1; j < n; ++j) {
                if(s.charAt(i) == '0') break;
                int currNum = Integer.parseInt(s.substring(i,Math.min(i + 8,j)));
                if(helper(s,j,prevNum,currNum))
                    return true;
            }
        }
        
        return false;
    }
}