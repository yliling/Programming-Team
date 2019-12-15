import java.util.*;

public class G7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			int c = scan.nextInt();
			int out = 1;
			for(int j = 1 ; j <= c; j++){
				out *= j;
			}
			System.out.println(out % 10);
		}
		scan.close();
	}

}
