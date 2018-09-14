package String;

public class RansomNote383 {
    public static void main(String[] args) {
        RansomNote383 rn = new RansomNote383();
        String ransomNote = "aac";
        String magazine = "aabc";
        System.out.println(rn.canConstruct(ransomNote,magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letter = new int[26];
        for (int i = 0; i < magazine.length(); i++){
            ++letter[magazine.charAt(i) - 'a'];
        }
        for (int j = 0; j < ransomNote.length(); j++){
            if (--letter[ransomNote.charAt(j) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
