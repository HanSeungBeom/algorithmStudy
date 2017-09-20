package algo.baekjoonProblem;

import java.util.Arrays;
import java.util.Scanner;

/* 
 * 17.09.20
 * https://www.acmicpc.net/problem/7453
 * ���� ���� ���� ����� �߾��µ� ������ �̻��Ѱ����� ������.
 * 2^28�̶� �ƹ��������� long���پ˾Ҵµ� int��������.
 * ���� long���� ���������� �� �ϴ°����� �ð����⵵�� ũ�� �����Ѱ� ����.
 */


public class _170920_p7453 {
	public static int upper_bound(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;

		while (low < high) {
			int mid = (int) Math.ceil((double) (low + high) / 2);
			if (a[mid] <= key)
				low = mid;
			else
				high = mid - 1;
		}

		return (key == a[high])? high:-1;
	}

	public static int lower_bound(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;
			if (a[mid] >= key)
				high = mid;
			else
				low = mid + 1;
		}
		
		return (key == a[high])?high:-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[4][N];

		for (int i = 0; i < N; i++) {
			for (int index = 0; index < 4; index++) {
				arr[index][i] = sc.nextInt();
			}
		}
		
		int[] abTemp = new int[N*N];
		int[] cdTemp = new int[N*N];

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				abTemp[i*N+j]= arr[0][i] + arr[1][j];
				cdTemp[i*N+j]= arr[2][i] + arr[3][j];
			}
		}
	
		//Collections.sort(abTemp);
		Arrays.sort(cdTemp);
		
		long ans = 0;
		
		for(int i=0;i<N*N;i++){
			int searchNum = -abTemp[i];
			int upper = upper_bound(cdTemp, searchNum);
			int lower = lower_bound(cdTemp, searchNum);
			
			if(upper!=-1)
				ans += upper - lower + 1;		
		}
		
		System.out.println(ans);
	}

}
