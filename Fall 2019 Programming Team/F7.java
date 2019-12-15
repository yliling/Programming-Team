import java.util.*;

public class F7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int i = 0; i < testcase; i++){
			int num = scan.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			for(int j = 0; j < num; j++){
				String name = scan.next();
				int n = scan.nextInt();
				if(map.containsKey(name)){
					int old = map.get(name);
					map.replace(name, old, old + n);
				}else{
					map.put(name, n);
				}
			}
			
			HashMap<Integer, ArrayList<String>> mapp = new HashMap<>();
			for(String name: map.keySet()){
				int quatity = map.get(name);
				if(mapp.containsKey(quatity)){
					ArrayList<String> old = mapp.get(quatity);
					old.add(name);
					mapp.replace(quatity, old);
				}else{
					ArrayList<String> list = new ArrayList<>();
					list.add(name);
					mapp.put(quatity, list);
				}
			}
			
			int key[] = new int[mapp.size()];
			int p = 0;
			for(int k: mapp.keySet()){
				key[p] = k;
				p++;
			}
			Arrays.sort(key);
			System.out.println(map.size());
			for(int o = key.length - 1; o>= 0; o--){
				ArrayList<String> newList = mapp.get(key[o]);
				Collections.sort(newList);
				for(int k = 0; k < newList.size(); k++){
					System.out.print(newList.get(k) + " ");
					System.out.println(key[o]);
				}
			}
		}
		scan.close();
	}

}
