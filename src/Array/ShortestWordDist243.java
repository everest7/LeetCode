package Array;

public class ShortestWordDist243 {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDist243 sw = new ShortestWordDist243();
        System.out.println(sw.shortestDistance(words, "practice", "makes"));
    }

    // One pass
    // Time complexity: O(n)
    // Space compelxity: O(1)
    public int shortestDistance(String[] words, String word1, String word2){
        int index1 = -1, index2 = -1;
        int minDist = words.length;

        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                index1 = i;
            } else if (words[i].equals(word2)){
                index2 = i;
            }
            if (index1 != -1 && index2 != -1){
                minDist = Math.min(minDist, Math.abs(index1 - index2));
            }
        }
        return minDist;
    }
    // Brute force
    // Time complexity: O(n^2)
    // Space complexity O(1)
//    public int shortestDistance(String[] words, String word1, String word2) {
//        int minDist = words.length;
//        for (int i = 0; i < words.length; i++){
//            if (words[i].equals(word1)){
//                for (int j = 0; j < words.length; j++){
//                    if (words[j].equals(word2)){
//                        minDist = Math.abs(i - j);
//                    }
//                }
//            }
//        }
//        return minDist;
//    }
}
