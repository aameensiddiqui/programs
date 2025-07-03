package postFix;

import java.util.Scanner;

public class PostFix {
	
	public static int postFix(String str) {
		int value =0;
		iStack2 is= new iStack2(str.length());
		char c;
		for(int i = 0 ; i < str.length() ; i++) {
			c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				is.push(c - '0');
			}
			else {
				int val1 = is.pop();
				int val2 = is.pop();
				
				switch(c) {
				case '+':{
					is.push(val2+val1);
					break;
				}
				case '-':{
					is.push(val2-val1);
					break;
				}
				case '*':{
					is.push(val2*val1);
					break;
				}
				case '/':{
					is.push(val2/val1);
					break;
				}
				}
			}
		}
		value=is.pop();
		return value;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Postfix");
		String str = sc.next();
		int val = postFix(str);
		System.out.println(val);
	}
}
