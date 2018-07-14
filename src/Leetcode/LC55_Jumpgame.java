package Leetcode;

public class LC55_Jumpgame {
    public static boolean canJump(int[] nums) {
        int potential[] = new int[nums.length];
        potential[nums.length-1] = Integer.MAX_VALUE;
        for(int i = nums.length-2; i>=0; i--){
            maxPotential(nums,potential,i);
        }
        if(potential[0]==Integer.MAX_VALUE)
            return true;
        else
            return false;
    }

    private static void maxPotential(int[] num,int [] potential,int pos){
        for(int i = 0;i<=num[pos];i++){
            int reach = i+pos;
            if(reach<num.length){
                if(potential[reach]>potential[pos])
                    potential[pos] = potential[reach];
            }
        }
    }

    public static void main(String [ ] args){
        int arr[] = {0,1};
        System.out.println(canJump(arr));
    }
}
