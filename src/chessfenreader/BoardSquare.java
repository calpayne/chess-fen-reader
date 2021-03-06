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

    public BoardSquare(boolean isLight, String piece) {
        if (piece != null) {
            this.setIcon(findPiece(piece));
        }
        this.setOpaque(true);
        this.setBackground(isLight ? Color.decode("#f0d9b5") : Color.decode("#b58863"));
        this.setPreferredSize(new Dimension(75, 75));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * Converts fen piece to ImageIcon
     *
     * @param piece the piece to find an image for
     * @return the ImageIcon of the piece
     */
    private ImageIcon findPiece(String piece) {
        if (piece.toUpperCase().equals(piece)) {
            return new ImageIcon("pieces/" + piece.toLowerCase() + ".png");
        } else {
            return new ImageIcon("pieces/" + piece.toLowerCase() + "b.png");
        }
    }

}
