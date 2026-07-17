class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
                
            } else if (c == '+' || c == '-') {
                // A sign is only valid at the very beginning,
                // or immediately after an exponent 'e' or 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                
            } else if (c == '.') {
                // A dot is invalid if we have already seen another dot 
                // or if we have already seen an exponent 'e'/'E'
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
                
            } else if (c == 'e' || c == 'E') {
                // An exponent is invalid if we have already seen an exponent,
                // or if we haven't seen a digit before it
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure there is a digit after the exponent
                
            } else {
                // Any other character is invalid
                return false;
            }
        }
        
        // The string must end with a digit (accounts for resetting seenDigit after 'e')
        return seenDigit;
    }
}
