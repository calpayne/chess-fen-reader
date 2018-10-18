package chessfenreader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
        
        renderFen("K6p/7p/1p1k4/6k1/8/1p6/8/8 w KQkq -");
        
        JTextField fen = new JTextField(25);
        JButton submit = new JButton("Set Fen");
        
        this.add(fen);
        this.add(submit);
        this.add(boardContainer);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(650, 660));
    }
    
    public void renderFen(String fen) {
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
                    if(fenArray[pos] == '1') {
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
    }
    
}
