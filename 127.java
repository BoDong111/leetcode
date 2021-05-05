class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict=new HashSet<>(wordList);
        Deque<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String tmp=queue.poll();
                for(int j=0;j<tmp.length();j++){
                    char[] tmparray=tmp.toCharArray();
                    for(char c='a';c<='z';c++){
                        tmparray[j]=c;
                        String word=new String(tmparray);
                        if(wordDict.contains(word)&&word.equals(endWord)){
                            return level+1;
                        }
                        if(wordDict.contains(word)&&!visited.contains(word)){
                            queue.offer(word);
                            visited.add(word);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}