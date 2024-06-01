package ticTacToe;

import java.util.Scanner;

public class TicTacToe {
    
    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String args[]){
        TicTacToe t = new TicTacToe();
        t.StartGame();

    }

    public void StartGame(){
       Scanner sc = new Scanner(System.in);
       //Take player input.
       player1 = takePlayerInput(++numPlayers);
       player2 = takePlayerInput(++numPlayers);
       while(player1.getSymbol() == player2.getSymbol()){
        System.out.println("symbol already taken! Please enter the symbol again");
        player2.setSymbol(sc.next().charAt(0));
       }

       //create the board.
       board = new Board(player1.getSymbol(), player2.getSymbol());

       //play the game.
       boolean player1Turn = true;
        int status = board.INCOMPLETE;
       while(status == board.INCOMPLETE || status == board.INVALIDMOVE){
        if(player1Turn){
            System.out.println("Player 1 - " + player1.getName() + " 's turn");
            System.out.println("Enter x: ");
            int x = sc.nextInt();
            System.out.println("Enter y: ");
            int y = sc.nextInt();

            status = board.move(player1.getSymbol(), x, y);
            if(status == board.INVALIDMOVE){
               System.out.println("Invalid move !! Please try again !!");
               continue;
            }
        }
        else{
             System.out.println("Player 2 - " + player2.getName() + " 's turn");
            System.out.println("Enter x: ");
            int x = sc.nextInt();
            System.out.println("Enter y: ");
            int y = sc.nextInt();

            status = board.move(player2.getSymbol(), x, y);
            if(status == board.INVALIDMOVE){
               System.out.println("Invalid move !! Please try again !!");
               continue;
            }
        }
             player1Turn = !player1Turn;
             board.print();
       }
        if(status == board.PLAYER1WINS){
            System.out.println("Player 1 - " + player1.getName() + " WINS !!");
        }else if(status == board.PLAYER2WINS){
            System.out.println("Player  - " + player2.getName() + " WINS !!");
        }else{
            System.out.println("DRAW !!");
        }

    }
    private Player takePlayerInput(int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player " + num + " name: ");
        String name = sc.nextLine();
        System.out.println("Enter Player " + num + " symbol: ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
    }
}
