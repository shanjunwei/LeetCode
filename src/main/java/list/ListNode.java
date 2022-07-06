package list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
/**
 * 普通 单向链表
 */
public class ListNode {
    Integer val;
    ListNode next;

    public ListNode(Integer data) {
        this.val = data;
    }
    public static ListNode init(){
        ListNode head = new ListNode(null);
        return head;
    }

    public static void print(ListNode head){
        while (head!=null){
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.print("null\n");
    }

    public static ListNode init(List<Integer> list){
        if(list== null && list.size() == 0) return  new ListNode(-1);
        ListNode head = new ListNode(list.get(0));
        ListNode p = head;
        for (int i = 1; i < list.size(); i++) {
            p.next =  new ListNode(list.get(i));
            p = p.next;
        }
        return head;
    }

    /**
     *  移除链表中的元素
     */
    public  ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(-1);
        ListNode fakeHead = p;
        p.next = head;
        while (p!= null){
            while (p.next!= null && p.next.val  != val) p = p.next;
            ListNode pre = p;
            ListNode end = p.next;
            while (end!= null && end.next != null && end.next.val == val)  end = end.next;
            // 执行删除操作
            if(end == null){
                ListNode after = null;
                pre.next = after;
                p = null;
            }else{
                ListNode after = end.next;
                end.next = null;
                pre.next = after;
                p = after;
            }
        }
       return fakeHead.next;
    }

//    [1,2,6,3,4,5,6]

    public static void main(String[] args) {
        ListNode list = init(Arrays.asList(6,6,6));
        ListNode solution = new ListNode(-1);
        ListNode newList =   solution.removeElements(list,6);
        print(newList);
    }
}
