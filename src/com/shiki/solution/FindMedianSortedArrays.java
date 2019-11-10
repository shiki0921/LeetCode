package com.shiki.solution;

/**
 * 寻找两个有序数组的中位数
 * @author shiki
 * @date 2019/11/10 - 22:46
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 思路：归并排序，算法复杂度O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int m = 0,n = 0,i = 0;
        while(m < nums1.length && n < nums2.length){
            arr[i++] = nums1[m] < nums2[n] ? nums1[m++] : nums2[n++];
        }
        while (m < nums1.length){
            arr[i++] = nums1[m++];
        }
        while (n < nums2.length){
            arr[i++] = nums2[n++];
        }
        return arr.length % 2 == 0 ? (double)(arr[arr.length/2-1]+arr[arr.length/2])/2 : arr[(arr.length-1)/2];
    }
}
