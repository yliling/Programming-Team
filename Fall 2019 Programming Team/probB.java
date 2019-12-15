import java.util.*;

public class probB {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] points = new double[6];
		for(int i = 0; i < 6; i++){
			points[i] = scan.nextDouble();
		}
		scan.close();
		double x = points[0];
		double y = points[1];
		double x1 = points[2];
		double y1 = points[3];
		double x2 = points[4];
		double y2 = points[5];
		double r = 0;
		
		if(x >= x1 && x <= x2){
			if(y >= y2){
				r = y - y2;
			}else if(y <= y1){
				r = y1 - y;
			}
		}else if(y >= y1 && y <= y2){
			if(x <= x1){
				r = x1 - x;
			}else if(x >= x2){
				r = x - x2;
			}
		}else{
			if(x <= x1 && y >= y2){
				r = Math.sqrt((x1 - x) * (x1 - x) + (y - y2) * (y - y2));
			}else if (x <= x1 && y <= y1){
				r = Math.sqrt((x1 - x) * (x1 - x) + (y - y1) * (y - y1));
			}else if (x >= x2 && y >= y2){
				r = Math.sqrt((x2 - x) * (x2 - x) + (y - y2) * (y - y2));
			}else if (x >= x2 && y <= y1){
				r = Math.sqrt((x2 - x) * (x2 - x) + (y - y1) * (y - y1));
			}
		}
		
		System.out.printf("%.3f", r);

	}

}
