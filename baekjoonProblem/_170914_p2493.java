package algo.baekjoonProblem;

import java.util.Scanner;

/* 
 * 17.09.14
 * https://www.acmicpc.net/problem/2493
 * memoization �� �̿��ؼ� ������ �ߴµ� , ���� �� ����ȭ�� �ʿ��� �� ����. 
 * �־��� ��쿣 O(N^2)�� �ɸ��� �ȴ�. N�� 50���̹Ƿ� O(NlogN)�� �ع��� �ʿ��� �� ����.
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
