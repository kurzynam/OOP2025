import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Point start = new Point(0,40);
//        Point end = new Point(30,70);
//        Segment line = new Segment(new Point(start), new Point(end));
//        start.setY(200);
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        points.add(new Point(20,50));
        points.add(new Point(15, 80));
        Polygon poly = new Polygon(points);

    }
}








