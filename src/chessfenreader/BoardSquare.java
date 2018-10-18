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
        switch (piece) {
            case "p":
                return new ImageIcon("pieces/PB.png");
            case "P":
                return new ImageIcon("pieces/p.png");
            case "k":
                return new ImageIcon("pieces/KB.png");
            case "K":
                return new ImageIcon("pieces/k.png");
            case "n":
                return new ImageIcon("pieces/knB.png");
            case "N":
                return new ImageIcon("pieces/Kn.png");
            case "q":
                return new ImageIcon("pieces/QB.png");
            case "Q":
                return new ImageIcon("pieces/q.png");
            case "r":
                return new ImageIcon("pieces/RB.png");
            case "R":
                return new ImageIcon("pieces/r.png");
            case "b":
                return new ImageIcon("pieces/BB.png");
            case "B":
                return new ImageIcon("pieces/b.png");

        }

        return null;
    }

}
