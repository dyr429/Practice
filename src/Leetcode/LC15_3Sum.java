package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int small = 0;small<nums.length-2; small++){
            if(small!=0 && nums[small] == nums[small-1])
                continue;

            int mid = small + 1;
            int large = nums.length-1;
            while(mid<large){
                System.out.print(mid);
                System.out.println(large);
                if((mid-1!=small)&&nums[mid]==nums[mid-1])
                    mid++;
                else if((large!=nums.length-1) && nums[large]==nums[large+1])
                    large--;
                else{
                    int sum = nums[small] + nums[mid] + nums[large];
                    if(sum==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[small]);
                        list.add(nums[mid]);
                        list.add(nums[large]);
                        ans.add(list);
                        mid++;
                        large--;

                    }else if(sum<0){
                        mid++;
                    }else{
                        large--;
                    }
                }

            }

        }
        return ans;

    }

    public static void main(String [ ] args){
        int arr[] = {-2,0,1,1,2};
        threeSum(arr);
    }
}
