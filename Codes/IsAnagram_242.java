package classic150;

import java.util.Arrays;

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t){
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
