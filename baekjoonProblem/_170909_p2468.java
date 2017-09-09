package algo.baekjoonProblem;

import java.util.Scanner;

//푼 날짜:17.09.09
//백준2468번
//분류 : dfs
//무난한 문제였다. 이런 문제가 되게 자주 나오는 것 같다.

public class _170909_p2468 {

	public static final int MAX = 200;
	
	static int N;
	static boolean[][] check;
	static int[][] map;
	
	static int px[] = {-1,0,0,1};
	static int py[] = {0,1,-1,0};
	
	public static void dfs(int i, int j){
		check[i][j] = true;
		for(int p=0;p<4;p++){
			int x_ = j+px[p];
			int y_ = i+py[p];
			
			if(0<=x_ && x_<N && 0<=y_ && y_<N){
				if(!check[y_][x_])dfs(y_,x_);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ans = 1;
		int min = MAX;
		map = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]<min)min = map[i][j];
			}
		}
		
		for(int h=min;h<MAX;h++){
			int count = 0 ;
			check = new boolean[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j] <= h){
						check[i][j] = true;
					}
				}
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!check[i][j]){
						count++;
						dfs(i,j);
					}
				}
			}
			if(count>ans)ans = count;
		}
		System.out.println(ans);
		
	}

}
