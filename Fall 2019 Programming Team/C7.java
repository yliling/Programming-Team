import java.util.*;

public class C7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		
		//loop the cases
		for(int i = 0; i < cases; i++){
			String a = scan.next();
			String b = scan.next();
			boolean check3 = false;
			//loop the length of the substring in A
			for(int j = a.length(); j >= 1; j--){
				boolean check2 = false;
				//loop the different substring in A which has length j
				char[][] store = new char[b.length() - j + 1][j];
				for(int k = 0; k < a.length() - j + 1; k++){
					String str = a.substring(k, k + j);
					char[] arr = str.toCharArray();
					Arrays.sort(arr);
					boolean check = false;
					//loop the different substring in B which has length j
					for(int p = 0; p < b.length() - j + 1; p++){
						if(store[p][0] == '\u0000'){
							String str2 = b.substring(p, p + j);
							char[] arr2 = str2.toCharArray();
							Arrays.sort(arr2);
							for(int w = 0; w < arr2.length; w++){
								store[p][w] = arr2[w];
							}
						}
						
						boolean same = true;
						//check two char array
						for(int w = 0; w < store[p].length; w++){
							if(arr[w] != store[p][w]){
								same = false;
								break;
							}
						}
						if(same){
							System.out.println(str);
							check = true;
							check2 = true;
							check3 =  true;
							break;
						}
					}
					if(check){
						break;
					}
				}
				if(check2){
					break;
				}
			}
			if(!check3){
				System.out.println("NONE");
			}
		}
		
		scan.close();
	}

}
