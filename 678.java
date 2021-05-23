class Solution {
    public boolean checkValidString(String s) {
        int pmin=0;
        int pmax=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                pmax++;
                pmin++;
            }
            else if(s.charAt(i)==')'){
                pmax--;
                pmin--;
            }
            else{
                pmax++;
                pmin--;
            }
            if(pmax<0){
                return false;
            }
            pmin=Math.max(pmin,0);
        }
        //pmin=Math.max(pmin,0);
        return pmin==0;
    }
}