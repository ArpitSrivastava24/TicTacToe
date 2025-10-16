package state;

public class XWonState implements GameState{

    @Override
    public void isGameOver(GameContext context) {
        System.out.println("X has won the game!");
    }
}
