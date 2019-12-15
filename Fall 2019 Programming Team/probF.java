import java.util.*;

public class probF {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int num = scan.nextInt();
		HashMap<Double, Double> map = new HashMap<>();
//		for(int i = 0; i < num; i++){
//			double x = scan.nextDouble();
//			double y = scan.nextDouble();
//			map.put(x, y);
//		}
//		scan.close();
		
		double a = 0.2;
		double b = 1.4;
		double x = a;
		double y = b;
		double[] arr = new double[200000];
		for(int i = 0; i < 200000; i++){
			arr[i] = x;
			map.put(x, y);
			x += a;
			y += b;
		}
		
		double constant = 0;
		
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				double left = Math.abs(map.get(arr[i]) - map.get(arr[j]));
				double diff = Math.abs(arr[i] - arr[j]);
				double l = left/diff;
				if(l > constant){
					constant = l;
				}
				
//				left = Math.abs(map.get(arr[j]) - map.get(arr[i]));
//				diff = Math.abs(arr[j] - arr[i]);
//				l = left/diff;
//				if(l > constant){
//					constant = l;
//				}
			}
		}
		
//		for(double key1: map.keySet()){
//			for(double key2: map.keySet()){
//				double left = Math.abs(map.get(key1) - map.get(key2));
//				double diff = Math.abs(key1 - key2);
//				double l = left/diff;
//				if(l > constant){
//					constant = l;
//				}
//			}
//		}
		System.out.println(constant);

	}
	

}
