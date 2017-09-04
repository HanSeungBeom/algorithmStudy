package algo.baekjoonProblem;

import java.util.Scanner;

//백준 1010번
//분류 : 다이나믹 프로그래밍
//점화식으로 for문 돌렸을 때 진행 방향을 생각해보는 것이 중요했음.

public class p1010 {
	
	public static final int MAXVALUE = 30;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[][] c = new int[MAXVALUE][MAXVALUE];
		for(int j=0;j<MAXVALUE;j++){
			for(int i=1;i<MAXVALUE;i++){
				if(j==0 || i==j){
					c[i][j] = 1;
				}
				else{
					c[i][j] = c[i-1][j]+c[i-1][j-1];
				}
			}
		}
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(c[M][N]);
		}
	}

}
