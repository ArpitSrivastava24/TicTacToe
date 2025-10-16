package com;

import strategy.HumanPlayerStrategy;

import java.util.Scanner;

public class TicTacToeConsole implements BoardGame {

    private Board board;

    private Player currentPlayer;

    private Player player2;

    private Player player1;

    @Override
    public void play() {

        board=new Board(3,3);
        player1=new Player(Symbol.X,new HumanPlayerStrategy());
        player2=new Player(Symbol.O,new HumanPlayerStrategy());
        //Randomly decide who is current player
        currentPlayer=player1; // placeholder for random selection

        System.out.println("Playing Tic Tac Toe!");
        System.out.println("Player 1 is X and Player 2 is O");
        System.out.println("Enter your moves in the format: row column (0-indexed)");
        while(true) {
            // get player input
            Scanner sc=new Scanner(System.in);
            System.out.println("Player " + (currentPlayer == player1 ? "1" : "2") + "'s turn. Enter your move:");
            int playerRow = sc.nextInt();
            int playerCol = sc.nextInt();
            Position position = new Position(playerRow, playerCol); // placeholder for player input

            // update board
            if(!board.isValidMove(position)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            currentPlayer.makeMove(position,board.grid); // placeholder for player symbol
            // check for win
            Player winner = board.winningPlayer(player1, player2);
            System.out.println(winner);
            // switch players
            if (winner != null) {
                System.out.println("Player " + (winner == player1 ? "1" : "2") + " wins!");
                break;
            }
            // check for draw
            boolean isDraw = board.isDraw();
            if (isDraw) {
                System.out.println("It's a draw!");
                break;
            }
            // continue game
            currentPlayer= (currentPlayer == player1) ? player2 : player1;
            board.printBoard();
            // for simplicity, we will not implement the full game loop here
        }

    }
}
