// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

	public static void main(String args[]) {
				
			
			int[] arr = {3, 5, 8, 9, 10, 17, 17, 20};
			int n = 8;

			Solution ob = new Solution();
			System.out.println(ob.cutRod(arr, n));
		
	}
}

class Solution {
	public int cutRod(int price[], int n) {

		int len = price.length;
		int[][] dp = new int[len+1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < len + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i= 1; i < len + 1; i++) {
			for (int j = 1; j < n + 1; j++){

				if (j>=i)
					dp[i][j] = Math.max(price[i - 1] + dp[i][j-i], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j ];

			}
		}

		
// 		for (int i = 0; i < len+ 1; i++) {
// 			for (int j = 0; j < n + 1; j++) {
// 			  System.out.print(dp[i][j]+" ");	
// 			 }
// 			System.out.println();
// 			}
		return dp[len][n];
	}
}
