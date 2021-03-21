class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0) return 0;
     // sort points based on their end point. 
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2)
            {
                if(p1[1]==p2[1]){
                    return 0;
                }
                return p1[1]<p2[1]?-1:1;
            }
        });
        int currentEnd=points[0][1];
        int count=1;
        for(int i=0;i<points.length;i++){
            if(points[i][0]>currentEnd){
                count++;
                currentEnd=points[i][1];
            }
            else{
                continue;
            }
        }
        return count;
    }
}