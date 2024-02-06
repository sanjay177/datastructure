package leetcode.advance.sort;

import java.util.Collections;
import java.util.List;

/**
 * Leetcode - 2824
 */
public class CountPairLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        // Sort elements
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int count=0;
        while(left < right) {
            //-1 1 1 2 3
            // if we find the indexes where target is greater than left and right index values
            // then sum of all the pairs between those indexes will still be smaller
            // hence right - left
            if(nums.get(left) + nums.get(right) < target) {
                count = count + (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
