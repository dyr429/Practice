package Leetcode;
//
//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
//        Note:
//
//        Given target value is a floating point.
//        You are guaranteed to have only one unique value in the BST that is closest to the target.
//        Example:
//
//        Input: root = [4,2,5,1,3], target = 3.714286
//
//        4
//        / \
//        2   5
//        / \
//        1   3
//
//        Output: 4

//import apple.laf.JRSUIUtils;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LC27_ClosestValue {
    public static int closestValue(List<Integer> list, double target) {
//        List<Integer> list = new ArrayList<>();
//        preOrder(root, list, target);
        if (list.size() == 1)
            return list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > target) {
                if (Math.abs(list.get(i) - target) < Math.abs(list.get(i - 1) - target)) {
                    return list.get(i);
                } else {
                    return list.get(i - 1);
                }
            }
        }
        return list.get(list.size() - 1);
    }






    public static void main(String [ ] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        double target = 3.7;
        System.out.print(closestValue(list,target));
    }
}
