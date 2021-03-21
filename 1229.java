class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result=new ArrayList<>();
        if(slots1==null||slots1.length==0||slots2==null||slots2.length==0){
            return result;
        }
        Arrays.sort(slots1, new Comparator<>(){
            public int compare(int[] i1, int[] i2){
                if(i1[0]==i2[0]){
                    return 0;
                }
                return i1[0]<i2[0]?-1:1;
            }
        });
        Arrays.sort(slots2, new Comparator<>(){
            public int compare(int[] i1, int[] i2){
                if(i1[0]==i2[0]){
                    return 0;
                }
                return i1[0]<i2[0]?-1:1;
            }
        });
        int i=0;
        int j=0;
        while(i<slots1.length&&j<slots2.length){
            int intersectStart=Math.max(slots1[i][0], slots2[j][0]);
            int intersectEnd=Math.min(slots1[i][1], slots2[j][1]);
            if(intersectStart+duration<=intersectEnd){
                result.add(intersectStart);
                result.add(intersectStart+duration);
                return result;
            }
            else{
                if(slots1[i][1]<slots2[j][1]){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }
}