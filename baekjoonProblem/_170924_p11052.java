package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.24
 * https://www.acmicpc.net/problem/11052
 * 동전개수 dp무네와 유사하다.
 */
public class _170924_p11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		for(int i=1;i<=N;i++){
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(i+j<=N)
					dp[i+j] = Math.max(dp[i+j],dp[i]+arr[j]);
			}
		}
		System.out.println(dp[N]);
	}

}
