package list;

import java.util.PriorityQueue;

public class KthLargest {
    // todo 手写优先队列
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    int queueMaxSize = 0;

    public KthLargest(int k, int[] nums) {
        this.queueMaxSize = k;
        for (int data : nums) {
            add(data);
        }
    }
    public int add(int val) {
        System.out.println("入队" + val);
        Integer headData = queue.peek();
        if (queue.size() != this.queueMaxSize) {
            queue.add(val);
        } else {
            // 队列满且比队首（第k大）最大
            if(val > headData){
                queue.poll();
                queue.add(val);
            }
        }
        System.out.println(queue);
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        // ["KthLargest","add","add","add","add","add"]
        //[[2,[0]],[-1],[1],[-2],[-4],[3]]
        kthLargest.add(-1);   // return 4
        kthLargest.add(1);   // return 5
        kthLargest.add(-2);  // return 5
        kthLargest.add(-4);   // return 8
        kthLargest.add(3);   // return 8
        kthLargest.add(40);   // return 8
    }

}
