package Leetcode;

public class LC5_Palindromic {
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 1;

        if(s.length()<2)
            return s;

        for(int i = 0; i< s.length(); i++){
            int offset = 1;
            while(i-offset>=0 && i+offset<=s.length()-1){
                if(s.charAt(i-offset)==s.charAt(i+offset)){
                    if(2*offset+1 > end-start){
                        start = i - offset;
                        end = i + offset+1;
                    }
                    offset++;
                }
                else{
                    break;
                }
            }
        }


        for(int i = 0; i< s.length()-1; i++){
            int offset = 0;
            while(i-offset>=0 && i+1+offset<=s.length()-1){
                if(s.charAt(i-offset)==s.charAt(i+1+offset)){
                    if(2*offset+2 > end-start){
                        start = i - offset;
                        end = i + offset+2;
                    }
                    offset++;
                }
                else{
                    break;
                }

            }


        }


        return s.substring(start,end);
    }

    public static void main(String [ ] args){
        String s = "abcuuuxyz";
        longestPalindrome(s);
    }
}
