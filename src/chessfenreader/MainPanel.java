package chessfenreader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cal Payne
 */
public class MainPanel extends JPanel {

    private BoardSquare[][] board;
    private final JPanel boardContainer;

    public MainPanel() {
        board = new BoardSquare[8][8];
        boardContainer = new JPanel();
        boardContainer.setLayout(new GridLayout(8, 8));

        renderFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq -");

        JTextField fen = new JTextField("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq -", 40);
        JButton submit = new JButton("Set Fen");
        submit.addActionListener((ActionEvent ae) -> {
            if (isValidFen(fen.getText())) {
                renderFen(fen.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Please use a valid fen string", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.add(fen);
        this.add(submit);
        this.add(boardContainer);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(650, 660));
    }

    /**
     * Validates a fen
     *
     * @param fen the fen to validate
     * @return if the fen is valid
     */
    public boolean isValidFen(String fen) {
        if (fen.chars().filter(num -> num == '/').count() != 7) {
            return false;
        }

        fen = fen.substring(0, fen.indexOf(" "));
        String[] check = fen.split("/");
        for (String s : check) {
            int total = 0;
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    total++;
                } else {
                    total += Integer.parseInt(String.valueOf(c));
                }
            }

            if (total != 8) {
                return false;
            }
        }

        return true;
    }

    /**
     * Renders a fen onto the screen
     *
     * @param fen the fen to render
     */
    public void renderFen(String fen) {
        boardContainer.removeAll();

        fen = fen.substring(0, fen.indexOf(" ")).replaceAll("/", "");
        char[] fenArray = fen.toCharArray();

        boolean isLight = true;

        int pos = 0;
        for (BoardSquare[] row : board) {
            for (int i = 0; i < board[0].length; i++) {
                if (Character.isLetter(fenArray[pos])) {
                    row[i] = new BoardSquare(isLight, Character.toString(fenArray[pos]));
                    pos++;
                } else if (Character.isDigit(fenArray[pos])) {
                    if (fenArray[pos] == '1') {
                        pos++;
                    } else {
                        fenArray[pos]--;
                    }
                    row[i] = new BoardSquare(isLight, null);
                }
                boardContainer.add(row[i]);
                isLight = !isLight;
            }
            isLight = !isLight;
        }

        boardContainer.revalidate();
        boardContainer.repaint();
    }

}
