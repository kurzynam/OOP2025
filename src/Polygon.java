import java.util.ArrayList;

public class Polygon {
    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

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

        String ending =        "\" style=\"fill:lime;stroke:purple;stroke-width:3\" />\n" +
                "</svg>";
        return beginning + midlle + ending;
    }
}
