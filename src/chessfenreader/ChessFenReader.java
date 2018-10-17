package chessfenreader;

import javax.swing.JFrame;

/**
 *
 * @author Cal Payne
 */
public class ChessFenReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame app = new JFrame("Chess Fen Reader");
        app.add(new MainPanel());
        app.pack();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    
}
