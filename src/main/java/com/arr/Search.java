package com.arr;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                l = mid;
                break;
            }
            if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        int count = 0;
        r = l + 1;
        while(r < n && r > -1 && nums[r] == target) {
            count++;
            r++;
        }
        while(l > -1 && l < n && nums[l] == target) {
            count++;
            l--;
        }
        return count;
    }

    public static void main(String[] args) {
        Search obj = new Search();
        System.out.println(obj.search(new int[]{}, 0));
        System.out.println(obj.search(new int[]{5,7,8,8,8,10}, 8));
        System.out.println(obj.search(new int[]{5,7,7,8,8,10}, 6));
    }
}
