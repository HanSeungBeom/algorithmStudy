package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.22
 * https://www.acmicpc.net/problem/5557
 * 처음엔 DFS로 풀려 했었는데 그렇게 하면 시간복잡도가 2^100이 되버렸다.
 * DP로 푸니 O(N^2) 에 풀 수 있었다. 
 * dp[i][j] 는 0~i 까지 j를 만드는 경우의 수
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
