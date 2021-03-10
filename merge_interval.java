class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<1){
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0]==e2[0]){
                    return 0;
                }
                return e1[0]<e2[0]?-1:1;
            }
        });
        List<int[]> result=new ArrayList<>();
        result.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>result.get(result.size()-1)[1]){
                result.add(intervals[i]);
            }
            else{
                result.get(result.size()-1)[1]=Math.max(intervals[i][1], result.get(result.size()-1)[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}