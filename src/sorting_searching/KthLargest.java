package sorting_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * k 번째로 제일 큰 원소는?
 *
 * 일반 Arrays.sort()와 PriorityQueue()를 각각 사용해봄
 * 중복 제거 없음
 */
public class KthLargest {
    public static void main(String[] args) {
        KthLargest kl = new KthLargest();
        int[] nums = {2,3,1,5,6,4};
        int k = 2; //2번째로 큰 값을 찾기
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int k2 = 4; //4번째로 큰 값을 찾기

        System.out.println(k + "번째로 큰 값은 = " + kl.solve(nums, k));
        System.out.println(k2 + "번째로 큰 값은 = " + kl.solve_pq(nums2, k2));
    }

    /**
     * sorting 후 값을 찾기
     * @param nums
     * @param k
     * @return
     */
    public int solve(int[] nums, int k){
        Arrays.sort(nums); //오름차순 정렬
        int len = nums.length; //6개

        return nums[len - k]; //[1,2,3,4,5,6] 4번방의 값을 찾아내야 함
    }

    /**
     * priority queue 를 이용하기
     * @param nums
     * @param k
     * @return
     */
    public int solve_pq(int[] nums, int k){
        // 1.
        Queue<Integer> pq = new PriorityQueue<>(); //asc - minHeap(작은 값이 맨 위로 올라감)

        // 2.
        for(int i : nums){
            pq.offer(i); //queue에 값을 다 넣는다
            if(pq.size() > k){ //다 넣을 필요 없이 k개 만큼만 유지함(위에 가장 작은 값이 있게 됨)
                pq.poll(); //큰 값이 나올때 까지 가장 앞의 값을 삭제
            }
        }
        return pq.peek(); //가장 뒤에 있는 값이 큰 값
    }
}
