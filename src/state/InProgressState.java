package state;

public class InProgressState implements GameState{

    @Override
    public void isGameOver(GameContext context) {
        System.out.println("The game is still in progress.");
    }
}
