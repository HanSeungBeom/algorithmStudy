package algo.baekjoonProblem;

import java.util.Scanner;

//Ǭ ��¥:17.09.11
//����3085��
//�з� : ����Ž��
// �翷�� �ٲٴ� ��츦 ��������, ���Ʒ� �ٲٴ� ���� �������� ���ߴ�.�� �κп��� �ð��� ���� ���.
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
		// map���� ���� �� ���ӵ� ���ڿ��� ã�´�.
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
				//�¿� ����
				if(j<N-1 && map[i][j]!=map[i][j+1]){
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					ans = Math.max(ans,getMaxLength());
					temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
				}
				
				//���Ϻ���
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
