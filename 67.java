class Solution {
    public String addBinary(String a, String b) {
        int idx1=a.length()-1;
        int idx2=b.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(idx1>=0||idx2>=0){
            int sum=0;
            if(idx1>=0){
                sum+=a.charAt(idx1)-'0';
                idx1--;
            }
            if(idx2>=0){
                sum+=b.charAt(idx2)-'0';
                idx2--;
            }
            sum+=carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}