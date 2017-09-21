package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 
 * 17.09.21
 * https://www.acmicpc.net/problem/1238
 * 갈때랑 올때 길이 다른 것을 이용해서 d[N][N]의 배열을 선언해야했다.
 * 시간복잡도는 O(N*VlogE)
 */


class Edge implements Comparable<Edge>{
	private int to;
	private int w;
	public Edge(int to, int w){
		this.to = to;
		this.w = w;
	}
	
	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return w-o.w;
	}
}

public class _170921_p1238 {
	public static final int MAX = 2000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		
		ArrayList<Edge> map[] = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++)map[i] = new ArrayList<>();
		for(int i=0;i<M;i++){
			int from = sc.nextInt();
			int to = sc.nextInt();
			int t = sc.nextInt();
			map[from].add(new Edge(to,t));
		}
		

		int d[][] = new int[N+1][N+1];
		for(int target=1;target<=N;target++){
			
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			for(int i=0;i<N+1;i++)d[target][i]=MAX;
			d[target][target] = 0;
			
			pq.add(new Edge(target,0));
			
			while(!pq.isEmpty()){
				Edge here = pq.poll();
				
				if(d[target][here.getTo()]<here.getW())
					continue;
				
				for(int i=0;i<map[here.getTo()].size();i++){
					Edge e = map[here.getTo()].get(i);
					if(here.getW()+e.getW()< d[target][e.getTo()]){
						d[target][e.getTo()] = here.getW()+e.getW();
						pq.add(new Edge(e.getTo(),here.getW()+e.getW()));
					}
				}
			}

		}
		int ans = -1;
		for(int i=1;i<=N;i++){
			if(d[i][X]+d[X][i]>ans)ans = d[i][X]+d[X][i];
		}
		System.out.println(ans);
	}

}
