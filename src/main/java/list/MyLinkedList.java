package list;

/**
 *
 */
public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;
    public static class ListNode {
        Integer val;
        ListNode next;
        ListNode pre;
        public ListNode() {
        }
        public ListNode(Integer val) {
            this.val = val;
        }
    }
    public MyLinkedList() {
        head = new ListNode();
        tail = head;
    }
    public int get(int index) {
        if(index > size) return -1;
        int cnt = 0;
        ListNode p = this.head.next;
        while (p!=null) {
            if(cnt == index) return  p.val;
            cnt++;
            p = p.next;
        }
        return -1;
    }
    public void addAtHead(int val) {
        ListNode addNode = new ListNode(val);
        if(head == tail){
            this.head.next = addNode;
            addNode.pre = this.head;
            this.tail = addNode;
        }else{
            ListNode pNext = this.head.next;
            addNode.next = pNext;
            pNext.pre = addNode;
            this.head.next = addNode;
            addNode.pre = this.head;
        }
        size++;
    }
    public void addAtTail(int val) {
        if(head == tail){
            addAtHead(val);
        }else{
            ListNode addNode = new ListNode(val);
            this.tail.next= addNode;
            addNode.pre = this.tail;
            this.tail = addNode;
        }
        size++;
    }
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        int cnt = 0;
        ListNode p = this.head;
        ListNode addNode = new ListNode(val);
        while (p!=null) {
            if(cnt == index){
                //System.out.println("==="+ p.val);
                ListNode pNext = p.next;
                addNode.next = pNext;
                if(pNext != null) pNext.pre = addNode;
                p.next = addNode;
                addNode.pre = p;
                if(p == this.tail) this.tail = addNode;
                size++;
                return;
            };
            cnt++;
            p = p.next;
        }
    }
    public void deleteAtIndex(int index) {
        if(index > size) return;
        int cnt = 0;
        ListNode p = this.head;
        while (p!=null) {
            if(cnt == index){
                ListNode next = p.next != null ? p.next.next : null;
                ListNode indexNode = p.next;
                p.next = next;
                if(next != null)  next.pre = p;
                if(indexNode != null) indexNode.next = null;
                size--;
                return;
            };
            cnt++;
            p = p.next;
        }
    }


    public  void print(){
        ListNode p = head.next;
        while (p!=null){
            System.out.print(p.val);
            System.out.print("->");
            p = p.next;
        }
        System.out.print("null"  +"  size="+size +" \n");
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.print();
        list.deleteAtIndex(2);
        list.print();
        System.out.println(list.get(2));
        list.print();
        list.addAtHead(6);
        list.print();
        list.addAtTail(4);
        list.print();

//        System.out.println("ssss"+ list.get(4));
//        list.addAtHead(4);
//
//        list.addAtIndex(5,0);
//        list.print();
//
//        list.addAtHead(6);
//        list.print();
    }

}
