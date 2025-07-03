package BookStack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of stack : ");
		size = sc.nextInt();
		bStack bs = new bStack(size);
		
		int ch;
		do {
			System.out.println("1. Push element");
			System.out.println("2. Pop element");
			System.out.println("3. Peek element");
			System.out.println("4. Disp element");
			System.out.println("0. Exit");
			
			System.out.print("Enter Your Choice : ");
			ch = sc.nextInt();
		
			Book b = null;
			int noOfPages;
			String name;
			
			switch(ch) {
			case 1:{
				if(!bs.isFull()) {
					System.out.print("Enter No of pages : ");
					noOfPages = sc.nextInt();
					System.out.print("Enter Name of Book : ");
					name = sc.next();
					b= new Book(noOfPages,name);
					bs.push(b);
				}else {
					System.out.println("Stack Over Flow");
				}
				break;
			}
			case 2:{
				if(!bs.isEmpty()) {
					b = bs.pop();
					System.out.print("Popped element is : \n"+b);
				}else {
					System.out.println("Stack UnderFlow");
				}
				break;
			}
			case 3:{
				if(!bs.isEmpty()) {
					b = bs.peek();
					System.out.print("Peek element in a array is : \n"+ b);
				}else {
					System.out.println("Stack UnderFlow");
				}
				break;
			}
			case 4:{
				if(!bs.isEmpty()) {
					System.out.println("**********Displaying elements in array********");
					bs.disp();
				}else {
					System.out.println("Stack UnderFlow");
				}
				break;
			}
			case 0:{
				break;
			}
			}
		}while(ch!=0);
	}

}
