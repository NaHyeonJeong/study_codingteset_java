package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        this.val = x;
    }
}
public class MergeSortedList {

    public static void main(String[] args) {
        MergeSortedList a = new MergeSortedList();

        ListNode1 l1 = new ListNode1(1);
        l1.next = new ListNode1(4);
        l1.next.next = new ListNode1(5);

        ListNode1 l2 = new ListNode1(1);
        l2.next = new ListNode1(3);
        l2.next.next = new ListNode1(4);

        ListNode1 l3 = new ListNode1(2);
        l3.next = new ListNode1(6);

        ListNode1[] list = new ListNode1[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        ListNode1 result = a.solve(list);
        a.print(result);
    }

    public ListNode1 solve(ListNode1[] lists){
        //1. data structure
        //1-1
        Queue<ListNode1> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val)); //작은거 부터 뽑아냄
        ListNode1 head = new ListNode1(0); //하나씩 뽑아낸걸 담아둘 list
        ListNode1 res = head; //최종적으로 정렬된 값들이 들어있는 list (처음에는 head와 같이 0을 가짐)

        /*//1-2
        Queue<ListNode1> pq1 = new PriorityQueue<>(new Comparator<ListNode1>() {
            @Override
            public int compare(ListNode1 o1, ListNode1 o2) {
                return o1.val-o2.val;
            }
        });
        //1-3
        Queue<ListNode1> pq2 = new PriorityQueue<>(Comp);*/

        //2. for while
        for(ListNode1 list : lists){
            if(list != null)
                pq.offer(list); //list 들을 일단 다 넣기
            //[1,4,5] - [1,3,4] - [2,6] 순서로 pq 에 들어감
        }
        while(!pq.isEmpty()){
            //pq = [1,4,5]-[1,3,4]-[2,6] >> [1,3,4]-[2,6]-[4,5] >> [2,6]-[3,4]-[4,5] >> [3,4]-[4,5]-[6] >> [4]-[4,5]-[6]
            ListNode1 node = pq.poll(); //리스트 별로 하나씩 빼기 ([1,4,5] > [1,3,4] > [2,6] > [3,4] > [4]
            //System.out.println("node.val = " + node.val);
            res.next = node; //res = [0,1,4,5] > [1,1,3,4] > [1,2,6] > [2,3,4]
            res = res.next; //res = [1] > [1] > [2] > [3]

            if(node.next != null){
                pq.offer(node.next); //[1,4,5] >> [4,5] | [1,3,4] >> [3,4] | [2,6] >> [6] | [3,4] >> [4]
            }
        }

        return head.next;
    }
    Comparator<ListNode1> Comp = new Comparator<ListNode1>() {
        @Override
        public int compare(ListNode1 o1, ListNode1 o2) {
            return o1.val - o2.val;
        }
    };

    private void print(ListNode1 node) {
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
