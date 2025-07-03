package prog01_introduction;

import java.util.Scanner;

public class Graph {
	int V;
	int[][] arr;
	
	public Graph(int V) {
		this.V = V;
		arr = new int[V][V];
	}
	
	void acceptGraph() {
		Scanner sc =  new Scanner(System.in);
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				System.out.print("Enter Value "+ i + "," + j + " : ");
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	
	public void addEdge(int i,int j) {
		arr[i][j] = 1;
//		arr[j][i] = 1;
	}
	
	void printGraph() {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(i +" : ");
			for(int j = 0 ; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void traverseDFS(int start,boolean[] b) {
		for(int j = 0 ;j<V ; j++) {
			if(arr[start][j] == 1 && b[j]!=true) {
				b[j] = true;
				System.out.print(j + " ");
				traverseDFS(j, b);
			}
		}
	}
	
	public void dfs(int start) {
		boolean[] b = new boolean[V];
		System.out.print(start + " ");
		b[start] = true;
		traverseDFS(start,b);
	}
	
	public void outDegree() {
		for(int i = 0 ; i < V ; i++) {
			int cnt = 0;
			for(int j = 0 ; j < V ; j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
			System.out.println("Out-Degree of "+i+" is "+cnt);
		}
	}
	
	public void inDegree() {
		for(int i = 0 ; i < V ; i++) {
			int cnt = 0;
			for(int j = 0 ; j < V ; j++) {
				if(arr[j][i]==1) {
					cnt++;
				}
			}
			System.out.println("In-Degree of "+i+" is "+cnt);
		}
	}
	
	public int noOfSource() {
		int cnt = 0 ;
		for(int i = 0 ; i < V ; i++) {
			int cnt1 = 0;
			for(int j = 0 ; j < V ; j++) {
				if(arr[i][j] == 1) {
					cnt1++;
				}
			}
			if(cnt1==0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public int noOfSink() {
		int cnt = 0 ;
		for(int i = 0 ; i < V ; i++) {
			int cnt1 = 0;
			for(int j = 0 ; j < V ; j++) {
				if(arr[j][i] == 1) {
					cnt1++;
				}
			}
			if(cnt1==0) {
				cnt++;
			}
		}
		return cnt;
	}
}
