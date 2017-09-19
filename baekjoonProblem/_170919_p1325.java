package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 
 * 17.09.19
 * https://www.acmicpc.net/problem/1325
 * 큐에 넣을때 visit을 true하고 넣느냐 안하고 넣느냐가 굉장히 중요한 문제였다
 * true로 안해주고 while문에서 true를 검사할시 큐에 굉장히 불필요한 변수가 많이 들어간다.
 * 이걸 해결해주니깐 정답이 나왔다.
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
			map[ed].add(ing); //ed를 감염시키면 ing도 감염됨.
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
