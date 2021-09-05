package sorting_searching;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Meeting Room
 *
 * 사람들이 모든 회의에 참석할 수 있는가?
 * == 회의 시간이 겹치치 않는가?
 * 이전 회의의 *종료 시간* vs 이제 들어가야 하는 회의 *시작 시간*
 */
public class MeetingRoom {

    public static void main(String[] args) {
        MeetingRoom mr = new MeetingRoom();
        /*int[][] intervals = { //{시작시간, 끝시간}
                {5,10}, {16,20}, {0,30}
        };*/
        int[][] intervals = {
                {7,10}, {2,4}
        };

        System.out.println(mr.solve(intervals));
    }

    public boolean solve(int[][] intervals){
        //회의가 아예 없는 경우
        if(intervals == null || intervals.length == 0){
            return true;
        }

        // 1. sorting
        print(intervals);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //시작시간 기준으로 오름차순 정렬
        System.out.println("----------------------------");
        print(intervals);

        // 2. for
        int end = intervals[0][1];//맨 처음 회의시간의 종료시간을 빼놓고 시작해야함(앞, 뒤 시간 비교를 위해서임)
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){ //사용 불가
                //전에 시작한 회의의 끝나는 시간이 내가 시작해야 하는 시간보다 큰 경우임
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }

    private void print(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
