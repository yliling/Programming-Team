import java.util.*;

public class CircuitMath {

	public static void main(String[] args) {
		Stack<Boolean> storage = new Stack<>();
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.next());
		Boolean[] tf = new Boolean[num];
		for(int i = 0; i < num; i++) {
			String value = scan.next();
			Boolean store = true;
			if(value.equals("F")) {
				store = false;
			}
			tf[i] = store;
		}
		
		scan.nextLine();
		String circuit = scan.nextLine();
		String[] description = circuit.split("\\s+");
		char[] descriptionChar = new char[description.length];
		for(int i = 0; i < description.length; i++) {
			descriptionChar[i] = description[i].charAt(0);
		}
		
		for(int i = 0; i < descriptionChar.length; i++) {
			char c = descriptionChar[i];
			if(c == '*') { //add
				Boolean v1 = storage.pop();
				Boolean v2 = storage.pop();
				Boolean v = v1 && v2;
				storage.push(v);
			}else if(c == '+') { //or
				Boolean v1 = storage.pop();
				Boolean v2 = storage.pop();
				Boolean v = v1 || v2;
				storage.push(v);
			}else if(c == '-') { //not
				Boolean v1 = storage.pop();
				Boolean v = !v1;
				storage.push(v);
			}else {
				int index = (int)c - 65;
				storage.push(tf[index]);
			}
		}
		Boolean answer = storage.pop();
		if(answer) {
			System.out.println("T");
		}else {
			System.out.println("F");
		}
	}

}
