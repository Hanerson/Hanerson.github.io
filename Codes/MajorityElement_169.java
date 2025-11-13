package classic150;

import java.util.Arrays;
import java.util.Stack;

public class MajorityElement_169 {
    //Solution one: Sorting
    public int majorityElementI(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //high-efficiency method: one by one till last(stack)
    public int majorityElementII(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            if(stack.isEmpty() || stack.peek() == num){
                stack.push(num);
            }else{
                stack.pop();
            }
        }
        return stack.peek();
    }

    //Boyer-Moore Voting
    public int majorityElementIII(int[] nums){
        int candidate = 0, count = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
                count = 1;
                continue;
            }
            if(num == candidate) count ++;
            else count--;
        }
        return candidate;
    }
}
