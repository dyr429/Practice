import java.util.*;

public class Solution {


    public Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node result = new Node();
        Node resultHead = result;
        while(headA!=null && headB!=null){
            if(headA.data>headB.data){
                result.next = headB;
                result=result.next;
                headB=headB.next;
            }else{
                result.next = headA;
                result = result.next;
                headA=headA.next;
            }
        }
        if(headA!=null){
            result.next = headA;
        }else if(headB!=null){
            result.next = headB;
        }
        return resultHead.next;


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node A = new Node();
        A.data = 2;
        Node B = new Node();
        B.data =5;
        Node C = new Node();
        C.data =1;

        Node D = new Node();
        D.data =4;
        A.next=B;
        C.next=D;


        s.mergeLists(A,C);
    }
}
class Node {
    int data;
    Node next;
}