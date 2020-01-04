//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package editor.cn;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();

       // solution.printList(solution.initList());

      //  System.out.println();
       // System.out.println(solution.getListCount(solution.initList()));
        // solution.printList(solution.revert(solution.initList()));

        solution.swapPairs(solution.initList());
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {


            int listCount = getListCount(head);

            int left = listCount / 2;
            int right = left + 1;

            // 逆置右半链表
          ListNode   rightList  =     revert(getKthLIstNode(right,head));

          printList(rightList);


            // 逆置左半链表
            ListNode   leftList  =    revert(head,left);

            printList(leftList);



            // 将左右连在一起
            ListNode  leftTail  = leftList;

            while (leftTail.next !=null){
                leftTail = leftTail.next;
            }

            leftTail.next  = rightList;


            printList(leftList);


            return leftList;
        }


        public ListNode getKthLIstNode(int num, ListNode head) {
            int count = 0;

            if (head == null) {
                return null;
            }
            while (head != null) {
                count++;

                if(count == num){
                    return head;
                }

                head = head.next;
            }

            return null;
        }


        // 获取链表的节点数
        public int getListCount(ListNode head) {
            int count = 0;

            if (head == null) {
                return count;
            }

            while (head != null) {
                count++;
                head = head.next;
            }

            return count;
        }

        // 单链表逆置,不完全逆置，到n处停止
        public ListNode revert(ListNode head,int n) {
            ListNode pRev = null;   // 已经逆置好的头节点
            ListNode pTemp = head;   // 遍历节点
            ListNode pNext = pTemp.next;  // 下一个节点
            int count = 0;

            while (pTemp != null) {
                pTemp.next = pRev;
                pRev = pTemp;
                pTemp = pNext;

                count++;
                if(count == n){
                    break;
                }
                if (pNext != null) {
                    pNext = pNext.next;
                }
            }
            return pRev;
        }

        // 单链表逆置
        public ListNode revert(ListNode head) {
            ListNode pRev = null;   // 已经逆置好的头节点
            ListNode pTemp = head;   // 遍历节点
            ListNode pNext = pTemp.next;  // 下一个节点

            while (pTemp != null) {
                pTemp.next = pRev;
                pRev = pTemp;
                pTemp = pNext;
                if (pNext != null) {
                    pNext = pNext.next;
                }

                //  System.out.println(String.format("pRev  %d  pTemp %d  pNext %d  ",pRev.val,pTemp.val,pNext.val));
            }
            return pRev;
        }

        // 链表初始化
        public ListNode initList() {
            ListNode node = new ListNode(1);
            ListNode head = node;
            for (int i = 2; i < 9; i++) {
                ListNode tempNode = new ListNode(i);
                node.next = tempNode;
                node = tempNode;
            }
            return head;
        }


        // 打印链表
        public void printList(ListNode node) {
            if (node == null) return;

            System.out.println();
            while (node != null) {
                System.out.print(node.val + "  >> ");
                node = node.next;
            }
        }



    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}