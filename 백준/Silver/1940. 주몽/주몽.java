
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int answer = 0;

		int material = sc.nextInt();
		int[] material_array = new int[material];
		int armor = sc.nextInt();
		int lt =0 , rt = material - 1;

		for(int i=0; i<material;i++){
			material_array[i] = sc.nextInt();
		}

		Arrays.sort(material_array);

		while(lt < rt){
			if(material_array[lt] + material_array[rt] > armor){
				rt--;
			}else if(material_array[lt] + material_array[rt] < armor){
				lt++;
			}else{
				answer++;
				rt--;
				lt++;
			}
		}
		System.out.println(answer);
	}
}