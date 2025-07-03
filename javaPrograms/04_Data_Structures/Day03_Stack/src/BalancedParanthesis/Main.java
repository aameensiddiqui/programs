package BalancedParanthesis;

import java.util.Scanner;

public class Main {

	static public boolean isValidParenthesis(String sr) {
		cStack cs = new cStack(sr.length());
		for(int i = 0 ; i < sr.length() ; i++) {
			if(cs.isEmpty()) {
				cs.push(sr.charAt(i));
			}
			else if(cs.peek()=='(' && sr.charAt(i)==')' || cs.peek()=='{' && sr.charAt(i)=='}' || cs.peek()=='[' && sr.charAt(i)==']'){
				cs.pop();
			}else {
				cs.push(sr.charAt(i));
			}
		}
		if(cs.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sr = sc.next();
		
//		boolean b = isValidParenthesis(sr);
		if(isValidParenthesis(sr)) {
			System.out.println("Valid Parenthesis");
		}else {
			System.out.println("Non-Valid Perenthesis");
		}
		
		
		
		sc.close();
	}

}
