package Mission2;

import javax.swing.*;
import java.awt.*;

public class DrawingJFrame extends JFrame implements ListenersForLife{

    private int _currentPressedPanel;
    private DrawingPanel[][] _panels;

    public DrawingJFrame(){
        super("Board");

        setLayout(new GridLayout(3, 3));

        _currentPressedPanel = -1;

        _panels = new DrawingPanel[3][3];
        int numOfPanel = 1;
        for(int i = 0; i < _panels.length; i++){
            for(int j = 0; j < _panels[i].length; j++){
                _panels[i][j] = new DrawingPanel(numOfPanel,false);
                _panels[i][j].addListener(this);
                add(_panels[i][j]);
                numOfPanel++;
            }
        }
        _panels[0][1].updateCircle(true);
        _panels[1][1].updateCircle(true);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void hasCircle(int panelNum) {

        for(int i = 0; i < _panels.length; i++){
            for(int j = 0; j < _panels[i].length; j++){
                if(_panels[i][j].get_panelNum() == _currentPressedPanel && _currentPressedPanel != panelNum){
                    _panels[i][j].setSelected(false);
                    _panels[i][j].updateCircle(true);
                }

            }
        }

        _currentPressedPanel = panelNum;
    }

    @Override
    public void noCircle(int panelNum) {
        if(_currentPressedPanel != -1){

            for(int i = 0; i < _panels.length; i++){
                for(int j = 0; j < _panels[i].length; j++){
                    if(_panels[i][j].get_panelNum() == _currentPressedPanel){
                        if(panelNum == -1){
                            _panels[i][j].setSelected(false);
                            _panels[i][j].updateCircle(true);
                        }else{
                            _panels[i][j].setSelected(false);
                            _panels[i][j].updateCircle(false);
                        }
                    }
                    if(_panels[i][j].get_panelNum() == panelNum){
                        _panels[i][j].updateCircle(true);
                    }
                }
            }
            _currentPressedPanel = -1;
        }

    }
}
