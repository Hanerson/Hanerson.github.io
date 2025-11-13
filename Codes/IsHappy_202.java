package classic150;

import java.util.HashSet;

public class IsHappy_202 {

    /// not good method for the set could be so big
    public boolean isHappy_hash(int n){
        HashSet<Integer> set = new HashSet<>();

        while(n != 1){
            int temp = operate(n);
            if(set.contains(temp)) return false;
            set.add(temp);
            n = temp;
        }

        return true;
    }

    /// we recommend fast and slow pointer when you saw "cycle"

    public boolean isHappy_pointer(int n){
        int fast = n, slow = n;
        while(true){
            slow = operate(slow);
            fast = operate(operate(fast));
            if(fast == 1) return true;
            if(slow == fast) return false;
        }
    }

    private int operate(int n){
        int sum = 0;
        while(n != 0){
            int leak = n % 10;
            sum += leak * leak;
            n /= 10;
        }

        return sum;
    }
}
