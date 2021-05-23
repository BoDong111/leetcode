class Solution {
    public List<String> removeInvalidParentheses(String s) {
        char[] array=s.toCharArray();
        int left=0;
        int right=0;
        for(int i=0;i<array.length;i++){
            if(array[i]=='('){
                left++;
            }
            else if(array[i]==')'){
                if(left>0){
                    left--;
                }
                else{
                    right++;
                }
            }
        }
        List<String> res=new ArrayList<>();
        Set<String> set=new HashSet<>();
        dfs(s, 0, left, right, "", res, set);
        return res;
    }
    public void dfs(String s, int index, int left, int right, String cur, List<String> res, 
                   Set<String> set){
        if(index==s.length()){
            if(left==0&&right==0){
                if(isValid(cur)){
                if(!set.contains(cur)){
                    res.add(cur);
                    set.add(cur);
                }
            }
            }
            return;
        }
        dfs(s, index+1, left, right, cur+s.charAt(index), res, set);
        if(s.charAt(index)=='('){
            dfs(s, index+1, left-1, right, cur, res, set);
        }
        if(s.charAt(index)==')'){
            dfs(s, index+1, left, right-1, cur, res, set);
        }
    }
    public boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            else if(s.charAt(i)==')'){
                if(count>0){
                    count--;
                }
                else{
                    return false;
                }
            }
        }
        return count==0;
    }
}