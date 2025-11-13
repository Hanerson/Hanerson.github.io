package classic150;

import java.util.*;

public class ContainsNearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(queue.size() > k){
                int temp = queue.poll();
                set.remove(temp);
            }
            queue.offer(num);
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
