class Solution {
    public int maxScore(int[] cards, int k) {
        int n = cards.length;
        int lsum = 0;
        int maxsum = 0;
        for(int i = 0 ; i < k; i++){
            lsum += cards[i];
        }
        int i = k - 1;
        int r = n - 1;
        maxsum = lsum;
        while(i >=0){
            lsum = lsum - cards[i];
            lsum = lsum + cards[r];
            maxsum = Math.max(maxsum,lsum);
            r--;
            i--;
        }
        return maxsum;
    }
}