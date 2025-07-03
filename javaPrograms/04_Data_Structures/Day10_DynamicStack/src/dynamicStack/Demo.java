package dynamicStack;

import java.util.Scanner;

public class Demo extends Exception{

	public static void main(String[] args) {
		cStack stack = new cStack();
		
		int ch;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. To push data");
			System.out.println("2. To pop data");
			System.out.println("3. Peek Element");
			System.out.println("4. isEmpty");
			System.out.println("5. display stack");
			System.out.println("6. Min Element is");

			System.out.println("0. To exit ");
			
			System.out.print("Enter ypur choise : ");
			ch=sc.nextInt();
			switch(ch) {
			case 1:{
				System.out.print("Enter Data to push in stack : ");
				int data = sc.nextInt();
				stack.push(data);
				break;
			}
			case 2:{
				try {
					int data = stack.pop();
					System.out.println("Deleted Element from stac is : "+data);					
				}catch(StackException e) {
					System.out.println(e.toString()); 
				}
				break;
			}
			case 3:{
				try {
					int data = stack.peek();
					System.out.println("Top Element from stack is : "+data);					
				}catch(StackException e) {
					System.out.println(e.toString()); 
				}
				break;
			}
			case 4:{
				if(stack.isEmpty()) {
					System.out.println("Stack is Empty");
				}else {
					System.out.println("Stack Contains Elements");
				}
				break;
			}
			case 5:{
				try {					
					stack.display();
				}catch(StackException e) {
					System.out.println(e.toString()); 
				}
				break;
			}
			case 6:{
				int min = stack.min();
				System.out.println("Min element in stak is : " + min);
				break;
			}
			case 0:{
				break;
			}
			}
		}while(ch!=0);
	}

}
