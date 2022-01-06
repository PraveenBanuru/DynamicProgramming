
public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 6, 8, 10 };
		int n = 1;

		System.out.println(subtSetSum(arr, n));

		System.out.println(subtSetSumCount(arr, n));

	}

	// Find no of Subset of given sum from the given array
	private static int subtSetSum(int[] arr, int sum) {

		int len = arr.length;
		int[][] dp = new int[len + 1][sum + 1];

		for (int i = 0; i < len + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					dp[i][j] = 0;

				if (j == 0)
					dp[i][j] = 1;
			}
		}
		for (int i = 1; i < len + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];

			}
		}

//		for (int i= 0; i < len + 1; i++) {
//			for (int j = 0; j < sum + 1; j++){
//				
//				  System.out.print(dp[i][j]+" ");	
//			 }
//			System.out.println();
//			}
		return dp[len][sum];
	}

	// Find if we can form a subset of given sum from array
	private static boolean subtSetSumCount(int[] arr, int sum) {
		int len = arr.length;
		boolean[][] dp = new boolean[len + 1][sum + 1];

		for (int i = 0; i < len + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					dp[i][j] = false;

				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i < len + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];

			}
		}
		for (int i = 0; i < len + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {

				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[len][sum];
	}

}
