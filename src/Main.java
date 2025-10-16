import com.TicTacToeConsole;
import com.TicTacToeGUI;

public class Main {
    public static void main(String[] args) {
        // Create and start the GUI version
        TicTacToeGUI gui = new TicTacToeGUI();
        gui.start();

        // Original console version (commented out)
//         TicTacToeConsole ticTacToe = new TicTacToeConsole();
//         ticTacToe.play();
    }
}
