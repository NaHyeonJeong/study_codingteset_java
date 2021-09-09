package Graph;

public class MazeDfs {

    public static void main(String[] args) {

        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {4, 4};

        MazeDfs a = new MazeDfs();
        System.out.println(a.solve(maze, start, dest));
    }

    int[][] dirs= { {-1,0}, {1,0}, {0,-1}, {0,1} }; //방향성 제공
    int m, n;

    public boolean solve(int[][] maze, int[] start, int [] dest) {
        if(maze == null || maze.length == 0 || maze[0].length == 0)
            return false;

        m = maze.length; //5
        n = maze[0].length; //5
        boolean[][] visited = new boolean[m][n];

        return dfs(maze, start, dest, visited);
    }

    public boolean dfs(int[][] grid, int[] start, int[] dest, boolean[][] visited){
        //error check
        System.out.println("=====================");
        if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || grid[start[0]][start[1]] != '1')
            return false;

        //0,4
        visited[start[0]][start[1]] = true;
        print1(visited);

        if(start[0] == dest[0] && start[1] == dest[1])
            return true;

        for(int[] dir : dirs){
            int x = start[0]; //0
            int y = start[1]; //4

            while(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0){
                x += dir[0]; //0 1 2 3
                y += dir[1]; //4 4 4 4 (1,0 까지지)
           }
            x -= dir[0]; //2
            y -= dir[1]; //4

            if(dfs(grid, new int[] {x,y}, dest, visited))
                return true;
        }
        return false;
    }

    private void print1(boolean[][] visited1) {
        if (visited1 == null || visited1.length == 0)
            return;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
