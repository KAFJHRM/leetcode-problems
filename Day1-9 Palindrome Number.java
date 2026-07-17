class Solution {
public:
    bool isPalindrome(int x) {
        // Edge cases:
        // 1. Negative numbers are not palindromes (e.g., -121 reads as 121- from right to left)
        // 2. If the last digit is 0, the first digit must also be 0 for it to be a palindrome.
        //    Only 0 itself satisfies this.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse only the second half of the number to prevent integer overflow
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers (e.g., 1221), x == reversedHalf (12 == 12)
        // For odd-length numbers (e.g., 12321), we can get rid of the middle digit by reversedHalf/10
        // (x == 12, reversedHalf == 123 -> 123/10 = 12)
        return x == reversedHalf || x == reversedHalf / 10;
    }
};
