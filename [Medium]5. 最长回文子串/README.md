# 5. 最长回文子串

**#左右指针**

## Java
```Java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for (int i = 0 ; i < s.length() ; i ++) {
            String sub1 = palindrome(s, i, i);
            String sub2 = palindrome(s, i, i + 1);
            res = res.length() > sub1.length() ? res : sub1;
            res = res.length() > sub2.length() ? res : sub2;
        }

        return res;
    }

    // 在s中寻找以l和r为中心的最长回文串（l可以与r相等）
    private String palindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
        }
        return s.substring(l + 1, r);
    }
}
```