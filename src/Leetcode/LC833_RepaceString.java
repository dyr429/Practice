package Leetcode;

public class LC833_RepaceString {
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        String ans = "";

        ans += S.substring(0,indexes[0]);
        int len = indexes.length;
        boolean replaced = false;
        for(int i = 0; i<len;i++){
            int index = indexes[i];
            String real = S.substring(index,sources[i].length()+index);

            if(real.equals( sources[i])){
                ans += targets[i];
                replaced = true;
            }else if(i!=0){
                ans += S.substring(indexes[i-1],index);
                replaced = false;
            }
        }
        if(replaced){
            ans += S.substring(indexes[len-1]+sources[len-1].length());
        }else{
            ans += S.substring(indexes[len-1]);
        }
        return ans;
    }

    public static void main(String [ ] args){
        String s = "jjievdtjfb";
        int[] index = {4,6,1};
        String[] source={"kg","ggq","mo"};
        String[] target = {"s","so","bfr"};
        System.out.println(findReplaceString(s,index,source,target));
    }
}
