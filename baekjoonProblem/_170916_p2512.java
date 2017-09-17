package algo.baekjoonProblem;

import java.util.Scanner;
/* 
 * 17.09.16
 * https://www.acmicpc.net/problem/2512
 * 처음에는 수학적으로 접근했었는데 이진탐색으로 쉽게 풀수가 있었다.
 * 시간복잡도는 O(logN)이다.
 */
public class _170916_p2512 {
	public static final int MAX = 100010;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		int biggest = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > biggest)
				biggest = arr[i];
		}
		int S = sc.nextInt();

		int ans = -1;

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		if (sum <= S) {
			ans = biggest;
		} else {

			int low = 0;
			int high = MAX;

			while (low < high) {
				sum = 0;
				int mid = (low + high+1) / 2; 
	
				for (int i = 0; i < N; i++) {
					if (arr[i] < mid) {
						sum += arr[i];
					} else {
						sum += mid;
					}
				}
				if (sum <= S) {
					if (mid > ans)
						ans = mid;

					low = mid;
				} else {
					high = mid - 1;
				}
			}
		}

		System.out.println(ans);

	}
}
