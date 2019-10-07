import java.util.*;

public class Gerrymandering {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int d = scan.nextInt();
		int wasteA = 0;
		int wasteB = 0;
		int total = 0;
		int vote[][] = new int[d + 1][2];
		for(int i = 0; i < p; i++) {
			int district = scan.nextInt();
			int voteA = scan.nextInt();
			int voteB = scan.nextInt();
			vote[district][0] += voteA;
			vote[district][1] += voteB;
			total += voteA;
			total += voteB;
		}
		
		scan.close();
		
		for(int i = 1; i <= d; i++) {
			int voteA = vote[i][0];
			int voteB = vote[i][1];
			int winningPoint = (voteA + voteB) / 2 + 1;
			if(voteA > voteB) {
				wasteB += voteB;
				wasteA += voteA - winningPoint;
				System.out.println("A " + (voteA - winningPoint) + " " + voteB);
			}else {
				wasteA += voteA;
				wasteB += voteB - winningPoint;
				System.out.println("B " + voteA + " " + (voteB - winningPoint));
			}
		}
		
		double wA = (double)wasteA;
		double wB = (double)wasteB;
		double to = (double)total;
		double e = Math.abs(wA - wB) / to;
		System.out.printf("%.10f\n", e);
		
		
	}

}
