class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0 || n<0){
           list.add("");
           return list;
        }
        String s  = "";
        int close = 0;
        int open = 0;
        s = s+"(" ;
        return generate(open+1,close,n,list,s);
        
      
    }
    public List<String> generate(int open,int close,int  n,List<String> list,String s ){
        
    if(open == n && close == n){
    list.add(s);
    return list;
   }


   if(open < n){
    generate(open + 1, close, n, list, s + "(");
   }

    if(close < open){
    generate(open, close + 1, n, list, s + ")");
   }
   return list;
    }

}