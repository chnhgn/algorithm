package sort;

import java.util.Scanner;
import java.util.Stack;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> oper = new Stack<String>();
		Stack<Double> value = new Stack<Double>();
		Scanner scan = new Scanner(System.in);
		String ss = null;
		ss = scan.next();
		
		char arr[] = ss.toCharArray();
		for (char c : arr) {
			String s = String.valueOf(c);
			if (s.equals("(") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				oper.push(s);
				continue;
			}else if (!s.equals(")")) {
				value.push(Double.valueOf(s));
				continue;
			}else if (s.equals(")")) {
				double a = value.pop();
				double b = value.pop();
				String op = oper.pop();
				oper.pop();
				if (op.equals("+")) {
					b = a + b;
				}else if (op.equals("-")) {
					b = a - b;
				}else if (op.equals("*")) {
					b = a * b;
				}else if (op.equals("/")) {
					b = a / b;
				}
				value.push(Double.valueOf(b));
			}
		}
		
		System.out.println(value.pop());
	}

}
