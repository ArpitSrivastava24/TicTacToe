package com;

public class Board {

    private final int row;
    private final int col;
    Symbol[][] grid;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        grid = new Symbol[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos){
        return pos.getRow()>=0 && pos.getRow()<row && pos.getCol()>=0 && pos.getCol()<col
                && grid[pos.getRow()][pos.getCol()]==Symbol.EMPTY;
    }

    public Player winningPlayer(Player player1, Player player2) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != Symbol.EMPTY && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return grid[i][0] == Symbol.X ? player1 : player2;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] != Symbol.EMPTY && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return grid[i][0] == Symbol.X ? player1 : player2;
            }
        }
           // check diagonals
            if (grid[0][0] != Symbol.EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
                return grid[0][0] == Symbol.X ? player1 : player2;
            }
            // check anti-diagonals
            if (grid[0][2] != Symbol.EMPTY && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
                return grid[0][2] == Symbol.X ? player1 : player2;
            }
        // no winner
        return null;
    }

    public boolean isDraw(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==Symbol.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    //printBoard method
    public void printBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
