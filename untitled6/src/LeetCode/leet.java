package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class leet {

    //to hop tat ca cac dau ngoac
    public static List<String> generate(int n){
        List<String> res = new ArrayList<>();
        if(n == 0){
            res.add("");
        }
        for (int i=0;i<n;i++){
            for (String left : generate(i)){
                for (String right : generate(n-i-1)){
                    res.add("("+left+")"+right);
                }
            }
        }
        return res;
    }


    //hop nhat listNode va sap sep
    public static ListNode mergaListNode(ListNode[] list){
        ListNode head = new ListNode();
        ListNode cur = head;
        boolean isValied = true;

        while (isValied){
            isValied=false;
            int minInds = find(list);

            if(minInds >= 0){
                isValied=true;
                cur.next=list[minInds];
                cur=cur.next;
                list[minInds]=list[minInds].next;
            }
        }
        return head.next;
    }

    public static int find(ListNode[] lists){
        int minVal = Integer.MAX_VALUE;
        int minInd = -1;

        for (int i=0;i< lists.length;i++){
            if(lists[i] != null){
                if(lists[i].val < minVal){
                    minVal = lists[i].val;
                    minInd = i;
                }
            }
        }
        return minInd;
    }
}
