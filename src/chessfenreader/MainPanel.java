package chessfenreader;

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
        boolean isWhite = true;
        
        String fenExm = "5r2/2p2rb1/1pNp4/p2Pp1pk/2P1K3/PP3PP1/5R2/5R2 w - - 1 51";
        
        boardContainer.setLayout(new GridLayout(8, 8));
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = new BoardSquare(isWhite, null);
                boardContainer.add(board[i][j]);
                isWhite = !isWhite;
            }
            
            isWhite = !isWhite;
        }
        
        JTextField fen = new JTextField(25);
        JButton submit = new JButton("Set Fen");
        
        this.add(fen);
        this.add(submit);
        this.add(boardContainer);
        this.setPreferredSize(new Dimension(650, 650));
    }
    
}
