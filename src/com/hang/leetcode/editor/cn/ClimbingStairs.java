//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1664 👎 0

package com.hang.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            /* 走大于3阶的台阶时，我们可以把它往走小于等于3阶时分解，因为小于等于3阶时是已知的，分别为走1阶和走两阶的分支 */
            /* 直接使用递归的话，时间复杂度为O(2 ^ n)，时间复杂度过高，会超时，所以要转换成迭代的形式 */
            /* 并且我们也可以直接发现它与求斐波那契数列是一样的 */
//            return climbStairs(n - 1) + climbStairs(n - 2);
            int f1 = 1, f2 = 2, ret = 0;
            for (int i = 3; i <= n; i++) {
                ret = f1 + f2;
                f1 = f2;
                f2 = ret;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}