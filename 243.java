class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                list1.add(i);
            }
            else if(words[i].equals(word2)){
                list2.add(i);
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(Math.abs(list1.get(i)-list2.get(j))<result){
                    result=Math.abs(list1.get(i)-list2.get(j));
                }
            }
        }
        return result;
    }
}