package classic150.MonotonicStack;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stack = new Stack<>(); // 存储索引，下标对应温度单调递减
        int[] ans = new int[temps.length];

        for (int pos = 0; pos < temps.length; pos++) {
            // 当前温度比栈顶的高，说明栈顶那天等到了更暖的一天
            while (!stack.isEmpty() && temps[pos] > temps[stack.peek()]) {
                int prev = stack.pop(); // 弹出之前那天的索引
                ans[prev] = pos - prev; // 计算等待天数
            }
            // 当前这天还没遇到更暖的，先压入栈
            stack.push(pos);
        }

        // 栈中剩下的索引默认答案是 0，无需再处理
        return ans;
    }

    /**
     由于Java当中 Stack类涉及非常多的类型/锁/安全检查，在实现单调栈的时候如果数据规模比较小往往会出现速度很慢的情况

     下面使用数组来模拟栈基本上是Java当中单调栈的最快实现

     @param T: 温度数组
     */
    public int[] dailyTemperatures2(int[] T){
        int n = T.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            int cur = T[i];
            while (top >= 0 && cur > T[stack[top]]) {
                int prev = stack[top--];
                ans[prev] = i - prev;
            }
            stack[++top] = i;
        }
        return ans;
    }
}
