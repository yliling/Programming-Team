import java.util.*;

public class MissingNumber {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		boolean[] nums = new boolean[201];
		int biggest = -1;
		for(int i = 0; i < num; i++) {
			int n = scan.nextInt();
			if(n > biggest) {
				biggest = n;
			}
			nums[n] = true;
		}
		int errorCount = 0;
		for(int i = 1; i <= biggest; i++) {
			if(!nums[i]) {
				System.out.println(i);
				errorCount++;
			}
		}
		if(errorCount == 0) {
			System.out.println("good job");
		}
		scan.close();
	}
}
