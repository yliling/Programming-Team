import java.util.*;

public class test {

	public static void main(String[] args) {
		System.out.println(1);
		String a = "a";
		for(int i = 0; i < 1000; i++){
			int n = (int)((Math.random() * 100) / 4);
			char b = (char)(n + 97);
			String c = "" + b;
			a += c;
		}
		System.out.println(a);
		String a1 = "a";
		for(int i = 0; i < 1000; i++){
			int n1 = (int)((Math.random() * 100) / 4);
			char b1 = (char)(n1 + 97);
			String c1 = "" + b1;
			a1 += c1;
		}
		System.out.println(a1);
		
		
//		char[][] store = new char[2][2];
//		System.out.println("Sdf");
//		System.out.println(store[0][0] == '\u0000');
	}


}
