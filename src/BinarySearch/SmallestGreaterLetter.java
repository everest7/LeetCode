package BinarySearch;

public class SmallestGreaterLetter {
    public static void main(String[] args) {
        SmallestGreaterLetter sl = new SmallestGreaterLetter();
        char[] letters = {'c','f','j'};
        System.out.println(sl.nextGreatestLetter(letters,'a'));
    }
//    public char nextGreatestLetter(char[] letters, char target) {
//        int min = 0;
//        for (char ch : letters){
//            if (ch - target > 0) return ch;
//
//        }
//        return letters[0];
//    }

    // Using binary search
    public char nextGreatestLetter(char[] letters, char target){
        int length = letters.length;
        int left = 0, right = length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return letters[left % length];

    }

}
