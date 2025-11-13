package classic150;

import java.util.Arrays;

public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] bucket = new int[256];
        Arrays.fill(bucket, 0);

        int max = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            bucket[c]++;

            // 如果出现重复字符，则收缩左边界
            while (bucket[c] > 1) {
                bucket[s.charAt(left)]--;
                left++;
            }

            // 更新最大长度
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstring_3 s = new LongestSubstring_3();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
