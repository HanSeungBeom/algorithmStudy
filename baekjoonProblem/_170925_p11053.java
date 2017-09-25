package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.25
 * https://www.acmicpc.net/problem/11053
 * DP 문제다. LIS 복습.
 */

public class _170925_p11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++)
			arr[i] = sc.nextInt();
		
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i=1;i<N;i++){
			int bigDp = -1;
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j]){
					if(dp[j]>bigDp){
						bigDp = dp[j];
					}
				}
			}
			if(bigDp == -1)
				dp[i] = 1;
			else
				dp[i] = bigDp+1;
		}
		
		int ans =-1;
		for(int i=0;i<N;i++){
			if(dp[i]>ans)ans = dp[i];
		}
		System.out.println(ans);
		
		
	}

}
