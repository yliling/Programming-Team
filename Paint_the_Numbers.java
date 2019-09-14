import java.util.*;

public class probA{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int[] check = new int[n];
		int count = 0;
		for(int i = 0; i < n; i++){
			if(check[i] == 0){
				count++;
				check[i] = 1;
			}
			for(int j = i + 1; j < n; j++){
				if(arr[j] % arr[i] == 0 && check[j] == 0){
					check[j] = 1;
				}
			}
		}
		System.out.println(count);
	}
}