package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Ǭ ��¥:17.09.13
//���� 11652��
//�з� : ����Ž��
//Ŭ������ ����°� �ξ� ������ �� ���Ƽ� Ŭ������ ���� ó���ߴ�. ����Ž���� ���Ұ�� N^2�� �ɸ���. 
//����Ž���� ���� O(NlogN)���� ������ִ� ���� �߿��ϴ�.
class VC{
	private long value;
	private int count;
	public VC(long value){
		this.value = value;
		count = 1;
	}
	public void plus(){
		count++;
	}
	public int getCount(){
		return count;
	}
	public long getValue(){
		return value;
	}
}
class solutionList{
	private ArrayList<VC> list;
	public solutionList(){
		list = new ArrayList<>();
	}
	public void add(long num){
		int low = 0;
		int high = list.size();
		boolean find = false;
		while(low<high){
			int mid = (low+high)/2;
			long target = list.get(mid).getValue();
			if(target>num){
				high = mid-1;
			}
			else if(target == num){
				list.get(mid).plus();
				find = true;
				break;
			}
			else{
				low = mid+1;
			}
		}
		if(!find)
			list.add(new VC(num));
	}
	
	public long getAnswer(){
		int ans = -1;
		int ansIndex = -1;
		for(int i=0;i<list.size();i++){
			int count = list.get(i).getCount();
			if(count>ans) {
				ans = count;
				ansIndex = i;
			}
		}
		return list.get(ansIndex).getValue();
	}
}
public class _170913_p11652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long []arr = new long[N];
		for(int i=0;i<N;i++){
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		
		solutionList list = new solutionList();
		for(int i=0;i<N;i++)
			list.add(arr[i]);
		
		System.out.println(list.getAnswer());
	}

}
