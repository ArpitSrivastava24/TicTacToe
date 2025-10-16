package com;

import strategy.PlayerStrategy;

public class Player {

    private Symbol symbol;

    private PlayerStrategy playerStrategy;

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public Player(Symbol symbol, PlayerStrategy playerStrategy) {
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public void makeMove(Position pos, Symbol [][] grid) {
        playerStrategy.makeMove(pos, symbol, grid);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
