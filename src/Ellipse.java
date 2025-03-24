public class Ellipse extends Shape{
    @Override
    public String toSvg() {
        return "<svg height=\"140\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "  <ellipse rx=\"100\" ry=\"50\" cx=\"120\" cy=\"80\"\n" +
                "  style=\"fill:yellow;stroke:green;stroke-width:3\" />\n" +
                "</svg>";
    }
}
