import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each letter (a-z) to its row index:
        // Row 1: q, w, e, r, t, y, u, i, o, p
        // Row 2: a, s, d, f, g, h, j, k, l
        // Row 3: z, x, c, v, b, n, m
        int[] rowMap = new int[26];
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        for (char c : r1.toCharArray()) rowMap[c - 'a'] = 1;
        for (char c : r2.toCharArray()) rowMap[c - 'a'] = 2;
        for (char c : r3.toCharArray()) rowMap[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isValid(word, rowMap)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean isValid(String word, int[] rowMap) {
        String lower = word.toLowerCase();
        int targetRow = rowMap[lower.charAt(0) - 'a'];

        for (int i = 1; i < lower.length(); i++) {
            if (rowMap[lower.charAt(i) - 'a'] != targetRow) {
                return false;
            }
        }

        return true;
    }
}
