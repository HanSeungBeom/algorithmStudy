package algo.baekjoonProblem;

import java.util.Scanner;

//푼 날짜:17.09.10
//백준1064번
//분류 : 기하학
//코딩 문제보단 수학문제 같았다. "한직선에 있을 조건"을 다시 공부하게 될 좋은 문제였다. 
class Point{
	int x,y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public double getDistance(Point p){
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
	}
}

public class _170910_p1064 {
	public static final int MAX = 40000;
	public static boolean isSameLine(Point p1,Point p2,Point p3){
		//한 직선에 있을 조건 a,b,c 세 점이 있을 때
		// a-b 의 벡터는 a-c의 상수배라는 점을 이용해서 작성하였다.
		return ((p2.x-p1.x)*(p3.y-p1.y) == (p3.x-p1.x)*(p2.y-p1.y));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Point[] p = new Point[3];
		for(int i=0;i<3;i++){
			p[i] = new Point(sc.nextInt(),sc.nextInt());
		}
		
		double ans = 0;
		if(isSameLine(p[0], p[1], p[2])){
			ans = -1;
		}
		else{
			double minValue = -1;
			double maxValue = -1;
			double a = p[0].getDistance(p[1]);
			double b = p[0].getDistance(p[2]);
			double c = p[1].getDistance(p[2]);
			minValue = Math.min(a+b,Math.min(a+c,b+c));
			maxValue = Math.max(a+b,Math.max(a+c,b+c));
			ans = 2*(maxValue - minValue);
		}
		System.out.println(ans);
	}

}
