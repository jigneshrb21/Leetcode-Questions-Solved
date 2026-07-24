class Solution 
{
    public String frequencySort(String s) 
    {
        Pair[] freq = new Pair[128];
        for(int i = 0; i < 128; i++)
        {
            freq[i]= new Pair(0, (char)(i));     
        
        }
        for(char ch : s.toCharArray())
        {
            freq[ch].freq++;
        }
        Arrays.sort(freq, (p1,p2) ->{
            if(p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.freq - p2.freq; 
        });
        StringBuilder ans = new StringBuilder();
        for( Pair p : freq)
            {
                while(p.freq > 0)
                {
                    ans.append(p.ch);
                    p.freq--;
                }
            }
        return ans.toString();
    }
    class Pair
    {
        int freq;
        char ch;
        Pair(int f, char c)
        {
            this.freq = f;
            this.ch = c;
        }
    }
}