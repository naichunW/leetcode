package cn.ac.iie.leetcode;

import java.util.ArrayList;

/**
 * Description:
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author naichun
 * @date 2018/10/23 下午10:37
 */
public class AddTwoNumbers {
    private int upNum = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int val1 = l1.val;
        int val2 = l2.val;
        result.add(sum(val1,val2,upNum));

        while(hasNext(l1) && hasNext(l2)){
            l1 = l1.next;
            l2 = l2.next;
            val1 = l1.val;
            val2 = l2.val;
            result.add(sum(val1,val2,upNum));
        }
        if(hasNext(l1)){
            while(hasNext(l1)){
                l1 = l1.next;
                val1 = l1.val;
                result.add(sum(val1,0,upNum));
            }
            if(upNum != 0){
                result.add(sum(0,0,upNum));
            }
        }else if(hasNext(l2)){
            while(hasNext(l2)){
                l2 = l2.next;
                val2 = l2.val;
                result.add(sum(0,val2,upNum));
            }
            if(upNum != 0){
                result.add(sum(0,0,upNum));
            }
        }
        else{
            if(upNum != 0){
                result.add(sum(0,0,upNum));
            }
        }

        int resultSize = result.size();
        ListNode resultNode = new ListNode(0);
        if(resultSize == 0){
            return resultNode;
        }
        ListNode tmp = resultNode;
        for(int i=0;i<result.size();i++){
            tmp.next = new ListNode(result.get(i));
            tmp = tmp.next;
        }
        return resultNode.next;
    }
    private int sum(int val1, int val2,int a){
        int sum = val1 + val2 + a;
        this.upNum = sum/10;
        return sum%10;
    }
    private boolean hasNext(ListNode node){
        return node.next != null;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
