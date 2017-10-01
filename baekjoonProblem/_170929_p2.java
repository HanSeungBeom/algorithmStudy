package algo.baekjoonProblem;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
 
/* 
 * 17.09.29
 * codeMonster LG CNS 2번문제.
 * DP문제. O(N^2)으로 해결하였다.
 */
public class _170929_p2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = new PrintWriter("output.txt");
 
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input.txt"));
		int T =Integer.parseInt(sc.nextLine());
		
		for(int t=1;t<=T;t++){
			int N = Integer.parseInt(sc.nextLine());
			char map[][] = new char[N+2][N+2];
			for(int i=1;i<=N;i++){
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for(int j=1;j<=N;j++){
					map[i][j] = (st.nextToken().equals("_"))?'_':'B';
				}
			}
			
			int goDp[][] = new int[N+2][N+2];
			int backDp[][] = new int[N+2][N+2];
			for(int j=1;j<=N;j++){
				for(int i=N;i>=1;i--){
					goDp[i][j] = Math.max(goDp[i][j-1], goDp[i+1][j]);
					if(map[i][j]=='B')goDp[i][j]++;
				}
			}
			for(int j=N;j>=1;j--){
				for(int i=N;i>=1;i--){
					backDp[i][j] = Math.max(backDp[i][j+1], backDp[i+1][j]);
					if(map[i][j]=='B')backDp[i][j]++;
				}
			}
			
			int ans = 0;
			for(int i=1;i<N;i++){
				for(int j=1;j<=N;j++){
					int totalBob = goDp[i][j]+backDp[i][j+1];
					if(totalBob>ans){
						ans = totalBob;
					}
				}
			}
			System.out.println(ans);
			out.println(ans);
		}
		
		out.close();
	}

}
