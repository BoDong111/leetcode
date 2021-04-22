class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return new int[][]{};
        }
        List<int[]> result=new ArrayList<>();
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] t1, int[] t2){
                if(t1[0]==t2[0]){
                    return 0;
                }
                return t1[0]<t2[0]?-1:1;
            }
        });
        result.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>result.get(result.size()-1)[1]){
                result.add(intervals[i]);
            }
            else{
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}