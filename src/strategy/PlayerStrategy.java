package strategy;

import com.Position;
import com.Symbol;

public  interface PlayerStrategy {
    void makeMove(Position pos, Symbol symbol, Symbol[][] grid);
}
