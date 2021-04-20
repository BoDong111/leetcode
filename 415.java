class Solution {
    public String addStrings(String num1, String num2) {
        int index1=num1.length()-1;
        int index2=num2.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(index1>=0||index2>=0){
            int sum=0;
            if(index1>=0){
                sum+=num1.charAt(index1)-'0';
                index1--;
            }
            if(index2>=0){
                sum+=num2.charAt(index2)-'0';
                index2--;
            }
            sum+=carry;
            sb.append(sum%10);
            carry=sum/10;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}