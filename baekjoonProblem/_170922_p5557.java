package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.22
 * https://www.acmicpc.net/problem/5557
 * ó���� DFS�� Ǯ�� �߾��µ� �׷��� �ϸ� �ð����⵵�� 2^100�� �ǹ��ȴ�.
 * DP�� Ǫ�� O(N^2) �� Ǯ �� �־���. 
 * dp[i][j] �� 0~i ���� j�� ����� ����� ��
 */
public class _170922_p5557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		long[][] dp = new long[N][21];
		
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		
		long ans = 0;

		dp[0][arr[0]]=1;
		
		for(int i=0;i<N-1;i++){
			for(int j=0;j<=20;j++){
				if(0<=j+arr[i+1] && j+arr[i+1]<=20)
					dp[i+1][j+arr[i+1]] += dp[i][j];
				if(0<=j-arr[i+1] && j-arr[i+1]<=20)
					dp[i+1][j-arr[i+1]] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-2][arr[N-1]]);
	}

}
