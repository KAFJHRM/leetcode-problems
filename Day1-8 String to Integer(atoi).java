class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int n = s.length();
        
        // 1. Discard leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If the string was entirely whitespaces
        if (i == n) {
            return 0;
        }
        
        // 2. Check for sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // 3. Read digits and handle overflow
        int res = 0;
        while (i < n) {
            char curr = s.charAt(i);
            
            // Stop at the first non-digit character
            if (curr < '0' || curr > '9') {
                break;
            }
            
            int digit = curr - '0';
            
            // Check for overflow before multiplying
            // Integer.MAX_VALUE is 2147483647
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res = res * 10 + digit;
            i++;
        }
        
        return res * sign;
    }
}
