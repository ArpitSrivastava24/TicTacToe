package strategy;

import com.Position;
import com.Symbol;

public class HumanPlayerStrategy implements PlayerStrategy{

    @Override
    public void makeMove(Position pos, Symbol symbol, Symbol[][] grid) {
        grid[pos.getRow()][pos.getCol()]=symbol;
    }
}
