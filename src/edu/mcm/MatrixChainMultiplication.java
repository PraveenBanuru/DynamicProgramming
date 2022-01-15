package edu.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {

	
	static int[][] dp=new int[100][100];
	public static void main(String[] args) {

		int arr[] = new int[]  {10, 20, 30, 40, 30} ;
		int n = arr.length;
		
		
		for (int[] row : dp) 
		      Arrays.fill(row, -1);
		

		System.out.println("Minimum number of multiplications is " + mcm(arr, 1, n-1));
		System.out.println("Minimum number of multiplications memoized way is " + mcmMemo(arr, 1, n-1));
	}

	static int  mcmMemo(int[] arr, int i, int j) {
	int min =Integer.MAX_VALUE;
		
		if(i>=j)
			return 0;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		for(int k=i;k<=j-1;k++) {
			
			int temp = mcm(arr,i,k)+mcm(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
			
			if(temp<min) {
				min=temp;
			}
			
		}
		
		dp[i][j]=min;
		return dp[i][j];
	}

	static int mcm(int[] arr, int i, int j) {

		int min =Integer.MAX_VALUE;
		
		if(i>=j)
			return 0;
		
		for(int k=i;k<=j-1;k++) {
			
			int temp = mcm(arr,i,k)+mcm(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
			
			if(temp<min) {
				min=temp;
			}
			
		}
		
		
		return min;
	}
}
