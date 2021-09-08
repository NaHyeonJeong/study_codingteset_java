package linkedlist;

class ListNode2{
    int val;
    ListNode2 next;
    ListNode2(int x){
        this.val = x;
    }
}
public class ReverseLinkedLists {

    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2(1);
        l1.next = new ListNode2(2);
        l1.next.next = new ListNode2(3);

        printNode(l1);
        ListNode2 head = reverseList(l1);
        printNode(head);
    }

    public static ListNode2 reverseList(ListNode2 current){ //current 는 가장 맨 앞의 값을 가리키고 있음

        //1. data sturcutre
        ListNode2 next = null;
        ListNode2 prev = null;

        //2. for while
        while(current != null){
            //current = 10을 기준으로 주석 작성
            next = current.next; //current 의 next 가 가리키고 있던 부분들을(2n-30) next 라는 임시 변수에 넣어줌 (next = 2n-30)
            current.next = prev; //current 의 next(0) 는 prev(n) 를 가리켜야 함(역순을 만들어줌) - (current = 1n으로 바뀜)
            prev = current; //current 가 가리키던 값은 이제 prev 로 바뀌게 됨 (prev = 1n)
            current = next; //next 역할을 하고 있던 부분들을 current 로 바꿔줌 (current = 2n-30)
        }

        return prev;
    }

    public static void printNode(ListNode2 head) {
        System.out.println("printNOde: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }

}
