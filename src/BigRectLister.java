import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        BigRectangleFilter rectFilter = new BigRectangleFilter();
        ArrayList<Object> acceptedRectangles;

        ArrayList<Object> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(10, 7));
        rectangles.add(new Rectangle(6, 3));
        rectangles.add(new Rectangle(4, 8));
        rectangles.add(new Rectangle(12, 3));
        rectangles.add(new Rectangle(8, 1));
        rectangles.add(new Rectangle(9, 4));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(7, 4));
        rectangles.add(new Rectangle(7, 1));

        acceptedRectangles = rectFilter.collectAll(rectangles);

        System.out.println("Accepted Rectangles: ");

        for (Object item : acceptedRectangles) {
            Rectangle r = (Rectangle) item;

            System.out.println("Width: " + r.width + "\tHeight: " + r.height);
        }
    }
}
