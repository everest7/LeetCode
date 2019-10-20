package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-27
 */
public class LargestBorderedSquare1139 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,1,1},{1,0,1}, {1,1,1}};
        LargestBorderedSquare1139 ld = new LargestBorderedSquare1139();
        System.out.println(ld.largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int max = 0;
        int rows = grid.length, cols = grid[0].length;
        int [][] hor = new int[rows][cols];
        int [][] ver= new int[rows][cols];
        hor[0][0] = ver[0][0] = 1;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 0)
                    ver[i][j] = hor[i][j] = 0;
                else
                {
                    hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
                }
            }
        }
        for (int i = rows - 1; i >= 1; i--)
        {
            for (int j = cols - 1; j >= 1; j--)
            {
                int small = Math.min(hor[i][j], ver[i][j]);
                while (small > max)
                {
                    if (ver[i][j - small + 1] >= small && hor[i - small + 1][j] >= small)
                    {
                        max = small;
                    }
                    small--;
                }
            }
        }
        return max * max;
    }

}
