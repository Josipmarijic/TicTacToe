import java.util.*;

public class Main {

    public static Boolean choose = false;
    public static Boolean gameOn = false;
    public static Scanner input = new Scanner(System.in);
    public static int turn;
    public static Random rand = new Random();

    public static String[][] gameBoard = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
    };
    public static ArrayList<Integer> playerOnePosition = new ArrayList<Integer>();
    public static ArrayList<Integer> playerTwoPosition = new ArrayList<Integer>();

    public static void main(String[] args) {


        optionsMenu();



    }

    public static void optionsMenu() {


            resetGameBoard();
            System.out.println("Tryck 1 för nytt spell, tryck 2 för att avsluta");


            if (input.nextLine().equals("1")) {


                gameOn = true;
                System.out.println(turn);
                turn = rand.nextInt(1, 3);
                playGame();
            } else System.out.println("Tryck 1 eller 2");


    }

    public static void playGame() {

        while (gameOn) if (turn == 1) {
            System.out.println("Välj en siffra 1-9;");
            showGameboard(gameBoard);
            int pOnePosition = input.nextInt();
            while (playerOnePosition.contains(pOnePosition) || playerTwoPosition.contains(pOnePosition)) {
                System.out.println("Den rutan är tagen välj en annan ruta.");
                pOnePosition = input.nextInt();

            }
            setPosition(gameBoard, pOnePosition, "playerone");
            chekWinner();




            turn = 2;
        } else if (turn == 2) {

            System.out.println("Välj en siffra 1-9;");
            showGameboard(gameBoard);
            int pTwoPosition = input.nextInt();
            while (playerOnePosition.contains(pTwoPosition) || playerTwoPosition.contains(pTwoPosition)) {
                System.out.println("Den rutan är tagen välj en annan ruta.");
                pTwoPosition = input.nextInt();
            }
            setPosition(gameBoard, pTwoPosition, "playertwo");
            chekWinner();



            turn = 1;
        }
    }

    public static void showGameboard(String[][] gameBoard) {
        for (String[] row : gameBoard) {

            System.out.println(Arrays.toString(row));

        }

    }

    public static void resetGameBoard() {
        gameBoard[0][0] = "1";
        gameBoard[0][1] = "2";
        gameBoard[0][2] = "3";
        gameBoard[1][0] = "4";
        gameBoard[1][1] = "5";
        gameBoard[1][2] = "6";
        gameBoard[2][0] = "7";
        gameBoard[2][1] = "8";
        gameBoard[2][2] = "9";

    }

    public static void setPosition(String[][] gameBoard, int position, String player) {

        String symbol = "";

        if (player.equals("playerone")) {
            symbol = "X";
            playerOnePosition.add(position);
        } else if (player.equals("playertwo")) {
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
    public static void chekWinner() {

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
                System.out.println("spelare ett vann tryck 1 för att spela igen eller 2 för att avsluta");
                resetGameBoard();
                input.nextLine();
                playerOnePosition.clear();
                playerTwoPosition.clear();
                if (input.nextLine().equals("1")){
                    turn = rand.nextInt(1, 3);
                }

            }else if (playerTwoPosition.containsAll(l)) {
                System.out.println("spelare två vann tryck 1 för att spela igen eller 2 för att avsluta");
                resetGameBoard();
                input.nextLine();
                playerOnePosition.clear();
                playerTwoPosition.clear();
                if (input.nextLine().equals("1")){
                    turn = rand.nextInt(1, 3);
                }
            } else if (playerOnePosition.size() + playerTwoPosition.size() == 9) {
                System.out.println("oavgjort tryck 1 för att spela igen eller 2 för att avsluta");
                input.nextLine();
                resetGameBoard();
                playerOnePosition.clear();
                playerTwoPosition.clear();
                if (input.nextLine().equals("1")){
                    turn = rand.nextInt(1, 3);
                }
            }

        }



    }
}

