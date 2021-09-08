package linkedlist;

/**
 * Add two numbers
 *
 * 2개의 linkedList로 구현된 숫자를 앞에서 부터 더하기
 * carry 가 발생하는 것도 고려해야 함
 * 주어진 값 : (2->4->5) + (5->6->2)
 * 결 과 값 : 0->(7->0->6)
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);
        while(node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve(ListNode l1, ListNode l2){
        //1
        ListNode newHead = new ListNode(0); //결과값
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0;

        //2
        while (p1 != null || p2 != null){
            //carry 에 주어진 값들을 착착 담음
            if(p1 != null){
                carry += p1.val; //값을 넣고
                p1 = p1.next; //다음 위치로 옮김
            }
            if(p2 != null){
                carry += p2.val; //값을 넣고
                p2 = p2.next; //다음 위치로 옮겨둠
            }
            p3.next = new ListNode(carry % 10); //carry 값이 없다면 더한 값이 그대로 들어감
            p3 = p3.next; //다음 위치를 가리킴
            carry /= 10; //carry 값이 있다면 carry 에 1이 있는 상태로 다음 단계로 넘어감
        }

        if(carry == 1){ //마지막 값에도 carry 가 발생한다면
            p3.next = new ListNode(1); //노드를 추가해 줘야함
        }

        return newHead.next;
    }
}
