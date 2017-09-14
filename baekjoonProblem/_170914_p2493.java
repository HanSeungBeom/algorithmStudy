package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.14
 * https://www.acmicpc.net/problem/2493
 * memoization 을 이용해서 구현을 했는데 , 조금 더 최적화가 필요할 것 같다. 
 * 최악의 경우엔 O(N^2)이 걸리게 된다. N이 50만이므로 O(NlogN)의 해법이 필요한 것 같다.
 */
public class _170914_p2493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		int p[] = new int[N+1];
		
		for(int i=1;i<=N;i++){
			arr[i] = sc.nextInt();
			p[i] = 0;
		}

		for(int i=1;i<=N;i++){
			int nextP = i-1;
			while(nextP>0){
				if(arr[nextP]>=arr[i]){
					p[i] = nextP;
					break;
				}
				else{
					if(nextP!=0)
						nextP = p[nextP];
					else{
						p[i] = 0;
						break;
					}
				}
			}
		}

		for(int i=1;i<=N;i++){
			System.out.print(p[i]+" ");
		}
		System.out.println("");
	}

}
