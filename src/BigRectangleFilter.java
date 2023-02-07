import java.awt.*;
import java.util.ArrayList;

public class BigRectangleFilter implements Filter{
    public ArrayList<Object> collectAll(ArrayList<Object> rectangles) {
        ArrayList<Object> accepted = new ArrayList<>();

        for (Object item : rectangles) {
            if (accept(item)) {
                accepted.add(item);
            }
        }

        return accepted;
    }

    @Override
    public boolean accept(Object x) {
        Rectangle r = (Rectangle) x;
        return r.height + r.width > 10;
    }
}
