package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  两个栈实现队列
 *  输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 */
public class CQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();

    public CQueue() {

    }

    /**
     * 入队
     */
    public void appendTail(int value) {
        stack1.addLast(value);
    }
    /**
     * 出队
     */
    public int deleteHead() {
        if(stack1.isEmpty())  return -1;
        while (!stack1.isEmpty()){
            stack2.addLast(stack1.pop());
        }
        int head = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.addLast(stack2.pop());
        }
        return head;
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
         obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
