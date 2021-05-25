### 解题思路
判断回文一般都是用双指针算法。这题和其他题不同的是有多余空或者符号，我们只要去掉这些多余空格和符号就行，再进行判断。

### 代码

```java
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;  //初始化
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))    //去掉左边非字母 
                ++l;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))    //去掉右边非字母 
                --r;
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) //都转换成小写比较
                    return false;
                ++l;
                --r;
            }
        }
        return true;
    }
}
```
### 复杂度分析
- 时间复杂度：O(n)
- 空间复杂度：O(1)