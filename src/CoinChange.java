
public class CoinChange {

	public static void main(String args[]) {

		int[] arr = { 1,2,3 };
		int n = 5;

		
		System.out.println(coinChange(arr, n));

	}

	public static int coinChange(int coin[], int n) {
		
		
		int len = coin.length;
		int[][] dp = new int[len+1][n + 1];

		for (int i = 0; i < len+ 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if ( i == 0)
					dp[i][j] = 0;
			
				if ( j == 0)
					dp[i][j] = 1;
			}	
		}
		
		for (int i= 1; i < len + 1; i++) {
			for (int j = 1; j < n + 1; j++){
		
				if(coin[i-1] <= j)
					dp[i][j]= dp[i][j-coin[i-1]]+dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j];
					
			}
		}
		
		
		for (int i= 0; i < len + 1; i++) {
			for (int j = 0; j < n + 1; j++){
				
				  System.out.print(dp[i][j]+" ");	
			 }
			System.out.println();
			}
		return dp[len][n];
	}
	
	
	}