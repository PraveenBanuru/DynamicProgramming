package edu.subsequence;

public class LongestCommonSubsequence {

	 static  int[][] mem = null;

		public static void main(String[] args) {
			String s1 = "ABCD";
			String s2 = "BACDBDCD";

			int n = s1.length();
			int m = s2.length();

			System.out.println("Recursive way :" + lcsRec(s1, s2, n, m));

			mem = new int[n + 1][m + 1];

			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					mem[i][j] = -1;
				}
			}
			System.out.println("Memoization way :" + lcsMem(s1, s2, n, m));
			
			System.out.println("TopDown way :" + lcsTopDown(s1, s2, n, m));
			
			System.out.println("Longest CommonSubstring :" + longestCommonSubstring(s1, s2, n, m));
		}

	 private static int longestCommonSubstring(String s1, String s2, int n, int m) {
			
		 
			int[][] dp = new int[n + 1][m + 1];

			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					
					if(i==0 || j==0)
					dp[i][j] = 0;
				}
			}
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						
					
						dp[i][j]=1+dp[i-1][j-1];
					}
					else
						dp[i][j]= 0;
					
				}
			}
			
			
			return dp[n][m];
		}

	static int lcsTopDown(String s1, String s2, int n, int m) {
		 
			int[][] dp = new int[n + 1][m + 1];

			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					
					if(i==0 || j==0)
					dp[i][j] = 0;
				}
			}
			
			
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						dp[i][j]=1+dp[i-1][j-1];
						
					}
					else
						dp[i][j]= Math.max(dp[i][j-1], dp[i-1][j]);
					
				}
			}
			
			System.out.println("Common Subsequence is :"+printLCS(dp,s1,s2));
			
			return dp[n][m];
		}

	

	private static String printLCS(int[][] dp,String s1,String s2) {
		
		String output="";
		int i=s1.length();
		int j=s2.length();
		while(i>0 && j>0) {
			
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				output=output+s1.charAt(i-1);
				i--;
				j--;
			}
			else {
				if(dp[i-1][j]>=dp[i][j-1])
					  i--;
				else
					j--;
			}

		}
		
		return output;
	}

	static int lcsMem(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		
		if(mem[n][m]==-1)
		{
			
			if (s1.charAt(n - 1) == s2.charAt(m - 1))

				mem[n][m]= 1 + lcsRec(s1, s2, n - 1, m - 1);
			else
				mem[n][m]= (Math.max(lcsRec(s1, s2, n - 1, m), lcsRec(s1, s2, n, m - 1)));
			
		}
		
		return mem[n][m];
		
	}

	static int lcsRec(String s1, String s2, int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		if (s1.charAt(n - 1) == s2.charAt(m - 1))

			return 1 + lcsRec(s1, s2, n - 1, m - 1);
		else
			return (Math.max(lcsRec(s1, s2, n - 1, m), lcsRec(s1, s2, n, m - 1)));

	}
//
}
