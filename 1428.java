class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim=binaryMatrix.dimensions();
        int m=dim.get(0);
        int n=dim.get(1);
        int ans=-1;
        int row=0;
        int col=n-1;
        while(row<m&&col>=0){
            if(binaryMatrix.get(row, col)==1){
                ans=col;
                col--;
            }
            else{
                row++;
            }
        }
        return ans;
        
    }
}