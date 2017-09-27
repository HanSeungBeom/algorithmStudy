package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.27
 * https://www.acmicpc.net/problem/11057
 * DP문제. 자신보다 큰 숫자만 뒤에 올 수 있다는 점을 이용해서 점화식을 세웠다.
 */

public class _170927_p11057 {

	public static final int MOD = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[N + 1][10];

		for (int i = 0; i <10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j]%MOD + dp[i - 1][k]%MOD)%MOD;
				}

			}
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = (ans%MOD+dp[N][i]%MOD)%MOD;
		}
		System.out.println(ans);
	}

}
