package chessfenreader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
            if(isValidFen(fen.getText())) {
                renderFen(fen.getText());
            }
        });

        this.add(fen);
        this.add(submit);
        this.add(boardContainer);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(650, 660));
    }
    
    public boolean isValidFen(String fen) {
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
