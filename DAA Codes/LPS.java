class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        
        int LPS[][] = new int[s.length() + 1][s.length() + 1];

        for(int i = 1; i <= s.length(); i ++)
        {
            for(int j = 1; j <= s.length(); j ++)
            {
                if(s.charAt(i - 1) == s1.charAt(j - 1))
                    LPS[i][j] = 1 + LPS[i - 1][j - 1];
                else
                    LPS[i][j] = Math.max(LPS[i - 1][j], LPS[i][j - 1]);
            }
        }

        return LPS[s.length()][s.length()];
    }
}