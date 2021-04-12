class Solution {
    public int maxSubArray(int[] nums) {
        int tmp=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            tmp=Math.max(tmp+nums[i], nums[i]);
            sum=Math.max(sum, tmp);
        }
        return sum;
    }
}