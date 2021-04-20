class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] array=s.toCharArray();
        Deque<Integer> stack=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(array[i]=='('){
                stack.push(i);
            }
            if(array[i]==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    set.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}