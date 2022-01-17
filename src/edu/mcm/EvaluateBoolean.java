package edu.mcm;

public class EvaluateBoolean {

	static int[][][] dp = null;
	public static void main(String[] args) {
		String s = "T|T&F^T";
		int n = s.length();
		
		dp = new int[100][100][2];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for(int q=0;q<2;q++)
				dp[i][j][q] = -1;
			}
		}

		System.out.println("Minimum number of ture evaluations  is " + evaluteRec(s, 0, n - 1, true));
		
		System.out.println("Minimum number of ture evaluations using Memoization  is " + evaluteMem(s, 0, n - 1, true));
	}

	 static int evaluteMem(String s, int i, int j, boolean isTrue) {
		 
		 
		 if (i == j) {
				if (isTrue) {
					if (s.charAt(i) == 'T')
						return 1;
					else
						return 0;
				}

				else {

					if (s.charAt(i) == 'F')
						return 1;
					else
						return 0;

				}

			}

			if (i > j)
				return 0;
			int q;
			if(isTrue)
				q=1;
			else 
				q=0;
			
			if(dp[i][j][q]!=-1)
				return dp[i][j][q];
			
			int temp = 0;
			for (int k = i + 1; k < j; k = k + 2) {

				int lT = evaluteMem(s, i, k - 1, true);
				int lF = evaluteMem(s, i, k - 1, false);

				int rT = evaluteMem(s, k + 1, j, true);
				int rF = evaluteMem(s, k + 1, j, false);

				if (s.charAt(k) == '^') {
					
					if(isTrue)
					temp  =temp+ lT * rF + rT * lF;
					else
						temp = temp+lF*rF+lT*rT;
				}

				else if (s.charAt(k) == '&') {
					if(isTrue)
					 temp  =temp+ lT * rT;
					else
						temp = temp+ lT*rF+rT*lF+lF*rF;
				} else if (s.charAt(k) == '|') {

					if(isTrue)
					temp  =temp+ lT * rF + lF * rT + lT * rT;
					else
						temp =temp+lF*rF;

				}
			}

			dp[i][j][q]=temp;
			return dp[i][j][q];
	}

	private static int evaluteRec(String s, int i, int j, boolean isTrue) {

		if (i == j) {
			if (isTrue) {
				if (s.charAt(i) == 'T')
					return 1;
				else
					return 0;
			}

			else {

				if (s.charAt(i) == 'F')
					return 1;
				else
					return 0;

			}

		}

		if (i > j)
			return 0;
		int temp = 0;
		for (int k = i + 1; k < j; k = k + 2) {
            
			int lT=0;
			if(dp[i][k-1][1]!=-1)
				lT=dp[i][k-1][1];
			else
			  lT = evaluteRec(s, i, k - 1, true);
			
			int lF=0;
			if(dp[i][k-1][0]!=-1)
				lF=dp[i][k-1][0];	
			else
			 lF = evaluteRec(s, i, k - 1, false);

			
			int rT=0;
			if(dp[k+1][j][1]!=-1)
				rT=dp[k+1][j][1];
			else
			 rT = evaluteRec(s, k + 1, j, true);
			
			int rF=0;
			if(dp[k+1][j][0]!=-1)
				rT=dp[k+1][j][0];
			else
			 rF = evaluteRec(s, k + 1, j, false);

			if (s.charAt(k) == '^') {
				
				if(isTrue)
				temp  =temp+ lT * rF + rT * lF;
				else
					temp = temp+lF*rF+lT*rT;
			}

			else if (s.charAt(k) == '&') {
				if(isTrue)
				 temp  =temp+ lT * rT;
				else
					temp = temp+ lT*rF+rT*lF+lF*rF;
			} else if (s.charAt(k) == '|') {

				if(isTrue)
				temp  =temp+ lT * rF + lF * rT + lT * rT;
				else
					temp =temp+lF*rF;

			}
		}

		return temp;
	}

}
