package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 문제 - BFS
 *
 * 공은 굴러서 빈 공간 통과할 수 있지만 벽에 부딪힐 때까지 굴러가는 것을 멈추지 않음
 * 공이 목적지에서 멈출 수 있으면 true 리턴, 그렇지 않으면 false 리턴
 *
 * BFS(Breadth-First Search) - 너비 우선 탐색
 * 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.
 * 주로 Queue 사용
 */
public class MazeBfs {

    public static void main(String[] args) {

        int[][] maze= {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start= {0,4};
        int[] dest = {4,4};

        MazeBfs a= new MazeBfs();
        System.out.println(a.hasPath(maze, start,dest ));
    }

    int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };
    int m ,n;

    public boolean hasPath(int[][] maze, int[] start, int[] dest){
        m = maze.length; //5
        n = maze[0].length; //5

        if(start[0] == dest[0] && start[1] == dest[0]){
            return true;
        }

        boolean[][] visited = new boolean[m][n]; //지나간 자리 여부 체크 위함
        visited[start[0]][start[1]] = true; //start point

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]}); //0,4

        while(!queue.isEmpty()){
            int[] cur = queue.poll(); //0,4
            for(int[] dir : dirs){
                int x = cur[0];
                int y = cur[1];
                while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) { //0인경우 쭉 통과해서 벽(1)까지 전진!
                    x += dir[0]; //x 값은 그대로
                    y += dir[1]; //y 값은 계속 감소하면서 앞으로 전진(또는 뒤로 전진)
                    //System.out.println("x = " + x + " | y = " + y);
                }
                //바로 앞이 벽이라면 벽 이전 값으로 바꿔줘야 함 {(3,4) -> (2,4)로 바꿔야 함}
                x -= dir[0];
                y -= dir[1];

                System.out.println("(벽 전) x = " + x + " | y = " + y);
                if(visited[x][y])
                    continue;
                visited[x][y] = true;

                print(visited);

                if(x == dest[0] && y == dest[1])
                    return true;

                queue.offer(new int[] {x,y});

            }
        }

        return false;
    }

    private void print(boolean[][] visited) {
        if(visited==null|| visited.length==0)return;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(visited[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
