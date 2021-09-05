package sorting_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Meeting Room2
 *
 * 사람들이 회의에 참석하려면 몇 개의 회의실이 필요한가?
 *
 * 회의 정렬 후 각 회의의 끝시간과 시작시간을 비교해서
 * 끝시간 > 시작시간 == 따로 회의실 사용해야 함
 * 끝시간 < 시작시간 == 같은 회의실 사용해도 됨
 */
public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 mr2 = new MeetingRoom2();
        int[][] intervals = { //{시작시간, 끝시간}
                {5,10}, {16,20}, {0,30}
        };
        /*int[][] intervals = {
                {7,10}, {2,4}
        };*/

        System.out.println("사용해야 하는 총 회의실 수는 " + mr2.solve(intervals) + "개 입니다.");
    }

    public int solve(int[][] intervals){
        // 1. sort
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //asc 오름차순
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //end time 기준으로 오름차순

        // 2. for
        for(int[] arr : intervals){
            if(queue.isEmpty()){ //같이 사용할 수 없다면
                queue.offer(arr); //[0,30], [5,10]
            } else{ //같이 사용할 수 있다면
                if(queue.peek()[1] <= arr[0]){
                    // 10 <= 16
                    queue.poll(); //조금 더 앞에 시작하는 회의 값 빼고
                }
                //뒤에 시작하는 회의 값 넣음
                queue.offer(arr); //[16,20]
            }
        }

        return queue.size();
    }
}
