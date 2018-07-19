package Leetcode;

public class LC838_Dominoes {
    public static String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int [] forceR = new int[len];
        int [] forceL = new int[len];
        boolean right = false;
        for(int i = 0 ; i< len;i++){
            if(dominoes.charAt(i) == 'R'){
                forceR[i] = len;
                right = true;
            }else if(dominoes.charAt(i) == 'L'){
                right = false;
            }else if(right == true){
                forceR[i] = forceR[i-1] -1;
            }
        }


        boolean left = false;
        for(int i = len-1 ; i >=0;i--){
            if(dominoes.charAt(i) == 'L'){
                forceL[i] = -len;
                left = true;
            }else if(dominoes.charAt(i) == 'R'){
                left = false;
            }else if(left == true){
                forceL[i] = forceL[i] + forceL[i+1] +1;
            }
        }


        char[] arr = dominoes.toCharArray();
        for(int i = 0; i<len; i++){
            if(forceL[i] + forceR[i]>0){
                arr[i] = 'R';
            }else if(forceL[i] + forceR[i]<0){
                arr[i] = 'L';
            }
        }

        String s = String.valueOf(arr);
        return s;


    }

    public static void main(String [ ] args){
        String s = ".L.R...LR..L..";
        System.out.println(pushDominoes(s));
    }
}
