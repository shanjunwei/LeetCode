package list;

/**
 * 普通 单向链表
 */
public class ListNode<T> {
    T data;
    ListNode next;

    public ListNode(T data) {
        this.data = data;
    }
    public static ListNode init(){
        ListNode<Integer> head = new ListNode(null);
        return head;
    }
}
