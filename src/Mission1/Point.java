package Mission1;

public class Point {

    private int _x, _y;

    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public void set(int newX, int newY) {
        _x = newX;
        _y = newY;
    }


}
