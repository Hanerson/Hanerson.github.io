package classic150.MonotonicStack;

public class LargestRectangle_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        int[] stack = new int[n + 1];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (top != -1 && (i == n || heights[i] < heights[stack[top]])) {
                int height = heights[stack[top]];
                top--;
                int width = top == -1 ? i : (i - stack[top] - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            top++;
            stack[top] = i;
        }
        return maxArea;
    }
}
