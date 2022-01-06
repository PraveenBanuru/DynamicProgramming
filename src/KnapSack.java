
public class KnapSack {

	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 40;
		int n = val.length;
		System.out.print(knapSackTopDown(W, wt, val));
	}

	static int knapSack(int W, int wt[], int val[], int N) {
		int dp[][] = new int[N + 1][W + 1];

		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < W + 1; j++)
				dp[i][j] = -1;

		return knapSackRec(W, wt, val, N, dp);

	}

	private static int knapSackRec(int W, int[] wt, int[] val, int N, int[][] dp) {

		if (N == 0 || W == 0)
			return 0;

		if (dp[N][W] != -1)
			return dp[N][W];

		if (wt[N - 1] <= W) {

			dp[N][W] = Math.max(val[N - 1] + knapSackRec(W - wt[N - 1], wt, val, N - 1, dp),
					knapSackRec(W, wt, val, N - 1, dp));

		}

		else {
			dp[N][W] = knapSackRec(W, wt, val, N - 1, dp);
		}

		return dp[N][W];
	}

	// knapsack TopDown approach
	static int knapSackTopDown(int W, int[] wt, int[] val) {

		int N = wt.length;
		int[][] dp = new int[W + 1][N + 1];

		for (int i = 0; i < W + 1; i++) {
			for (int j = 0; j < N + 1; j++) {

				if (i == 0 || j == 0)
					dp[i][j] = 0;

			}
		}

		for (int i = 1; i < W + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (wt[j - 1] <= i) {
					dp[i][j] = Math.max(val[j - 1] + dp[i - wt[j - 1]][j - 1], dp[i ][j - 1]);
				}
				else
					dp[i][j] = dp[i ][j - 1];

			}

		}
		return dp[W][N];

	}

}
