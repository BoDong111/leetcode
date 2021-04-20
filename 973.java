class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap=new PriorityQueue<>(k, new Comparator<int[]>(){
        public int compare(int[] p1, int[] p2){
            if(distance(p1)==distance(p2)){
                return 0;
            }
            return distance(p1)>distance(p2)?-1:1;
        }});
        for(int i=0;i<points.length;i++){
            if(i<k){
                maxheap.offer(points[i]);
            }
            else{
                int[] tmp=maxheap.peek();
                if(distance(tmp)>distance(points[i])){
                    maxheap.poll();
                    maxheap.offer(points[i]);
                }
            }
        }
        int[][] result=new int[k][2];
        int i=0;
        while(i<k){
            int[] tmp=maxheap.poll();
            result[i][0]=tmp[0];
            result[i][1]=tmp[1];
            i++;
        }
        return result;
    }
    public int distance(int[] p1){
        return p1[0]*p1[0]+p1[1]*p1[1];
    }
}