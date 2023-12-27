package Mission1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements ListenToMe, MouseListener {
    private int _x, _y;
    private ArrayList<ListenToMe> listeners;
    private ArrayList<Point> points;

    public DrawingPanel(){
        super();

        _x = -1;
        _y = -1;

        listeners = new ArrayList<>();
        points = new ArrayList<>();
        addMouseListener(this);


    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(0, 0,getWidth(), 0);
        g.drawLine(getWidth(), 0,getWidth(), getHeight());
        g.drawLine(getWidth(), getHeight(),0, getHeight());
        g.drawLine(0, 0,0, getHeight());

        for(Point point : points){
            g.drawOval(point.getX(), point.getY(), 5, 5);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        _x = e.getX();
        _y = e.getY();
        points.add(new Point(_x, _y));
        repaint();
        for(ListenToMe listener : listeners){
            listener.firstIsDrawing(_x, _y);
        }
    }

    @Override
    public void firstIsDrawing(int x, int y) {
        points.add(new Point(x, y));
        repaint();
    }

    public void addListener(ListenToMe listener){
        listeners.add(listener);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }

}
