package algo.baekjoonProblem;

import java.util.Scanner;

//푼 날짜:17.09.11
//백준3085번
//분류 : 완전탐색
// 양옆만 바꾸는 경우를 생각했지, 위아래 바꾸는 경우는 생각하지 못했다.이 부분에서 시간을 많이 썼다.
public class _170911_p3085 {
	static char[][] map;
	static int N;
	
	public static int getValueIJ(int i,int j){
		char target = map[i][j];
		//search vertical
		int verLen = 1;
		int pos = i-1;
		while(pos>=0){
			if(map[pos][j]==target){
				pos--;
				verLen++;
			}
			else{
				break;
			}
		}
		pos = i+1;
		while(pos<N){
			if(map[pos][j]==target){
				pos++;
				verLen++;
			}
			else{
				break;
			}
		}
		
		//search horizontal
		int horLen = 1;
		pos = j-1;
		while(pos>=0){
			if(map[i][pos]==target){
				pos--;
				horLen++;
			}
			else{
				break;
			}
		}
		pos = j+1;
		while(pos<N){
			if(map[i][pos]==target){
				pos++;
				horLen++;
			}
			else{
				break;
			}
		}

		return Math.max(verLen, horLen);
	}
	public static int getMaxLength() {
		// map에서 가장 긴 연속된 문자열을 찾는다.
		int maxVal = -1;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				maxVal = Math.max(maxVal,getValueIJ(i, j));
			}
		}
		return maxVal;	
	}

	public static void showMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		
		int ans = 0;
		sc.nextLine();
		for(int i=0;i<N;i++){
			map[i] = sc.nextLine().toCharArray();
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				//좌우 변경
				if(j<N-1 && map[i][j]!=map[i][j+1]){
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					ans = Math.max(ans,getMaxLength());
					temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
				}
				
				//상하변경
				if(i<N-1 && map[i][j]!=map[i+1][j]){
					char temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
					ans = Math.max(ans,getMaxLength());
					temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
				}
			}
		}
		System.out.println(ans);
		
	}

}
