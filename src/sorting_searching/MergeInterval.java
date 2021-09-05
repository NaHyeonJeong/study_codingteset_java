package sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 겹치는 구간을 병합하여 최종 배열을 반환
 *
 * 이전값의 end와 다음값의 start를 비교해야함
 */
public class MergeInterval {

    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
        int[][] intervals = {
                {1,4},
                {8,10},
                {2,6},
                {15,18}
        };
        int[][] result = mi.solve(intervals); //최종적으로 만들어진 결과값

        System.out.println("result ");
        for(int[] arr : result){
            System.out.println(arr[0] + " : " + arr[1]);
        }
    }

    public int[][] solve(int[][] intervals){
        List<int[]> result = new ArrayList<>();

        if(intervals.length == 0 || intervals == null) {
            return result.toArray(new int[0][]); //빈 값을 반환
        }

        // 1. data structure
        // sorting
        Arrays.sort(intervals, (Comparator.comparingInt(a -> a[0]))); //오름차순 asc

        // 2. for
        //[0]번을 먼저 뽑아놓고 비교해야 편할듯
        int start = intervals[0][0]; //1
        int end = intervals[0][1]; //4

        //== 중요 ==//
        for(int i = 1; i < intervals.length; i++){
            //System.out.println("i = " + i);
            //겹친다면
            if(end >= intervals[i][0]){ //이전값의 end와 다음값의 start를 비교
                end = Math.max(end, intervals[i][1]); //더 큰 값을 넣어줌
                //[1,4] + [2,6] = [1,6]
            } else{ //겹치지 않는다면
                start = intervals[i][0];
                end = intervals[i][1];
                //[8,10]
                //[15,18]
            }
            result.add(new int[] {start, end}); //최종적으로 [15,18]이 담김
        }

        //List<int[]>를 int[][]로 변환해야 함
        return result.toArray(new int[result.size()][]);
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
