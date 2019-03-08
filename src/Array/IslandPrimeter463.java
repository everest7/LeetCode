package Array;

public class IslandPrimeter463 {
    public static void main(String[] args) {
        IslandPrimeter463 ip = new IslandPrimeter463();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(ip.islandPerimeter(grid));

    }
    // Each island has four side, whenever there is an island right next or down to
    // one island, both subtract one side from the total sides.
    // Therefore, Perimeter = island * 4 - neighbor * 2
    public int islandPerimeter(int[][] grid) {
        int island = 0, neighbor = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    island++;
                    if (i < grid.length - 1 && grid[i+1][j] == 1) neighbor++;
                    if (j < grid[i].length - 1 && grid[i][j+1] == 1) neighbor++;
                }
            }
        }
        return island * 4 - neighbor * 2;
    }
}
