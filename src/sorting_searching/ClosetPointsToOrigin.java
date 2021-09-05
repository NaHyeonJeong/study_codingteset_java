package sorting_searching;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 원점에 가장 가까운 지점
 *
 * 그거... 피타고라스 그거 사용하는데 대신 루트는 사용 안하고 비교
 * Comparator, Comparable 공부 필요
 * Queue 사용법 공부 필요
 */
public class ClosetPointsToOrigin {

    public static void main(String[] args) {
        ClosetPointsToOrigin cpto = new ClosetPointsToOrigin();
        /*int[][] points = {
                {1,3}, {-2, 2}
        };
        int k = 1;*/
        int[][] points = {
                {3,3},
                {5,-1},
                {-2,4}
        };
        int k = 2;

        int result[][] = cpto.solve(points, k);
        cpto.print(result);
    }

    public int[][] solve(int[][] points, int k){
        // 1. data structure
        //작은 수가 앞으로 오게 하겠다
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1]))); //x^2 + y^2
        int[][] result = new int[k][2]; //k개 만큼 반환할꺼

        // 2. for while
        for(int[] p : points){
            pq.offer(p); //큰 값은 아래로, 작은 값은 위로
        }
        int index = 0;
        while(index < k){
            result[index] = pq.poll();
            index++;
        }
        return result;
    }

    public void print(int[][] result){
        int m = result.length;
        int n = result[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.println("[" + i + "][" + j + "]" + result[i][j]);
            }
            System.out.println();
        }
    }
}
