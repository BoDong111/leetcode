class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList==null||firstList.length==0||secondList==null||secondList.length==0){
            return new int[][]{};
        }
        int i=0;
        int j=0;
        int begmax=0;
        int endmin=0;
        List<int[]> result=new ArrayList<>();
        while(i<firstList.length&&j<secondList.length){
            begmax=Math.max(firstList[i][0], secondList[j][0]);
            endmin=Math.min(firstList[i][1], secondList[j][1]);
            if(endmin>=begmax){
                result.add(new int[]{begmax, endmin});
            }
            if(endmin==firstList[i][1]){
                i++;
            }
            if(endmin==secondList[j][1]){
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}