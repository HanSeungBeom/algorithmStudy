package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.22
 * https://www.acmicpc.net/problem/10844
 * �������� DP ����.
 * ��ⷯ ��꿡�� �����÷ο찡 �߻����� �ʰ� (a%modN + b%modN)%modN ���ִ� ���� �߿��ߴ�.
 */

public class _170923_p10844 {
	public static final int MOD = 10_0000_0000;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int dp[][] = new int[N+1][10];
		
		for(int i=1;i<=9;i++){
			dp[1][i] = 1;
		}
		for(int i=2;i<=N;i++){
			for(int j=0;j<=9;j++){
				if(j-1>=0)
					dp[i][j] = (dp[i][j]%MOD+dp[i-1][j-1]%MOD)%MOD;
				if(j+1<=9)
					dp[i][j] = (dp[i][j]%MOD+dp[i-1][j+1]%MOD)%MOD;
			}
		}
		int ans = 0;
		for(int i=0;i<=9;i++){
			ans = (ans%MOD + dp[N][i]%MOD)%MOD;
		}
		System.out.println(ans);
	}
}
