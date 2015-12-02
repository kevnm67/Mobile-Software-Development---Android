package com.kevinmorton.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


// The code developed is from following the tutorial found at the following link:
// http://lyndonarmitage.com/making-tic-tac-toe-in-android/


public class MainActivity extends Activity {

    //--------| Game state variables |------------//
    private boolean isXturn = false; // false = X's turn else = O's turn
    private char board[][] = new char[3][3]; // Array of characters for X's and O's

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setupOnClickListeners();
        resetButtons();
    }

    /**
     * Creates a new game via "New Game" button.
     *
     * @param view New Game button
     */
    public void newGame(View view) {
        isXturn = false;
        board = new char[3][3];
        resetButtons();
    }

    /**
     * Reset's all buttons in grid to blank and able to receive actions.
     */
    private void resetButtons() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);

        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow R = (TableRow) T.getChildAt(y);

                for (int x = 0; x < R.getChildCount(); x++) {

                    if (R.getChildAt(x) instanceof Button) {

                        Button resetButton = (Button) R.getChildAt(x);
                        resetButton.setText("");
                        resetButton.setEnabled(true);
                    }
                }
            }
        }
        TextView aTextView = (TextView) findViewById(R.id.titleText);
        aTextView.setText(R.string.title);
    }

    /**
     * Checks if there's a winner and, if true, displays their name.
     *
     * @return BOOL representing whether a player has won.
     */
    private boolean checkWin() {

        char winner = '\0';

        if (checkWinner(board, 3, 'X')) {
            winner = 'X';

        } else if (checkWinner(board, 3, 'O')) {

            winner = 'O';
        }

        if (winner == '\0') {

            return false; // nobody won

        } else {
            // display winner
            TextView winnerTextView = (TextView) findViewById(R.id.titleText);
            winnerTextView.setText(winner + " is the winner!");
            return true;
        }
    }

    /**
     * Algorithm used to determine the winnner.
     * Source: http://lyndonarmitage.com/making-tic-tac-toe-in-android/
     *
     * @param board  the tic tac toe board
     * @param size   width and height of the board
     * @param player player, 'X' or 'O'
     * @return true if  specified player has won
     */
    private boolean checkWinner(char[][] board, int size, char player) {

        // check each column
        for (int x = 0; x < size; x++) {

            int total = 0;

            for (int y = 0; y < size; y++) {
                if (board[x][y] == player) {
                    total++;
                }
            }
            if (total >= size) {
                // Winner!
                return true;
            }
        }

        // check each row
        for (int y = 0; y < size; y++) {

            int total = 0;

            for (int x = 0; x < size; x++) {

                if (board[x][y] == player) {

                    total++;
                }
            }
            if (total >= size) {
                // Winner!
                return true;
            }
        }

        // forward diag
        int total = 0;

        for (int x = 0; x < size; x++) {

            for (int y = 0; y < size; y++) {

                if (x == y && board[x][y] == player) {
                    total++;
                }
            }
        }
        if (total >= size) {
            //Winner!
            return true;
        }

        // backward diag
        total = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x + y == size - 1 && board[x][y] == player) {
                    total++;
                }
            }
        }
        if (total >= size) {
            //Winner!
            return true;
        }

        // No winners
        return false;
    }

    /**
     * Disables all the buttons in  grid.
     */
    private void disableButtons() {

        TableLayout theTableLayout = (TableLayout) findViewById(R.id.tableLayout);

        for (int y = 0; y < theTableLayout.getChildCount(); y++) {

            if (theTableLayout.getChildAt(y) instanceof TableRow) {

                TableRow aTableRow = (TableRow) theTableLayout.getChildAt(y);

                for (int x = 0; x < aTableRow.getChildCount(); x++) {

                    if (aTableRow.getChildAt(x) instanceof Button) {

                        Button B = (Button) aTableRow.getChildAt(x);
                        B.setEnabled(false);
                    }
                }
            }
        }
    }

    /**
     * This will add the OnClickListener to each button inside out TableLayout
     */
    private void setupOnClickListeners() {

        TableLayout theTableLayout = (TableLayout) findViewById(R.id.tableLayout);

        for (int y = 0; y < theTableLayout.getChildCount(); y++) {

            if (theTableLayout.getChildAt(y) instanceof TableRow) {

                TableRow aTableRow = (TableRow) theTableLayout.getChildAt(y);

                for (int x = 0; x < aTableRow.getChildCount(); x++) {

                    // This is each button on the grid
                    View aView = aTableRow.getChildAt(x);
                    aView.setOnClickListener(new PlayOnClick(x, y));
                }
            }
        }
    }

    /**
     * Custom OnClickListener for the game taking individual buttons unique position into consideration.
     */
    private class PlayOnClick implements View.OnClickListener {

        private int x = 0;
        private int y = 0;

        public PlayOnClick(int x, int y) {

            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View view) {

            if (view instanceof Button) {

                Button aButton = (Button) view;

                board[x][y] = isXturn ? 'O' : 'X';

                aButton.setText(isXturn ? "O" : "X");
                aButton.setEnabled(false);

                isXturn = !isXturn;

                // check for a  possible winner
                if (checkWin()) {
                    disableButtons();
                }
            }
        }
    }
}
