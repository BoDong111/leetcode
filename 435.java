class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] i1, int[] i2){
                if(i1[0]==i2[0]){
                    return 0;
                }
                return i1[0]<i2[0]?-1:1;
            }
        });
        int prevend=intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prevend){
                count++;
                prevend=Math.min(prevend, intervals[i][1]);
            }
            else{
                prevend=intervals[i][1];
            }
        }
        return count;
    }
}