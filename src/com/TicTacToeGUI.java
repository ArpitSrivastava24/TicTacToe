package com;

import strategy.HumanPlayerStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private JButton[][] buttons;
    private JLabel statusLabel;

    public TicTacToeGUI() {
        // Initialize game components
        board = new Board(3, 3);
        player1 = new Player(Symbol.X, new HumanPlayerStrategy());
        player2 = new Player(Symbol.O, new HumanPlayerStrategy());
        currentPlayer = player1; // Start with player 1
        // Set up the GUI
        setupGUI();
    }

    private void setupGUI() {
        // Set up the frame
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLayout(new BorderLayout());

        // Status label at the top
        statusLabel = new JLabel("Player 1's turn (X)");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(statusLabel, BorderLayout.NORTH);

        // Game board in the center
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create buttons for the board
        buttons = new JButton[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 60));
                button.setFocusPainted(false);

                // Add action listener to handle clicks
                final int currentRow = row;
                final int currentCol = col;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(currentRow, currentCol);
                    }
                });

                buttons[row][col] = button;
                boardPanel.add(button);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        // Reset button at the bottom
        JButton resetButton = new JButton("New Game");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resetButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    private void handleButtonClick(int row, int col) {
        // Check if the move is valid
        Position position = new Position(row, col);
        if (!board.isValidMove(position)) {
            return;
        }

        // Make the move
        currentPlayer.makeMove(position, board.grid);

        // Update the button text
        if (currentPlayer.getSymbol() == Symbol.X) {
            buttons[row][col].setText("X");
            buttons[row][col].setForeground(Color.BLUE);
        } else {
            buttons[row][col].setText("O");
            buttons[row][col].setForeground(Color.RED);
        }

        // Check for win
        Player winner = board.winningPlayer(player1, player2);
        System.out.println(winner);
        if (winner != null) {
            String winnerText = (winner == player1) ? "Player 1 (X)" : "Player 2 (O)";
            statusLabel.setText(winnerText + " wins!");
            disableAllButtons();
            return;
        }

        // Check for draw
        if (board.isDraw()) {
            statusLabel.setText("It's a draw!");
            disableAllButtons();
            return;
        }

        // Switch players
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        String playerText = (currentPlayer == player1) ? "Player 1's turn (X)" : "Player 2's turn (O)";
        statusLabel.setText(playerText);
    }

    private void disableAllButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        // Reset the board
        board = new Board(3, 3);
        currentPlayer = player1;

        // Reset the GUI
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
            }
        }

        // Reset status
        statusLabel.setText("Player 1's turn (X)");
    }

    public void start() {
        setVisible(true);
    }
}
