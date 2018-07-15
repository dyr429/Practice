package Leetcode;

import java.util.*;

public class LC835_ImageOverlap {
    public static int largestOverlap(int[][] A, int[][] B) {
        int len = A.length;
        List<Integer> countA = new ArrayList<>();
        List<Integer> countB = new ArrayList<>();;

        for(int i = 0; i<len;i++ ){
            for(int j = 0; j<len; j++){
                if(A[i][j] == 1){
                    countA.add(i*100+j);
                }
            }
        }

        for(int i = 0; i<len;i++ ){
            for(int j = 0; j<len; j++){
                if(A[i][j] == 1){
                    countB.add(i*100+j);
                }
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(Integer ia : countA){
            for(Integer ib: countB){
                int offset = ia-ib;
                if(map.containsKey(offset)){
                    map.put(offset,map.get(offset)+1);
                }else{
                    map.put(offset,1);
                }
            }
        }

        Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();
        int max = 0;
        while (it.hasNext()){
            Map.Entry<Integer,Integer> entry=it.next();
            max = Math.max(max,entry.getValue());

        }
        return max;

    }

    public static void main(String [ ] args){
        int A [][]= {{1,1,0},{0,1,0},{0,1,0}};
        int B [][]= {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(largestOverlap(A,B));
    }
}
