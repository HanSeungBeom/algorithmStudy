package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 
 * 17.09.19
 * https://www.acmicpc.net/problem/1325
 * ť�� ������ visit�� true�ϰ� �ִ��� ���ϰ� �ִ��İ� ������ �߿��� ��������
 * true�� �����ְ� while������ true�� �˻��ҽ� ť�� ������ ���ʿ��� ������ ���� ����.
 * �̰� �ذ����ִϱ� ������ ���Դ�.
 */

public class _170919_p1325 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[] map = new ArrayList[N+1];
		for(int i=0;i<N+1;i++)map[i] = new ArrayList<>();
		
		
		int count;
		int M = sc.nextInt();
		for(int i=0;i<M;i++){
			int ing = sc.nextInt();
			int ed = sc.nextInt();
			map[ed].add(ing); //ed�� ������Ű�� ing�� ������.
		}
		
		
		int biggest = -1;
		int countList[] = new int[N+1];
		for(int i=1;i<=N;i++){
			boolean[] visit = new boolean[N+1];
			count = 1;
			Queue<Integer> q = new LinkedList<>();
			visit[i] = true;
			q.add(i);
		
			while(!q.isEmpty()){
				int v = q.poll();

				for(int j=0;j<map[v].size();j++){
					int go = map[v].get(j);
					if(!visit[go]){
						visit[go] = true;
						q.add(go);	
						count++;
					}
				}
			}
			
			if(count>=biggest){
				biggest = count;
				countList[i] = count;
			}
		}
		
		
		for(int i=1;i<=N;i++){
			if(countList[i]==biggest)
				System.out.print(i+" ");
		}
		System.out.println("");
	}

}
