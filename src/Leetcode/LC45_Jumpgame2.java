package Leetcode;

public class LC45_Jumpgame2 {
    public static int jump(int[] nums) {
        int len = nums.length;
        int step[] = new int[nums.length];
        for(int i=0;i<len;i++){
            step[i] = 0;
        }
        step[len-1] = 0;

        for(int pos = len-2; pos>=0; pos--){
            if(nums[pos]==0){
                step[pos] = Integer.MAX_VALUE;
            }
            else if(nums[pos]+pos>=len-1){
                step[pos] = 1;
            }else{
                int minStep =  minStep(nums, step, pos);
                if(minStep!=Integer.MAX_VALUE){
                    step[pos] = 1 + minStep;
                }else {
                    step[pos] = minStep;
                }

            }
        }
        return step[0];
    }

    private static int minStep(int[] nums, int[] step, int pos){
        int min = Integer.MAX_VALUE;
        for(int i = pos+1; i<=pos+nums[pos];i++){
            if(min>step[i]){
                min = step[i];
            }
        }
        return min;
    }


    public static void main(String [ ] args){
        int arr[] = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(jump(arr));
    }
}
