package list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ListNodeSolution {
    /**
     * 判断链表是否有环
     */
    public boolean hasCycle(ListNode head) {
        ListNode low = head,fast = head;
        while (low!=null && fast!=null){
            low = low.next;
            if(fast.next == null){
                return false;
            } else{
                fast = fast.next.next;
            }
            if(low == fast) return true;
        }
        return false;
    }
    @Test
    public void hasCycleTest() {
        ListNode list = ListNode.init(Arrays.asList(1));
        ListNodeSolution solution = new ListNodeSolution();
        Assert.assertEquals(false,solution.hasCycle(list));
    }
}
