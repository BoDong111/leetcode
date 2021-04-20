class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mapping=new int[26];
        for(int i=0;i<order.length();i++){
            mapping[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            if(!valid(words[i-1], words[i], mapping)){
                return false;
            }
        }
        return true;
    }
    public boolean valid(String w1, String w2, int[] mapping){
        int len1=w1.length();
        int len2=w2.length();
        for(int i=0;i<len1&&i<len2;i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                return mapping[w1.charAt(i)-'a']<mapping[w2.charAt(i)-'a'];
            }
        }
        return len1<=len2;
    }
}