import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WhichIsTriangle2 {

	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		int idx = 0, count = 0;
		int[] arr = new int[9];
		while(in.hasNextInt()) {
			while(idx < 9) {
				arr[idx] = in.nextInt();
				idx+= 1;
			
			}
			for(int i = 0; i < 3; i++)
				if(arr[i] < arr[i+3] + arr[i+6] && arr[i+3] < arr[i] + arr[i+6] && arr[i+6] < arr[i] + arr[i+3])
					count+= 1;
			idx = 0;
		}
		in.close();
		System.out.println(count);
	}
}
