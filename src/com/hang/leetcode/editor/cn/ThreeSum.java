//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3366 👎 0

package com.hang.leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /* 1.暴力解法，未去除重复解 */
//            ArrayList<List<Integer>> ret = new ArrayList<>();
//            for (int i = 0; i < nums.length - 2; i++) {
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0) {
//                            ArrayList<Integer> list = new ArrayList<>();
//                            list.add(nums[i]);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            ret.add(list);
//                        }
//                    }
//                }
//            }
//            return ret;

            /* 2.HashMap，未去除重复元素 */
//            HashMap<Integer, Integer> map = new HashMap<>();
//            ArrayList<List<Integer>> ret = new ArrayList<>();
//            for (int i = 0; i < nums.length - 1; i++) {
//                if (map.containsKey(nums[i])) {
//                    continue;
//                }
//                map.put(nums[i], i);
//                for (int j = i + 1; j < nums.length; j++) {
//                    map.put(nums[j], j);
//                    int key = -(nums[i] + nums[j]);
//                    if (map.containsKey(key) && map.get(key) != i && map.get(key) != j) {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(key);
//                        ret.add(list);
//                    }
//                }
//            }
//            return ret;

            /* 排序 + 双指针 */
            Arrays.sort(nums);
            ArrayList<List<Integer>> ret = new ArrayList<>();
            for (int k = 0; k < nums.length - 1; k++) {
                /* 已经将nums升序排列，所以只要nums[k]>0了，那么它右边的所有数都>0，不可能找到某个三元组其和等于0 */
                if (nums[k] > 0) {
                    break;
                }
                /* 当前k定位的数在之前已经判断过能否与其它的元素组成和为0的三元组，所以不再进行判断 */
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        /* 需要更大的数来凑0 */
                        while (i < j && nums[i] == nums[++i]) ;
                    } else if (sum > 0) {
                        /* 需要更小的数来凑0 */
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        ret.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        /* 已经找到包含nums[k]且和为0的三元组，将i和j分别后移和前移并跳过重复的数，防止重复项 */
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}