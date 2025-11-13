package classic150;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        int right = points[0][1];
        for(int i = 1; i < points.length; i++){
            int[] cur =  points[i];
            if(cur[0] <= right){
                right = Math.min(cur[1], right);
            }else{
                count ++;
                right = cur[1];
            }
        }
        return count;
    }
}
