package state;

public class GameContext {
    private GameState state;

    public GameContext() {
        state = new InProgressState();
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void isGameOver() {
        state.isGameOver(this);
    }
}
