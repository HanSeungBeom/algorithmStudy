package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.Scanner;
/* 
 * 17.09.29
 * https://www.acmicpc.net/problem/1965
 * LIS DP문제. 를 n^2 의 시간복잡도를 nlogn으로 풀었다.
 */
public class _170928_p1965 {
	public static final int MIN = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(MIN);
		int ans = 0;
		for(int i=0;i<N;i++){
			if(list.get(list.size()-1)<arr[i]){
				list.add(arr[i]);
				ans++;
			}
			else{
				//do lower_bound
				int low = 0;
				int high = list.size()-1;
				while(low<high){
					int mid = (low+high)/2;
					if(list.get(mid)<=arr[i]){
						low = mid+1;
					}
					else{
						high = mid;
					}
				}
				if(list.get(low-1)==arr[i])
					low--;
				list.set(low, arr[i]);
			}
		}
		System.out.println(ans);
	}

}
