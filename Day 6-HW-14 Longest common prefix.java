class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start by assuming the first word is the common prefix
        String prefix = strs[0];
        
        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Shorten the prefix until the current string starts with it
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
