class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int result=0;
        int left=-1;
        int right=-1;
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] i1, int[] i2){
                if(i1[0]==i2[0]){
                    return 0;
                }
                return i1[0]<i2[0]?-1:1;
            }
        });
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>left&&intervals[i][1]>right){
                result++;
                left=intervals[i][0];
            }
            right=Math.max(right, intervals[i][1]);
        }
        return result;
    }
}