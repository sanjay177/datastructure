package leetcode.advance.sort;

/**
 * Leetcode - 1365
 * Constraints
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class CountSmallerThanNumber {
    /**
     * Time complexity - O(n)
     * Space Complexity - O(n) -- output array created
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //Initialize count array with size 101
        int[] count = new int[101];
        int[] result = new int[nums.length];

        //Update count array with number of occurrence of number from nums array on index position
        for(int i=0; i<nums.length; i++) {   // O(n)
           count[nums[i]]++;
        }

        //Add current index value and previous index value
        // This will tell number of smaller numbers on left
        for(int i=1; i< count.length; i++) {    /// O(1) -- size is 100 so constant
            count[i] = count[i]+count[i-1];
        }

        //Now get the total smaller number from count array using index position corresponding to nums array integetrs
        for(int i=0;i<nums.length; i++) { /// O(n)
            if(nums[i] == 0){
                result[i] = 0;
                continue;
            }
            result[i] = count[nums[i]-1];
        }
        return result;
    }



}
