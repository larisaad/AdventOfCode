import java.io.*;
import java.util.StringTokenizer;
public class WhichIsTriangle {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		String line;
		line = in.readLine();
		int l1, l2, l3;
		int count = 0;
		while(line != null) {
			StringTokenizer word = new StringTokenizer(line, " ");
			l1 = Integer.parseInt(word.nextToken());
			l2 = Integer.parseInt(word.nextToken());
			l3 = Integer.parseInt(word.nextToken());
			if(l1 < l2 + l3 && l2 < l1 + l3 && l3 < l1 + l2)
				count+= 1;
		line =  in.readLine();
		}
		
		System.out.println(count);
		in.close();
	}
}
