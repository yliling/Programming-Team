import java.util.*;

public class probC1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		int repeat = scan.nextInt();
		scan.close();
		
		String front = num.substring(0, num.length() - repeat);
		String end = num.substring(num.length() - repeat);
		int index = num.indexOf(end);
		int diff = 20 - index + 1;
		while(diff > 0){
			diff -= end.length();
			front += end;
		}
		
		double number = Double.parseDouble(front);
		if((int)number >= 1){
			//iterate b
			double e = Math.pow(10, -9);
			int i = 1;
			while(Math.ceil(i * number) - i * number > e){
				i++;
			}
			
			System.out.println((int)Math.ceil(i * number) + "/" + i);
		}else{
			//iterate a
			double e = Math.pow(10, -9);
			int i = 1;
			while(Math.floor(i / number) - i / number > e){
				i++;
			}
			
			System.out.println(i + "/" + (int)Math.floor(i / number));
		}
		
		
		
	}

}