class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                String a = input.substring(0, i);
                String b = input.substring(i+1, input.length());
                List<Integer> resa=diffWaysToCompute(a);
                List<Integer> resb=diffWaysToCompute(b);
                for(int tmpa:resa){
                    for(int tmpb:resb){
                        if(c=='+'){
                            result.add(tmpa+tmpb);
                        }
                        else if(c=='-'){
                            result.add(tmpa-tmpb);
                        }
                        else if(c=='*'){
                            result.add(tmpa*tmpb);
                        }
                    }
                }
            }
        }
        if(result.size()==0){
                result.add(Integer.valueOf(input));
            }
        return result;
    }
}