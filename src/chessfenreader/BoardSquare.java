package chessfenreader;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Cal Payne
 */
public class BoardSquare extends JLabel {
    
    public BoardSquare(boolean isWhiteOrBlack, String piece) {
        if(piece != null) {
            this.setIcon(findPiece(piece));
        }
        this.setOpaque(true);
        this.setBackground(isWhiteOrBlack ? Color.WHITE : Color.BLACK);
        this.setPreferredSize(new Dimension(75, 75));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private ImageIcon findPiece(String piece) {
        return new ImageIcon("pieces/P.png");
    }
    
}
