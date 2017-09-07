package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.Scanner;

//Ǭ ��¥:17.09.07
//���� 1068��
//�з� : dfs, tree
//��带 ������ �� ������带 ó���ϴ� ����� ��ٷο���. ������ ������ �̷��� Ŭ������ ���� ���� Ǫ�°͵� ���� �� ����.

class Node{
	private ArrayList<Node> leafs;
	private int nodeNum;
	
	public Node(){
	}
	public Node(int nodeNum){
		this.nodeNum = nodeNum;
		leafs = new ArrayList<>();
	}
	public void addLeaf(Node node){
		leafs.add(node);
	}
	public void deleteNode(int index){
		for(int i=0;i<leafs.size();i++){
			if(leafs.get(i).getNodeNum()==index){
				leafs.remove(i);
				break;
			}
		}
	}
	public int getNodeNum(){
		return nodeNum;
	}
	public boolean isLeafNode(){
		return (leafs.size()==0)?true:false;
	}
	public int getLeafNum(){
		return leafs.size();
	}
	public Node getLeaf(int index){
		return leafs.get(index);
	}
}
public class _170907_p1068 {
	static int ans;
	public static void dfs(Node node,int rootNode){
		if(node.getNodeNum()==rootNode){
			for(int i=0;i<node.getLeafNum();i++){
				dfs(node.getLeaf(i),rootNode);
			}
		}
		else{
			if(node.isLeafNode()){
				ans++;
			}
			else{
				for(int i=0;i<node.getLeafNum();i++){
					dfs(node.getLeaf(i),rootNode);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Node nodes[] = new Node[N];
		//��� ����
		for(int i=0;i<N;i++)
			nodes[i] = new Node(i);
		
		int rootNode=-1;
		ans = 0;
		
		for(int i=0;i<N;i++){
			int targetIndex = sc.nextInt();
			if(targetIndex!=-1)
				nodes[targetIndex].addLeaf(nodes[i]);
			else
				rootNode = i;
		}
		
		int deletedNodeIndex = sc.nextInt();
		for(int i=0;i<N;i++){
			nodes[i].deleteNode(deletedNodeIndex);
		}
		
		if(deletedNodeIndex!=rootNode)
			dfs(nodes[rootNode],rootNode);
		System.out.println(ans);
		
	}

}
