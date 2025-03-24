import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        SvgScene picture = new SvgScene(1000,10000);
        Shape poly = new Polygon(points, new Style("#FF0000","#00FFFF",2));
        Shape ellipse = new Circle(new Style("#FF8888","#000000", 3),
                new Point(200,100),30);
        picture.getShapes().add(poly);
        picture.getShapes().add(ellipse);
        try{
            FileWriter fw = new FileWriter("ksztalty.svg");
            fw.write(picture.toSvg());
            fw.close();
        }catch (IOException e){
            System.out.println("Not hello");
        }
    }
}








