package com.shiki.solution;

import java.util.HashMap;

/**
 * @author shiki
 * @date 2019/10/13 - 18:58
 */
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 示例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                if(target == nums[i] + nums[j]){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    /**
     * 别人的答案
     * 哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
