package state;

public class OWonState implements GameState{

    @Override
    public void isGameOver(GameContext context) {
        System.out.println("O has won the game!");
    }
}
