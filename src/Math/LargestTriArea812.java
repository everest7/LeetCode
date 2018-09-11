package Math;

public class LargestTriArea812
{
    public static void main(String[] args) {
        LargestTriArea812 ls = new LargestTriArea812();
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        int[][] points2 = {{4,6},{6,5},{3,1}};
        System.out.println(ls.largestTriangleArea(points));
        System.out.println(ls.largestTriangleArea(points2));
    }

    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int[] i : points){
            for(int[] j : points){
                for (int[] k : points){
                    res = Math.max(res, 0.5 * (i[0]*(j[1]-k[1]) + j[0]*(k[1]-i[1]) + k[0]*(i[1]-j[1])));
                }
            }
        }
        return res;
    }
}
