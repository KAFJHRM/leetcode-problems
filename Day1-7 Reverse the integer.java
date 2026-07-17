class Solution {
public:
    int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            // Check for positive overflow:
            // INT_MAX is 2147483647. If rev > INT_MAX/10, multiplying by 10 will overflow.
            // If rev == INT_MAX/10, adding any digit greater than 7 will overflow.
            if (rev > INT_MAX / 10 || (rev == INT_MAX / 10 && pop > 7)) {
                return 0;
            }
            
            // Check for negative overflow:
            // INT_MIN is -2147483648. If rev < INT_MIN/10, multiplying by 10 will underflow.
            // If rev == INT_MIN/10, adding any digit less than -8 will underflow.
            if (rev < INT_MIN / 10 || (rev == INT_MIN / 10 && pop < -8)) {
                return 0;
            }
            
            rev = rev * 10 + pop;
        }
        return rev;
    }
};
