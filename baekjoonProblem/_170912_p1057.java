package algo.baekjoonProblem;

import java.util.Scanner;

//Ǭ ��¥:17.09.12
//���� 1057��
//�з� : ���������ڸ� ���ϴµ� �ø�(Math.ceil)���� ���ϴ� ����� ����ߴ�.
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
