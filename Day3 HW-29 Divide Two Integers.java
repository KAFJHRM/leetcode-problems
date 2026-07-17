class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow condition
        // -2147483648 / -1 = 2147483648 (which overflows 32-bit signed integer)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // We expect negative if the signs of dividend and divisor are different
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both inputs to negative to avoid overflow when converting MIN_VALUE to positive
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int quotient = 0;

        // Since both are negative, we check if dividend is "less than or equal" to divisor
        // (i.e. more negative / larger absolute value)
        while (dividend <= divisor) {
            int tempDivisor = divisor;
            int numDoubles = 1;

            // Double the divisor until doubling it further would exceed the dividend.
            // We use bitwise left shift (<< 1) which is equivalent to multiplying by 2.
            // We must prevent overflow: tempDivisor cannot be less than Integer.MIN_VALUE / 2 (which is -1073741824)
            while (tempDivisor >= -1073741824 && (tempDivisor << 1) >= dividend) {
                tempDivisor <<= 1;
                numDoubles <<= 1;
            }

            // Subtract the scaled divisor and add the scaling factor to the quotient
            dividend -= tempDivisor;
            quotient += numDoubles;
        }

        return isNegative ? -quotient : quotient;
    }
}
