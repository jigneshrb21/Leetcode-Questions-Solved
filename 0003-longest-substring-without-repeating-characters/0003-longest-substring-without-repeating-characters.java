class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n  = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0; 
        int right = 0;
        int maxlen = 0;
        while(right < n){
            if(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(right)) >= left){
                    left = map.get(s.charAt(right)) + 1;
                }
            }
            map.put(s.charAt(right),right);
            int len = right - left + 1;
            maxlen = Math.max(maxlen,len);
            right++;
        }
        return maxlen;

    }
}