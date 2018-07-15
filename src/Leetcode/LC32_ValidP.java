package Leetcode;

import java.util.Arrays;

public class LC32_ValidP {
    public static int longestValidParentheses(String s) {


///////////////////////        double scan
//        int left = 0;
//        int right = 0;
//        int maxLeft = 0;
//        int maxRight = 0;
//        char[] arr = s.toCharArray();
//        for(int i =0;i<s.length();i++){
//            char c = arr[i];
//            if(c=='(')
//                left++;
//            else if(right<left)
//            {
//                right++;
//                if(left == right){
//                    maxLeft = Math.max(maxLeft,right*2);
//                }
//            }else{
//                left = 0;
//                right = 0;
//            }
//
//
//
//        }
//
//        left = right = 0;
//
//        for(int i =s.length()-1;i>0;i--) {
//            char c = arr[i];
//            if(c==')')
//                right++;
//            else if(right>left)
//            {
//                left++;
//                if(left == right){
//                    maxRight = Math.max(maxRight,left*2);
//                }
//            }else{
//                left = 0;
//                right = 0;
//            }
//        }
//        return Math.max(maxLeft,maxRight);

        ////////////////DP//////////////
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;

    }
    public static void main(String [ ] args){
        String s = "()(((())";
        System.out.print(longestValidParentheses(s));
    }
}
