import java.util.ArrayList;

public class Polygon {

    private Style gangnam;
    private ArrayList<Point> points;


    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + points +
                '}';
    }

    public String toSvg(){
        String beginning = "<svg height=\"220\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "  <polygon points=\"";


        String midlle = "";
        for (Point p : points){
            midlle += p.getX() + "," +p.getY() + " ";
        }

        String ending =        "\" " +
                gangnam.toSvg() +
                "\" />\n" +
                "</svg>";
        return beginning + midlle + ending;
    }

    public Style getGangnam() {
        return gangnam;
    }

    public void setGangnam(Style gangnam) {
        this.gangnam = gangnam;
    }

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }
    public Polygon(ArrayList<Point> points, Style gangnam) {
        this.gangnam = gangnam;
        this.points = points;
    }

    public static Polygon createSquare(Segment s, Style style){
        ArrayList<Point> points = new ArrayList<>();
        points.add(s.getStart());
        points.add(s.getEnd());
        //Segment perpendicularSegment = s.findPerpendicular();
        //points.add(perpendicularSegment.getStart());
        //points.add(perpendicularSegment.getEnd());
        return new Polygon(points,style);
    }
}
