class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                String str1=words[i]+words[j];
                String str2=words[j]+words[i];
                if(isPalindrome(str1)){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(new ArrayList(tmp));
                }
                if(isPalindrome(str2)){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(j);
                    tmp.add(i);
                    result.add(new ArrayList(tmp));
                }
            }
        }
        return result;
    }
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}