class Solution {
    public boolean canJump(int[] nums) {
        boolean[] result=new boolean[nums.length];
        result[0]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(result[j]&&nums[j]>=(i-j)){
                    result[i]=true;
                }
            }
        }
        return result[nums.length-1];
    }
}