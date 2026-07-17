class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        int n = s.length();
        
        // 1. Discard leading whitespaces
        while (i < n && s[i] == ' ') {
            i++;
        }
        
        // 2. Determine sign
        int sign = 1;
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }
        
        // 3. Convert digits and handle potential overflow
        int res = 0;
        while (i < n && isdigit(s[i])) {
            int digit = s[i] - '0';
            
            // Check for overflow before multiplying by 10 and adding the digit
            // INT_MAX is 2147483647 (ends in 7). INT_MIN is -2147483648 (ends in 8).
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && digit > INT_MAX % 10)) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }
            
            res = res * 10 + digit;
            i++;
        }
        
        return res * sign;
    }
};
