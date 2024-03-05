package machine_coding.tictactoe;

import machine_coding.tictactoe.controllers.GameController;
import machine_coding.tictactoe.models.*;

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many human players?");
        int numOfHumanPlayers = scanner.nextInt();

        List<Player> players = new ArrayList<>();
        Set<Character> symbolSet = new HashSet<>();
        for(int i=0; i<numOfHumanPlayers; i++){
            System.out.println("Enter name and symbol for player");
            String name = scanner.next();
            String symbolStr = scanner.next();
            char symbol = symbolStr.charAt(0);
            while(symbolSet.contains(symbol)){
                System.out.println("Enter a new symbol");
                symbolStr = scanner.next();
                symbol = symbolStr.charAt(0);
            }
            symbolSet.add(symbol);
            players.add(new HumanPlayer(name, new Symbol(symbol)));
        }

        System.out.println("How many bots?");
        int numOfBotPlayers = scanner.nextInt();

        String s = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        for(int i=0; i<numOfBotPlayers; i++){
            System.out.println("Choose bot difficulty level: E/M/D");
            String diffLevelStr = scanner.next();
            BotLevel botLevel;
            switch (diffLevelStr.charAt(0)){
                case 'E':
                    botLevel = BotLevel.EASY;
                    break;
                case 'M':
                    botLevel = BotLevel.MEDIUM;
                    break;
                case 'D':
                    botLevel = BotLevel.DIFFICULT;
                    break;
                default:
                    System.out.println("Invalid input, choosing easy!");
                    botLevel = BotLevel.EASY;
                    break;
            }

            int idx = random.nextInt(s.length());
            char symbol = s.charAt(idx);
            while (symbolSet.contains(symbol)){
                idx = random.nextInt(s.length());
                symbol = s.charAt(idx);
            }
            symbolSet.add(symbol);
            players.add(new BotPlayer("Bot " + (i+1), new Symbol(symbol), botLevel));
        }

        Game game;
        try {
            game = gameController.createGame(players);
        } catch (Exception e){
            System.out.println("Error while creating the game: " + e.getMessage());
            return;
        }

        // Start playing the game
        // while game is in progress
        // 1. Print the board
        // 2. Make a move
        // 2.1: Check if the player has won
        // 2.1.1: If the player wins, set the gamestatus to ENDED
        // 2.1.2: Else if drawn scenario, set the Gamestatus to DRAWN
        // 2.1.3: Else, pass the chance to the next player, and capture the move

        while (gameController.getGameStatus(game) == GameStatus.IN_PROGRESS){
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        GameStatus gameStatus = gameController.getGameStatus(game);
        if(gameStatus.equals(GameStatus.ENDED)){
            // This means someone has won
        }
        else {
            System.out.println("This game has drawn");
            gameController.printBoard(game);
        }


    }
}
