package Mission1;

import javax.swing.*;
import java.awt.*;

public class DrawingJFrame extends JFrame {

    public DrawingJFrame(){
        super("Dots");

        setLayout(new GridLayout(3, 3));

        DrawingPanel p1 = new DrawingPanel();
        p1.setBackground(Color.yellow);
        add(p1);
        for(int i = 0; i < 8; i++){
            DrawingPanel p = new DrawingPanel();
            p.setBackground(Color.cyan);
            p1.addListener(p);
            add(p);
        }


        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
