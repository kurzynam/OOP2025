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
        Polygon poly = new Polygon(points);

        try{
            FileWriter fw = new FileWriter("ksztalty.svg");
            fw.write(poly.toSvg());
            fw.close();
        }catch (IOException e){
            System.out.println("Not hello");
        }
        int ch;
        FileReader fr = null;
        try
        {
            fr = new FileReader("krztalty.svg");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
        try{
            while ((ch=fr.read())!=-1)
                System.out.print((char)ch);
            fr.close();
        } catch (Exception e){
            System.out.println("Wystąpił błąd");
        }


        // close the file


    }
}








