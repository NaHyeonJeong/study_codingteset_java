package queue_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 이진 트리 레벨 순서 순회
 *
 * 이진 트리가 주어지면 노드 ㄱ밧의 레벨 순서 순회를 반환함
 * 이진 트리의 값들을 큐에 넣어서 하나씩 빼고(FIFO) 각 레벨별로 list 로 묶어서 다시 list 에 넣는 문제
 *
 * Queue의 FIFO 성질을 이용해서 이진 트리의 레벨 순회 가능
 */
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val=x;
    }
}

public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(solve(root));
    }
    public static List<List<Integer>> solve(TreeNode root) {
        //1.
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //2.
        while(!queue.isEmpty()) {
            int size = queue.size(); //1(level1), 2(level2), 2(level3)
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); //1, 2, 3, 4, 5
                list.add(node.val); //[1] - [2 - 3] - [4 - 5]
                //하위 노드가 있을때 까지 계속 반복하게 됨
                if(node.left != null) { //2, 4
                    queue.offer(node.left);
                }
                if(node.right != null) { //3, 5
                    queue.offer(node.right);
                }
            }
            result.add(list); //[1] - [2,3] - [4,5]
        }
        return result;
    }
}
