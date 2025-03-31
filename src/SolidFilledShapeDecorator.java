public class SolidFilledShapeDecorator extends ShapeDecorator{
    String color;

    public SolidFilledShapeDecorator(Shape decoratedShape, String color) {
        super();
        this.color = color;
    }
}
