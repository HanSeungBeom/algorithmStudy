package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * 17.09.18
 * https://www.acmicpc.net/problem/7452
 * 시간복잡도를 줄이는 것이 문제다.
 * 현재는 O(N^4)을 O(N^3)까지 줄였는데 정답을 내려면 O(N^2logN)이 되어야 한다. 내일다시 풀기
 */


class Number implements Comparable<Number>{
	long value;
	int count;

	public Number(long value) {
		this.value = value;
		count = 1;
	}

	public void add() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public long getValue() {
		return value;
	}

	@Override
	public int compareTo(Number o) {
		// TODO Auto-generated method stub
		return (value-o.value)>0?1:-1;
	}

	
}

public class _170918_p7453 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] arr = new long[4][N];

		for (int i = 0; i < N; i++) {
			for (int index = 0; index < 4; index++) {
				arr[index][i] = sc.nextLong();
			}
		}

		ArrayList<Number> ab, cd;
		ab = new ArrayList<>();
		cd = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long value = arr[0][i] + arr[1][j];
				
				int index = -1;
				for (int k = 0; k < ab.size(); k++) {
					if (ab.get(k).getValue() == value) {
						index = k;
						break;
					}
				}
				if (index == -1)
					ab.add(new Number(value));
				else
					ab.get(index).add();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long value = arr[2][i] + arr[3][j];
				int index = -1;
				for (int k = 0; k < cd.size(); k++) {
					if (cd.get(k).getValue() == value) {
						index = k;
						break;
					}
				}
				if (index == -1)
					cd.add(new Number(value));
				else
					cd.get(index).add();
			}
		}
	
		int ans = 0;

		for (int i = 0; i < ab.size(); i++) {
			for (int j = 0; j < cd.size(); j++) {
				long sum = ab.get(i).getValue() + cd.get(j).getValue();
				if (sum == 0) {
					ans += ab.get(i).getCount() * cd.get(j).getCount();
				}
			}
		}
		System.out.println(ans);
	}

}
