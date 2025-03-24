public class Ellipse extends Shape{
    private Point center;

    private double rx, ry;

    public Ellipse(){}
    public Ellipse(Style gangnam, Point center, double rx, double ry) {
        super(gangnam);
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }

    public Ellipse(Point center, double rx, double ry) {
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public String toSvg() {
        return "<svg height=\"500\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "  <ellipse rx=\"" + rx +
                "\" ry=\"" + ry +
                "\" cx=\"" + center.getX() +
                "\" cy=\"" + center.getY() +
                "\"\n" +
                "" + gangnam.toSvg() +
                "\" />\n" +
                "</svg>";
    }
}
