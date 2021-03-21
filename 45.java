class Solution {
    public int jump(int[] nums) {
        int[] result=new int[nums.length];
        for(int i=0;i<result.length;i++){
            result[i]=-1;
        }
        result[0]=0;
        for(int i=1;i<nums.length;i++){
            int tmpmin=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(result[j]>=0&&nums[j]>=(i-j)){
                    tmpmin=Math.min(tmpmin, result[j]+1);
                }
            }
            result[i]=tmpmin==Integer.MAX_VALUE?-1:tmpmin;
        }
        return result[nums.length-1];
    }
}