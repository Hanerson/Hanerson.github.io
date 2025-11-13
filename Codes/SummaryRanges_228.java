package classic150;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // 仍在连续区间内
                end = nums[i];
            } else {
                // 区间断开，保存当前区间
                if (start == end) ans.add(String.valueOf(start));
                else ans.add(start + "->" + end);

                // 开始新的区间
                start = end = nums[i];
            }
        }

        // 补上最后一个区间
        if (start == end) ans.add(String.valueOf(start));
        else ans.add(start + "->" + end);

        return ans;
    }

}
