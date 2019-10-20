package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-09-02
 */
public class MinimumCostToHireKWorkers857 {
    public static void main(String[] args) {
        MinimumCostToHireKWorkers857 mw = new MinimumCostToHireKWorkers857();
        System.out.println(mw.mincostToHireWorkers(new int[] {10,20,5}, new int[] {70,50,30}, 2));
    }

    /**
     * Sorting workers based on ratio = wage / quality
     * In choosing a group of K workers, wageSum = ratio * totalQuality, in order for the wageSum to be minimum,
     * we need to make sure that ratio is as small as possible but be able to cover workers minimum wage expectation,
     * and totalQuality as small as possible. That is,
     * ratio is the maximum in current group of K workers
     * totalQuality is the sum of their quality
     *
     * @param quality
     * @param wage
     * @param K
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, new Comparator<Worker>(){
            public int compare(Worker a, Worker b) {
                return Double.compare(a.ratio, b.ratio);
            }
        });
        double res = Double.MAX_VALUE;
        int totalQuality = 0;
        for (int i = 0; i < n; i++){
            pq.offer(workers[i].quality);
            totalQuality += workers[i].quality;
            while (pq.size() > K) {
                totalQuality -= pq.poll();
            }
            if (pq.size() == K) {
                res = Math.min(res, totalQuality * workers[i].ratio);
            }
        }
        return res;
    }

    class Worker {
        int quality;
        int wage;
        double ratio;
        Worker(int q, int w) {
            this.quality = q;
            this.wage = w;
            this.ratio = (double) w / (double) q;

        }
    }


    /**
     * Using class implements Comparable
     */
//    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//        int n = quality.length;
//        Worker[] workers = new Worker[n];
//        for (int i = 0; i < n; i++) {
//            workers[i] = new Worker(quality[i], wage[i]);
//        }
//        Arrays.sort(workers);
//        double res = Double.MAX_VALUE;
//        int totalQuality = 0;
//        for (int i = 0; i < n; i++){
//            pq.offer(workers[i].getQuality());
//            totalQuality += workers[i].getQuality();
//            while (pq.size() > K) {
//                totalQuality -= pq.poll();
//            }
//            if (pq.size() == K) {
//                res = Math.min(res, totalQuality * workers[i].getRatio());
//            }
//        }
//        return res;
//    }
//
//    class Worker implements Comparable<Worker> {
//        private int quality;
//        private int wage;
//        public Worker(int q, int w) {
//            quality = q;
//            wage = w;
//        }
//
//        public double getRatio() {
//            return (double) wage / (double) quality;
//        }
//
//        public int getQuality() {
//            return this.quality;
//        }
//
//        public int compareTo(Worker other) {
//            if (this.getRatio() - other.getRatio() < 0) {
//                return -1;
//            } else if (this.getRatio() - other.getRatio() > 0) {
//                return 1;
//            } else {
//                return this.getQuality() - other.getQuality();
//            }
//        }
//    }
}
