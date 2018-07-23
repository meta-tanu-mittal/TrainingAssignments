import java.util.Scanner;

class UseClass {
	static int max = 30;
	char stack[] = new char[max];
	static int top = -1;

	/**
	 * 
	 * @param a
	 */
	void push(char a) {
		// System.out.println(max);
		if (top == (max - 1))
			System.out.println("stack is full");
		else {// System.out.println(top);
			top++;
			stack[top] = a;
		}
	}

	int pop() {
		char n;
		if (top == -1) {
			System.out.println("stack is empty");
			return -1;
		} else {
			n = stack[top];
			top--;
			return n;
		}
	}

}

public class Palindrome {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		UseClass uc = new UseClass();
		System.out.println("enter the string");
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++)
			uc.push(str.charAt(i));

		String reverse = "";
		while (UseClass.top != -1) {
			reverse = reverse + uc.stack[UseClass.top];
			UseClass.top--;
		}

		// System.out.println(reverse);
		if (str.equals(reverse))
			System.out.println("string is palindrome");
		else
			System.out.println("string is not palindrome");
		sc.close();

	}
}