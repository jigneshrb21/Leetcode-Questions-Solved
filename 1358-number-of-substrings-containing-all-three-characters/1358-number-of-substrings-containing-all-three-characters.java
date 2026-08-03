class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        int[] hash = {-1, -1, -1};

        for (int i = 0; i < n; i++) {
            hash[s.charAt(i) - 'a'] = i;

            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1) {
                int minw = Math.min(hash[0], Math.min(hash[1], hash[2]));
                cnt += minw + 1;
            }
        }

        return cnt;
    }
}