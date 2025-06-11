class Solution {
    public int findLength(int[] color, int[] radius) {
       
       Stack<int[]> s=new Stack<>();
       for(int i=0;i<color.length;i++){
           if(!s.isEmpty()){
               int[] p=s.peek();
               if(p[0]==color[i] && p[1]==radius[i]){
                   s.pop();
               }else{
                   s.push(new int[] {color[i],radius[i]});
               }
           }else{
               s.push(new int[] {color[i],radius[i]});
           }
       }
       return s.size();
    }
}