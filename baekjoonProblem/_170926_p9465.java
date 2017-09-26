package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.26
 * https://www.acmicpc.net/problem/9465
 * DP문제. 점화식을 잘 세우는 것이 중요.
 */

public class _170926_p9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int N = sc.nextInt();
			int map[][] = new int[N][2];
			for(int i=0;i<N;i++)
				map[i][0] = sc.nextInt();
			for(int i=0;i<N;i++)
				map[i][1] = sc.nextInt();
			
			int dp[][] = new int[N+1][2];
			
			dp[1][0] = map[0][0];
			dp[1][1] = map[0][1];
			
			for(int i=1;i<N;i++){
				dp[i+1][0] = Math.max(dp[i][1],Math.max(dp[i-1][0], dp[i-1][1]))+map[i][0];
				dp[i+1][1] = Math.max(dp[i][0],Math.max(dp[i-1][0], dp[i-1][1]))+map[i][1]; 
			}
			System.out.println(Math.max(dp[N][0], dp[N][1]));
		}
	}

}
