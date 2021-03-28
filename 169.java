class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int result=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()>nums.length/2){
                result=e.getKey();
                break;
            }
        }
        return result;
    }
}