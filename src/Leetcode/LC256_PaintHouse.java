package Leetcode;

public class LC256_PaintHouse {
    public static int minCost(int[][] costs) {
        int[] sumCost = new int[3];
//        sumCost[0] = costs[0][0];
//        sumCost[1] = costs[0][1];
//        sumCost[2] = costs[0][2];

        for(int i = 0;i<costs.length;i++){
            int lastred = sumCost[0];
            int lastgreen = sumCost[1];
            int lastblue = sumCost[2];
            sumCost[0] = costs[i][0] + Math.min(lastgreen,lastblue);
            sumCost[1] = costs[i][1] + Math.min(lastred,lastblue);
            sumCost[2] = costs[i][2] + Math.min(lastgreen,lastred);
        }

        return Math.min(sumCost[0],Math.min(sumCost[1],sumCost[2]));


    }

    public static void main(String [ ] args){
        int[][] s = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(s));
    }
}
