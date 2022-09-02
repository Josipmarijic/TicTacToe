import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.Position;

public class Chessboard {
	
	static ArrayList<Integer> playerOnePosition = new ArrayList<Integer>();
	static ArrayList<Integer> playerTwoPosition = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		String [][] gameBoard = {
				{"1","2","3"},
				{"4","5","6"},
				{"7","8","9"},
		};
		
		showGameboard(gameBoard);
		
		
		
			
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Välj en siffra 1-9;");
			int pOnePosition = scan.nextInt();
			while(playerOnePosition.contains(pOnePosition) || playerTwoPosition.contains(pOnePosition)) {
				System.out.println("Den rutan är tagen välj en annan ruta.");
				pOnePosition = scan.nextInt();
			}
			
			setPosition(gameBoard, pOnePosition, "playerone");
			showGameboard(gameBoard);
			int pTwoPosition = scan.nextInt();
			while(playerOnePosition.contains(pTwoPosition) || playerTwoPosition.contains(pTwoPosition)) {
				System.out.println("Den rutan är tagen välj en annan ruta.");
				pTwoPosition = scan.nextInt();
			}
			
			setPosition(gameBoard, pTwoPosition, "playertwo");
			showGameboard(gameBoard);
			
			String result = chekWinner();
			System.out.println(result);
			
		}
		
		
		
		
		}
	
	public static void showGameboard(String [][] gameBoard) {
for (String [] row : gameBoard) {
			
			System.out.println(Arrays.toString(row));
				
			}
		
	}
	
	public static void setPosition(String[][] gameBoard, int position, String player) {
		
		String symbol = "";
		
		if(player.equals("playerone")) {
			symbol = "X";
			playerOnePosition.add(position);
		}else if(player.equals("playertwo")) {
			symbol = "O";
			playerTwoPosition.add(position);
		}
		
		
			
		switch (position) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][1] = symbol;
			break;
		case 3:
			gameBoard[0][2] = symbol;
			break;
		case 4:
			gameBoard[1][0] = symbol;
			break;
		case 5:
			gameBoard[1][1] = symbol;
			break;
		case 6:
			gameBoard[1][2] = symbol;
			break;
		case 7:
			gameBoard[2][0] = symbol;
			break;
		case 8:
			gameBoard[2][1] = symbol;
			break;
		case 9:
			gameBoard[2][2] = symbol;
			break;
			
			default:
				break;

		
		}
		
		
		
		
		
		
	}
	
	public static String chekWinner() {
		
		List fRow = Arrays.asList(1,2,3);
		List sRow = Arrays.asList(4,5,6);
		List tRow = Arrays.asList(7,8,9);
		List fCol =  Arrays.asList(1,4,7);
		List sCol = Arrays.asList(2,5,8);
		List tCol = Arrays.asList(3,6,9);
		List fCross = Arrays.asList(1,5,9);
		List sCross = Arrays.asList(3,5,7);
		
		List<List> winCondition = new ArrayList<List>();
		
		winCondition.add(fRow);
		winCondition.add(sRow);
		winCondition.add(tRow);
		winCondition.add(fCol);
		winCondition.add(sCol);
		winCondition.add(tCol);
		winCondition.add(fCross);
		winCondition.add(sCross);
		
		for(List l : winCondition) {
			if(playerOnePosition.containsAll(l)) {
			return "spelare ett vann";
			}else if (playerTwoPosition.containsAll(l)) {
				return "spelare två vann";
			} else if (playerOnePosition.size() + playerTwoPosition.size() == 9) {
				return "oavgjort";
			}
			
		} 
		
		return "";
		
	}
	
	

		
	}

	


