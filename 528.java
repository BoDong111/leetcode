class Solution {
    List<Integer> list=new ArrayList<>();
    int total=0;
    Random rand=new Random();
    public Solution(int[] w) {
        for(int i=0;i<w.length;i++){
            total+=w[i];
            list.add(total);
        }
    }
    
    public int pickIndex() {
        int target=rand.nextInt(total);
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)==target+1){
                return mid;
            }
            else if(list.get(mid)<=target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }
}