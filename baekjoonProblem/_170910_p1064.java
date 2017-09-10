package algo.baekjoonProblem;

import java.util.Scanner;

//Ǭ ��¥:17.09.10
//����1064��
//�з� : ������
//�ڵ� �������� ���й��� ���Ҵ�. "�������� ���� ����"�� �ٽ� �����ϰ� �� ���� ��������. 
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
		//�� ������ ���� ���� a,b,c �� ���� ���� ��
		// a-b �� ���ʹ� a-c�� ������� ���� �̿��ؼ� �ۼ��Ͽ���.
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
