package algo.baekjoonProblem;

import java.util.Scanner;

//푼 날짜:17.09.12
//백준 1057번
//분류 : 다음진출자를 구하는데 올림(Math.ceil)으로 구하는 방식을 사용했다.
//
public class _170912_p1057 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int round = 1;
		
		while(N!=1){
			p1 =(int)Math.ceil((double)p1/2);
			p2 =(int)Math.ceil((double)p2/2);
			if(p1 == p2)
				break;
			
			round++;
			N = (int)Math.ceil((double)N/2);
		}
		System.out.println(round);
	}
}
