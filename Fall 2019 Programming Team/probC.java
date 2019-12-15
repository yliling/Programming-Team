import java.util.*;

public class probC {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int candidate = scan.nextInt();
		int unique = scan.nextInt();
		
		int arr1[] = new int[unique];
		String arr2[] = new String[unique]; 
		
		for(int i = 0; i < unique; i++){
			arr1[i] = scan.nextInt();
			arr2[i] = scan.next();
		}
		scan.close();
		
		int total = 0;
		
		int score[][] = new int[candidate][candidate];
		
		for(int j = 0; j < unique; j++){
			total += arr1[j];
			int s = arr1[j];
			String si = arr2[j];
			char[] si2 = si.toCharArray();
			for(int i = 0; i < candidate; i++){
				char letter = si2[i];
				int index = (int)letter - 65;
				for(int k = i + 1; k < candidate; k++){
					char letter1 = si2[k];
					int index2 = (int)letter1 - 65;
					score[index][index2] += arr1[j];
				}
			}
		}
		
		int half = total / 2;
		ArrayList<Character> canwin[] = new ArrayList[candidate];
		ArrayList<Character> cantwin[] = new ArrayList[candidate];
		
		for(int i = 0; i < candidate; i++){
			ArrayList<Character> win = new ArrayList<>();
			ArrayList<Character> nwin = new ArrayList<>();
			for(int j = 0; j < candidate; j++){
				char c = (char)(j + 65);
				if(score[i][j] > half){
					win.add(c);
				}else if(score[i][j] != 0){
					nwin.add(c);
				}
			}
			canwin[i] = win;
			cantwin[i] = nwin;
		}
		
		
		for(int i = 0; i < candidate; i++){
			char can = (char)(i + 65);
			String output = "" + can + ": ";
			HashSet<Character> set = new HashSet<>();
			for(int k = 0; k < candidate; k++){
				set.add((char)(k + 65));
			}
			if(win(can, set, canwin)){
				output += "can win";
			}else{
				output += "can't win";
			}
			System.out.println(output);
		}
	
	}
	
	public static boolean win(char c, HashSet<Character> s, ArrayList<Character>[] canwin){
		int index = (int)c - 65;
		if(s.size() == 2){
			Object info[] = s.toArray();
			char c1 = (char)info[0];
			char c2 = (char)info[1];
			if(c1 == c){
				return canwin[index].contains(c2);
			}else{
				return canwin[index].contains(c1);
			}
		}
		s.remove(c);
		boolean result = false;
		for(char ch: canwin[index]){
			if(s.contains(ch)){
				result = result || win(ch, s, canwin);
			}
		}
		return result;
	}

}
/*
5 5
4 ADCBE
3 DCABE
3 CADBE
2 BDCAE
1 EBCDA

3 4
1 CAB
1 CAB
1 CAB
1 CAB


2 2
4 BA
2 AB
*/
