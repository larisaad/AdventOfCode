import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class getBlocks {
	
	private static boolean visitedtwice = false;
	
	private static class Position {
	
		private int x, y;
		private LinkedList<String> trail = new LinkedList<String>();
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		void move(Direction direction, int blocks) {
		
			for(int i = 0; i < blocks && visitedtwice == false; i++) {
				switch(direction) {
					case NORTH:
						y+= 1;
						break;
					case EAST:
						x+= 1;
						break;
					case SOUTH:
						y-= 1;
						break;
					case WEST:
						x-= 1;
						break;
				}
				if(trail.contains(x+"+"+y)) {
					visitedtwice = true;
				}
			trail.add(x+"+"+y);
			}
		}
		
		int getBlocks() {
			return Math.abs(x) + Math.abs(y);
		}
	}
	
	private static abstract class Movement {
		abstract Direction rigth();
		abstract Direction left();
	}
	
	private static enum Direction {
		NORTH(new Movement() {

			@Override
			Direction rigth() {
				return EAST;
			}

			@Override
			Direction left() {
				return WEST;
			}}),
		EAST(new Movement(){

			@Override
			Direction rigth() {
				return SOUTH;
			}

			@Override
			Direction left() {
				return NORTH;
			}
			
		}),
		SOUTH(new Movement(){

			@Override
			Direction rigth() {
				return WEST;
			}

			@Override
			Direction left() {
				return EAST;
			}
			
		}),
		
		WEST(new Movement() {

			@Override
			Direction rigth() {
				return NORTH;
			}

			@Override
			Direction left() {
				return SOUTH;
			}
			
		});
		
		private Movement move;
		Direction(Movement move) {
			this.move = move;
		}
		private Direction right() {
			return move.rigth();
		}
		private Direction left() {
			return move.left();
		}
	}
	
	
	private static Position position = new Position(0, 0);
	private static Direction direction = Direction.NORTH;
	
	public static void main(String[] args) throws IOException{
		
		RandomAccessFile in = new RandomAccessFile("input.txt", "r");
		String input = in.readLine();
		StringTokenizer word = new StringTokenizer(input, ", ");
		String orientation;
		String number;
		int blocks;
		while(word.hasMoreTokens() && visitedtwice == false) {
			orientation = word.nextToken();
			if(orientation.charAt(0) == 'L') 
				direction = direction.left();
			else
				direction = direction.right();
			number = orientation.substring(1);
			blocks = Integer.parseInt(number);
			position.move(direction, blocks);
		}
		
		
		System.out.println(position.getBlocks());
		
	}

}
