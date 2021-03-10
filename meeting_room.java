class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a1, int[] a2){
                if(a1[0]==a2[0]){
                    return 0;
                }
                return a1[0]<a2[0]?-1:1;
            }
        });
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}