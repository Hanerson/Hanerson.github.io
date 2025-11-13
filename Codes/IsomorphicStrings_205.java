package classic150;

import java.util.HashMap;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // s -> t 检查
            if (mapST.containsKey(c1) && mapST.get(c1) != c2) return false;
            // t -> s 检查
            if (mapTS.containsKey(c2) && mapTS.get(c2) != c1) return false;

            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }

        return true;
    }
}
