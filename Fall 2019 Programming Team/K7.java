import java.util.*;


public class K7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int company = scan.nextInt();
		int cases = scan.nextInt();
		int[] comp = new int[company + 1];
		for(int i = 1; i < company + 1; i++){
			comp[i] = scan.nextInt();
		}
		for(int i = 0; i < cases; i++){
			int type = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			if(type == 1){
				comp[a] = b;
			}else if(type == 2){
				System.out.println(Math.abs(comp[a] - comp[b]));
			}
		}
		scan.close();
	}

}
