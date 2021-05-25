//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2477 👎 0

package com.hang.leetcode.editor.cn;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* O(n ^ 2) 超时 */
//        public int maxArea(int[] height) {
//            int max = 0;
//            for (int left = 0; left < height.length - 1; left++) {
//                for (int right = left + 1; right < height.length; right++) {
//                    int curArea = (right - left) * Math.min(height[left], height[right]);
//                    max = Math.max(max, curArea);
//                }
//            }
//            return max;
//        }

        /* 左右夹逼，向中间收敛 */
        /* O(n) 从左右两个边界开始往中间收缩，即最开始的宽度是最大的，每次让较小的高度的一边往中间收缩，以期望能找到高度更高的与另一边的配合生成更大的面积 */
        public int maxArea(int[] height) {
            int max = 0;
            for (int left = 0, right = height.length - 1; left < right; ) {
                /* 每次都让较小的高度一边往中间收缩 */
                int minHeight = height[left] > height[right] ? height[right--] : height[left++];
                int curArea = (right - left + 1) * minHeight;
                max = Math.max(max, curArea);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}