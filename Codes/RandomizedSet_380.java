package classic150;

import java.util.*;

class RandomizedSet_380 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public RandomizedSet_380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);

        list.set(idx, lastVal);
        map.put(lastVal, idx);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}