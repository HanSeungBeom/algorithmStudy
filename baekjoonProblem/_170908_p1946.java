package algo.baekjoonProblem;

import java.util.Arrays;
import java.util.Scanner;

//푼 날짜:17.09.08
//백준 1946번
//분류 : 정렬
//처음엔  O(n^2) 으로 풀었더니 시간초과가 났다. 하나를 정렬해놓고 나머지 하나에 대해 생각하니 O(nlogn)으로 풀 수 있었다.

class Volunteer implements Comparable<Volunteer>{
	int rankA,rankB;
	public Volunteer(){
		
	}
	public Volunteer(int rankA, int rankB) {
		this.rankA = rankA;
		this.rankB = rankB;
	}
	
	@Override
	public int compareTo(Volunteer arg0) {
		// TODO Auto-generated method stub
		return arg0.rankA- rankA;
	}
}

public class _170908_p1946 {

	public static final int MAX = 100002;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++){
			
			int N = sc.nextInt();
			Volunteer[] vols = new Volunteer[N];
			for(int i=0;i<N;i++){
				int scoreA = sc.nextInt();
				int scoreB = sc.nextInt();
				vols[i] = new Volunteer(scoreA, scoreB);
			}
			
			Arrays.sort(vols);
			
			int ans = 0;
			int minValue = MAX;
			for(int i=N-1;i>=0;i--){
				if(vols[i].rankB<minValue){
					minValue = vols[i].rankB;
					ans++;
				}
			}
			
			System.out.println(ans);
		}
	}

}
