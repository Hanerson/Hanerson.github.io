package classic150;

import java.util.HashMap;

public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(map.containsKey(c)){
                if(map.get(c) == 0) return false;
                map.put(c, map.get(c) - 1);
            }else return false;
        }
        return true;
    }
}
