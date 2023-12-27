package Mission2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements MouseListener{

    private int _panelNum;
    private boolean _hasCircle, _selected;
    private ArrayList<ListenersForLife> listeners;

    public DrawingPanel(int panelNum, boolean hasCircle){
        super();

        _panelNum = panelNum;
        _hasCircle = hasCircle;

        _selected = false;

        listeners = new ArrayList<>();

        addMouseListener(this);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(0, 0,getWidth(), 0);
        g.drawLine(getWidth(), 0,getWidth(), getHeight());
        g.drawLine(getWidth(), getHeight(),0, getHeight());
        g.drawLine(0, 0,0, getHeight());

        if(_selected){
            setBackground(Color.yellow);
        }else{
            setBackground(Color.white);
        }

        if(_hasCircle){
            g.fillOval(getWidth()/2 - 20, getHeight()/2 - 20, 40, 40);
        }



    }


    public void updateCircle(boolean isCircle){
        _hasCircle = isCircle;
        repaint();
    }


    public void addListener(ListenersForLife listener){
        listeners.add(listener);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(_selected){
            for(ListenersForLife listener : listeners){
                listener.noCircle(-1);
            }
        }
        else{
            if(_hasCircle){
                _selected = true;
                repaint();
                for(ListenersForLife listener : listeners) {
                    listener.hasCircle(_panelNum);
                }
            }else{
                for(ListenersForLife listener : listeners){
                    listener.noCircle(_panelNum);
                }
            }
        }


    }

    public void setSelected(boolean isSelected){
        _selected = isSelected;
    }

    public int get_panelNum() {
        return _panelNum;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}
