package selectionSort;

import java.util.Scanner;

public class Main {
	private Employee[] arr;
	private int size;
	public Main(int size) {
		this.size = size;
		arr = new Employee[size];
	}
	
	public void sort() {
		for(int i = 0 ;i < size-1 ; i++) {
			Employee small = arr[i];
			int index = i;
			
			for(int j = i+1 ; j<size ; j++) {
				if(small.getSal()>arr[j].getSal()) {
					small = arr[j];
					index = j;
				}
			}
			arr[index] = arr[i];
			arr[i] = small;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size of array : ");
		int size = sc.nextInt();
		Main m = new Main(size);
		
		int salary;
		for(int i = 0; i < size ; i++) {
			System.out.print("Enter salary for "+(i+1)+" : ");
			salary= sc.nextInt();
			Employee e = new Employee(salary);
			m.arr[i] = e;
		}
		
		System.out.println("Before Sort");
		for(int i = 0; i < size ; i++) {
			System.out.print(m.arr[i]);
		}
		
		System.out.println();
		m.sort();
		System.out.println("After Sort");
		for(int i = 0; i < size ; i++) {
			System.out.print(m.arr[i]);
		}
	}
}
