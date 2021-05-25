//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 383 👎 0

package com.hang.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.equals("")) {
                return false;
            }

            int pre = 0, next = s.length() - 1;
            while (pre < next) {
                while (pre < next && !isLetterOrDigit(s.charAt(pre))) {
                    pre++;
                }
                while (pre < next && !isLetterOrDigit(s.charAt(next))) {
                    next--;
                }
                if (pre < next) {
                    if (!ignoreLetterCase(s.charAt(pre), s.charAt(next))) {
                        return false;
                    }
                    pre++;
                    next--;
                }
            }
            return true;
        }

        public boolean isLetterOrDigit(char ch) {
            return (ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90) || (ch >= '0' && ch <= '9');
        }

        public boolean ignoreLetterCase(char ch1, char ch2) {
            ch1 = ch1 >= 97 ? (char) (ch1 - 32) : ch1;
            ch2 = ch2 >= 97 ? (char) (ch2 - 32) : ch2;
            return ch1 == ch2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}