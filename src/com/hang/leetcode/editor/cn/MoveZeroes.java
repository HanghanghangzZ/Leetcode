//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1064 👎 0

package com.hang.leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            /* 1.自己的双指针解法 */
//            int pre = 0, next = 1;
//            while (next < nums.length) {
//                /* 定位到0所在的位置 */
//                while (nums[pre] != 0 && next < nums.length) {
//                    pre++;
//                    next++;
//                }
//                /* 定位到0将要移动到的位置 */
//                while (next < nums.length && nums[next] == 0) {
//                    next++;
//                }
//                if (next < nums.length) {
//                    int temp = nums[pre];
//                    nums[pre] = nums[next];
//                    nums[next] = temp;
//                    pre++;
//                    next++;
//                }
//            }

            /* 2. */
            int j = 0;      // j始终定位到非零元素将要前插的位置，也就是在数组最前的0的位置
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}