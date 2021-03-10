class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length<1){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0]==e2[0]){
                    return 0;
                }
                return e1[0]<e2[0]?-1:1;
            }
        });
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            if(minheap.isEmpty()||intervals[i][0]<minheap.peek()){
                minheap.offer(intervals[i][1]);
            }
            else{
                minheap.poll();
                minheap.offer(intervals[i][1]);
            }
        }
        return minheap.size();
    }
}