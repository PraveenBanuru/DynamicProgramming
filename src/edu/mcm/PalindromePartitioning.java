package edu.mcm;

public class PalindromePartitioning {

	/*
	 * Given a string, a partitioning of the string is a palindrome partitioning if
	 * every substring of the partition is a palindrome. For example,
	 * “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
	 * Determine the fewest cuts needed for a palindrome partitioning of a given
	 * string. For example, minimum of 3 cuts are needed for “ababbbabbababa”. The
	 * three cuts are “a|babbbab|b|ababa”. If a string is a palindrome, then minimum
	 * 0 cuts are needed. If a string of length n containing all different
	 * characters, then minimum n-1 cuts are needed.
	 */

	static int[][] mem = null;

	public static void main(String[] args) {

		String s = "abcde";
		int n = s.length();

		mem = new int[100][100];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				mem[i][j] = -1;
			}
		}

		System.out.println("Minimum number of partitions is " + partitionsRec(s, 0, n - 1));
		System.out.println("Minimum number of partitions memoized way is " + partitionsMem(s, 0, n - 1));

	}

	private static int partitionsMem(String s, int i, int j) {
		if (i >= j)
			return 0;
		if (isPalindrome(s, i, j))
			return 0;

		if (mem[i][j] != -1)
			return mem[i][j];

		int min = Integer.MAX_VALUE - 1;

		for (int k = i; k < j; k++) {

//			int temp = partitionsMem(s, i, k) + partitionsMem(s, k + 1, j) + 1;
			/* More optimized way */

			int left;
			if (mem[i][k] != -1)
				left = mem[i][k];
			else
				left = partitionsMem(s, i, k);

			int right;
			if (mem[k + 1][j] != -1)
				right = mem[k + 1][j];
			else
				right = partitionsMem(s, k + 1, j);

			int temp = left + right + 1;

			min = Math.min(min, temp);

			mem[i][j] = min;
		}

		return mem[i][j];
	}

	static int partitionsRec(String s, int i, int j) {
		if (i >= j)
			return 0;
		if (isPalindrome(s, i, j))
			return 0;
		int min = Integer.MAX_VALUE - 1;

		for (int k = i; k < j; k++) {
			int temp = partitionsRec(s, i, k) + partitionsRec(s, k + 1, j) + 1;

			// System.out.println(temp);
			min = Math.min(min, temp);
		}

		return min;
	}

	static boolean isPalindrome(String s, int i, int j) {

		if (i == j)
			return true;

		while (i <= j) {

			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;

			}

			else
				return false;

		}

		return true;
	}

}
