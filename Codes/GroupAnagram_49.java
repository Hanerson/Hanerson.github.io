package classic150;

import java.util.*;

public class GroupAnagram_49 {

    private static final int[] TABLE = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113
    };


    public List<List<String>> groupAnagrams_hash(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_PrimeNumberTable(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        long temp = 1L;
        for(String str : strs){
            temp = 1L;
            for(char c : str.toCharArray()) temp *= TABLE[c - 'a'];
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
