import java.util.*;

public class Zipline {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			double w = scan.nextDouble();
			double g = scan.nextDouble();
			double h = scan.nextDouble();
			double r = scan.nextDouble();
			
			//calculate min
			double diff = Math.abs(h-g);
			double beforeSR = w * w + diff * diff;
			double min = Math.sqrt(beforeSR);
			System.out.printf("%.8f ", min);
			
			//calculate max
			double x = w / 2; //when left = right
			double left = g - r;
			double right = h - r;
			if(left > right) {
				double temp = left;
				left = right;
				right = temp;
			}
			if(left != right) {
				double findX1 = ((-1) * w * left * left + right * left * w) / (right * right - left * left);
				double findX2 = ((-1) * w * left * left - right * left * w) / (right * right - left * left);
				x = findX1;
				if(findX2 > 0 && findX1 < 0) {
					x = findX2;
				}
			}
			double max = Math.sqrt(left * left + x * x) + Math.sqrt(right * right + (w - x) * (w - x));
			System.out.printf("%.8f\n", max);
		}
		scan.close();
	}

}
