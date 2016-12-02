import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BathroomCode {
	private static char[][] a = new char[5][5];
	private static int x = 2;
	private static int y = 0;
	private static void initializeMatrix(char[][] a) {
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
					a[i][j] = (char) '0';
		int count = 1;
		int  i = 0;
		int columnnr1 = 2, columnnr2 = 2;
		while(count < 14) {
			for(int j = columnnr1; j <= columnnr2; j++) {
					if(count > 9) 
						a[i][j] =((char) (65 + count - 10));
					else
						a[i][j] = Character.forDigit(count, 10);
					count+= 1;
				}
			i+=1;
			if(i <= 2) {
				columnnr1-= 1;
				columnnr2+= 1;
			}
			else
			{
				columnnr1+= 1;
				columnnr2-= 1;
				
			}
		}
			
	}
	private static void move(char orientation) {
		
		switch(orientation) {
		case 'L':
			if(y > 0 && a[x][y-1] != '0')
				y--;
			break;
		case 'R':
			if(y < 4 && a[x][y+1] != '0')
				y++;
			break;
		case 'U':
			if(x > 0 && a[x-1][y] != '0')
				x--;
			break;
		case 'D':
			if(x < 4 && a[x+1][y] != '0')
				x++;
			break;
			
		}
	}
	private static char getResult() {
		return a[x][y];
	}
	public static void main(String[] args) throws IOException {
		initializeMatrix(a);
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		String line;
		line = in.readLine();
		while(line != null) {
			for(int i = 0; i < line.length(); i++) 
				move(line.charAt(i));
			System.out.print(getResult());
			line = in.readLine();
		}
		in.close();
	}

}
